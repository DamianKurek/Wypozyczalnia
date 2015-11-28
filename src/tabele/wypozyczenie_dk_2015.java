/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author damian
 */
@Entity
@Table(name = "wypozyczenie_dk_2015")
public class wypozyczenie_dk_2015 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_wypozyczenie_dk_2015;
    @OneToOne
    @JoinColumn(name = "id_klient_wypozyczenie_dk_2015")
    private klient_dk_2015 id_klient_wypozyczenie_dk_2015;

    @OneToOne
    @JoinColumn(name = "id_pracownik_wypozyczenie_dk_2015")
    private pracownik_dk_2015 id_pracownik_wypozyczenie_dk_2015;

    @OneToOne
    @JoinColumn(name = "id_auta_dk_2015")
    private auta_dk_2015 id_auta_wypozyczenie_dk_2015;

    @Temporal(TemporalType.DATE)
    private Date data_wypozyczenia_dk_2015;
    @Temporal(TemporalType.DATE)
    private Date data_zwrotu_dk_2015;
    private int koszt_dk_2015;

    public pracownik_dk_2015 getId_pracownik_wypozyczenie_dk_2015() {
        return id_pracownik_wypozyczenie_dk_2015;
    }

    public void setId_pracownik_wypozyczenie_dk_2015(pracownik_dk_2015 id_pracownik_wypozyczenie_dk_2015) {
        this.id_pracownik_wypozyczenie_dk_2015 = id_pracownik_wypozyczenie_dk_2015;
    }

    public klient_dk_2015 getId_klient_wypozyczenie_dk_2015() {
        return id_klient_wypozyczenie_dk_2015;
    }

    public void setId_klient_wypozyczenie_dk_2015(klient_dk_2015 id_klient_wypozyczenie_dk_2015) {
        this.id_klient_wypozyczenie_dk_2015 = id_klient_wypozyczenie_dk_2015;
    }

    public auta_dk_2015 getId_auta_wypozyczenie_dk_2015() {
        return id_auta_wypozyczenie_dk_2015;
    }

    public void setId_auta_wypozyczenie_dk_2015(auta_dk_2015 id_auta_wypozyczenie_dk_2015) {
        this.id_auta_wypozyczenie_dk_2015 = id_auta_wypozyczenie_dk_2015;
    }

    public int getId_wypozyczenie_dk_2015() {
        return id_wypozyczenie_dk_2015;
    }

    public void setId_wypozyczenie_dk_2015(int id_wypozyczenie_dk_2015) {
        this.id_wypozyczenie_dk_2015 = id_wypozyczenie_dk_2015;
    }

    public Date getData_wypozyczenia_dk_2015() {
        return data_wypozyczenia_dk_2015;
    }

    public void setData_wypozyczenia_dk_2015(Date data_wypozyczenia_dk_2015) {
        this.data_wypozyczenia_dk_2015 = data_wypozyczenia_dk_2015;
    }

    public Date getData_zwrotu_dk_2015() {
        return data_zwrotu_dk_2015;
    }

    public void setData_zwrotu_dk_2015(Date data_zwrotu_dk_2015) {
        this.data_zwrotu_dk_2015 = data_zwrotu_dk_2015;
    }

    public int getKoszt_dk_2015() {
        return koszt_dk_2015;
    }

    public void setKoszt_dk_2015(int koszt_dk_2015) {
        this.koszt_dk_2015 = koszt_dk_2015;
    }

}
