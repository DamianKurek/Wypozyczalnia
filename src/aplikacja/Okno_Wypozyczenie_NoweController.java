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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.criterion.Projections;
import tabele.auta_dk_3i;
import tabele.klient_dk_3i;
import tabele.pracownik_dk_3i;
import tabele.wypozyczenie_dk_3i;

public class Okno_Wypozyczenie_NoweController implements Initializable {

    public void Odswiez_Klient1() {
        id_klient.setText(String.valueOf(zamowienie_klient.getId_dk_3i()));
        imie_klient.setText(zamowienie_klient.getImie_dk_3i());
        nazwisko_klient.setText(zamowienie_klient.getNazwisko_dk_3i());
        ulica_klient.setText(zamowienie_klient.getAdres_ulica_dk_3i());
        nr_domu_klient.setText(String.valueOf(zamowienie_klient.getAdres_nr_dom_dk_3i()));
        miasto_klient.setText(zamowienie_klient.getAdres_miasto_dk_3i());
        telefon_klient.setText(String.valueOf(zamowienie_klient.getNr_tel_dk_3i()));
    }
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
    TextField wypozyczenie_calkowity_koszt;

    @FXML
    void Okno_Wybierz_klient() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Okno_Wypozyczenie_Klient_Wybierz.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Klienci");
        Scene scenaWykres = new Scene(root1);
        stage.setScene(scenaWykres);
        stage.showAndWait();
        Odswiez_Klient();
//        Okno_Wypozyczenie_Klient_WybierzController controller = fxmlLoader.getController();
//        Optional<String> db = controller.);
//        db.ifPresent(dbName -> {
//            // do whatever you need with dbName, e.g.
//            databaseView.getRoot().getChildren().add(new TreeItem<>(dbName));
//        });

    }

    @FXML
    public void Odswiez_Klient() {
        id_klient.setText(String.valueOf(zamowienie_klient.getId_dk_3i()));
        imie_klient.setText(zamowienie_klient.getImie_dk_3i());
        nazwisko_klient.setText(zamowienie_klient.getNazwisko_dk_3i());
        ulica_klient.setText(zamowienie_klient.getAdres_ulica_dk_3i());
        nr_domu_klient.setText(String.valueOf(zamowienie_klient.getAdres_nr_dom_dk_3i()));
        miasto_klient.setText(zamowienie_klient.getAdres_miasto_dk_3i());
        telefon_klient.setText(String.valueOf(zamowienie_klient.getNr_tel_dk_3i()));
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
        id_pracownik.setText(String.valueOf(zamowienie_pracownik.getId_dk_3i()));
        imie_pracownik.setText(zamowienie_pracownik.getImie_dk_3i());
        nazwisko_pracownik.setText(zamowienie_pracownik.getNazwisko_dk_3i());
    }

    @FXML
    void Okno_Wybierz_Auto() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Okno_Wypozyczenie_Auto_Wybierz.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Auta");
        Scene scenaWykres = new Scene(root1);
        stage.setScene(scenaWykres);
        stage.showAndWait();
        Odswiez_Auto();
    }

    @FXML
    public void Odswiez_Auto() {
        id_auto.setText(String.valueOf(zamowienie_auto.getId_dk_3i()));
        auto_marka.setText(zamowienie_auto.getMarka_dk_3i());
        auto_model.setText(zamowienie_auto.getModel_dk_3i());
        auto_rocznik.setText(String.valueOf(zamowienie_auto.getRocznik_dk_3i()));
        auto_skrzynia.setText(zamowienie_auto.getSkrzynia_biegow_dk_3i());
        auto_cena_doba.setText(String.valueOf(zamowienie_auto.getCena_doba_dk_3i()));

    }

    @FXML
    void Wyczysc() {
        id_klient.setText("id");
        imie_klient.setText("");
        nazwisko_klient.setText("");
        ulica_klient.setText("");
        nr_domu_klient.setText("");
        miasto_klient.setText("");
        telefon_klient.setText("");
//        id_pracownik.setText("id");
//        imie_pracownik.setText("");
//        nazwisko_pracownik.setText("");
        id_auto.setText("id");
        auto_marka.setText("");
        auto_model.setText("");
        auto_rocznik.setText("");
        auto_skrzynia.setText("");
        auto_cena_doba.setText("");
        wypozyczenie_start.setValue(LocalDate.now());
        wypozyczenie_end.setValue(null);
        wypozyczenie_liczba_dni.setText("");
        wypozyczenie_calkowity_koszt.setText("");
        zamowienie_klient = null;
        zamowienie_auto = null;

    }

    @FXML
    void tescik() {
        System.out.println("few");
    }

    @FXML
    void Zapisz() {
        session = sesia.openSession();
        session.beginTransaction();
        wypozyczenie_dk_3i w = new wypozyczenie_dk_3i();

        w.setId_pracownik_wypozyczenie_dk_3i(zamowienie_pracownik);
        w.setId_klient_wypozyczenie_dk_3i(zamowienie_klient);
        w.setId_auta_wypozyczenie_dk_3i(zamowienie_auto);
        w.setData_wypozyczenia_dk_3i(Date.valueOf(wypozyczenie_start.getValue()));
        w.setData_zwrotu_dk_3i(Date.valueOf(wypozyczenie_end.getValue()));
        w.setKoszt_dk_3i(zamowienie_auto.getCena_doba_dk_3i() * (wypozyczenie_end.getValue().getDayOfYear() - wypozyczenie_start.getValue().getDayOfYear()));
        session.save(w);
        session.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Zapis");
        alert.setHeaderText("Zapis");
        alert.setContentText("Poprawnia dodano nowe zamówienie");
        alert.showAndWait();
        Wyczysc();
        Stage stage = new Stage();
        stage = (Stage) id_klient.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Policz_dni() {
        wypozyczenie_liczba_dni.setText(String.valueOf(wypozyczenie_end.getValue().getDayOfYear() - wypozyczenie_start.getValue().getDayOfYear()));
        wypozyczenie_calkowity_koszt.setText(String.valueOf(
                (wypozyczenie_end.getValue().getDayOfYear() - wypozyczenie_start.getValue().getDayOfYear()) * zamowienie_auto.getCena_doba_dk_3i()
        ));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        wypozyczenie_start.setValue(LocalDate.now());
        session = sesia.openSession();
        session.beginTransaction();
        Long f = (Long) session.createCriteria("tabele.wypozyczenie_dk_3i").setProjection(Projections.rowCount()).uniqueResult();
        id_wypozyczenie.setText(String.valueOf(f + 1));
        session.close();
        Odswiez_Pracownik();
    }

}
