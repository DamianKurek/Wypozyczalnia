/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import static aplikacja.Wypozyczalnia.sesia;
import static aplikacja.Wypozyczalnia.session;
import static aplikacja.Wypozyczalnia.zamowienie;
import static aplikacja.Wypozyczalnia.zamowienie_auto;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import tabele.klient_dk_2015;
import tabele.pracownik_dk_2015;
import tabele.wypozyczenie_dk_2015;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_Wypozyczenie_ZwrotController implements Initializable {

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
    void Odswiez() {
    }

    @FXML
    void Policz_dni() {
        wypozyczenie_liczba_dni.setText(String.valueOf(wypozyczenie_end.getValue().getDayOfYear() - wypozyczenie_start.getValue().getDayOfYear()));
        wypozyczenie_calkowity_koszt.setText(String.valueOf(
                (wypozyczenie_end.getValue().getDayOfYear() - wypozyczenie_start.getValue().getDayOfYear()) * zamowienie_auto.getCena_doba_dk_2015()
        ));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id_klient.setText(String.valueOf(zamowienie));
    }

}
