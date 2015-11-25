/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tabele.klient_dk_2015;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_KlientController implements Initializable {

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
    void Szukaj() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //SessionFactory sesia = new Configuration().configure().buildSessionFactory();
        //Session session = sesia.openSession();

        //session.close();
    }

}
