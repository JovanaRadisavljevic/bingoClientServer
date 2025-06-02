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
public class Nit extends Thread{
    private JLabel labela;
    private boolean  kraj=false;

    public Nit(JLabel labela) {
        this.labela = labela;
    }

    @Override
    public void run() {
        while (!kraj) {            
            int br = (int) Math.round(Math.random()*5);
            labela.setText(br+"");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Nit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void zaustaviNit(){
        kraj=true;
    }
    
}
