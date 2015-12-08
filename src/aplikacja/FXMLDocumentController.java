package aplikacja;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static aplikacja.Wypozyczalnia.zalogowany_pracownik;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
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
    @FXML Button button_klienci;
    @FXML
    Label text_zalogowany_pracownik;
    
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
        stage.setTitle("Pracownicy");
        Scene scenaWykres = new Scene(root1);
        stage.setScene(scenaWykres);
        stage.show();
    }
    
    @FXML
    private void OknoAuta(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Okno_Auta.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Auta");
        Scene scenaWykres = new Scene(root1);
        stage.setScene(scenaWykres);
        stage.show();
    }
    
    @FXML
    private void OknoWypozyczenie(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Okno_Wypozyczenia.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Wypożyczenie");
        Scene scenaWykres = new Scene(root1);
        stage.setScene(scenaWykres);
        stage.show();
       
    }
    @FXML
    private void OknoRaporty(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Okno_Raporty.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Raporty");
        Scene scenaWykres = new Scene(root1);
        stage.setScene(scenaWykres);
        stage.show();
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        text_zalogowany_pracownik.setText(zalogowany_pracownik.getImie_dk_3i() + " " + zalogowany_pracownik.getNazwisko_dk_3i());
        
    }
    
}
