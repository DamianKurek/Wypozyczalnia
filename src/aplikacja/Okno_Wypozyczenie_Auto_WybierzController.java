package aplikacja;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static aplikacja.Wypozyczalnia.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import tabele.auta_dk_2015;
import tabele.pracownik_dk_2015;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_Wypozyczenie_Auto_WybierzController implements Initializable {

    @FXML
    TextField text_id;
    @FXML
    TextField text_marka;
    @FXML
    TextField text_model;
    @FXML
    TextField text_rocznik;
    @FXML
    TextField text_skrzynia_biegow;
    @FXML
    TextField text_cena;
    @FXML
    TableView<auta_dk_2015> tabela;
    @FXML
    TableColumn<auta_dk_2015, Integer> TableColumn1;
    @FXML
    TableColumn<auta_dk_2015, Integer> TableColumn2;
    @FXML
    TableColumn<auta_dk_2015, String> TableColumn3;
    @FXML
    TableColumn<auta_dk_2015, String> TableColumn4;
    @FXML
    TableColumn<auta_dk_2015, Integer> TableColumn5;
    @FXML
    TableColumn<auta_dk_2015, String> TableColumn6;
    @FXML
    TableColumn<auta_dk_2015, Integer> TableColumn7;
    @FXML
    public final ObservableList<auta_dk_2015> dane = FXCollections.observableArrayList();

    @FXML
    void Zapisz() {
        auta_dk_2015 auto = new auta_dk_2015();
        auto.setId_naprawy_dk_2015(0);
        auto.setMarka_dk_2015(text_marka.getText());
        auto.setModel_dk_2015(text_model.getText());
        auto.setRocznik_dk_2015(Integer.parseInt(text_rocznik.getText()));
        auto.setSkrzynia_biegow_dk_2015(text_skrzynia_biegow.getText());
        auto.setCena_doba_dk_2015(Integer.parseInt(text_cena.getText()));
        session = sesia.openSession();
        //zapisane do bazy
        session.beginTransaction();
        session.save(auto);
        session.getTransaction().commit();
        session.close();
    }

    @FXML
    void Wczytaj() {
        dane.clear();
        session = sesia.openSession();
        session.beginTransaction();
        Criterion imie = Expression.eq("id_naprawy_dk_2015", 0);
        Criteria crit = session.createCriteria(auta_dk_2015.class);
        crit.add(imie);
        
        List<auta_dk_2015> wynik = crit.list();
        session.close();
        for (int x = 0; x < wynik.size(); x++) {

            dane.add(wynik.get(x));
        }
    }

    @FXML
    void Wybierz_z_Tabeli() {
        zamowienie_auto = tabela.getSelectionModel().getSelectedItem();
        Stage stage = (Stage) tabela.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabela.setItems(dane);

        TableColumn1.setCellValueFactory(new PropertyValueFactory<auta_dk_2015, Integer>("id_dk_2015")//nazwa pola w klasie
        );
        TableColumn2.setCellValueFactory(new PropertyValueFactory<auta_dk_2015, Integer>("id_naprawy_dk_2015")//nazwa pola w klasie
        );
        TableColumn3.setCellValueFactory(new PropertyValueFactory<auta_dk_2015, String>("marka_dk_2015")//nazwa pola w klasie
        );
        TableColumn4.setCellValueFactory(new PropertyValueFactory<auta_dk_2015, String>("model_dk_2015")//nazwa pola w klasie
        );
        TableColumn5.setCellValueFactory(new PropertyValueFactory<auta_dk_2015, Integer>("rocznik_dk_2015")//nazwa pola w klasie
        );
        TableColumn6.setCellValueFactory(new PropertyValueFactory<auta_dk_2015, String>("skrzynia_biegow_dk_2015")//nazwa pola w klasie
        );
        TableColumn7.setCellValueFactory(new PropertyValueFactory<auta_dk_2015, Integer>("cena_doba_dk_2015")//nazwa pola w klasie
        );
        Wczytaj();
    }

}
