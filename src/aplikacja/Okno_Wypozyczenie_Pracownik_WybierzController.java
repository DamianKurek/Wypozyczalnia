package aplikacja;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import tabele.pracownik_dk_2015;
import static aplikacja.Wypozyczalnia.*;
import javafx.stage.Stage;
import tabele.auta_dk_2015;
import tabele.klient_dk_2015;
import tabele.wypozyczenie_dk_2015;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_Wypozyczenie_Pracownik_WybierzController implements Initializable {

    //SessionFactory sesia;
    //SessionFactory sesia = new Configuration().configure().buildSessionFactory();
    //Session session;
    @FXML
    TextField text_id_szukaj;
    @FXML
    TextField text_nazwisko_szukaj;
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
    TableColumn<pracownik_dk_2015, Integer> TableColumn1;
    @FXML
    TableColumn<pracownik_dk_2015, String> TableColumn2;
    @FXML
    TableColumn<pracownik_dk_2015, String> TableColumn3;
    @FXML
    TableColumn<pracownik_dk_2015, String> TableColumn4;
    @FXML
    public final ObservableList<pracownik_dk_2015> dane = FXCollections.observableArrayList();

    @FXML
    void Zapisz() {
        pracownik_dk_2015 pracownik = new pracownik_dk_2015();
        pracownik.setImie_dk_2015(text_imie.getText());
        pracownik.setNazwisko_dk_2015(text_nazwisko.getText());
        pracownik.setData_zatrudnienia_dk_2015(Date.valueOf(data.getValue()));
        session = sesia.openSession();
        //zapisane do bazy
        session.beginTransaction();
        session.save(pracownik);
        session.getTransaction().commit();
        session.close();
        
        
 
    }

    @FXML
    void Szukaj() {

        if (!text_nazwisko_szukaj.getText().isEmpty() && text_id_szukaj.getText().isEmpty()) {
            dane.clear();
            session = sesia.openSession();
            Criterion imie = Expression.eq("nazwisko_dk_2015", text_nazwisko_szukaj.getText());
            Criteria crit = session.createCriteria(pracownik_dk_2015.class);
            crit.add(imie);
            List<pracownik_dk_2015> p = crit.list();
            if (!p.isEmpty()) {
                for (int x = 0; x < p.size(); x++) {
//            System.out.println(p.get(x).getImie_dk_2015() + " "
//                    + p.get(x).getNazwisko_dk_2015());
                    dane.add(p.get(x));
                }
            } else {
                //kominukat o nie znalezieniu pracownika
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Błąd");
                alert.setHeaderText("Błąd");
                alert.setContentText("Brak Pracownika o takim Nazwisku w bazie danych");
                alert.showAndWait();
            }

            session.close();
        }
        if (text_nazwisko_szukaj.getText().isEmpty() && !text_id_szukaj.getText().isEmpty()) {
            dane.clear();
            session = sesia.openSession();
            Criterion id = Expression.eq("id_dk_2015", Integer.parseInt(text_id_szukaj.getText()));
            Criteria crit = session.createCriteria(pracownik_dk_2015.class);
            crit.add(id);
            pracownik_dk_2015 p2 = (pracownik_dk_2015) crit.uniqueResult();
            if (p2 != null) {
                dane.add(p2);
            } else {
                //kominukat o nie znalezieniu pracownika
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Błąd");
                alert.setHeaderText("Błąd");
                alert.setContentText("Brak Pracownika o takim Id w bazie danych");
                alert.showAndWait();
            }

            session.close();

        }
        if (!text_nazwisko_szukaj.getText().isEmpty() && !text_id_szukaj.getText().isEmpty()) {
            //kominukat o błedzie
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd");
            alert.setContentText("Wpisz tylko 1 parametr do szukanai (Id lub nazwisko)");
            alert.showAndWait();
        }
    }

    @FXML
    void Wczytaj() {
        dane.clear();
        session = sesia.openSession();
        session.beginTransaction();
        List<pracownik_dk_2015> wynik = session.createQuery("from pracownik_dk_2015").list();
        session.close();
        for (int x = 0; x < wynik.size(); x++) {
//            System.out.println(wynik.get(x).getId_dk_2015() + " "
//                    + wynik.get(x).getImie_dk_2015() + " "
//                    + wynik.get(x).getNazwisko_dk_2015()
//            );
            dane.add(wynik.get(x));
        }

    }
@FXML
    void Wybierz_z_Tabeli() {
        zamowienie_pracownik = tabela.getSelectionModel().getSelectedItem();
        Stage stage = (Stage) tabela.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        data.setValue(LocalDate.now());
        tabela.setItems(dane);

        TableColumn1.setCellValueFactory(
                new PropertyValueFactory<pracownik_dk_2015, Integer>("id_dk_2015")//nazwa pola w klasie
        );
        TableColumn2.setCellValueFactory(
                new PropertyValueFactory<pracownik_dk_2015, String>("imie_dk_2015")//nazwa pola w klasie
        );
        TableColumn3.setCellValueFactory(
                new PropertyValueFactory<pracownik_dk_2015, String>("nazwisko_dk_2015")//nazwa pola w klasie
        );
        TableColumn4.setCellValueFactory(
                new PropertyValueFactory<pracownik_dk_2015, String>("data_zatrudnienia_dk_2015")//nazwa pola w klasie
        );

        
    }

}
