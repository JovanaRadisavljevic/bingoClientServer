/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jovana
 */
public class PokreniServer extends Thread {
    private ServerSocket serverskiSoket;

    @Override
    public void run() {
        try {
            serverskiSoket= new ServerSocket(9000);
            System.out.println("SERVER CEKA...");
            while (true) {                
                Socket s = serverskiSoket.accept();
                System.out.println("KLIJENT JE POVEZAN");
                ObradaKlijentskihZahteva okz = new ObradaKlijentskihZahteva(s);
                okz.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
