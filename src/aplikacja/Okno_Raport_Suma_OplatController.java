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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import tabele.zwrot_dk_3i;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_Raport_Suma_OplatController implements Initializable {
//zalozenie żę okres do raporty ma jakies 2 misiecie jesli nie inny wykres
    //@FXML ScatterChart<String,Number> wykres;

    @FXML
    BarChart<String, Number> wykres;
    @FXML
    TextField text_kary;
    @FXML
    TextField text_suma;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        List<zwrot_dk_3i> miesiac0 = new ArrayList();
        int miesiac0_suma = 0;
        List<zwrot_dk_3i> miesiac1 = new ArrayList();
        int miesiac1_suma = 0;
        List<zwrot_dk_3i> miesiac2 = new ArrayList();
        int miesiac2_suma = 0;
        List<zwrot_dk_3i> miesiac3 = new ArrayList();
        int miesiac3_suma = 0;
        List<zwrot_dk_3i> miesiac4 = new ArrayList();
        int miesiac4_suma = 0;
        List<zwrot_dk_3i> miesiac5 = new ArrayList();
        int miesiac5_suma = 0;
        List<zwrot_dk_3i> miesiac6 = new ArrayList();
        int miesiac6_suma = 0;
        List<zwrot_dk_3i> miesiac7 = new ArrayList();
        int miesiac7_suma = 0;
        List<zwrot_dk_3i> miesiac8 = new ArrayList();
        int miesiac8_suma = 0;
        List<zwrot_dk_3i> miesiac9 = new ArrayList();
        int miesiac9_suma = 0;
        List<zwrot_dk_3i> miesiac10 = new ArrayList();
        int miesiac10_suma = 0;
        List<zwrot_dk_3i> miesiac11 = new ArrayList();
        int miesiac11_suma = 0;
        int miesiac_alone_suma = 0;
        int suma = 0;
        int suma_kar = 0;
        int liczba_miesiecy = 0;
        List<zwrot_dk_3i> miesiac_alone = null;

//wykres
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Styczeń");

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Luty");

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Marzec");

        XYChart.Series series4 = new XYChart.Series();
        series4.setName("Kwiecień");

        XYChart.Series series5 = new XYChart.Series();
        series5.setName("Maj");

        XYChart.Series series6 = new XYChart.Series();
        series6.setName("Czerwiec");

        XYChart.Series series7 = new XYChart.Series();
        series7.setName("Liepiec");

        XYChart.Series series8 = new XYChart.Series();
        series8.setName("Sierpień");

        XYChart.Series series9 = new XYChart.Series();
        series9.setName("Wrzesień");

        XYChart.Series series10 = new XYChart.Series();
        series10.setName("Pażdziernik");

        XYChart.Series series11 = new XYChart.Series();
        series11.setName("Listopad");

        XYChart.Series series12 = new XYChart.Series();
        series12.setName("Grudzień");

        XYChart.Series sesies_alone = new XYChart.Series();
        /////////////////////
        session = sesia.openSession();

        Criterion id = Expression.between("data_zwrotu_dk_3i", data_raport_od, data_raport_do);
        Criteria crit = session.createCriteria(zwrot_dk_3i.class);
        crit.add(id);
        List<zwrot_dk_3i> wynik = crit.list();
        session.close();
        wykres.setLegendVisible(true);
        for (int x = 0; x < wynik.size(); x++) {
            if (wynik.get(x).getData_zwrotu_dk_3i().getMonth() == 0) {
                miesiac0.add(wynik.get(x));
            } else if (wynik.get(x).getData_zwrotu_dk_3i().getMonth() == 1) {
                miesiac1.add(wynik.get(x));
            } else if (wynik.get(x).getData_zwrotu_dk_3i().getMonth() == 2) {
                miesiac2.add(wynik.get(x));
            } else if (wynik.get(x).getData_zwrotu_dk_3i().getMonth() == 3) {
                miesiac3.add(wynik.get(x));
            } else if (wynik.get(x).getData_zwrotu_dk_3i().getMonth() == 4) {
                miesiac4.add(wynik.get(x));
            } else if (wynik.get(x).getData_zwrotu_dk_3i().getMonth() == 5) {
                miesiac5.add(wynik.get(x));
            } else if (wynik.get(x).getData_zwrotu_dk_3i().getMonth() == 6) {
                miesiac6.add(wynik.get(x));
            } else if (wynik.get(x).getData_zwrotu_dk_3i().getMonth() == 7) {
                miesiac7.add(wynik.get(x));
            } else if (wynik.get(x).getData_zwrotu_dk_3i().getMonth() == 8) {
                miesiac8.add(wynik.get(x));
            } else if (wynik.get(x).getData_zwrotu_dk_3i().getMonth() == 9) {
                miesiac9.add(wynik.get(x));
            } else if (wynik.get(x).getData_zwrotu_dk_3i().getMonth() == 10) {
                miesiac10.add(wynik.get(x));

            } else if (wynik.get(x).getData_zwrotu_dk_3i().getMonth() == 11) {
                miesiac11.add(wynik.get(x));

            }

        }
        if (miesiac0.size() > 0) {
            liczba_miesiecy += 1;
            miesiac_alone = miesiac0;
            for (int x = 0; x < miesiac0.size(); x++) {
                miesiac0_suma += miesiac0.get(x).getKoszt_dk_3i();
                suma_kar += miesiac0.get(x).getKara_dk_3i();
            }
            suma += miesiac0_suma;
            series1.getData().add(new XYChart.Data("styczeń", miesiac0_suma));
            wykres.getData().add(series1);
        }
        if (miesiac1.size() > 0) {
            liczba_miesiecy += 1;
            miesiac_alone = miesiac1;
            for (int x = 0; x < miesiac1.size(); x++) {
                miesiac1_suma += miesiac1.get(x).getKoszt_dk_3i();
                suma_kar += miesiac1.get(x).getKara_dk_3i();
            }
            suma += miesiac1_suma;

            series2.getData().add(new XYChart.Data("luty", miesiac1_suma));
            wykres.getData().add(series2);
        }
        if (miesiac2.size() > 0) {
            liczba_miesiecy += 1;
            miesiac_alone = miesiac2;
            for (int x = 0; x < miesiac2.size(); x++) {
                miesiac2_suma += miesiac2.get(x).getKoszt_dk_3i();
                suma_kar += miesiac2.get(x).getKara_dk_3i();
            }
            suma += miesiac2_suma;

            series3.getData().add(new XYChart.Data("marzec", miesiac2_suma));
            wykres.getData().add(series3);
        }
        if (miesiac3.size() > 0) {
            liczba_miesiecy += 1;
            miesiac_alone = miesiac3;
            for (int x = 0; x < miesiac3.size(); x++) {
                miesiac3_suma += miesiac3.get(x).getKoszt_dk_3i();
                suma_kar += miesiac3.get(x).getKara_dk_3i();
            }
            suma += miesiac3_suma;

            series4.getData().add(new XYChart.Data("kwiecień", miesiac3_suma));
            wykres.getData().add(series4);
        }
        if (miesiac4.size() > 0) {
            liczba_miesiecy += 1;
            miesiac_alone = miesiac4;
            for (int x = 0; x < miesiac4.size(); x++) {
                miesiac4_suma += miesiac4.get(x).getKoszt_dk_3i();
                suma_kar += miesiac4.get(x).getKara_dk_3i();
            }
            suma += miesiac4_suma;

            series5.getData().add(new XYChart.Data("maj", miesiac4_suma));
            wykres.getData().add(series5);
        }
        if (miesiac5.size() > 0) {
            liczba_miesiecy += 1;
            miesiac_alone = miesiac5;
            for (int x = 0; x < miesiac5.size(); x++) {
                miesiac5_suma += miesiac5.get(x).getKoszt_dk_3i();
                suma_kar += miesiac5.get(x).getKara_dk_3i();
            }
            suma += miesiac5_suma;

            series6.getData().add(new XYChart.Data("czerwiec", miesiac5_suma));
            wykres.getData().add(series6);
        }
        if (miesiac6.size() > 0) {
            liczba_miesiecy += 1;
            miesiac_alone = miesiac6;
            for (int x = 0; x < miesiac6.size(); x++) {
                miesiac6_suma += miesiac6.get(x).getKoszt_dk_3i();
                suma_kar += miesiac6.get(x).getKara_dk_3i();
            }
            suma += miesiac6_suma;

            series7.getData().add(new XYChart.Data("lipiec", miesiac6_suma));
            wykres.getData().add(series7);
        }
        if (miesiac7.size() > 0) {
            miesiac_alone = miesiac7;
            liczba_miesiecy += 1;
            for (int x = 0; x < miesiac7.size(); x++) {
                miesiac8_suma += miesiac7.get(x).getKoszt_dk_3i();
                suma_kar += miesiac7.get(x).getKara_dk_3i();
            }
            suma += miesiac8_suma;

            series8.getData().add(new XYChart.Data("sierpien", miesiac7_suma));
            wykres.getData().add(series8);
        }
        if (miesiac8.size() > 0) {
            liczba_miesiecy += 1;
            miesiac_alone = miesiac8;
            for (int x = 0; x < miesiac8.size(); x++) {
                miesiac8_suma += miesiac8.get(x).getKoszt_dk_3i();
                suma_kar += miesiac8.get(x).getKara_dk_3i();
            }
            suma += miesiac8_suma;

            series9.getData().add(new XYChart.Data("wrzesień", miesiac8_suma));
            wykres.getData().add(series9);
        }
        if (miesiac9.size() > 0) {
            liczba_miesiecy += 1;
            miesiac_alone = miesiac9;
            for (int x = 0; x < miesiac9.size(); x++) {
                miesiac9_suma += miesiac9.get(x).getKoszt_dk_3i();
                suma_kar += miesiac9.get(x).getKara_dk_3i();
            }
            suma += miesiac9_suma;

            series10.getData().add(new XYChart.Data("październik", miesiac9_suma));
            wykres.getData().add(series10);
        }
        if (miesiac10.size() > 0) {
            liczba_miesiecy += 1;
            miesiac_alone = miesiac10;
            for (int x = 0; x < miesiac10.size(); x++) {
                miesiac10_suma += miesiac10.get(x).getKoszt_dk_3i();
                suma_kar += miesiac10.get(x).getKara_dk_3i();
            }
            suma += miesiac10_suma;

            series11.getData().add(new XYChart.Data("listopad", miesiac10_suma));
            wykres.getData().add(series11);
        }
        if (miesiac11.size() > 0) {
            liczba_miesiecy += 1;
            miesiac_alone = miesiac11;
            for (int x = 0; x < miesiac11.size(); x++) {
                miesiac11_suma += miesiac11.get(x).getKoszt_dk_3i();
                suma_kar += miesiac11.get(x).getKara_dk_3i();
            }
            suma += miesiac11_suma;
            series12.getData().add(new XYChart.Data("grudzien", miesiac11_suma));
            wykres.getData().add(series12);
        }

        //jeśli zakres z jednego miesiaca
        if (liczba_miesiecy == 1) {
            wykres.getData().clear();
            suma_kar = 0;
            suma = 0;
            for (int x = 0; x < miesiac_alone.size(); x++) {
                sesies_alone.getData().add(new XYChart.Data(miesiac_alone.get(x).getData_zwrotu_dk_3i().toString(), miesiac_alone.get(x).getKoszt_dk_3i()));
                suma += miesiac_alone.get(x).getKoszt_dk_3i();
                suma_kar += miesiac_alone.get(x).getKara_dk_3i();
            }
            wykres.getData().add(sesies_alone);
            wykres.setLegendVisible(false);
        }
//wykres.setBarGap(0);
//wykres.setCategoryGap(0);
        wykres.setVerticalGridLinesVisible(false);
        text_kary.setText(String.valueOf(suma_kar));
        text_suma.setText(String.valueOf(suma));
        for (final Series<String, Number> series : wykres.getData()) {
            for (final Data<String, Number> data : series.getData()) {
                Tooltip tooltip = new Tooltip();
                tooltip.setText(data.getYValue().toString());
                Tooltip.install(data.getNode(), tooltip);
            }
        }
        //wykres.getData().addAll(series12);
    }

}
