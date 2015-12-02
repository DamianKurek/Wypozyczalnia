/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import static aplikacja.Wypozyczalnia.sesia;
import static aplikacja.Wypozyczalnia.session;
import static aplikacja.Wypozyczalnia.zamowienie;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import tabele.klient_dk_2015;
import tabele.pracownik_dk_2015;
import tabele.wypozyczenie_dk_2015;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_Wypozyczenie_Lista2Controller implements Initializable {

    @FXML
    TableView<zwrotTabela> tabela;
    @FXML
    TableColumn<zwrotTabela, Integer> TableColumn1;
    @FXML
    TableColumn<zwrotTabela, String> TableColumn2;
    @FXML
    TableColumn<zwrotTabela, String> TableColumn3;
    @FXML
    TableColumn<zwrotTabela, String> TableColumn4;
    @FXML
    TableColumn<zwrotTabela, String> TableColumn5;
    @FXML
    TableColumn<zwrotTabela, String> TableColumn6;
    @FXML
    TableColumn<zwrotTabela, String> TableColumn7;
    @FXML
    TextField text_nazwisko_szukaj;
    @FXML
    TextField text_id_szukaj;
    public final ObservableList<zwrotTabela> dane = FXCollections.observableArrayList();

    @FXML
    void Odswiez() {
    }

    @FXML
    void WczytajzTabeli() throws IOException {
        zamowienie = tabela.getSelectionModel().getSelectedItem().getId_wypozyczenie_dk_2015();

        System.out.print(zamowienie);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Okno_Wypozyczenie_Zwrot.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Zwrot auta");
        Scene scenaWykres = new Scene(root1);
        stage.setScene(scenaWykres);
        stage.show();
        stage = (Stage) text_id_szukaj.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Wczytaj() {
        dane.clear();
        session = sesia.openSession();
        session.beginTransaction();
        List<wypozyczenie_dk_2015> wynik = session.createQuery("from wypozyczenie_dk_2015").list();
        session.close();
        for (int x = 0; x < wynik.size(); x++) {
            zwrotTabela w = new zwrotTabela();
            w.setId_wypozyczenie_dk_2015(wynik.get(x).getId_wypozyczenie_dk_2015());
            w.setImie_dk_2015(wynik.get(x).getId_klient_wypozyczenie_dk_2015().getImie_dk_2015());
            w.setNazwisko_dk_2015(wynik.get(x).getId_klient_wypozyczenie_dk_2015().getNazwisko_dk_2015());
            w.setMarka_dk_2015(wynik.get(x).getId_auta_wypozyczenie_dk_2015().getMarka_dk_2015());
            w.setModel_dk_2015(wynik.get(x).getId_auta_wypozyczenie_dk_2015().getModel_dk_2015());
            w.setData_wypozyczenia_dk_2015((Date) wynik.get(x).getData_wypozyczenia_dk_2015());
            w.setData_zwrotu_dk_2015((Date) wynik.get(x).getData_zwrotu_dk_2015());
            dane.add(w);
//            
        }
    }

    @FXML
    void Szukaj() {
        if (!text_nazwisko_szukaj.getText().isEmpty()) {
            dane.clear();
            session = sesia.openSession();
            Query query = session.createQuery("from wypozyczenie_dk_2015 as w JOIN fetch w.id_klient_wypozyczenie_dk_2015 where w.id_klient_wypozyczenie_dk_2015.nazwisko_dk_2015 is '" + text_nazwisko_szukaj.getText() + "'");
            List<wypozyczenie_dk_2015> list = query.list();

            for (int x = 0; x < list.size(); x++) {
                zwrotTabela w = new zwrotTabela();
                w.setId_wypozyczenie_dk_2015(list.get(x).getId_wypozyczenie_dk_2015());
                w.setImie_dk_2015(list.get(x).getId_klient_wypozyczenie_dk_2015().getImie_dk_2015());
                w.setNazwisko_dk_2015(list.get(x).getId_klient_wypozyczenie_dk_2015().getNazwisko_dk_2015());
                w.setMarka_dk_2015(list.get(x).getId_auta_wypozyczenie_dk_2015().getMarka_dk_2015());
                w.setModel_dk_2015(list.get(x).getId_auta_wypozyczenie_dk_2015().getModel_dk_2015());
                w.setData_wypozyczenia_dk_2015((Date) list.get(x).getData_wypozyczenia_dk_2015());
                w.setData_zwrotu_dk_2015((Date) list.get(x).getData_zwrotu_dk_2015());
                dane.add(w);

            }
        }
        if (!text_id_szukaj.getText().isEmpty()) {
            dane.clear();
            session = sesia.openSession();
            session.beginTransaction();
            Criterion id = Expression.eq("id_wypozyczenie_dk_2015", Integer.parseInt(text_id_szukaj.getText()));
            Criteria crit = session.createCriteria(wypozyczenie_dk_2015.class);
            crit.add(id);
            wypozyczenie_dk_2015 wynik = (wypozyczenie_dk_2015) crit.uniqueResult();
            session.close();
            zwrotTabela w = new zwrotTabela();
            w.setId_wypozyczenie_dk_2015(wynik.getId_wypozyczenie_dk_2015());
            w.setImie_dk_2015(wynik.getId_klient_wypozyczenie_dk_2015().getImie_dk_2015());
            w.setNazwisko_dk_2015(wynik.getId_klient_wypozyczenie_dk_2015().getNazwisko_dk_2015());
            w.setMarka_dk_2015(wynik.getId_auta_wypozyczenie_dk_2015().getMarka_dk_2015());
            w.setModel_dk_2015(wynik.getId_auta_wypozyczenie_dk_2015().getModel_dk_2015());
            w.setData_wypozyczenia_dk_2015((Date) wynik.getData_wypozyczenia_dk_2015());
            w.setData_zwrotu_dk_2015((Date) wynik.getData_zwrotu_dk_2015());
            dane.add(w);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabela.setItems(dane);

        TableColumn1.setCellValueFactory(
                new PropertyValueFactory<zwrotTabela, Integer>("id_wypozyczenie_dk_2015")//nazwa pola w klasie
        );
        TableColumn2.setCellValueFactory(
                new PropertyValueFactory<zwrotTabela, String>("imie_dk_2015")//nazwa pola w klasie
        );
        TableColumn3.setCellValueFactory(
                new PropertyValueFactory<zwrotTabela, String>("nazwisko_dk_2015")//nazwa pola w klasie
        );
        TableColumn4.setCellValueFactory(
                new PropertyValueFactory<zwrotTabela, String>("model_dk_2015")//nazwa pola w klasie
        );
        TableColumn5.setCellValueFactory(
                new PropertyValueFactory<zwrotTabela, String>("marka_dk_2015")//nazwa pola w klasie
        );
        TableColumn6.setCellValueFactory(
                new PropertyValueFactory<zwrotTabela, String>("data_wypozyczenia_dk_2015")//nazwa pola w klasie
        );
        TableColumn7.setCellValueFactory(
                new PropertyValueFactory<zwrotTabela, String>("data_zwrotu_dk_2015")//nazwa pola w klasie
        );
    }

}
