package aplikacja;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static aplikacja.Wypozyczalnia.*;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import tabele.klient_dk_2015;

import tabele.pracownik_dk_2015;
import aplikacja.Okno_Wypozyczenie_NoweController.*;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_Wypozyczenie_Klient_WybierzController implements Initializable {

    @FXML
    TextField text_id_szukaj;
    @FXML
    TextField text_nazwisko_szukaj;
    @FXML
    TextField text_miasto_szukaj;
    @FXML
    TextField text_id;
    @FXML
    TextField text_imie;
    @FXML
    TextField text_nazwisko;
    @FXML
    TextField text_miasto;
    @FXML
    TextField text_ulica;
    @FXML
    TextField text_nr_domu;
    @FXML
    TextField text_telefon;
    @FXML
    TableView<klient_dk_2015> tabela;
    @FXML
    TableColumn<klient_dk_2015, Integer> TableColumn1;
    @FXML
    TableColumn<klient_dk_2015, String> TableColumn2;
    @FXML
    TableColumn<klient_dk_2015, String> TableColumn3;
    @FXML
    TableColumn<klient_dk_2015, Integer> TableColumn4;
    @FXML
    TableColumn<klient_dk_2015, String> TableColumn5;
    @FXML
    TableColumn<klient_dk_2015, String> TableColumn6;
    @FXML
    TableColumn<klient_dk_2015, Integer> TableColumn7;
    @FXML
    public final ObservableList<klient_dk_2015> dane = FXCollections.observableArrayList();
    //SessionFactory sesia = new Configuration().configure().buildSessionFactory();
    //Session session = sesia.openSession();

    @FXML
    void Wybierz_z_Tabeli() {
        zamowienie_klient = tabela.getSelectionModel().getSelectedItem();
        //System.out.println(k.getNazwisko_dk_2015());
        // get a handle to the stage
        Stage stage = (Stage) tabela.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void Czysc() {
//text_id.setText(null);;
        text_imie.setText(null);
        text_nazwisko.setText(null);
        text_miasto.setText(null);
        text_ulica.setText(null);
        text_nr_domu.setText(null);
        text_telefon.setText(null);
    }

    @FXML
    void Zapisz() {
        klient_dk_2015 klient = new klient_dk_2015();
        klient.setImie_dk_2015(text_imie.getText());
        klient.setNazwisko_dk_2015(text_nazwisko.getText());
        klient.setAdres_miasto_dk_2015(text_miasto.getText());
        klient.setAdres_ulica_dk_2015(text_ulica.getText());
        klient.setAdres_nr_dom_dk_2015(Integer.parseInt(text_nr_domu.getText()));
        if (!text_telefon.getText().isEmpty()) {
            klient.setNr_tel_dk_2015(Integer.parseInt(text_telefon.getText()));
        }

        SessionFactory sesia = new Configuration().configure().buildSessionFactory();
        Session session = sesia.openSession();
        //zapisane do bazy
        session.beginTransaction();
        session.save(klient);
        session.getTransaction().commit();
        session.close();

    }

    @FXML
    void Wczytaj() {
        dane.clear();
        session = sesia.openSession();
        session.beginTransaction();
        List<klient_dk_2015> wynik = session.createQuery("from klient_dk_2015").list();
        session.close();
        for (int x = 0; x < wynik.size(); x++) {
            dane.add(wynik.get(x));
        }

    }

    @FXML
    void Szukaj() {
        if (!text_id_szukaj.getText().isEmpty() && text_nazwisko_szukaj.getText().isEmpty() && text_miasto_szukaj.getText().isEmpty()) {
            dane.clear();
            session = sesia.openSession();
            Criterion id = Expression.eq("id_dk_2015", Integer.parseInt(text_id_szukaj.getText()));
            Criteria crit = session.createCriteria(klient_dk_2015.class);
            crit.add(id);
            klient_dk_2015 p2 = (klient_dk_2015) crit.uniqueResult();
            if (p2 != null) {
                dane.add(p2);
            } else {
                //kominukat o nie znalezieniu pracownika
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Błąd");
                alert.setHeaderText("Błąd");
                alert.setContentText("Brak Pracownika o takim Id w bazie danych");
                alert.showAndWait();
            }

            session.close();
        }
        if (text_id_szukaj.getText().isEmpty() && !text_nazwisko_szukaj.getText().isEmpty() && text_miasto_szukaj.getText().isEmpty()) {
            dane.clear();
            session = sesia.openSession();
            Criterion id = Expression.eq("nazwisko_dk_2015", text_nazwisko_szukaj.getText());
            Criteria crit = session.createCriteria(klient_dk_2015.class);
            crit.add(id);
            List<klient_dk_2015> p2 = crit.list();
            if (!p2.isEmpty()) {
                for (int x = 0; x < p2.size(); x++) {
//            System.out.println(p.get(x).getImie_dk_2015() + " "
//                    + p.get(x).getNazwisko_dk_2015());
                    dane.add(p2.get(x));
                }
            } else {
                //kominukat o nie znalezieniu pracownika
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Błąd");
                alert.setHeaderText("Błąd");
                alert.setContentText("Brak Pracownika o takim Nazwisku w bazie danych");
                alert.showAndWait();
            }

            session.close();
        }
        if (text_id_szukaj.getText().isEmpty() && text_nazwisko_szukaj.getText().isEmpty() && !text_miasto_szukaj.getText().isEmpty()) {
            dane.clear();
            session = sesia.openSession();
            Criterion id = Expression.eq("adres_miasto_dk_2015", text_miasto_szukaj.getText());
            Criteria crit = session.createCriteria(klient_dk_2015.class);
            crit.add(id);
            List<klient_dk_2015> p3 = crit.list();
            if (!p3.isEmpty()) {
                for (int x = 0; x < p3.size(); x++) {
//            System.out.println(p.get(x).getImie_dk_2015() + " "
//                    + p.get(x).getNazwisko_dk_2015());
                    dane.add(p3.get(x));
                }
            } else {
                //kominukat o nie znalezieniu pracownika
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Błąd");
                alert.setHeaderText("Błąd");
                alert.setContentText("Brak Pracownika z tego miasta w bazie danych");
                alert.showAndWait();
            }

            session.close();
        }
        if (!text_id_szukaj.getText().isEmpty() && text_nazwisko_szukaj.getText().isEmpty() && !text_miasto_szukaj.getText().isEmpty()) {
            //kominukat o błedzie
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd");
            alert.setContentText("Wybierz tylko 1 parametr do szukanai (Id,nazwisko lub miasto)");
            alert.showAndWait();
        }
        if (!text_id_szukaj.getText().isEmpty() && !text_nazwisko_szukaj.getText().isEmpty() && text_miasto_szukaj.getText().isEmpty()) {
            //kominukat o błedzie
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd");
            alert.setContentText("Wybierz tylko 1 parametr do szukanai (Id,nazwisko lub miasto)");
            alert.showAndWait();
        }

        if (text_id_szukaj.getText().isEmpty() && !text_nazwisko_szukaj.getText().isEmpty() && !text_miasto_szukaj.getText().isEmpty()) {
            //kominukat o błedzie
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd");
            alert.setContentText("Wybierz tylko 1 parametr do szukanai (Id,nazwisko lub miasto)");
            alert.showAndWait();
        }
        if (text_id_szukaj.getText().isEmpty() && text_nazwisko_szukaj.getText().isEmpty() && text_miasto_szukaj.getText().isEmpty()) {
            //kominukat o błedzie
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd");
            alert.setContentText("Wybierz 1 parametr do szukanai (Id,nazwisko lub miasto)");
            alert.showAndWait();
        }
        if (!text_id_szukaj.getText().isEmpty() && !text_nazwisko_szukaj.getText().isEmpty() && !text_miasto_szukaj.getText().isEmpty()) {
            //kominukat o błedzie
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd");
            alert.setContentText("Wybierz tylko 1 parametr do szukanai (Id,nazwisko lub miasto)");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tabela.itemsProperty().setValue(dane);
        TableColumn1.setCellValueFactory(new PropertyValueFactory<klient_dk_2015, Integer>("id_dk_2015")//nazwa pola w klasie
        );
        TableColumn2.setCellValueFactory(new PropertyValueFactory<klient_dk_2015, String>("imie_dk_2015")//nazwa pola w klasie
        );
        TableColumn3.setCellValueFactory(new PropertyValueFactory<klient_dk_2015, String>("nazwisko_dk_2015")//nazwa pola w klasie
        );
        TableColumn4.setCellValueFactory(new PropertyValueFactory<klient_dk_2015, Integer>("nr_tel_dk_2015")//nazwa pola w klasie
        );
        TableColumn5.setCellValueFactory(new PropertyValueFactory<klient_dk_2015, String>("adres_miasto_dk_2015")//nazwa pola w klasie
        );
        TableColumn6.setCellValueFactory(new PropertyValueFactory<klient_dk_2015, String>("adres_ulica_dk_2015")//nazwa pola w klasie
        );
        TableColumn7.setCellValueFactory(new PropertyValueFactory<klient_dk_2015, Integer>("adres_nr_dom_dk_2015")//nazwa pola w klasie
        );
        Wczytaj();
    }

}
