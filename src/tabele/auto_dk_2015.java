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
@Table(name="auto_dk_2015")
public class auto_dk_2015 {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_dk_2015;
    private String auto_model_dk_2015;
    private String auto_marka_dk_2015;
    private int auto_rok_dk_2015;
    private String auto_skrzynia_dk_2015;
    private int auto_cena_dk_2015;
    
    
}
