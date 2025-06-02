/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Jovana
 */
public class Igra implements Serializable {
    private int rb;
    private String kombinacija;
    private int brNaMestu;
    private int brVanMesta;

    public Igra() {
    }

    public Igra(int rb, String kombinacija, int brNaMestu, int brVanMesta) {
        this.rb = rb;
        this.kombinacija = kombinacija;
        this.brNaMestu = brNaMestu;
        this.brVanMesta = brVanMesta;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getKombinacija() {
        return kombinacija;
    }

    public void setKombinacija(String kombinacija) {
        this.kombinacija = kombinacija;
    }

    public int getBrNaMestu() {
        return brNaMestu;
    }

    public void setBrNaMestu(int brNaMestu) {
        this.brNaMestu = brNaMestu;
    }

    public int getBrVanMesta() {
        return brVanMesta;
    }

    public void setBrVanMesta(int brVanMesta) {
        this.brVanMesta = brVanMesta;
    }

    @Override
    public String toString() {
        return "Igra{" + "rb=" + rb + ", kombinacija=" + kombinacija + ", brNaMestu=" + brNaMestu + ", brVanMesta=" + brVanMesta + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Igra other = (Igra) obj;
        if (this.brNaMestu != other.brNaMestu) {
            return false;
        }
        if (this.brVanMesta != other.brVanMesta) {
            return false;
        }
        return Objects.equals(this.kombinacija, other.kombinacija);
    }
     
    
}
