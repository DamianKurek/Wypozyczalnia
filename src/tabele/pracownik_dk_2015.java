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
public class pracownik_dk_2015 {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_dk_2015;
    private String imie_dk_2015;
    private String nazwisko_dk_2015;
    @Temporal(TemporalType.DATE)
    private Date data_zatrudnienia_dk_2015;

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

    public Date getData_zatrudnienia_dk_2015() {
        return data_zatrudnienia_dk_2015;
    }

    public void setData_zatrudnienia_dk_2015(Date data_zatrudnienia_dk_2015) {
        this.data_zatrudnienia_dk_2015 = data_zatrudnienia_dk_2015;
    }
    
    
}
