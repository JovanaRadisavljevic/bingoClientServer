/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import forme.ServerskaForma;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Igra;
import model.RezultatIgre;

/**
 *
 * @author Jovana
 */
public class Controller {
    private static Controller instance;
    private String kombiancija;
    private List<Igra> igre;
    private RezultatIgre ri = new RezultatIgre(-1, new Date(), kombiancija, "IZGUBIO", 0, igre);
    private int brPokusaja=0;   
    private ServerskaForma sf;
    private DBBroker dbb;
  
    private Controller(){
        igre=new ArrayList<>();
        dbb=new DBBroker();
    }

    public String getKombiancija() {
        return kombiancija;
    }

    public void setKombiancija(String kombiancija) {
        this.kombiancija = kombiancija;
    }
    
    
    public static Controller getInstance(){
        if(instance==null)
            instance=new Controller();
        return instance;
    }

    public void setSf(ServerskaForma sf) {
        this.sf = sf;
    }
    

    public Igra pogodiKombinaciju(Igra i) {
        String kombiancijaKlijent = i.getKombinacija();
        String[] nizKlijent= kombiancijaKlijent.split("-");
        String[] nizServer= kombiancija.split("-");
        int brNaMestu=0;
        int brVanMesta=0;
        boolean[] pogodjeniServer = new boolean[4];
        boolean[] pogodjeniKlijent = new boolean[4];
        //PRVO GLEDAM KOLIKO IMAM NA MESTU
        for (int j = 0; j < 4; j++) {
            if(nizKlijent[j].equals(nizServer[j])){
                brNaMestu++;
                pogodjeniKlijent[j]=true;
                pogodjeniServer[j]=true;
            }
        }
        //SAD GLEDAM KOD KLIJENTA STA NIJE ISKORISCENO
        //DA LI JE VAN MESTA ILI SAM NA SERVERU VEC ISKORISTILA TO MESTO
        for (int j = 0; j < 4; j++) {
            if(!pogodjeniKlijent[j]){
                for (int k = 0; k < 4; k++) {
                    if(!pogodjeniServer[k] && nizKlijent[j].equals(nizServer[k])){
                        brVanMesta++;
                        pogodjeniServer[k]=true;
                        break;
                    }
                }
            }
        }
        i.setBrNaMestu(brNaMestu);
        i.setBrVanMesta(brVanMesta);
        igre.add(i);
        if(i.getBrNaMestu()==4){
            ri.setRezultat("POBEDIO");
            sf.krajIgre(true);
        }
        brPokusaja++;
        if(brPokusaja==6){
            ri.setRezultat("IZGUBIO");
             sf.krajIgre(false);
        }
        return i;
    }

    public boolean sacuvajIgru() {
        ri.setDobitnaKombinacija(kombiancija);
        ri.setBrPoksuaja(brPokusaja);
        ri.setIgre(igre);
        ri.setDatum(new Date());
        return dbb.sacuvajIgru(ri);
    }

    public List<RezultatIgre> vratiRezultate() {
        return dbb.vratiRezultate();
    }

    public List<Igra> vratiIgreZaRezultat(RezultatIgre ri) {
        return dbb.vratiIgreZaRezultat(ri);
    }
}
