/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import tabele.auta_dk_3i;

/**
 *
 * @author damian
 */
public class auto_raport extends auta_dk_3i {

    private int dni;

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void DodajDni(int x) {
        this.dni += x;
    }

}
