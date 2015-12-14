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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author damian
 */
@Entity
@Table(name = "auta_dk_3i")
public class auta_dk_3i {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_dk_3i;
    @OneToOne
    @JoinColumn(name="id_naprawy_dk_3i")
    public  naprawa_dk_3i id_naprawy_dk_3i;
    private String model_dk_3i;
    private String marka_dk_3i;
    private int rocznik_dk_3i;
    private String skrzynia_biegow_dk_3i;
    private int cena_doba_dk_3i;
    private boolean uszkodzony_dk_3i;
    

    public int getId_dk_3i() {
        return id_dk_3i;
    }

    public void setId_dk_3i(int id_dk_3i) {
        this.id_dk_3i = id_dk_3i;
    }

    public String getModel_dk_3i() {
        return model_dk_3i;
    }

    public void setModel_dk_3i(String model_dk_3i) {
        this.model_dk_3i = model_dk_3i;
    }

    public String getMarka_dk_3i() {
        return marka_dk_3i;
    }

    public void setMarka_dk_3i(String marka_dk_3i) {
        this.marka_dk_3i = marka_dk_3i;
    }

    public int getRocznik_dk_3i() {
        return rocznik_dk_3i;
    }

    public void setRocznik_dk_3i(int rocznik_dk_3i) {
        this.rocznik_dk_3i = rocznik_dk_3i;
    }

    public String getSkrzynia_biegow_dk_3i() {
        return skrzynia_biegow_dk_3i;
    }

    public void setSkrzynia_biegow_dk_3i(String skrzynia_biegow_dk_3i) {
        this.skrzynia_biegow_dk_3i = skrzynia_biegow_dk_3i;
    }

    public int getCena_doba_dk_3i() {
        return cena_doba_dk_3i;
    }

    public void setCena_doba_dk_3i(int cena_doba_dk_3i) {
        this.cena_doba_dk_3i = cena_doba_dk_3i;
    }

    public boolean isUszkodzony_dk_3i() {
        return uszkodzony_dk_3i;
    }

    public void setUszkodzony_dk_3i(boolean uszkodzony_dk_3i) {
        this.uszkodzony_dk_3i = uszkodzony_dk_3i;
    }

    public naprawa_dk_3i getId_naprawy_dk_3i() {
        return id_naprawy_dk_3i;
    }

    public void setId_naprawy_dk_3i(naprawa_dk_3i id_naprawy_dk_3i) {
        this.id_naprawy_dk_3i = id_naprawy_dk_3i;
    }


}
