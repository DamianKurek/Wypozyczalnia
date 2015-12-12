/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import static aplikacja.Wypozyczalnia.edycja_klient;
import static aplikacja.Wypozyczalnia.sesia;
import static aplikacja.Wypozyczalnia.session;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import tabele.klient_dk_3i;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_Klient_EdycjaController implements Initializable {

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
        session = sesia.openSession();
        Criterion id = Expression.eq("id_dk_3i", edycja_klient.getId_dk_3i());
        Criteria crit = session.createCriteria(klient_dk_3i.class);
        crit.add(id);
        klient_dk_3i klient = (klient_dk_3i) crit.uniqueResult();
        if (text_imie.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("pole imie nie możę być puste");
            alert.showAndWait();
        } else if (text_nazwisko.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("pole nazwisko nie możę być puste");
            alert.showAndWait();
        } else if (text_miasto.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("pole miasto nie możę być puste");
            alert.showAndWait();
        } else if (text_ulica.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("pole ulica nie możę być puste");
            alert.showAndWait();
        } else if (text_nr_domu.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("pole numer domu nie możę być puste");
            alert.showAndWait();
        } else {
            //update klienta
            klient.setImie_dk_3i(text_imie.getText());
            klient.setNazwisko_dk_3i(text_nazwisko.getText());
            klient.setAdres_miasto_dk_3i(text_miasto.getText());
            klient.setAdres_ulica_dk_3i(text_ulica.getText());
            klient.setAdres_nr_dom_dk_3i(Integer.parseInt(text_nr_domu.getText()));
            klient.setNr_tel_dk_3i(Integer.parseInt(text_telefon.getText()));
            //zapisane do bazy
            session.beginTransaction();
            session.update(klient);
            session.getTransaction().commit();
            session.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Zapis");
            alert.setHeaderText("Edycja");
            alert.setContentText("Poprawnia zmieniono dane");
            alert.showAndWait();

            Stage stage = new Stage();
            stage = (Stage) text_imie.getScene().getWindow();
            stage.close();

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        text_id.setText(String.valueOf(edycja_klient.getId_dk_3i()));
        text_imie.setText(edycja_klient.getImie_dk_3i());
        text_nazwisko.setText(edycja_klient.getNazwisko_dk_3i());
        text_miasto.setText(edycja_klient.getAdres_miasto_dk_3i());
        text_ulica.setText(edycja_klient.getAdres_ulica_dk_3i());
        text_nr_domu.setText(String.valueOf(edycja_klient.getAdres_nr_dom_dk_3i()));
        text_telefon.setText(String.valueOf(edycja_klient.getNr_tel_dk_3i()));

        text_imie.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_imie.getText().charAt(oldValue.intValue());
                    if ((ch >= '0' && ch <= '9')) {
                        text_imie.setText(text_imie.getText().substring(0, text_imie.getText().length() - 1));
                    }
                    if(text_telefon.getText().length()>9){
                        text_telefon.setText(text_telefon.getText().substring(0, text_telefon.getText().length() - 1));
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
        text_miasto.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_miasto.getText().charAt(oldValue.intValue());
                    if ((ch >= '0' && ch <= '9')) {
                        text_miasto.setText(text_miasto.getText().substring(0, text_miasto.getText().length() - 1));
                    }
                }
            }

        });

        text_nr_domu.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_nr_domu.getText().charAt(oldValue.intValue());
                    if (!(ch >= '0' && ch <= '9')) {
                        text_nr_domu.setText(text_nr_domu.getText().substring(0, text_nr_domu.getText().length() - 1));
                    }
                }
            }

        });
        text_telefon.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_telefon.getText().charAt(oldValue.intValue());
                    if (!(ch >= '0' && ch <= '9')) {
                        text_telefon.setText(text_telefon.getText().substring(0, text_telefon.getText().length() - 1));
                    }
                }
            }

        });
    }

}
