/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tabele.pracownik_dk_2015;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_PracownikController implements Initializable {

    @FXML
    TextField text_imie;
    @FXML
    TextField text_id;
    @FXML
    TextField text_nazwisko;
    @FXML
    DatePicker data;
    @FXML
    TableView<pracownik_dk_2015> tabela;
    @FXML
    public final ObservableList<pracownik_dk_2015> dane = FXCollections.observableArrayList();
    static public List<pracownik_dk_2015> Lista = new ArrayList();

    @FXML
    void Zapisz() {
        pracownik_dk_2015 pracownik = new pracownik_dk_2015();
        pracownik.setImie_dk_2015(text_imie.getText());
        pracownik.setNazwisko_dk_2015(text_nazwisko.getText());
        pracownik.setData_zatrudnienia_dk_2015(Date.valueOf(data.getValue()));
        SessionFactory sesia = new Configuration().configure().buildSessionFactory();
        Session session = sesia.openSession();
        //zapisane do bazy
        session.beginTransaction();
        session.save(pracownik);
        session.getTransaction().commit();
        session.close();
    }

    @FXML
    void Szukaj() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.setValue(LocalDate.now());
        pracownik_dk_2015 p1 = new pracownik_dk_2015();
        p1.setId_dk_2015(1);
        p1.setImie_dk_2015("a");
        p1.setNazwisko_dk_2015("dsadsa");
        Lista.add(p1);
        
        p1.setId_dk_2015(1);
        p1.setImie_dk_2015("a");
        p1.setNazwisko_dk_2015("dsadsa");
        Lista.add(p1);
        
        
        
        
        pracownik_dk_2015 pp =new pracownik_dk_2015();
        for(int s=0;s<Lista.size();s++){
            pp.setId_dk_2015(Lista.get(s).getId_dk_2015());
            pp.setImie_dk_2015(Lista.get(s).getImie_dk_2015());
            pp.setNazwisko_dk_2015(Lista.get(s).getNazwisko_dk_2015());
            dane.add(pp);
        }
            
        tabela.setItems(dane);
    }

}
