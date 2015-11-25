

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Calendar;
import java.util.Date;
import tabele.test;
import tabele.klient_dk_2015;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tabele.pracownik_dk_2015;
/**
 *
 * @author damian
 */
public class Wypozyczalnia extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //połączenie z baza
      
       //okno
        /*
        test punkt = new test();
        punkt.setX(3);
        punkt.setY(66);
        punkt.setZ(66);
        punkt.setV(66);

        klient_dk_2015 k1 = new klient_dk_2015();
        k1.setImie_dk_2015("Damian");
        k1.setNazwisko_dk_2015("Kurek");
        k1.setAdres_miasto_dk_2015("Łowicz");
        k1.setAdres_nr_dom_dk_2015(25);
        k1.setAdres_ulica_dk_2015("Jastrzębia");
        
        pracownik_dk_2015 p1 = new pracownik_dk_2015();
        p1.setImie_dk_2015("Jan");
        p1.setNazwisko_dk_2015("Kowalski");

       
        Calendar cal = Calendar.getInstance();
        cal.set(2010, 0, 10); //miesiace liczone od 0
        Date data = cal.getTime();
        
        
        p1.setData_zatrudnienia_dk_2015(data);
        
        SessionFactory sesia = new Configuration().configure().buildSessionFactory();
        Session session = sesia.openSession();
        
        //zapisane do bazy
        session.beginTransaction();
        //session.save(punkt);
        //session.save(k1);
        session.save(p1);
        session.getTransaction().commit();
        session.close();
        
        //odczytanie punku z bazy
        //punkt =null;
        //session = sesia.openSession();
        //session.beginTransaction();
        //punkt = (test)session.get(test.class, 5); // get test o id 1 
        //System.out.print("punkt z bazy Dancyh"+punkt.getZ());
        
        
        */
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
