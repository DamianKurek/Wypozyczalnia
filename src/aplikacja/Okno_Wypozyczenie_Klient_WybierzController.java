package aplikacja;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static aplikacja.Wypozyczalnia.*;

import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import tabele.klient_dk_3i;

import tabele.pracownik_dk_3i;
import aplikacja.Okno_Wypozyczenie_NoweController.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.hibernate.criterion.Projections;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_Wypozyczenie_Klient_WybierzController implements Initializable {

    @FXML
    TextField text_id_szukaj;
    @FXML
    TextField text_nazwisko_szukaj;
    @FXML
    TextField text_miasto_szukaj;
    @FXML
    TextField text_id;
    @FXML
    TextField text_imie;
    @FXML
    TextField text_nazwisko;
    @FXML
    TextField text_miasto;
    @FXML
    TextField text_ulica;
    @FXML
    TextField text_nr_domu;
    @FXML
    TextField text_telefon;
    @FXML
    TableView<klient_dk_3i> tabela;
    @FXML
    TableColumn<klient_dk_3i, Integer> TableColumn1;
    @FXML
    TableColumn<klient_dk_3i, String> TableColumn2;
    @FXML
    TableColumn<klient_dk_3i, String> TableColumn3;
    @FXML
    TableColumn<klient_dk_3i, Integer> TableColumn4;
    @FXML
    TableColumn<klient_dk_3i, String> TableColumn5;
    @FXML
    TableColumn<klient_dk_3i, String> TableColumn6;
    @FXML
    TableColumn<klient_dk_3i, Integer> TableColumn7;
    @FXML
    public final ObservableList<klient_dk_3i> dane = FXCollections.observableArrayList();
    //SessionFactory sesia = new Configuration().configure().buildSessionFactory();
    //Session session = sesia.openSession();

    @FXML
    void Wybierz_z_Tabeli() {
        zamowienie_klient = tabela.getSelectionModel().getSelectedItem();
        //System.out.println(k.getNazwisko_dk_3i());
        // get a handle to the stage
        //Stage stage = (Stage) tabela.getScene().getWindow();
        Stage stage = (Stage) tabela.getParent().getScene().getWindow();
        
        // do what you have to do
        stage.close();
       
    }

    @FXML
    void Czysc() {
//text_id.setText(null);;
        text_imie.setText(null);
        text_nazwisko.setText(null);
        text_miasto.setText(null);
        text_ulica.setText(null);
        text_nr_domu.setText(null);
        text_telefon.setText(null);
    }

    @FXML
    void Zapisz() {
        klient_dk_3i klient = new klient_dk_3i();
        if (text_imie.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("pole imie nie możę być puste");
            alert.showAndWait();
        } else if (text_nazwisko.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("pole nazwisko nie możę być puste");
            alert.showAndWait();
        } else if (text_miasto.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("pole miasto nie możę być puste");
            alert.showAndWait();
        } else if (text_ulica.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("pole ulica nie możę być puste");
            alert.showAndWait();
        } else if (text_nr_domu.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd danych");
            alert.setContentText("pole numer domu nie możę być puste");
            alert.showAndWait();
        } else {
            klient.setImie_dk_3i(text_imie.getText());
            klient.setNazwisko_dk_3i(text_nazwisko.getText());
            klient.setAdres_miasto_dk_3i(text_miasto.getText());
            klient.setAdres_ulica_dk_3i(text_ulica.getText());
            klient.setAdres_nr_dom_dk_3i(Integer.parseInt(text_nr_domu.getText()));
            if (!text_telefon.getText().isEmpty()) {
                klient.setNr_tel_dk_3i(Integer.parseInt(text_telefon.getText()));
            }
            //zapisane do bazy
            session = sesia.openSession();
            session.beginTransaction();
            session.save(klient);
            session.getTransaction().commit();
            session.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Zapis");
            alert.setHeaderText("Zapis danych");
            alert.setContentText("Poprawnia dodano nowego klienta");
            alert.showAndWait();
            Czysc();
          
        }
    }


    @FXML
    void Wczytaj() {
        dane.clear();
        session = sesia.openSession();
        session.beginTransaction();
        List<klient_dk_3i> wynik = session.createQuery("from klient_dk_3i").list();
        session.close();
        for (int x = 0; x < wynik.size(); x++) {
            dane.add(wynik.get(x));
        }

    }

    @FXML
    void Szukaj() {
        if (!text_id_szukaj.getText().isEmpty() && text_nazwisko_szukaj.getText().isEmpty() && text_miasto_szukaj.getText().isEmpty()) {
            dane.clear();
            session = sesia.openSession();
            Criterion id = Expression.eq("id_dk_3i", Integer.parseInt(text_id_szukaj.getText()));
            Criteria crit = session.createCriteria(klient_dk_3i.class);
            crit.add(id);
            klient_dk_3i p2 = (klient_dk_3i) crit.uniqueResult();
            if (p2 != null) {
                dane.add(p2);
            } else {
                //kominukat o nie znalezieniu pracownika
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Błąd");
                alert.setHeaderText("Błąd");
                alert.setContentText("Brak Pracownika o takim Id w bazie danych");
                alert.showAndWait();
            }

            session.close();
        }
        if (text_id_szukaj.getText().isEmpty() && !text_nazwisko_szukaj.getText().isEmpty() && text_miasto_szukaj.getText().isEmpty()) {
            dane.clear();
            session = sesia.openSession();
            Criterion id = Expression.eq("nazwisko_dk_3i", text_nazwisko_szukaj.getText());
            Criteria crit = session.createCriteria(klient_dk_3i.class);
            crit.add(id);
            List<klient_dk_3i> p2 = crit.list();
            if (!p2.isEmpty()) {
                for (int x = 0; x < p2.size(); x++) {
//            System.out.println(p.get(x).getImie_dk_3i() + " "
//                    + p.get(x).getNazwisko_dk_3i());
                    dane.add(p2.get(x));
                }
            } else {
                //kominukat o nie znalezieniu pracownika
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Błąd");
                alert.setHeaderText("Błąd");
                alert.setContentText("Brak Pracownika o takim Nazwisku w bazie danych");
                alert.showAndWait();
            }

            session.close();
        }
        if (text_id_szukaj.getText().isEmpty() && text_nazwisko_szukaj.getText().isEmpty() && !text_miasto_szukaj.getText().isEmpty()) {
            dane.clear();
            session = sesia.openSession();
            Criterion id = Expression.eq("adres_miasto_dk_3i", text_miasto_szukaj.getText());
            Criteria crit = session.createCriteria(klient_dk_3i.class);
            crit.add(id);
            List<klient_dk_3i> p3 = crit.list();
            if (!p3.isEmpty()) {
                for (int x = 0; x < p3.size(); x++) {
//            System.out.println(p.get(x).getImie_dk_3i() + " "
//                    + p.get(x).getNazwisko_dk_3i());
                    dane.add(p3.get(x));
                }
            } else {
                //kominukat o nie znalezieniu pracownika
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Błąd");
                alert.setHeaderText("Błąd");
                alert.setContentText("Brak Pracownika z tego miasta w bazie danych");
                alert.showAndWait();
            }

            session.close();
        }
        if (!text_id_szukaj.getText().isEmpty() && text_nazwisko_szukaj.getText().isEmpty() && !text_miasto_szukaj.getText().isEmpty()) {
            //kominukat o błedzie
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd");
            alert.setContentText("Wybierz tylko 1 parametr do szukanai (Id,nazwisko lub miasto)");
            alert.showAndWait();
        }
        if (!text_id_szukaj.getText().isEmpty() && !text_nazwisko_szukaj.getText().isEmpty() && text_miasto_szukaj.getText().isEmpty()) {
            //kominukat o błedzie
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd");
            alert.setContentText("Wybierz tylko 1 parametr do szukanai (Id,nazwisko lub miasto)");
            alert.showAndWait();
        }

        if (text_id_szukaj.getText().isEmpty() && !text_nazwisko_szukaj.getText().isEmpty() && !text_miasto_szukaj.getText().isEmpty()) {
            //kominukat o błedzie
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd");
            alert.setContentText("Wybierz tylko 1 parametr do szukanai (Id,nazwisko lub miasto)");
            alert.showAndWait();
        }
        if (text_id_szukaj.getText().isEmpty() && text_nazwisko_szukaj.getText().isEmpty() && text_miasto_szukaj.getText().isEmpty()) {
            //kominukat o błedzie
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd");
            alert.setContentText("Wybierz 1 parametr do szukanai (Id,nazwisko lub miasto)");
            alert.showAndWait();
        }
        if (!text_id_szukaj.getText().isEmpty() && !text_nazwisko_szukaj.getText().isEmpty() && !text_miasto_szukaj.getText().isEmpty()) {
            //kominukat o błedzie
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Błąd");
            alert.setContentText("Wybierz tylko 1 parametr do szukanai (Id,nazwisko lub miasto)");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tabela.itemsProperty().setValue(dane);
        TableColumn1.setCellValueFactory(new PropertyValueFactory<klient_dk_3i, Integer>("id_dk_3i")//nazwa pola w klasie
        );
        TableColumn2.setCellValueFactory(new PropertyValueFactory<klient_dk_3i, String>("imie_dk_3i")//nazwa pola w klasie
        );
        TableColumn3.setCellValueFactory(new PropertyValueFactory<klient_dk_3i, String>("nazwisko_dk_3i")//nazwa pola w klasie
        );
        TableColumn4.setCellValueFactory(new PropertyValueFactory<klient_dk_3i, Integer>("nr_tel_dk_3i")//nazwa pola w klasie
        );
        TableColumn5.setCellValueFactory(new PropertyValueFactory<klient_dk_3i, String>("adres_miasto_dk_3i")//nazwa pola w klasie
        );
        TableColumn6.setCellValueFactory(new PropertyValueFactory<klient_dk_3i, String>("adres_ulica_dk_3i")//nazwa pola w klasie
        );
        TableColumn7.setCellValueFactory(new PropertyValueFactory<klient_dk_3i, Integer>("adres_nr_dom_dk_3i")//nazwa pola w klasie
        );
        Wczytaj();
        session = sesia.openSession();
        Long f = (Long) session.createCriteria("tabele.klient_dk_3i").setProjection(Projections.rowCount()).uniqueResult();
        text_id.setText(String.valueOf(f + 1));
        session.close();
        text_imie.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_imie.getText().charAt(oldValue.intValue());
                    if ((ch >= '0' && ch <= '9')) {
                        text_imie.setText(text_imie.getText().substring(0, text_imie.getText().length() - 1));
                    }
                }
            }

        });
        text_nazwisko.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_nazwisko.getText().charAt(oldValue.intValue());
                    if ((ch >= '0' && ch <= '9')) {
                        text_nazwisko.setText(text_nazwisko.getText().substring(0, text_nazwisko.getText().length() - 1));
                    }
                }
            }

        });
        text_miasto.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_miasto.getText().charAt(oldValue.intValue());
                    if ((ch >= '0' && ch <= '9')) {
                        text_miasto.setText(text_miasto.getText().substring(0, text_miasto.getText().length() - 1));
                    }
                }
            }

        });
        text_nr_domu.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_nr_domu.getText().charAt(oldValue.intValue());
                    if (!(ch >= '0' && ch <= '9')) {
                        text_nr_domu.setText(text_nr_domu.getText().substring(0, text_nr_domu.getText().length() - 1));
                    }
                }
            }

        });
        text_telefon.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = text_telefon.getText().charAt(oldValue.intValue());
                    if (!(ch >= '0' && ch <= '9')) {
                        text_telefon.setText(text_telefon.getText().substring(0, text_telefon.getText().length() - 1));
                    }
                    if(text_telefon.getText().length()>9){
                        text_telefon.setText(text_telefon.getText().substring(0, text_telefon.getText().length() - 1));
                    }
                }
            }

        });
    }

}
