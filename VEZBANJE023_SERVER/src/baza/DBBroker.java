/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Igra;
import model.RezultatIgre;

/**
 *
 * @author Jovana
 */
public class DBBroker {

    public boolean sacuvajIgru(RezultatIgre ri) {
        try {
            String upit="INSERT INTO rezultat (kombinacija,rezultatIgre,brPokusaja,datum) VALUES (?,?,?,?)";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ri.getDobitnaKombinacija());
            ps.setString(2, ri.getRezultat());
            ps.setInt(3, ri.getBrPoksuaja());
            Timestamp ts = new Timestamp(ri.getDatum().getTime());
            ps.setTimestamp(4, ts);
            //izvrsi upit
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id=rs.getInt(1);
                System.out.println("Generisan id: "+ id);
                
                //napravi upit za igre
                String upit2 = "INSERT INTO igra (kombinacija,naMestu,vanMesta,rezultat) VALUES (?,?,?,?)";
                PreparedStatement ps2 = Konekcija.getInstance().getConnection().prepareStatement(upit2);
                for (Igra igra : ri.getIgre()) {
                    ps2.setString(1, igra.getKombinacija());
                    ps2.setInt(2, igra.getBrNaMestu());
                    ps2.setInt(3, igra.getBrVanMesta());
                    ps2.setInt(4, id);
                    ps2.addBatch();
                }
                ps2.executeBatch();
                Konekcija.getInstance().getConnection().commit();
                return true;
            }
           
        } catch (SQLException ex) {
            try {
                Konekcija.getInstance().getConnection().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<RezultatIgre> vratiRezultate() {
         List<RezultatIgre> lista = new ArrayList<>();
        try {
           
            String upit = "SELECT * FROM rezultat";
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs= st.executeQuery(upit);
            while (rs.next()) {
                String kombinacija = rs.getString("kombinacija");
                String rez = rs.getString("rezultatIgre");
                int brPokusaja = rs.getInt("brPokusaja");
                int id = rs.getInt("id");
                Timestamp ts = rs.getTimestamp("datum");
                java.util.Date datum = new java.util.Date(ts.getTime());
                RezultatIgre ri = new RezultatIgre(id, datum, kombinacija, rez, brPokusaja);
                lista.add(ri);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
          return lista;       
    }

    public List<Igra> vratiIgreZaRezultat(RezultatIgre ri) {
        List<Igra> lista = new ArrayList<>();
        try {
           
            String upit = "SELECT * FROM igra WHERE rezultat="+ri.getId();
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs= st.executeQuery(upit);
            while (rs.next()) {
                String kombinacija = rs.getString("kombinacija");
                int naMestu = rs.getInt("naMestu");
                int vanMesta = rs.getInt("vanMesta");
                int id = rs.getInt("id");
                Igra i = new Igra(id, kombinacija, naMestu, vanMesta);
                lista.add(i);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
          return lista;      
    }
    
}
