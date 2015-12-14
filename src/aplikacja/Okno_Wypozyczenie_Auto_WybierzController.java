package aplikacja;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static aplikacja.Wypozyczalnia.*;
import java.net.URL;
import java.time.LocalDate;
import static java.util.Collections.list;
import java.util.Iterator;
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
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import tabele.auta_dk_3i;
import tabele.naprawa_dk_3i;
import tabele.pracownik_dk_3i;
import tabele.wypozyczenie_dk_3i;

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
    TableView<auta_dk_3i> tabela;
    @FXML
    TableColumn<auta_dk_3i, Integer> TableColumn1;
    @FXML
    TableColumn<auta_dk_3i, Integer> TableColumn2;
    @FXML
    TableColumn<auta_dk_3i, String> TableColumn3;
    @FXML
    TableColumn<auta_dk_3i, String> TableColumn4;
    @FXML
    TableColumn<auta_dk_3i, Integer> TableColumn5;
    @FXML
    TableColumn<auta_dk_3i, String> TableColumn6;
    @FXML
    TableColumn<auta_dk_3i, Integer> TableColumn7;
    @FXML
    public final ObservableList<auta_dk_3i> dane = FXCollections.observableArrayList();

    @FXML
    void Zapisz() {
        auta_dk_3i auto = new auta_dk_3i();
        //auto.setId_naprawy_dk_3i(0);
        auto.setMarka_dk_3i(text_marka.getText());
        auto.setModel_dk_3i(text_model.getText());
        auto.setRocznik_dk_3i(Integer.parseInt(text_rocznik.getText()));
        auto.setSkrzynia_biegow_dk_3i(text_skrzynia_biegow.getText());
        auto.setCena_doba_dk_3i(Integer.parseInt(text_cena.getText()));
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

        /////////////////zawraca auta uszkodzone
        Criteria criteria = session.createCriteria(auta_dk_3i.class)
                        .add(Restrictions.eq("uszkodzony_dk_3i", false));
        List<auta_dk_3i> wynik1 = criteria.list();
        for (int x = 0; x < wynik1.size(); x++) {
        
        }
        ///////////////////////////////////////////
        ///////zwraca wypozyczone juz auta/////////////
        Criteria criteria1 = session.createCriteria(wypozyczenie_dk_3i.class)
                        .add(Restrictions.isNull("id_zwrot_dk_3i"));
        List<wypozyczenie_dk_3i> wynik2 = criteria1.list();
        //////////////////////////////////////////////
        ///////////////wszystkie auta//////////////////////
        List<auta_dk_3i> wszystkie = session.createQuery("from auta_dk_3i").list();
        boolean jest=false;
        for (int x = 0; x < wynik1.size(); x++) {
           // System.out.println(wszystkie.get(x).getId_dk_3i());
            for (int y = 0; y < wynik2.size(); y++){
                
                if(wynik1.get(x).getId_dk_3i()==wynik2.get(y).getId_auta_wypozyczenie_dk_3i().getId_dk_3i())
                {
                jest=true;
                }   
            }
            if(!jest)
                dane.add(wynik1.get(x));
            jest=false;
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

        TableColumn1.setCellValueFactory(new PropertyValueFactory<auta_dk_3i, Integer>("id_dk_3i")//nazwa pola w klasie
        );
//        TableColumn2.setCellValueFactory(new PropertyValueFactory<auta_dk_3i, Integer>("id_naprawy_dk_3i")//nazwa pola w klasie
//        );
        TableColumn3.setCellValueFactory(new PropertyValueFactory<auta_dk_3i, String>("marka_dk_3i")//nazwa pola w klasie
        );
        TableColumn4.setCellValueFactory(new PropertyValueFactory<auta_dk_3i, String>("model_dk_3i")//nazwa pola w klasie
        );
        TableColumn5.setCellValueFactory(new PropertyValueFactory<auta_dk_3i, Integer>("rocznik_dk_3i")//nazwa pola w klasie
        );
        TableColumn6.setCellValueFactory(new PropertyValueFactory<auta_dk_3i, String>("skrzynia_biegow_dk_3i")//nazwa pola w klasie
        );
        TableColumn7.setCellValueFactory(new PropertyValueFactory<auta_dk_3i, Integer>("cena_doba_dk_3i")//nazwa pola w klasie
        );
        Wczytaj();
    }

}
