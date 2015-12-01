/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import static aplikacja.Wypozyczalnia.sesia;
import static aplikacja.Wypozyczalnia.session;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
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
public class Okno_Wypozyczenie_ListaController implements Initializable {

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
    public final ObservableList<zwrotTabela> dane = FXCollections.observableArrayList();

    @FXML
    void Wczytaj() {

    }

    @FXML
    void Szukaj() {
//        session = sesia.openSession();
//        klient_dk_2015 klient = new klient_dk_2015();
//        klient.setImie_dk_2015(text_nazwisko_szukaj.getText());
//        Criterion imie = Expression.eq("id_klient_wypozyczenie_dk_2015", klient);
//        Criteria crit = session.createCriteria(wypozyczenie_dk_2015.class);
//        crit.add(imie);
//        List <wypozyczenie_dk_2015> wynik = crit.list();
//        //System.out.print(wynik.get(0).getId_klient_wypozyczenie_dk_2015().getImie_dk_2015());
//        zwrotTabela wynikTabel = new zwrotTabela();
//       // for(int x=0;x<wynik.size();x++){
//            //wynikTabel.setId_wypozyczenie_dk_2015(wynik.get(x).getId_wypozyczenie_dk_2015());
//            //wynikTabel.setImie_dk_2015(wynik.get(x).getId_klient_wypozyczenie_dk_2015().getImie_dk_2015());
//            //dane.add(wynikTabel);
//        //}
       session = sesia.openSession();
       String t="Kurek";
            Criterion imie = Expression.eq("id_klient_wypozyczenie_dk_2015", t);
            Criteria crit = session.createCriteria(wypozyczenie_dk_2015.class);
            crit.add(imie);
            List<wypozyczenie_dk_2015> p = crit.list();
   
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
