package aplikacja;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static aplikacja.Wypozyczalnia.sesia;
import java.util.Calendar;
import java.util.Date;
import tabele.klient_dk_3i;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tabele.auta_dk_3i;
import tabele.pracownik_dk_3i;
import tabele.wypozyczenie_dk_3i;

/**
 *
 * @author damian
 */
public class Wypozyczalnia extends Application {

    static public SessionFactory sesia;
    static public Session session;
    static public klient_dk_3i zamowienie_klient;
    static public klient_dk_3i edycja_klient;
    static public pracownik_dk_3i zamowienie_pracownik;
    static public auta_dk_3i zamowienie_auto;
    static public int zamowienie;
    static public autoLista auto_naprawa;
    static public pracownik_dk_3i zalogowany_pracownik;
    static public Date data_raport_od;
    static public Date data_raport_do;

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        try {
            sesia = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
// Make sure you log the exception, as it might be swallowed
            System.out.println("Initial SessionFactory creation failed." + ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd Połączenia");
            alert.setContentText("Initial SessionFactory creation failed." + ex);
            alert.showAndWait();
            Platform.exit();
            System.exit(0);

        }
        Parent root = FXMLLoader.load(getClass().getResource("Okno_Logowanie.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        // stage.setResizable(false);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }

}
