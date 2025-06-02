/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jovana
 */
public class RezultatIgre implements Serializable{
    private int id;
    private Date datum;
    private String dobitnaKombinacija;
    private String rezultat;
    private int brPoksuaja;
    private List<Igra> igre;

    public RezultatIgre() {
    }

    public RezultatIgre(int id, Date datum, String dobitnaKombinacija, String rezultat, int brPoksuaja, List<Igra> igre) {
        this.id = id;
        this.datum = datum;
        this.dobitnaKombinacija = dobitnaKombinacija;
        this.rezultat = rezultat;
        this.brPoksuaja = brPoksuaja;
        this.igre = igre;
    }
    public RezultatIgre(int id, Date datum, String dobitnaKombinacija, String rezultat, int brPoksuaja) {
        this.id = id;
        this.datum = datum;
        this.dobitnaKombinacija = dobitnaKombinacija;
        this.rezultat = rezultat;
        this.brPoksuaja = brPoksuaja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getDobitnaKombinacija() {
        return dobitnaKombinacija;
    }

    public void setDobitnaKombinacija(String dobitnaKombinacija) {
        this.dobitnaKombinacija = dobitnaKombinacija;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    public int getBrPoksuaja() {
        return brPoksuaja;
    }

    public void setBrPoksuaja(int brPoksuaja) {
        this.brPoksuaja = brPoksuaja;
    }

    public List<Igra> getIgre() {
        return igre;
    }

    public void setIgre(List<Igra> igre) {
        this.igre = igre;
    }
    
    
}
