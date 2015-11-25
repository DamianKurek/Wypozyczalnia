/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author damian
 */
public class FXMLDocumentController implements Initializable {
  
    
    
    GregorianCalendar data = new GregorianCalendar();
    @FXML
    private Label data1;
    @FXML
    private Label data2;
  
    @FXML
    private void handleButtonAction(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //##############daty##############
        test x = new test();
        x.setX(1);
        x.setY(2);
        x.setZ(3);
        x.setV(4);
        
        SessionFactory sesia = new Configuration().configure().buildSessionFactory();
        Session session = sesia.openSession();
        session.beginTransaction();
        session.save(x);
        session.getTransaction().commit();
        
          //EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("BazaDanych");
        //EntityManager entityManager=entityManagerFactory.createEntityManager();
        
       //entityManager.close();
        //entityManagerFactory.close();
    SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
    fmt.setCalendar(data);
    String dateFormatted = fmt.format(data.getTime());
        data1.setText(dateFormatted);
        data.add(Calendar.DAY_OF_MONTH, 1);
        fmt.setCalendar(data);
        dateFormatted = fmt.format(data.getTime());
        data2.setText(dateFormatted);
    //####################################
        
    }    
    
}
