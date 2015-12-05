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

import tabele.pracownik_dk_3i;
import static aplikacja.Wypozyczalnia.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.hibernate.criterion.Projections;
import tabele.auta_dk_3i;
import tabele.klient_dk_3i;
import tabele.wypozyczenie_dk_3i;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_PracownikController implements Initializable {

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
    TableView<pracownik_dk_3i> tabela;
    @FXML
    TableColumn<pracownik_dk_3i, Integer> TableColumn1;
    @FXML
    TableColumn<pracownik_dk_3i, String> TableColumn2;
    @FXML
    TableColumn<pracownik_dk_3i, String> TableColumn3;
    @FXML
    TableColumn<pracownik_dk_3i, String> TableColumn4;
    @FXML
    public final ObservableList<pracownik_dk_3i> dane = FXCollections.observableArrayList();

    @FXML
    void Zapisz() {
        if (text_imie.getText().toString().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("Brak imienia");
            alert.showAndWait();
        } else if (text_nazwisko.getText().toString().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("Brak nazwiska");
            alert.showAndWait();
        } else {
            pracownik_dk_3i pracownik = new pracownik_dk_3i();
            pracownik.setImie_dk_3i(text_imie.getText());
            pracownik.setNazwisko_dk_3i(text_nazwisko.getText());
            pracownik.setData_zatrudnienia_dk_3i(Date.valueOf(data.getValue()));
            session = sesia.openSession();
            //zapisane do bazy
            session.beginTransaction();
            session.save(pracownik);
            session.getTransaction().commit();
            session.close();
        }
    }

    @FXML
    void Szukaj() {

        if (!text_nazwisko_szukaj.getText().isEmpty() && text_id_szukaj.getText().isEmpty()) {
            dane.clear();
            session = sesia.openSession();
            Criterion imie = Expression.eq("nazwisko_dk_3i", text_nazwisko_szukaj.getText());
            Criteria crit = session.createCriteria(pracownik_dk_3i.class);
            crit.add(imie);
            List<pracownik_dk_3i> p = crit.list();
            if (!p.isEmpty()) {
                for (int x = 0; x < p.size(); x++) {
//            System.out.println(p.get(x).getImie_dk_3i() + " "
//                    + p.get(x).getNazwisko_dk_3i());
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
            Criterion id = Expression.eq("id_dk_3i", Integer.parseInt(text_id_szukaj.getText()));
            Criteria crit = session.createCriteria(pracownik_dk_3i.class);
            crit.add(id);
            pracownik_dk_3i p2 = (pracownik_dk_3i) crit.uniqueResult();
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
        List<pracownik_dk_3i> wynik = session.createQuery("from pracownik_dk_3i").list();
        session.close();
        for (int x = 0; x < wynik.size(); x++) {
//            System.out.println(wynik.get(x).getId_dk_3i() + " "
//                    + wynik.get(x).getImie_dk_3i() + " "
//                    + wynik.get(x).getNazwisko_dk_3i()
//            );
            dane.add(wynik.get(x));
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        data.setValue(LocalDate.now());
        tabela.setItems(dane);

        TableColumn1.setCellValueFactory(
                new PropertyValueFactory<pracownik_dk_3i, Integer>("id_dk_3i")//nazwa pola w klasie
        );
        TableColumn2.setCellValueFactory(
                new PropertyValueFactory<pracownik_dk_3i, String>("imie_dk_3i")//nazwa pola w klasie
        );
        TableColumn3.setCellValueFactory(
                new PropertyValueFactory<pracownik_dk_3i, String>("nazwisko_dk_3i")//nazwa pola w klasie
        );
        TableColumn4.setCellValueFactory(
                new PropertyValueFactory<pracownik_dk_3i, String>("data_zatrudnienia_dk_3i")//nazwa pola w klasie
        );
        text_imie.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_imie.getText().charAt(oldValue.intValue());
                    if ((ch >= '0' && ch <= '9')) {
                        text_imie.setText(text_imie.getText().substring(0, text_imie.getText().length() - 1));
                    }
                }
            }

        });
        text_nazwisko.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_nazwisko.getText().charAt(oldValue.intValue());
                    if ((ch >= '0' && ch <= '9')) {
                        text_nazwisko.setText(text_nazwisko.getText().substring(0, text_nazwisko.getText().length() - 1));
                    }
                }
            }

        });
        session = sesia.openSession();
        Long f = (Long) session.createCriteria("tabele.pracownik_dk_3i").setProjection(Projections.rowCount()).uniqueResult();
        text_id.setText(String.valueOf(f + 1));
        session.close();
    }

}
