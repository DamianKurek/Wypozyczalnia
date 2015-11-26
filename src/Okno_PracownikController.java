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
import org.hibernate.Criteria;
import org.hibernate.Query;
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
        pracownik_dk_2015 pracownik = new pracownik_dk_2015();

        SessionFactory sesia = new Configuration().configure().buildSessionFactory();
        Session session = sesia.openSession();
        ///////wykaszanie po id
        session.beginTransaction();
        //pracownik = session.get(pracownik_dk_2015.class, 1);// odszukanie po Id
        pracownik = session.get(pracownik_dk_2015.class, 1);

        System.out.println(pracownik.getImie_dk_2015());
        ////////////////////////////////////
        List<pracownik_dk_2015> wynik = session.createQuery("from pracownik_dk_2015 where imie_dk_2015='Jan'").list();
        //
        
        for (int x = 0; x < wynik.size(); x++) {
            System.out.println(wynik.get(x).getImie_dk_2015() + " " + wynik.get(x).getNazwisko_dk_2015());
        }

        session.close();
        tabela.setItems(dane);

    }

}
