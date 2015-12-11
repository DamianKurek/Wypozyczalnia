/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import static aplikacja.Wypozyczalnia.sesia;
import static aplikacja.Wypozyczalnia.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tooltip;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import tabele.auta_dk_3i;
import tabele.naprawa_dk_3i;
import tabele.wypozyczenie_dk_3i;
import tabele.zwrot_dk_3i;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_Raport_Suma_AwariiController implements Initializable {

    @FXML
    BarChart<String, Number> wykres;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series series1 = new XYChart.Series();
        //series1.setName("Styczeń");

        XYChart.Series series2 = new XYChart.Series();
        //series2.setName("Luty");

        XYChart.Series series3 = new XYChart.Series();
        //series3.setName("Marzec");

        XYChart.Series series4 = new XYChart.Series();
        //series4.setName("Kwiecień");

        XYChart.Series series5 = new XYChart.Series();
        //series5.setName("Maj");
        session = sesia.openSession();

        List<Object[]> result = session.createCriteria(naprawa_dk_3i.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.rowCount(), "rCount")
                        .add(Projections.groupProperty("id_auto_dk_3i.id_dk_3i")
                        )
                )
                .addOrder(Order.desc("rCount"))
                .setMaxResults(5)
                .list();
        auta_dk_3i auto = new auta_dk_3i();

        int x = 0;
        for (x = 0; x < result.size(); x++) {
        }
        System.out.print(x);
        if (x == 1) {
            Criterion id = Expression.eq("id_dk_3i", result.get(0)[1]);
            Criteria crit = session.createCriteria(auta_dk_3i.class);
            crit.add(id);
            auto = (auta_dk_3i) crit.uniqueResult();
            series1.getData().add(new XYChart.Data(auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i(), result.get(0)[0]));
            wykres.getData().add(series1);
            series1.setName("[" + auto.getId_dk_3i() + "] " + auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i() + " " + auto.getRocznik_dk_3i());
        }
        if (x == 2) {
            Criterion id = Expression.eq("id_dk_3i", result.get(0)[1]);
            Criteria crit = session.createCriteria(auta_dk_3i.class);
            crit.add(id);
            auto = (auta_dk_3i) crit.uniqueResult();

            id = Expression.eq("id_dk_3i", result.get(1)[1]);
            crit = session.createCriteria(auta_dk_3i.class);
            crit.add(id);
            auto = (auta_dk_3i) crit.uniqueResult();
            series2.getData().add(new XYChart.Data(auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i(), result.get(1)[0]));
            wykres.getData().add(series1);
            series1.setName("[" + auto.getId_dk_3i() + "] " + auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i() + " " + auto.getRocznik_dk_3i());
            wykres.getData().add(series2);
            series2.setName("[" + auto.getId_dk_3i() + "] " + auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i() + " " + auto.getRocznik_dk_3i());
        }
        if (x == 3) {
            Criterion id = Expression.eq("id_dk_3i", result.get(0)[1]);
            Criteria crit = session.createCriteria(auta_dk_3i.class);
            crit.add(id);
            auto = (auta_dk_3i) crit.uniqueResult();
            series1.getData().add(new XYChart.Data(auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i(), result.get(0)[0]));

            id = Expression.eq("id_dk_3i", result.get(1)[1]);
            crit = session.createCriteria(auta_dk_3i.class);
            crit.add(id);
            auto = (auta_dk_3i) crit.uniqueResult();
            series2.getData().add(new XYChart.Data(auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i(), result.get(1)[0]));

            id = Expression.eq("id_dk_3i", result.get(2)[1]);
            crit = session.createCriteria(auta_dk_3i.class);
            crit.add(id);
            auto = (auta_dk_3i) crit.uniqueResult();
            series3.getData().add(new XYChart.Data(auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i(), result.get(2)[0]));
            wykres.getData().add(series1);
            series1.setName("[" + auto.getId_dk_3i() + "] " + auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i() + " " + auto.getRocznik_dk_3i());
            wykres.getData().add(series2);
            series2.setName("[" + auto.getId_dk_3i() + "] " + auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i() + " " + auto.getRocznik_dk_3i());
            wykres.getData().add(series3);
            series3.setName("[" + auto.getId_dk_3i() + "] " + auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i() + " " + auto.getRocznik_dk_3i());
        }
        if (x >= 4) {
            Criterion id = Expression.eq("id_dk_3i", result.get(0)[1]);
            Criteria crit = session.createCriteria(auta_dk_3i.class);
            crit.add(id);
            auto = (auta_dk_3i) crit.uniqueResult();
            series1.getData().add(new XYChart.Data(auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i(), result.get(0)[0]));
            series1.setName("[" + auto.getId_dk_3i() + "] " + auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i() + " " + auto.getRocznik_dk_3i());

            id = Expression.eq("id_dk_3i", result.get(1)[1]);
            crit = session.createCriteria(auta_dk_3i.class);
            crit.add(id);
            auto = (auta_dk_3i) crit.uniqueResult();
            series2.getData().add(new XYChart.Data(auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i(), result.get(1)[0]));
            series2.setName("[" + auto.getId_dk_3i() + "] " + auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i() + " " + auto.getRocznik_dk_3i());

            id = Expression.eq("id_dk_3i", result.get(2)[1]);
            crit = session.createCriteria(auta_dk_3i.class);
            crit.add(id);
            auto = (auta_dk_3i) crit.uniqueResult();
            series3.getData().add(new XYChart.Data(auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i(), result.get(2)[0]));
            series3.setName("[" + auto.getId_dk_3i() + "] " + auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i() + " " + auto.getRocznik_dk_3i());

            id = Expression.eq("id_dk_3i", result.get(3)[1]);
            crit = session.createCriteria(auta_dk_3i.class);
            crit.add(id);
            auto = (auta_dk_3i) crit.uniqueResult();
            series4.getData().add(new XYChart.Data(auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i(), result.get(3)[0]));
            series4.setName("[" + auto.getId_dk_3i() + "] " + auto.getMarka_dk_3i() + " " + auto.getModel_dk_3i() + " " + auto.getRocznik_dk_3i());
            wykres.getData().add(series1);
            wykres.getData().add(series2);
            wykres.getData().add(series3);
            wykres.getData().add(series4);
        }

//        
        for (final XYChart.Series<String, Number> series : wykres.getData()) {
            for (final XYChart.Data<String, Number> data : series.getData()) {
                Tooltip tooltip = new Tooltip();
                tooltip.setText(data.getYValue().toString());
                Tooltip.install(data.getNode(), tooltip);
            }
        }

       
    }

}
