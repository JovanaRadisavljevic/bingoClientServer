/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Jovana
 */
public class NitBrojevi extends Thread{
    private JLabel br1;
    private JLabel br2;
    private JLabel br3;
    private JLabel br4;
    private boolean  kraj=false;

    public NitBrojevi(JLabel br1, JLabel br2, JLabel br3, JLabel br4) {
        this.br1 = br1;
        this.br2 = br2;
        this.br3 = br3;
        this.br4 = br4;
    }
    
    @Override
    public void run() {
        while (!kraj) {            
            int broj1= (int) Math.round(Math.random()*5);
            int broj2= (int) Math.round(Math.random()*5);
            int broj3= (int) Math.round(Math.random()*5);
            int broj4= (int) Math.round(Math.random()*5);
            br1.setText(broj1+"");
            br2.setText(broj2+"");
            br3.setText(broj3+"");
            br4.setText(broj4+"");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(NitBrojevi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void zaustaviNit(){
        kraj=true;
    }
    
}
