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
import static aplikacja.Wypozyczalnia.zamowienie_klient;
import static aplikacja.Wypozyczalnia.zamowienie_pracownik;
import java.net.URL;
import java.time.ZoneId;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.temporal.TemporalQueries.localDate;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
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
import tabele.zwrot_dk_2015;

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
    Label text_id_wypozyczenie;
    @FXML
    CheckBox check_uszkodzony;
    @FXML
    TextField text_kara;
    @FXML
    TextField text_do_zaplaty;
    int doZaplaty;

    @FXML
    DatePicker data_zwrotu;

    @FXML
    void Odswiez() {
    }
    int KaraUszkodzenie;
    int KaraOpoznienie;

    @FXML
    void AutoUszkodzone() {
        KaraUszkodzenie = 0;
        if (check_uszkodzony.isSelected()) {
            KaraUszkodzenie = 100;
        }
        if (!check_uszkodzony.isSelected()) {
            KaraUszkodzenie = 0;
        }
        doZaplaty = Integer.parseInt(wypozyczenie_calkowity_koszt.getText()) + KaraUszkodzenie + KaraOpoznienie;
        text_kara.setText(String.valueOf(KaraUszkodzenie + KaraOpoznienie));
        text_do_zaplaty.setText(String.valueOf(doZaplaty));

    }

    @FXML
    void PoliczOpoznienie() {
        if (data_zwrotu.getValue().compareTo(wypozyczenie_end.getValue()) < 0) {
            data_zwrotu.setValue(LocalDate.now());
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd daty");
            alert.setContentText("Data zwrotu nie możę być wcześniejsza niż data końca wypozyczenia");
            alert.showAndWait();

        } else {

            KaraOpoznienie = 0;
            int dni;
            dni = data_zwrotu.getValue().getDayOfYear() - wypozyczenie_end.getValue().getDayOfYear();
            if (dni > 0) {
                KaraOpoznienie = dni * 200;
            }
            if (dni < 0) {
                KaraOpoznienie = 0;

            }
            text_kara.setText(String.valueOf(KaraUszkodzenie + KaraOpoznienie));
            doZaplaty = Integer.parseInt(wypozyczenie_calkowity_koszt.getText()) + KaraUszkodzenie + KaraOpoznienie;
            text_do_zaplaty.setText(String.valueOf(doZaplaty));
        }

    }

    @FXML
    void Policz_dni() {
        wypozyczenie_liczba_dni.setText(String.valueOf(wypozyczenie_end.getValue().getDayOfYear() - wypozyczenie_start.getValue().getDayOfYear()));
        wypozyczenie_calkowity_koszt.setText(String.valueOf(
                (wypozyczenie_end.getValue().getDayOfYear() - wypozyczenie_start.getValue().getDayOfYear()) * zamowienie_auto.getCena_doba_dk_2015()
        ));

    }

    @FXML
    void Zapisz() {
        session = sesia.openSession();
        session.beginTransaction();
        Criterion id = Expression.eq("id_wypozyczenie_dk_2015", zamowienie);
        Criteria crit = session.createCriteria(wypozyczenie_dk_2015.class);
        crit.add(id);
        wypozyczenie_dk_2015 wynik = (wypozyczenie_dk_2015) crit.uniqueResult();
        
        zwrot_dk_2015 zwrot = new zwrot_dk_2015();
        zwrot.setId_wypozyczenie_dk_2015(wynik);
        zwrot.setKara_dk_2015(Integer.parseInt(text_kara.getText()));
        zwrot.setKoszt_dk_2015(Integer.parseInt(text_do_zaplaty.getText()));
        zwrot.setData_zwrotu_dk_2015(Date.valueOf(data_zwrotu.getValue()));
        session.save(zwrot);
        session.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        session = sesia.openSession();
        session.beginTransaction();
        Criterion id = Expression.eq("id_wypozyczenie_dk_2015", zamowienie);
        Criteria crit = session.createCriteria(wypozyczenie_dk_2015.class);
        crit.add(id);
        wypozyczenie_dk_2015 wynik = (wypozyczenie_dk_2015) crit.uniqueResult();
        session.close();

        id_klient.setText(String.valueOf(wynik.getId_wypozyczenie_dk_2015()));
        id_auto.setText(String.valueOf(wynik.getId_auta_wypozyczenie_dk_2015().getId_dk_2015()));
        auto_marka.setText(wynik.getId_auta_wypozyczenie_dk_2015().getMarka_dk_2015());
        auto_model.setText(wynik.getId_auta_wypozyczenie_dk_2015().getModel_dk_2015());
        auto_rocznik.setText(String.valueOf(wynik.getId_auta_wypozyczenie_dk_2015().getRocznik_dk_2015()));
        auto_skrzynia.setText(wynik.getId_auta_wypozyczenie_dk_2015().getSkrzynia_biegow_dk_2015());
        auto_cena_doba.setText(String.valueOf(wynik.getId_auta_wypozyczenie_dk_2015().getCena_doba_dk_2015()));

        id_pracownik.setText(String.valueOf(wynik.getId_pracownik_wypozyczenie_dk_2015().getId_dk_2015()));
        imie_pracownik.setText(wynik.getId_pracownik_wypozyczenie_dk_2015().getImie_dk_2015());
        nazwisko_pracownik.setText(wynik.getId_pracownik_wypozyczenie_dk_2015().getNazwisko_dk_2015());

        id_klient.setText(String.valueOf(wynik.getId_klient_wypozyczenie_dk_2015().getId_dk_2015()));
        imie_klient.setText(wynik.getId_klient_wypozyczenie_dk_2015().getImie_dk_2015());
        nazwisko_klient.setText(wynik.getId_klient_wypozyczenie_dk_2015().getNazwisko_dk_2015());
        ulica_klient.setText(wynik.getId_klient_wypozyczenie_dk_2015().getAdres_ulica_dk_2015());
        nr_domu_klient.setText(String.valueOf(wynik.getId_klient_wypozyczenie_dk_2015().getAdres_nr_dom_dk_2015()));
        miasto_klient.setText(wynik.getId_klient_wypozyczenie_dk_2015().getAdres_miasto_dk_2015());
        telefon_klient.setText(String.valueOf(wynik.getId_klient_wypozyczenie_dk_2015().getNr_tel_dk_2015()));
        Date date = (Date) wynik.getData_wypozyczenia_dk_2015();
        Instant instant = Instant.ofEpochMilli(date.getTime());
        LocalDate res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        wypozyczenie_start.setValue(res);
        date = (Date) wynik.getData_zwrotu_dk_2015();
        instant = Instant.ofEpochMilli(date.getTime());
        res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        wypozyczenie_end.setValue(res);
        wypozyczenie_liczba_dni.setText(String.valueOf(wypozyczenie_end.getValue().getDayOfYear() - wypozyczenie_start.getValue().getDayOfYear()));
        wypozyczenie_calkowity_koszt.setText(String.valueOf(
                (wypozyczenie_end.getValue().getDayOfYear() - wypozyczenie_start.getValue().getDayOfYear()) * wynik.getId_auta_wypozyczenie_dk_2015().getCena_doba_dk_2015()
        ));
        text_id_wypozyczenie.setText(String.valueOf(wynik.getId_wypozyczenie_dk_2015()));
        data_zwrotu.setValue(LocalDate.now());
        PoliczOpoznienie();
        //wypozyczenie_calkowity_koszt;

    }

}
