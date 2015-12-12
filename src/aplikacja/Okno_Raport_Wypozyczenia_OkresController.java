/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import static aplikacja.Wypozyczalnia.data_raport_do;
import static aplikacja.Wypozyczalnia.data_raport_od;
import static aplikacja.Wypozyczalnia.sesia;
import static aplikacja.Wypozyczalnia.session;
import java.net.URL;
import java.sql.Date;
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
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import tabele.wypozyczenie_dk_3i;
import tabele.zwrot_dk_3i;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_Raport_Wypozyczenia_OkresController implements Initializable {
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
    public final ObservableList<zwrotTabela> dane = FXCollections.observableArrayList();
    @FXML TextField text_ilosc;
    @FXML TextField text_koszt;
    int suma=0;
  void Wczytaj() {
        dane.clear();
        suma=0;
        session = sesia.openSession();

        Criterion id = Expression.between("data_zwrotu_dk_3i", data_raport_od, data_raport_do);
        Criteria crit = session.createCriteria(zwrot_dk_3i.class);
        crit.add(id);
        List<zwrot_dk_3i> wynik = crit.list();
        session.close();
        for (int x = 0; x < wynik.size(); x++) {
          zwrotTabela w = new zwrotTabela();
                w.setId_wypozyczenie_dk_3i(wynik.get(x).getId_wypozyczenie_dk_3i().getId_wypozyczenie_dk_3i());
                w.setImie_dk_3i(wynik.get(x).getId_wypozyczenie_dk_3i().getId_klient_wypozyczenie_dk_3i().getImie_dk_3i());
                w.setNazwisko_dk_3i(wynik.get(x).getId_wypozyczenie_dk_3i().getId_klient_wypozyczenie_dk_3i().getNazwisko_dk_3i());
                w.setMarka_dk_3i(wynik.get(x).getId_wypozyczenie_dk_3i().getId_auta_wypozyczenie_dk_3i().getMarka_dk_3i());
                w.setModel_dk_3i(wynik.get(x).getId_wypozyczenie_dk_3i().getId_auta_wypozyczenie_dk_3i().getModel_dk_3i());
                w.setData_wypozyczenia_dk_3i((Date) wynik.get(x).getId_wypozyczenie_dk_3i().getData_wypozyczenia_dk_3i());
                w.setData_zwrotu_dk_3i((Date) wynik.get(x).getData_zwrotu_dk_3i());
                dane.add(w);
                suma+=(wynik.get(x).getKoszt_dk_3i()+wynik.get(x).getKara_dk_3i());
//            
        }
        text_ilosc.setText(String.valueOf(wynik.size()));
        text_koszt.setText(String.valueOf(suma));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TableColumn1.setCellValueFactory(
                new PropertyValueFactory<zwrotTabela, Integer>("id_wypozyczenie_dk_3i")//nazwa pola w klasie
        );
        TableColumn2.setCellValueFactory(
                new PropertyValueFactory<zwrotTabela, String>("imie_dk_3i")//nazwa pola w klasie
        );
        TableColumn3.setCellValueFactory(
                new PropertyValueFactory<zwrotTabela, String>("nazwisko_dk_3i")//nazwa pola w klasie
        );
        TableColumn4.setCellValueFactory(
                new PropertyValueFactory<zwrotTabela, String>("model_dk_3i")//nazwa pola w klasie
        );
        TableColumn5.setCellValueFactory(
                new PropertyValueFactory<zwrotTabela, String>("marka_dk_3i")//nazwa pola w klasie
        );
        TableColumn6.setCellValueFactory(
                new PropertyValueFactory<zwrotTabela, String>("data_wypozyczenia_dk_3i")//nazwa pola w klasie
        );
        TableColumn7.setCellValueFactory(
                new PropertyValueFactory<zwrotTabela, String>("data_zwrotu_dk_3i")//nazwa pola w klasie
        );
        tabela.setItems(dane);
        Wczytaj();
    }    
    
}
