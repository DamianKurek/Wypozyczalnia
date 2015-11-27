/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
/**
 *
 * @author damian
 */
@Entity
@Table(name="klient_dk_2015")
@SecondaryTable(name="adres_klient_dk_2015")
public class klient_dk_2015 {
     @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int id_dk_2015;
     private String imie_dk_2015;
     private String nazwisko_dk_2015;
     //druga tabela
     @Column(table="adres_klient_dk_2015")
     private int nr_tel_dk_2015;
     @Column(table="adres_klient_dk_2015")
     private String adres_miasto_dk_2015;
     @Column(table="adres_klient_dk_2015")
     private String adres_ulica_dk_2015;
     @Column(table="adres_klient_dk_2015")
     int adres_nr_dom_dk_2015;

    public int getId_dk_2015() {
        return id_dk_2015;
    }

    public void setId_dk_2015(int id_dk_2015) {
        this.id_dk_2015 = id_dk_2015;
    }

    public String getImie_dk_2015() {
        return imie_dk_2015;
    }

    public void setImie_dk_2015(String imie_dk_2015) {
        this.imie_dk_2015 = imie_dk_2015;
    }

    public String getNazwisko_dk_2015() {
        return nazwisko_dk_2015;
    }

    public void setNazwisko_dk_2015(String nazwisko_dk_2015) {
        this.nazwisko_dk_2015 = nazwisko_dk_2015;
    }

    public int getNr_tel_dk_2015() {
        return nr_tel_dk_2015;
    }

    public void setNr_tel_dk_2015(int nr_tel_dk_2015) {
        this.nr_tel_dk_2015 = nr_tel_dk_2015;
    }

    public String getAdres_miasto_dk_2015() {
        return adres_miasto_dk_2015;
    }

    public void setAdres_miasto_dk_2015(String adres_miasto_dk_2015) {
        this.adres_miasto_dk_2015 = adres_miasto_dk_2015;
    }

    public String getAdres_ulica_dk_2015() {
        return adres_ulica_dk_2015;
    }

    public void setAdres_ulica_dk_2015(String adres_ulica_dk_2015) {
        this.adres_ulica_dk_2015 = adres_ulica_dk_2015;
    }

    public int getAdres_nr_dom_dk_2015() {
        return adres_nr_dom_dk_2015;
    }

    public void setAdres_nr_dom_dk_2015(int adres_nr_dom_dk_2015) {
        this.adres_nr_dom_dk_2015 = adres_nr_dom_dk_2015;
    }
    
}
