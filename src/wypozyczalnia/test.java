/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author damian
 */
@Entity
public class test {
    @Id
    private int x;
    private int y;
    private int z;
    private int v;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
    
}
