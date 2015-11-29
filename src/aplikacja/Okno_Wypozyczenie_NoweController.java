/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import static aplikacja.Wypozyczalnia.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tabele.auta_dk_2015;
import tabele.klient_dk_2015;
import tabele.pracownik_dk_2015;
import tabele.wypozyczenie_dk_2015;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_Wypozyczenie_NoweController implements Initializable {

    @FXML
    Label id_klient;
    @FXML
    Label id_pracownik;
    @FXML
    Label id_auto;
    @FXML
    Label id_wypozyczenie;
    @FXML
    TextField imie_klient;
    @FXML
    TextField nazwisko_klient;
    @FXML
    TextField ulica_klient;
    @FXML
    TextField nr_domu_klient;
    @FXML
    TextField miasto_klient;
    @FXML
    TextField telefon_klient;
    @FXML
    TextField imie_pracownik;
    @FXML
    TextField nazwisko_pracownik;
    @FXML
    TextField auto_marka;
    @FXML
    TextField auto_model;
    @FXML
    TextField auto_rocznik;
    @FXML
    TextField auto_skrzynia;
    @FXML
    TextField auto_cena_doba;
    @FXML
    DatePicker wypozyczenie_start;
    @FXML
    DatePicker wypozyczenie_end;
    @FXML
    TextField wypozyczenie_liczba_dni;
    @FXML
    static public TextField wypozyczenie_calkowity_koszt;

    @FXML
    void Okno_Wybierz_klient() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Okno_Wypozyczenie_Klient_Wybierz.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Klienci");
        Scene scenaWykres = new Scene(root1);
        stage.setScene(scenaWykres);
        stage.show();
    }

    @FXML
    void Odswiez_Klient() {
        id_klient.setText(String.valueOf(zamowienie_klient.getId_dk_2015()));
        imie_klient.setText(zamowienie_klient.getImie_dk_2015());
        nazwisko_klient.setText(zamowienie_klient.getNazwisko_dk_2015());
        ulica_klient.setText(zamowienie_klient.getAdres_ulica_dk_2015());
        nr_domu_klient.setText(String.valueOf(zamowienie_klient.getAdres_nr_dom_dk_2015()));
        miasto_klient.setText(zamowienie_klient.getAdres_miasto_dk_2015());
        telefon_klient.setText(String.valueOf(zamowienie_klient.getNr_tel_dk_2015()));
    }

    @FXML
    void Okno_Wybierz_pracownik() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Okno_Wypozyczenie_Pracownik_Wybierz.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("pracownicy");
        Scene scenaWykres = new Scene(root1);
        stage.setScene(scenaWykres);
        stage.show();
    }

    @FXML
    void Odswiez_Pracownik() {
        id_pracownik.setText(String.valueOf(zamowienie_pracownik.getId_dk_2015()));
        imie_pracownik.setText(zamowienie_pracownik.getImie_dk_2015());
        nazwisko_pracownik.setText(zamowienie_pracownik.getNazwisko_dk_2015());
    }

    @FXML
    void Okno_Wybierz_Auto() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Okno_Wypozyczenie_Auto_Wybierz.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Auta");
        Scene scenaWykres = new Scene(root1);
        stage.setScene(scenaWykres);
        stage.show();
    }

    @FXML
    void Odswiez_Auto() {
        id_auto.setText(String.valueOf(zamowienie_auto.getId_dk_2015()));
        auto_marka.setText(zamowienie_auto.getMarka_dk_2015());
        auto_model.setText(zamowienie_auto.getModel_dk_2015());
        auto_rocznik.setText(String.valueOf(zamowienie_auto.getRocznik_dk_2015()));
        auto_skrzynia.setText(zamowienie_auto.getSkrzynia_biegow_dk_2015());
        auto_cena_doba.setText(String.valueOf(zamowienie_auto.getCena_doba_dk_2015()));

    }

    @FXML
    void Wyczysc() {
        id_klient.setText("");
        imie_klient.setText("");
        nazwisko_klient.setText("");
        ulica_klient.setText("");
        nr_domu_klient.setText("");
        miasto_klient.setText("");
        telefon_klient.setText("");
        id_pracownik.setText("");
        imie_pracownik.setText("");
        nazwisko_pracownik.setText("");
        id_auto.setText("");
        auto_marka.setText("");
        auto_model.setText("");
        auto_rocznik.setText("");
        auto_skrzynia.setText("");
        auto_cena_doba.setText("");
        zamowienie_klient=null;
        zamowienie_pracownik=null;
        zamowienie_auto=null;
        
    }

    @FXML
    void tescik() {
        System.out.println("few");
    }

    @FXML
    void Zapisz() {
        //testy relacji // dziala
        session = sesia.openSession();
        session.beginTransaction();
        pracownik_dk_2015 p = new pracownik_dk_2015();
        klient_dk_2015 k = new klient_dk_2015();
        k.setImie_dk_2015("test relacji");
        k.setNazwisko_dk_2015("test relacji");
        k.setAdres_miasto_dk_2015("test relacji");
        k.setAdres_nr_dom_dk_2015(11);
        k.setAdres_ulica_dk_2015("test relacji");

        p.setImie_dk_2015("test relacji");
        p.setNazwisko_dk_2015("test relacji");
        //p.setData_zatrudnienia_dk_2015(Date.valueOf(data.getValue()));

        auta_dk_2015 auto = new auta_dk_2015();
        auto.setMarka_dk_2015("BMW");
        auto.setModel_dk_2015("i8");
        auto.setRocznik_dk_2015(2015);
        auto.setSkrzynia_biegow_dk_2015("automatyczna");
        auto.setCena_doba_dk_2015(200);

        wypozyczenie_dk_2015 w = new wypozyczenie_dk_2015();

        w.setId_pracownik_wypozyczenie_dk_2015(p);
        w.setId_klient_wypozyczenie_dk_2015(k);
        w.setId_auta_wypozyczenie_dk_2015(auto);
        //w.setData_wypozyczenia_dk_2015(Date.valueOf(data.getValue()));
        // w.setData_zwrotu_dk_2015(Date.valueOf(data.getValue()));
        w.setKoszt_dk_2015(auto.getCena_doba_dk_2015() * 3);
        session.save(p);
        session.save(k);
        session.save(auto);
        session.save(w);
        session.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
