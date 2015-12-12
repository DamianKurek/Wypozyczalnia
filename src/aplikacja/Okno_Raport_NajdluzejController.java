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
import javafx.fxml.Initializable;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        session = sesia.openSession();
        List<Object[]> result = session.createCriteria(zwrot_dk_3i.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.rowCount(), "rCount")
                        .add(Projections.groupProperty("id_wypozyczenie_dk_3i.koszt_dk_3i")
                        )
                )
                .addOrder(Order.desc("rCount"))
                .setMaxResults(6)
                .list();

        System.out.println(result.get(0)[0] + " " + result.get(0)[1]);
    }    
    
}
