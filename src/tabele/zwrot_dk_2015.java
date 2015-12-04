/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

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
public class zwrot_dk_2015 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_zwrot_dk_2015;
    @OneToOne
    @JoinColumn(name = "id_wypozyczenie_dk_2015")
    private wypozyczenie_dk_2015 id_wypozyczenie_dk_2015;
    @Temporal(TemporalType.DATE)
    private Date data_zwrotu_dk_2015;
    private int kara_dk_2015;
    private int koszt_dk_2015;

    public int getId_zwrot_dk_2015() {
        return id_zwrot_dk_2015;
    }

    public void setId_zwrot_dk_2015(int id_zwrot_dk_2015) {
        this.id_zwrot_dk_2015 = id_zwrot_dk_2015;
    }

    public wypozyczenie_dk_2015 getId_wypozyczenie_dk_2015() {
        return id_wypozyczenie_dk_2015;
    }

    public void setId_wypozyczenie_dk_2015(wypozyczenie_dk_2015 id_wypozyczenie_dk_2015) {
        this.id_wypozyczenie_dk_2015 = id_wypozyczenie_dk_2015;
    }

    public Date getData_zwrotu_dk_2015() {
        return data_zwrotu_dk_2015;
    }

    public void setData_zwrotu_dk_2015(Date data_zwrotu_dk_2015) {
        this.data_zwrotu_dk_2015 = data_zwrotu_dk_2015;
    }

    public int getKara_dk_2015() {
        return kara_dk_2015;
    }

    public void setKara_dk_2015(int kara_dk_2015) {
        this.kara_dk_2015 = kara_dk_2015;
    }

    public int getKoszt_dk_2015() {
        return koszt_dk_2015;
    }

    public void setKoszt_dk_2015(int koszt_dk_2015) {
        this.koszt_dk_2015 = koszt_dk_2015;
    }
    
}
