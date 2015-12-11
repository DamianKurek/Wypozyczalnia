/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import static aplikacja.Wypozyczalnia.sesia;
import static aplikacja.Wypozyczalnia.session;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Subqueries;
import tabele.auta_dk_3i;
import tabele.naprawa_dk_3i;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_Raport_AutaBezawaryjneController implements Initializable {

    @FXML//tabela aut
    TableView<autoLista> tabela;
    @FXML
    TableColumn<autoLista, Integer> TableColumn1;

    @FXML
    TableColumn<autoLista, String> TableColumn3;
    @FXML
    TableColumn<autoLista, String> TableColumn4;
    @FXML
    TableColumn<autoLista, Integer> TableColumn5;
    @FXML
    TableColumn<autoLista, String> TableColumn6;
    @FXML
    TableColumn<autoLista, Integer> TableColumn7;

     @FXML
    public final ObservableList<autoLista> dane = FXCollections.observableArrayList();
     @FXML
    void Wczytaj() {}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        session = sesia.openSession();
        Criteria criteria = session.createCriteria(auta_dk_3i.class)
                .add(Subqueries.propertyNotIn("id_dk_3i", DetachedCriteria.forClass(naprawa_dk_3i.class)
                                .createAlias("id_auto_dk_3i", "a")
                                .setProjection(Property.forName("a.id_dk_3i"))
                        ));
        List<auta_dk_3i> wynik = criteria.list();
        for (int x = 0; x < wynik.size(); x++) {
            System.out.println(wynik.get(x).getModel_dk_3i());
            autoLista auto = new autoLista();
            auto.setId_auto_dk_3i(wynik.get(x).getId_dk_3i());
            auto.setMarka_dk_3i(wynik.get(x).getMarka_dk_3i());
            auto.setModel_dk_3i(wynik.get(x).getModel_dk_3i());
            auto.setRocznik_dk_3i(wynik.get(x).getRocznik_dk_3i());
            auto.setSkrzynia_biegow_dk_3i(wynik.get(x).getSkrzynia_biegow_dk_3i());
            if (wynik.get(x).getId_naprawy_dk_3i() != null) {
                auto.setId_naprawy_dk_3i(wynik.get(x).getId_naprawy_dk_3i().getId_naprawa_dk_3i());
            }
            auto.setUszkodzony_dk_3i(wynik.get(x).isUszkodzony_dk_3i());
            auto.setCena_doba_dk_3i(wynik.get(x).getCena_doba_dk_3i());
            dane.add(auto);
        }
       
        tabela.setItems(dane);
        TableColumn1.setCellValueFactory(new PropertyValueFactory<autoLista, Integer>("id_auto_dk_3i")//nazwa pola w klasie
        );
        TableColumn3.setCellValueFactory(new PropertyValueFactory<autoLista, String>("marka_dk_3i")//nazwa pola w klasie
        );
        TableColumn4.setCellValueFactory(new PropertyValueFactory<autoLista, String>("model_dk_3i")//nazwa pola w klasie
        );
        TableColumn5.setCellValueFactory(new PropertyValueFactory<autoLista, Integer>("rocznik_dk_3i")//nazwa pola w klasie
        );
        TableColumn6.setCellValueFactory(new PropertyValueFactory<autoLista, String>("skrzynia_biegow_dk_3i")//nazwa pola w klasie
        );
        TableColumn7.setCellValueFactory(new PropertyValueFactory<autoLista, Integer>("cena_doba_dk_3i")//nazwa pola w klasie
        );

    }

}
