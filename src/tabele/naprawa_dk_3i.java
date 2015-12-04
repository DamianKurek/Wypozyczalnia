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

/**
 *
 * @author damian
 */
@Entity
public class naprawa_dk_3i {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_naprawa_dk_3i;
    @OneToOne
    @JoinColumn(name="id_auto_dk_3i")
    private auta_dk_3i id_auto_dk_3i;
    private String opis_naprawa_3i;
    private int cena_naprawa_dk_3i;

    public int getId_naprawa_dk_3i() {
        return id_naprawa_dk_3i;
    }

    public void setId_naprawa_dk_3i(int id_naprawa_dk_3i) {
        this.id_naprawa_dk_3i = id_naprawa_dk_3i;
    }

    public String getOpis_naprawa_3i() {
        return opis_naprawa_3i;
    }

    public void setOpis_naprawa_3i(String opis_naprawa_3i) {
        this.opis_naprawa_3i = opis_naprawa_3i;
    }

    public int getCena_naprawa_dk_3i() {
        return cena_naprawa_dk_3i;
    }

    public void setCena_naprawa_dk_3i(int cena_naprawa_dk_3i) {
        this.cena_naprawa_dk_3i = cena_naprawa_dk_3i;
    }

    public auta_dk_3i getId_auto_dk_3i() {
        return id_auto_dk_3i;
    }

    public void setId_auto_dk_3i(auta_dk_3i id_auto_dk_3i) {
        this.id_auto_dk_3i = id_auto_dk_3i;
    }
    
}
