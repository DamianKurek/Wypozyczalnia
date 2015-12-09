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
import javafx.fxml.Initializable;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        session = sesia.openSession();
//        Criteria c = session.createCriteria(naprawa_dk_3i.class)
//                .createCriteria("id_auto_dk_3i")
//                .setProjection(
//                        Projections.projectionList()
//                        .add(Projections.groupProperty("id_dk_3i"))
//                        .add(Projections.rowCount(), "rowcount")
//                )
//                .addOrder(org.hibernate.criterion.Order.desc("rowcount"));
//        List<naprawa_dk_3i> wynik = c.list();
//
//        Query query = session.createQuery("from select id_auto_dk_3i, COUNT(*) AS magnitude FROM naprawa_dk_3i GROUP BY id_auto_dk_3i ORDER BY magnitude DESC LIMIT 5");
//        List<naprawa_dk_3i> wynik = query.list();

//         Criteria crit = session.createCriteria(zwrot_dk_3i.class);
//        crit.setProjection(Projections.rowCount());
//        List wynik = crit.list();
        ///////////////////////////////////wzroci liczby zwrat z kara = 0/////////////////////////////
//        Query query = session.createQuery(
//                "select count(*) from zwrot_dk_3i zwrot_dk_3i where zwrot_dk_3i.kara_dk_3i=:wartosc");
//
//        query.setString("wartosc", "0");
//        query.setInteger("wartosc", 0);
//        Long wynik = (Long) query.uniqueResult();
//        System.out.print(wynik);
        //////////////////////////////////////////////////////////////////////////////////////////////////
        List<zwrot_dk_3i> wynik = session.createCriteria(zwrot_dk_3i.class)
                .add(Restrictions.or(
                                Restrictions.eq("kara_dk_3i", new Integer(0))
                        ))
                .list();
        for (int x = 0; x < wynik.size(); x++) {
            // System.out.println(wynik.get(x).getId_wypozyczenie_dk_3i().getId_wypozyczenie_dk_3i());
        }
        //////////////////////
//        List results = session.createCriteria(zwrot_dk_3i.class)
//                .setProjection(Projections.alias(Projections.groupProperty("kara_dk_3i"), "0"))
//                .addOrder(Order.asc("kara_dk_3i"))
//                .list();
        //System.out.print(results.size());

        //////////////////////
        Criteria c = session.createCriteria(naprawa_dk_3i.class)
                .createCriteria("id_auto_dk_3i")
                .setProjection(
                        Projections.projectionList()
                        //.add(Projections.groupProperty("id"))
                        .add(Projections.rowCount(), "rowcount")
                )
                .addOrder(org.hibernate.criterion.Order.desc("rowcount"));

        wynik = c.list();
        //System.out.print(wynik);
        ////////////////////
       List results = session.createCriteria(naprawa_dk_3i.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.rowCount(), "rCount")
                        .add(Projections.groupProperty("id_auto_dk_3i.id_dk_3i"))
                )
                .addOrder(Order.desc("rCount"))
                .setMaxResults(1)
                .list();
       for (Object[] result:(List<Object[]>) c.list()){
        System.out.println("type id: " + result[0] + "\tcount: " + result[1]);
    }
        //////////
       
        // return ((Integer) criteria.list().get(0)).intValue();
        //System.out.print(wynik.get(0).getOpis_naprawa_3i());
//    for (Object[] result:(List<naprawa_dk_3i[]>) c.list()){
//        System.out.println("type id: " + result[0] + "\tcount: " + result[1]);
//    }
    }

}
