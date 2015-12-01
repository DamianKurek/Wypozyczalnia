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
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import tabele.klient_dk_2015;
import tabele.pracownik_dk_2015;
import tabele.wypozyczenie_dk_2015;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Okno_Wypozyczenie_ZwrotController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        session = sesia.openSession();
        klient_dk_2015 klient = new klient_dk_2015();
        klient.setId_dk_2015(17);
            Criterion imie = Expression.eq("id_klient_wypozyczenie_dk_2015", klient);
            Criteria crit = session.createCriteria(wypozyczenie_dk_2015.class);
            crit.add(imie);
            wypozyczenie_dk_2015 p = (wypozyczenie_dk_2015)crit.uniqueResult();
            System.out.print(p.getKoszt_dk_2015());
    }    
    
}
