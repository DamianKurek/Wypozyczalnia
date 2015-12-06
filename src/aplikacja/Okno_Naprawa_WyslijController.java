/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import static aplikacja.Wypozyczalnia.auto_naprawa;
import static aplikacja.Wypozyczalnia.sesia;
import static aplikacja.Wypozyczalnia.session;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import tabele.auta_dk_3i;
import tabele.klient_dk_3i;
import tabele.naprawa_dk_3i;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_Naprawa_WyslijController implements Initializable {

    @FXML
    TextField text_cena_naprawy;
    @FXML
    TextArea text_opis_naprawy;

    @FXML
    void Zapisz() {
        session = sesia.openSession();
        Criterion id = Expression.eq("id_dk_3i", auto_naprawa.getId_auto_dk_3i());
        //Criterion id = Expression.eq("id_dk_3i", 9);
        Criteria crit = session.createCriteria(auta_dk_3i.class);
        crit.add(id);
        auta_dk_3i auto = (auta_dk_3i) crit.uniqueResult();

        session.beginTransaction();
        naprawa_dk_3i naprawa = new naprawa_dk_3i();
        naprawa.setOpis_naprawa_3i(text_opis_naprawy.getText());
        naprawa.setCena_naprawa_dk_3i(Integer.parseInt(text_cena_naprawy.getText()));
        naprawa.setId_auto_dk_3i(auto);

        auto.setId_naprawy_dk_3i(naprawa);
        auto.setUszkodzony_dk_3i(true);
        session.save(naprawa);
        session.update(auto);
        session.getTransaction().commit();
        session.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacja");
        alert.setHeaderText("Aktualizacja auta");
        alert.setContentText("Auto zostało wysłane do naprawy");
        alert.showAndWait();
         Stage  stage = (Stage) text_opis_naprawy.getScene().getWindow();
         stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        text_opis_naprawy.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_opis_naprawy.getText().charAt(oldValue.intValue());
                    if ((ch >= '0' && ch <= '9')) {
                        text_opis_naprawy.setText(text_opis_naprawy.getText().substring(0, text_opis_naprawy.getText().length() - 1));
                    }
                }
            }

        });
        text_cena_naprawy.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_cena_naprawy.getText().charAt(oldValue.intValue());
                    if (!(ch >= '0' && ch <= '9')) {
                        text_cena_naprawy.setText(text_cena_naprawy.getText().substring(0, text_cena_naprawy.getText().length() - 1));
                    }
                }
            }

        });
    }

}
