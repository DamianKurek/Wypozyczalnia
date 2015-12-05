package aplikacja;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static aplikacja.Wypozyczalnia.sesia;
import static aplikacja.Wypozyczalnia.session;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Pair;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import tabele.pracownik_dk_3i;
import static aplikacja.Wypozyczalnia.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_LogowanieController implements Initializable {

    /**
     * Initializes the controller class.
     */
    GregorianCalendar data = new GregorianCalendar();
    @FXML
    Label data1;
    @FXML
    Label data2;
    @FXML
    Label text_stopka;
    @FXML
    Button zaloguj;
    @FXML
    TextField text_login;
    @FXML
    TextField text_haslo;

    @FXML
    void Login() throws IOException {
        if (!text_login.getText().toString().isEmpty() && !text_haslo.getText().toString().isEmpty()) {
            session = sesia.openSession();
            Criterion id = Expression.eq("id_dk_3i", Integer.parseInt(text_login.getText()));
            Criteria crit = session.createCriteria(pracownik_dk_3i.class);
            crit.add(id);
            pracownik_dk_3i pracownik = (pracownik_dk_3i) crit.uniqueResult();
            session.close();
            if (pracownik == null) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Błąd");
                alert.setHeaderText("Błąd logowania");
                alert.setContentText("Brak Pracownika w bazie danych");
                alert.showAndWait();
            } else {
                if (pracownik.getNazwisko_dk_3i().equals(text_haslo.getText().toString())) {
                    zalogowany_pracownik = pracownik;
                    zamowienie_pracownik = pracownik;
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));

                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = stage = (Stage) text_haslo.getScene().getWindow();
                    stage.centerOnScreen();
                    stage.setTitle("Klienci");
                    Scene scenaWykres = new Scene(root1);
                    stage.setScene(scenaWykres);
                    stage.show();

                    stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                        @Override
                        public void handle(WindowEvent t) {
                            Platform.exit();
                            System.exit(0);
                        }
                    });

                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Błąd");
                    alert.setHeaderText("Błąd logowania");
                    alert.setContentText("Błędne hasło");
                    alert.showAndWait();
                }

            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd logowania");
            alert.setContentText("wprawadz dane logowania");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
        fmt.setCalendar(data);
        String dateFormatted = fmt.format(data.getTime());
        data1.setText(dateFormatted);
        data.add(Calendar.DAY_OF_MONTH, 3820);
        fmt.setCalendar(data);
        dateFormatted = fmt.format(data.getTime());
        data2.setText(dateFormatted);
        text_stopka.setText("Damian Kurek     Legitymacja:3820     Grupa:3i");
        text_login.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_login.getText().charAt(oldValue.intValue());
                    if (!(ch >= '0' && ch <= '9')) {
                        text_login.setText(text_login.getText().substring(0, text_login.getText().length() - 1));
                    }
                }
            }

        });
         text_haslo.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_haslo.getText().charAt(oldValue.intValue());
                    if ((ch >= '0' && ch <= '9')) {
                        text_haslo.setText(text_haslo.getText().substring(0, text_haslo.getText().length() - 1));
                    }
                }
            }

        });

    }

}
