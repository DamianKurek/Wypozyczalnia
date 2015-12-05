package aplikacja;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static aplikacja.Wypozyczalnia.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.fxml.Initializabimport javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
//import jimport javafx.stage.Stage;
//avafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.persistence.OneToOne;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import tabele.auta_dk_3i;
import tabele.klient_dk_3i;
import tabele.naprawa_dk_3i;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_Auta_Controller implements Initializable {

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
    TextField text_szukaj_marka;
    @FXML
    TextField text_szukaj_model;
    @FXML
    ChoiceBox szukaj_skrzynia;
    @FXML
    TextField text_szukaj_cena_stop;
    @FXML
    TextField text_szukaj_cena_start;
    @FXML
    CheckBox check_szukaj_dostepne;
    @FXML
    TableView<autoLista> tabela;
    @FXML
    TableColumn<autoLista, Integer> TableColumn1;
    @FXML
    TableColumn<autoLista, Integer> TableColumn2;
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
    TableColumn<autoLista, Boolean> TableColumn8;
    @FXML
    public final ObservableList<autoLista> dane = FXCollections.observableArrayList();

    @FXML
    void Zapisz() {
        ///sprawdzanie warunki!text_model.getText().toString().isEmpty()
        if (text_marka.getText().toString().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("Brak marki auta");
            alert.showAndWait();
        } else if (text_model.getText().toString().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("Brak modelu auta");
            alert.showAndWait();

        } else if (text_rocznik.getText().toString().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("Brak rocznika auta");
            alert.showAndWait();

        } else if ((Integer.parseInt(text_rocznik.getText())) < 1950) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("Błąd rocznika auta");
            alert.showAndWait();

        } else if ((Integer.parseInt(text_rocznik.getText())) > 2015) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("Błąd rocznika auta");
            alert.showAndWait();

        } else if (!(text_skrzynia_biegow.getText().toString().trim().matches("manualna")) && !(text_skrzynia_biegow.getText().toString().trim().matches("automatyczna"))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("Dostępne skrzynie biegów to: manualna lub automatyczna2");
            alert.showAndWait();
        } else if (text_cena.getText().toString().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("brak ceny");
            alert.showAndWait();
        } else {
            auta_dk_3i auto = new auta_dk_3i();
            naprawa_dk_3i naprawa = new naprawa_dk_3i();

            naprawa.setId_auto_dk_3i(auto);
            naprawa.setCena_naprawa_dk_3i(999);
            naprawa.setOpis_naprawa_3i("fesfs");
            auto.setId_naprawy_dk_3i(naprawa);
            //auto.setId_naprawy_dk_3i(1);
            auto.setUszkodzony_dk_3i(false);
            auto.setMarka_dk_3i(text_marka.getText());
            auto.setModel_dk_3i(text_model.getText());
            auto.setRocznik_dk_3i(Integer.parseInt(text_rocznik.getText()));
            auto.setSkrzynia_biegow_dk_3i(text_skrzynia_biegow.getText());
            auto.setCena_doba_dk_3i(Integer.parseInt(text_cena.getText()));
            session = sesia.openSession();
            //zapisane do bazy
            session.beginTransaction();
            session.save(naprawa);
            session.save(auto);
            session.getTransaction().commit();
            session.close();
        }

    }
    autoLista auto = new autoLista();

    @FXML
    void Wczytaj() {
        dane.clear();
        session = sesia.openSession();
        session.beginTransaction();
        List<auta_dk_3i> wynik = session.createQuery("from auta_dk_3i").list();
        session.close();
        for (int x = 0; x < wynik.size(); x++) {
//            System.out.println(wynik.get(x).getId_dk_3i() + " "
//                    + wynik.get(x).getImie_dk_3i() + " "
//                    + wynik.get(x).getNazwisko_dk_3i()
//            );
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
    }

    @FXML
    void Szukaj() {
        if (!text_szukaj_marka.getText().isEmpty()) {
            dane.clear();
            session = sesia.openSession();
            Criterion id = Expression.eq("marka_dk_3i", text_szukaj_marka.getText());
            Criteria crit = session.createCriteria(auta_dk_3i.class);
            crit.add(id);
            List<auta_dk_3i> wynik = crit.list();
            if (!wynik.isEmpty()) {
                for (int x = 0; x < wynik.size(); x++) {
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
            }
        }
        if (!text_szukaj_model.getText().isEmpty()) {
            dane.clear();
            session = sesia.openSession();
            Criterion id = Expression.eq("model_dk_3i", text_szukaj_model.getText());
            Criteria crit = session.createCriteria(auta_dk_3i.class);
            crit.add(id);
            List<auta_dk_3i> wynik = crit.list();
            if (!wynik.isEmpty()) {
                for (int x = 0; x < wynik.size(); x++) {
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
            }
        }
        if (szukaj_skrzynia.getValue() != null) {
            dane.clear();
            session = sesia.openSession();
            Criterion id = Expression.eq("skrzynia_biegow_dk_3i", szukaj_skrzynia.getValue().toString());
            Criteria crit = session.createCriteria(auta_dk_3i.class);
            crit.add(id);
            List<auta_dk_3i> wynik = crit.list();
            if (!wynik.isEmpty()) {
                for (int x = 0; x < wynik.size(); x++) {
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
            }
        }
        if (!text_szukaj_cena_stop.getText().isEmpty()) {
            dane.clear();
            session = sesia.openSession();
            Criterion id = Expression.between("cena_doba_dk_3i",
                    Integer.parseInt(text_szukaj_cena_start.getText()),
                    Integer.parseInt(text_szukaj_cena_stop.getText()));
            Criteria crit = session.createCriteria(auta_dk_3i.class);
            crit.add(id);
            List<auta_dk_3i> wynik = crit.list();
            if (!wynik.isEmpty()) {
                for (int x = 0; x < wynik.size(); x++) {
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
            }
        }
    }

    @FXML
    void RightClick() throws IOException {
        //Group root = new Group();
        //field == tabela
        //txtNode == tabela
        ContextMenu menu = new ContextMenu();
        MenuItem item1 = new MenuItem("Oddaj do naprawy");
        MenuItem item2 = new MenuItem("Powrót z naprawy");
        MenuItem item3 = new MenuItem("Oznacz jako uszkodzone");
        menu.getItems().addAll(item1, item2, item3);

        tabela.setContextMenu(menu);
        item1.setOnAction(event -> {
            auto_naprawa = tabela.getSelectionModel().getSelectedItem();
            if (auto_naprawa.getId_naprawy_dk_3i() != 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Błąd");
                alert.setHeaderText("Błąd");
                alert.setContentText("to Auto już jest w naprawie");
                alert.showAndWait();
            } else {
                try {

                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Okno_Naprawa_Wyslij.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Naprawa");
                    Scene scenaWykres = new Scene(root1);
                    stage.setScene(scenaWykres);
                    stage.show();

                } catch (IOException e) {

                }
            }
        });
        item2.setOnAction(event -> {
            auto_naprawa = tabela.getSelectionModel().getSelectedItem();
            if (auto_naprawa.getId_naprawy_dk_3i() == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Błąd");
                alert.setHeaderText("Błąd");
                alert.setContentText("to Auto nie jest w naprawie");
                alert.showAndWait();
            } else {
                session = sesia.openSession();
                Criterion id = Expression.eq("id_dk_3i", auto_naprawa.getId_auto_dk_3i());
                Criteria crit = session.createCriteria(auta_dk_3i.class);
                crit.add(id);
                auta_dk_3i auto = (auta_dk_3i) crit.uniqueResult();
                auto.setId_naprawy_dk_3i(null);
                auto.setUszkodzony_dk_3i(false);
                session.beginTransaction();

                session.update(auto);
                session.getTransaction().commit();
                session.close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informacja");
                alert.setHeaderText("Aktualizacja auta");
                alert.setContentText("Auto zostało odebrane z naprawy");
                alert.showAndWait();
                Wczytaj();
            }
        });
        item3.setOnAction(event -> {
            auto_naprawa = tabela.getSelectionModel().getSelectedItem();
            if (auto_naprawa.getId_naprawy_dk_3i() != 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Błąd");
                alert.setHeaderText("Błąd");
                alert.setContentText("to Auto jest oznaczone jako uszkodzene i jest już w naprawie");
                alert.showAndWait();
            } else if (auto_naprawa.isUszkodzony_dk_3i()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Błąd");
                alert.setHeaderText("Błąd");
                alert.setContentText("to Auto jest oznaczone jako uszkodzene");
                alert.showAndWait();
            } else {
                session = sesia.openSession();
                session.beginTransaction();
                Criterion id = Expression.eq("id_dk_3i", auto_naprawa.getId_auto_dk_3i());
                Criteria crit = session.createCriteria(auta_dk_3i.class);
                crit.add(id);
                auta_dk_3i auto = (auta_dk_3i) crit.uniqueResult();
                auto.setUszkodzony_dk_3i(true);
                session.update(auto);
                session.getTransaction().commit();
                session.close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informacja");
                alert.setHeaderText("Aktualizacja auta");
                alert.setContentText("Auto oznaczone jako uszkodzone");
                alert.showAndWait();
                Wczytaj();
            }
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabela.setItems(dane);

        TableColumn1.setCellValueFactory(new PropertyValueFactory<autoLista, Integer>("id_auto_dk_3i")//nazwa pola w klasie
        );
        TableColumn2.setCellValueFactory(new PropertyValueFactory<autoLista, Integer>("id_naprawy_dk_3i")//nazwa pola w klasie
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
        TableColumn8.setCellValueFactory(new PropertyValueFactory<autoLista, Boolean>("uszkodzony_dk_3i")//nazwa pola w klasie
        );
        szukaj_skrzynia.setItems(FXCollections.observableArrayList("manualna", "automatyczna"));
        session = sesia.openSession();
        Long f = (Long) session.createCriteria("tabele.auta_dk_3i").setProjection(Projections.rowCount()).uniqueResult();
        text_id.setText(String.valueOf(f + 1));
        session.close();
        text_rocznik.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_rocznik.getText().charAt(oldValue.intValue());
                    if (!(ch >= '0' && ch <= '9')) {
                        text_rocznik.setText(text_rocznik.getText().substring(0, text_rocznik.getText().length() - 1));
                    }
                }
            }

        });
        text_marka.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_marka.getText().charAt(oldValue.intValue());
                    if (ch >= '0' && ch <= '9') {
                        text_marka.setText(text_marka.getText().substring(0, text_marka.getText().length() - 1));
                    }
                }
            }

        });
        text_model.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_model.getText().charAt(oldValue.intValue());
                    if (ch >= '0' && ch <= '9') {
                        text_model.setText(text_model.getText().substring(0, text_model.getText().length() - 1));
                    }
                }
            }

        });
        text_cena.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_cena.getText().charAt(oldValue.intValue());
                    if (!(ch >= '0' && ch <= '9')) {
                        text_cena.setText(text_cena.getText().substring(0, text_cena.getText().length() - 1));
                    }
                }
            }

        });
        text_skrzynia_biegow.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_skrzynia_biegow.getText().charAt(oldValue.intValue());
                    if (ch >= '0' && ch <= '9') {
                        text_skrzynia_biegow.setText(text_skrzynia_biegow.getText().substring(0, text_skrzynia_biegow.getText().length() - 1));
                    }
                }
            }

        });
    }
}
