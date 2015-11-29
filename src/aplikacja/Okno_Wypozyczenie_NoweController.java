/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import java.io.IOException;
import java.net.URL;
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

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_Wypozyczenie_NoweController implements Initializable {

    @FXML static public Label id_klient;
    @FXML Label id_pracownik;
    @FXML Label id_auto;
    @FXML Label id_wypozyczenie;
    @FXML TextField imie_klient;
    @FXML TextField nazwisko_klient;
    @FXML TextField ulica_klient;
    @FXML TextField nr_domu_klient;
    @FXML TextField miasto_klient;
    @FXML TextField telefon_klient;
    @FXML TextField imie_pracownik;
    @FXML TextField nazwisko_pracownik;
    @FXML TextField auto_marka;
    @FXML TextField auto_model;
    @FXML TextField auto_rocznik;
    @FXML TextField auto_skrzynia;
    @FXML TextField auto_cena_doba;
    @FXML DatePicker wypozyczenie_start;
    @FXML DatePicker wypozyczenie_end;
    @FXML TextField wypozyczenie_liczba_dni;
    @FXML static public TextField wypozyczenie_calkowity_koszt;
    static public int test=0;
    @FXML void Okno_Wybierz_klient() throws IOException{
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Okno_Wypozyczenie_Klient_Wybierz.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Lista Wypozycze");
        Scene scenaWykres = new Scene(root1);
        stage.setScene(scenaWykres);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
