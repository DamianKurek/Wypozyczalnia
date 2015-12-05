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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author damian
 */
@Entity
public class pracownik_dk_3i {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_dk_3i;
    private String imie_dk_3i;
    private String nazwisko_dk_3i;
    @Temporal(TemporalType.DATE)
    private Date data_zatrudnienia_dk_3i;

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

    public Date getData_zatrudnienia_dk_3i() {
        return data_zatrudnienia_dk_3i;
    }

    public void setData_zatrudnienia_dk_3i(Date data_zatrudnienia_dk_3i) {
        this.data_zatrudnienia_dk_3i = data_zatrudnienia_dk_3i;
    }

  

}
