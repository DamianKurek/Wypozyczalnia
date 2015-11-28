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
@Table(name="auta_dk_2015")
public class auta_dk_2015 {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_dk_2015;
    //id naprawy //referencja
    private String model_dk_2015;
    private String marka_dk_2015;
    private int rocznik_dk_2015;
    private String skrzynia_biegow_dk_2015;
    private int cena_doba_dk_2015;

    public int getId_dk_2015() {
        return id_dk_2015;
    }

    public void setId_dk_2015(int id_dk_2015) {
        this.id_dk_2015 = id_dk_2015;
    }

    public String getModel_dk_2015() {
        return model_dk_2015;
    }

    public void setModel_dk_2015(String model_dk_2015) {
        this.model_dk_2015 = model_dk_2015;
    }

    public String getMarka_dk_2015() {
        return marka_dk_2015;
    }

    public void setMarka_dk_2015(String marka_dk_2015) {
        this.marka_dk_2015 = marka_dk_2015;
    }

    public int getRocznik_dk_2015() {
        return rocznik_dk_2015;
    }

    public void setRocznik_dk_2015(int rocznik_dk_2015) {
        this.rocznik_dk_2015 = rocznik_dk_2015;
    }

    public String getSkrzynia_biegow_dk_2015() {
        return skrzynia_biegow_dk_2015;
    }

    public void setSkrzynia_biegow_dk_2015(String skrzynia_biegow_dk_2015) {
        this.skrzynia_biegow_dk_2015 = skrzynia_biegow_dk_2015;
    }

    public int getCena_doba_dk_2015() {
        return cena_doba_dk_2015;
    }

    public void setCena_doba_dk_2015(int cena_dk_2015) {
        this.cena_doba_dk_2015 = cena_dk_2015;
    }

    
    
}
