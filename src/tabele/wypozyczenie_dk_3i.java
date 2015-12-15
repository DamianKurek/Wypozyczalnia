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
@Table(name = "wypozyczenie_dk_3i")
public class wypozyczenie_dk_3i {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_wypozyczenie_dk_3i;
    @OneToOne
    @JoinColumn(name = "id_zwrot_dk_3i")
    private zwrot_dk_3i id_zwrot_dk_3i;
    @OneToOne
    @JoinColumn(name = "id_klient_wypozyczenie_dk_3i")
    private klient_dk_3i id_klient_wypozyczenie_dk_3i;

    @OneToOne
    @JoinColumn(name = "id_pracownik_wypozyczenie_dk_3i")
    private pracownik_dk_3i id_pracownik_wypozyczenie_dk_3i;

    @OneToOne
    @JoinColumn(name = "id_auta_dk_3i")
    private auta_dk_3i id_auta_wypozyczenie_dk_3i;

    @Temporal(TemporalType.DATE)
    private Date data_wypozyczenia_dk_3i;
    @Temporal(TemporalType.DATE)
    private Date data_zwrotu_dk_3i;
    private int koszt_dk_3i;

    public pracownik_dk_3i getId_pracownik_wypozyczenie_dk_3i() {
        return id_pracownik_wypozyczenie_dk_3i;
    }

    public void setId_pracownik_wypozyczenie_dk_3i(pracownik_dk_3i id_pracownik_wypozyczenie_dk_3i) {
        this.id_pracownik_wypozyczenie_dk_3i = id_pracownik_wypozyczenie_dk_3i;
    }

    public klient_dk_3i getId_klient_wypozyczenie_dk_3i() {
        return id_klient_wypozyczenie_dk_3i;
    }

    public void setId_klient_wypozyczenie_dk_3i(klient_dk_3i id_klient_wypozyczenie_dk_3i) {
        this.id_klient_wypozyczenie_dk_3i = id_klient_wypozyczenie_dk_3i;
    }

    public auta_dk_3i getId_auta_wypozyczenie_dk_3i() {
        return id_auta_wypozyczenie_dk_3i;
    }

    public void setId_auta_wypozyczenie_dk_3i(auta_dk_3i id_auta_wypozyczenie_dk_3i) {
        this.id_auta_wypozyczenie_dk_3i = id_auta_wypozyczenie_dk_3i;
    }

    public int getId_wypozyczenie_dk_3i() {
        return id_wypozyczenie_dk_3i;
    }

    public void setId_wypozyczenie_dk_3i(int id_wypozyczenie_dk_3i) {
        this.id_wypozyczenie_dk_3i = id_wypozyczenie_dk_3i;
    }

    public Date getData_wypozyczenia_dk_3i() {
        return data_wypozyczenia_dk_3i;
    }

    public void setData_wypozyczenia_dk_3i(Date data_wypozyczenia_dk_3i) {
        this.data_wypozyczenia_dk_3i = data_wypozyczenia_dk_3i;
    }

    public Date getData_zwrotu_dk_3i() {
        return data_zwrotu_dk_3i;
    }

    public void setData_zwrotu_dk_3i(Date data_zwrotu_dk_3i) {
        this.data_zwrotu_dk_3i = data_zwrotu_dk_3i;
    }

    public int getKoszt_dk_3i() {
        return koszt_dk_3i;
    }

    public void setKoszt_dk_3i(int koszt_dk_3i) {
        this.koszt_dk_3i = koszt_dk_3i;
    }

    public zwrot_dk_3i getId_zwrot_dk_3i() {
        return id_zwrot_dk_3i;
    }

    public void setId_zwrot_dk_3i(zwrot_dk_3i id_zwrot_dk_3i) {
        this.id_zwrot_dk_3i = id_zwrot_dk_3i;
    }

}
