/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import static aplikacja.Wypozyczalnia.sesia;
import static aplikacja.Wypozyczalnia.session;
import java.net.URL;
//import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tooltip;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import tabele.naprawa_dk_3i;
import tabele.wypozyczenie_dk_3i;
import tabele.zwrot_dk_3i;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_Raport_NajdluzejController implements Initializable {

    @FXML
    BarChart<String, Number> wykres;
    XYChart.Series series1 = new XYChart.Series();

    XYChart.Series series2 = new XYChart.Series();

    XYChart.Series series3 = new XYChart.Series();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        class CustomComparator implements Comparator<wypozyczenie_dk_3i> {
//
//            @Override
//            public int compare(wypozyczenie_dk_3i o1, wypozyczenie_dk_3i o2) {
//                int x = (int) (o1.getData_wypozyczenia_dk_3i().getTime() - o1.getData_zwrotu_dk_3i().getTime()) / (1000 * 60 * 60 * 24);
//                int y = (int) (o2.getData_wypozyczenia_dk_3i().getTime() - o2.getData_zwrotu_dk_3i().getTime()) / (1000 * 60 * 60 * 24);
//                if (x == y) {
//                    return 0;
//                }
//                if (x > y) {
//                    return 1;
//                } else {
//                    return -1;
//                }
//            }
//        }
        class CustomComparator implements Comparator<auto_raport> {

            @Override
            public int compare(auto_raport o1, auto_raport o2) {
                int x = o1.getDni();
                int y = o2.getDni();
                if (x == y) {
                    return 0;
                }
                if (x < y) {
                    return 1;
                } else {
                    return -1;
                }
            }

        }

        ObservableList<wypozyczenie_dk_3i> lista = FXCollections.observableArrayList();
        ObservableList<auto_raport> lista_aut = FXCollections.observableArrayList();

        session = sesia.openSession();
        session.beginTransaction();

        List<wypozyczenie_dk_3i> wynik = session.createQuery("from wypozyczenie_dk_3i as w JOIN fetch w.id_zwrot_dk_3i where w.id_zwrot_dk_3i is not null").list();
        for (int x = 0; x < wynik.size(); x++) {
            wypozyczenie_dk_3i w = new wypozyczenie_dk_3i();
            auto_raport auto = new auto_raport();

            w.setId_wypozyczenie_dk_3i(wynik.get(x).getId_wypozyczenie_dk_3i());
            w.setId_auta_wypozyczenie_dk_3i(wynik.get(x).getId_auta_wypozyczenie_dk_3i());
            w.setData_wypozyczenia_dk_3i(wynik.get(x).getData_wypozyczenia_dk_3i());
            w.setData_zwrotu_dk_3i(wynik.get(x).getId_zwrot_dk_3i().getData_zwrotu_dk_3i());

            lista.add(w);
//            System.out.println("id wyp" + wynik.get(x).getId_wypozyczenie_dk_3i());
//            System.out.println("data wypozyczenia" + wynik.get(x).getData_wypozyczenia_dk_3i());
//            System.out.println("data oddania" + wynik.get(x).getId_zwrot_dk_3i().getData_zwrotu_dk_3i());
//            System.out.println(Policz_dni(wynik.get(x).getId_zwrot_dk_3i().getData_zwrotu_dk_3i(), wynik.get(x).getData_wypozyczenia_dk_3i()));
        }

        boolean jest = false;
        int dni = 0;
        for (int x = 0; x < lista.size(); x++) {
            auto_raport auto = new auto_raport();
            auto.setId_dk_3i(lista.get(x).getId_auta_wypozyczenie_dk_3i().getId_dk_3i());
            for (int y = 0; y < lista_aut.size(); y++) {
                if (lista_aut.get(y).getId_dk_3i() == lista.get(x).getId_auta_wypozyczenie_dk_3i().getId_dk_3i()) {
                    dni = (int) ((lista.get(x).getData_zwrotu_dk_3i().getTime() - lista.get(x).getData_wypozyczenia_dk_3i().getTime()) / (1000 * 60 * 60 * 24));
                    lista_aut.get(y).DodajDni(dni);
                    jest = true;
                    dni = 0;
                }
            }
            if (!jest) {
                auto.setMarka_dk_3i(lista.get(x).getId_auta_wypozyczenie_dk_3i().getMarka_dk_3i());
                auto.setModel_dk_3i(lista.get(x).getId_auta_wypozyczenie_dk_3i().getModel_dk_3i());
                auto.setRocznik_dk_3i(lista.get(x).getId_auta_wypozyczenie_dk_3i().getRocznik_dk_3i());
                dni = (int) ((lista.get(x).getData_zwrotu_dk_3i().getTime() - lista.get(x).getData_wypozyczenia_dk_3i().getTime()) / (1000 * 60 * 60 * 24));
                auto.DodajDni(dni);
                lista_aut.add(auto);

            } else {
                jest = false;
            }
        }
//        for (int y = 0; y < lista_aut.size(); y++) {
//            System.out.println("id auta :"+lista_aut.get(y).getId_dk_3i()+ " dni : "+lista_aut.get(y).getDni());
//        }
        Collections.sort(lista_aut, new CustomComparator());
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&   SOR   T&&&&&&&&&&&&&&&&&&&&&&&&&");
        for (int y = 0; y < lista_aut.size(); y++) {
            System.out.println("id auta :" + lista_aut.get(y).getId_dk_3i() + " dni : " + lista_aut.get(y).getDni());
        }
         series1.getData().add(new XYChart.Data(lista_aut.get(0).getMarka_dk_3i() + " " + lista_aut.get(0).getModel_dk_3i(),lista_aut.get(0).getDni()));
         wykres.getData().add(series1);
         series1.setName("[" + lista_aut.get(0).getId_dk_3i() + "] " + lista_aut.get(0).getMarka_dk_3i() + " " + lista_aut.get(0).getModel_dk_3i() + " " + lista_aut.get(0).getRocznik_dk_3i());
         series2.getData().add(new XYChart.Data(lista_aut.get(1).getMarka_dk_3i() + " " + lista_aut.get(1).getModel_dk_3i(),lista_aut.get(2).getDni()));
         wykres.getData().add(series2);
         series2.setName("[" + lista_aut.get(1).getId_dk_3i() + "] " + lista_aut.get(1).getMarka_dk_3i() + " " + lista_aut.get(1).getModel_dk_3i() + " " + lista_aut.get(1).getRocznik_dk_3i());
         series3.getData().add(new XYChart.Data(lista_aut.get(2).getMarka_dk_3i() + " " + lista_aut.get(2).getModel_dk_3i(),lista_aut.get(2).getDni()));
         wykres.getData().add(series3);
         series3.setName("[" + lista_aut.get(2).getId_dk_3i() + "] " + lista_aut.get(2).getMarka_dk_3i() + " " + lista_aut.get(2).getModel_dk_3i() + " " + lista_aut.get(2).getRocznik_dk_3i());
        
         for (final XYChart.Series<String, Number> series : wykres.getData()) {
            for (final XYChart.Data<String, Number> data : series.getData()) {
                Tooltip tooltip = new Tooltip();
                tooltip.setText(data.getYValue().toString());
                Tooltip.install(data.getNode(), tooltip);
            }
        }
    }

}
