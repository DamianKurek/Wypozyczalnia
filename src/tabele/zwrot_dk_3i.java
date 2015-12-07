/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author damian
 */
@Entity
public class zwrot_dk_3i implements Serializable{
    //
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private int id_zwrot_dk_3i;
    @Id
    @OneToOne
    @JoinColumn(name = "id_wypozyczenie_dk_3i")
    private wypozyczenie_dk_3i id_wypozyczenie_dk_3i;
    @Temporal(TemporalType.DATE)
    private Date data_zwrotu_dk_3i;
    private int kara_dk_3i;
    private int koszt_dk_3i;

//    public int getId_zwrot_dk_3i() {
//        return id_zwrot_dk_3i;
//    }
//
//    public void setId_zwrot_dk_3i(int id_zwrot_dk_3i) {
//        this.id_zwrot_dk_3i = id_zwrot_dk_3i;
//    }

    public wypozyczenie_dk_3i getId_wypozyczenie_dk_3i() {
        return id_wypozyczenie_dk_3i;
    }

    public void setId_wypozyczenie_dk_3i(wypozyczenie_dk_3i id_wypozyczenie_dk_3i) {
        this.id_wypozyczenie_dk_3i = id_wypozyczenie_dk_3i;
    }

    public Date getData_zwrotu_dk_3i() {
        return data_zwrotu_dk_3i;
    }

    public void setData_zwrotu_dk_3i(Date data_zwrotu_dk_3i) {
        this.data_zwrotu_dk_3i = data_zwrotu_dk_3i;
    }

    public int getKara_dk_3i() {
        return kara_dk_3i;
    }

    public void setKara_dk_3i(int kara_dk_3i) {
        this.kara_dk_3i = kara_dk_3i;
    }

    public int getKoszt_dk_3i() {
        return koszt_dk_3i;
    }

    public void setKoszt_dk_3i(int koszt_dk_3i) {
        this.koszt_dk_3i = koszt_dk_3i;
    }
    
}
