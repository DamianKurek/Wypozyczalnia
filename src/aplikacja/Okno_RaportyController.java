/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import static aplikacja.Wypozyczalnia.sesia;
import static aplikacja.Wypozyczalnia.session;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import tabele.auta_dk_3i;
import tabele.wypozyczenie_dk_3i;
import tabele.zwrot_dk_3i;
import static aplikacja.Wypozyczalnia.*;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Okno_RaportyController implements Initializable {

    @FXML
    DatePicker data_do;
    @FXML
    DatePicker data_od;

    @FXML
    void Suma_Oplat()throws IOException  {
        LocalDate localDate = data_od.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        data_raport_od = Date.from(instant);
        localDate = data_do.getValue();
        instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        data_raport_do = Date.from(instant);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Okno_Raport_Suma_Oplat.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Suma Opłat");
        Scene scenaWykres = new Scene(root1);
        stage.setScene(scenaWykres);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
