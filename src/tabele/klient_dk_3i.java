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
@Table(name="klient_dk_3i")
@SecondaryTable(name="adres_klient_dk_3i")
public class klient_dk_3i {
     @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
     @Column(table="klient_dk_3i")
     private int id_dk_3i;
     @Column(table="klient_dk_3i")
     private String imie_dk_3i;
     @Column(table="klient_dk_3i")
     private String nazwisko_dk_3i;
     //druga tabela
     @Column(table="adres_klient_dk_3i")
     private int nr_tel_dk_3i;
     @Column(table="adres_klient_dk_3i")
     private String adres_miasto_dk_3i;
     @Column(table="adres_klient_dk_3i")
     private String adres_ulica_dk_3i;
     @Column(table="adres_klient_dk_3i")
     int adres_nr_dom_dk_3i;

    public int getId_dk_3i() {
        return id_dk_3i;
    }

    public void setId_dk_3i(int id_dk_3i) {
        this.id_dk_3i = id_dk_3i;
    }

    public String getImie_dk_3i() {
        return imie_dk_3i;
    }

    public void setImie_dk_3i(String imie_dk_3i) {
        this.imie_dk_3i = imie_dk_3i;
    }

    public String getNazwisko_dk_3i() {
        return nazwisko_dk_3i;
    }

    public void setNazwisko_dk_3i(String nazwisko_dk_3i) {
        this.nazwisko_dk_3i = nazwisko_dk_3i;
    }

    public int getNr_tel_dk_3i() {
        return nr_tel_dk_3i;
    }

    public void setNr_tel_dk_3i(int nr_tel_dk_3i) {
        this.nr_tel_dk_3i = nr_tel_dk_3i;
    }

    public String getAdres_miasto_dk_3i() {
        return adres_miasto_dk_3i;
    }

    public void setAdres_miasto_dk_3i(String adres_miasto_dk_3i) {
        this.adres_miasto_dk_3i = adres_miasto_dk_3i;
    }

    public String getAdres_ulica_dk_3i() {
        return adres_ulica_dk_3i;
    }

    public void setAdres_ulica_dk_3i(String adres_ulica_dk_3i) {
        this.adres_ulica_dk_3i = adres_ulica_dk_3i;
    }

    public int getAdres_nr_dom_dk_3i() {
        return adres_nr_dom_dk_3i;
    }

    public void setAdres_nr_dom_dk_3i(int adres_nr_dom_dk_3i) {
        this.adres_nr_dom_dk_3i = adres_nr_dom_dk_3i;
    }
    
}
