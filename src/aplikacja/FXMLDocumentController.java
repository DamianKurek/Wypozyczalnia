package aplikacja;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author damian
 */
public class FXMLDocumentController implements Initializable {

    GregorianCalendar data = new GregorianCalendar();
    @FXML
    private Label data1;
    @FXML
    private Label data2;

    @FXML
    private void OknoKlient(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Okno_Klient.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Klienci");
        Scene scenaWykres = new Scene(root1);
        stage.setScene(scenaWykres);
        stage.show();
    }

    @FXML
    private void OknopRracownik(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Okno_Pracownik.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Klienci");
        Scene scenaWykres = new Scene(root1);
        stage.setScene(scenaWykres);
        stage.show();
    }

    @FXML
    private void OknoAuta(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Okno_Auta.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Klienci");
        Scene scenaWykres = new Scene(root1);
        stage.setScene(scenaWykres);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //##############daty##############

        //EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("BazaDanych");
        //EntityManager entityManager=entityManagerFactory.createEntityManager();
        //entityManager.close();
        //entityManagerFactory.close();
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
        fmt.setCalendar(data);
        String dateFormatted = fmt.format(data.getTime());
        data1.setText(dateFormatted);
        data.add(Calendar.DAY_OF_MONTH, 1);
        fmt.setCalendar(data);
        dateFormatted = fmt.format(data.getTime());
        data2.setText(dateFormatted);
        //####################################

    }

}
