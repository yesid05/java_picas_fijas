/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yesid caicedo
 */
public class ServidorJuego extends Thread{

    public ServidorJuego(String mensaje) {
        super(mensaje);
    }

    @Override
    public void run() {
        try {
            JuegoRMI juegoRMI = new JuegoRMI();
            
            Registry registry = LocateRegistry.createRegistry(5555);
            
            registry.bind("Juego", juegoRMI);
            
            System.out.println("Servidor en marcha...!");
            
        } catch (Exception ex) {
            Logger.getLogger(ServidorJuego.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    
    
    public static void main(String args[]){
        try {
            JuegoRMI juegoRMI = new JuegoRMI();
            
            Registry registry = LocateRegistry.createRegistry(5555);
            
            registry.bind("Juego", juegoRMI);
            
            System.out.println("Servidor en marcha...!");
            
        } catch (Exception ex) {
            Logger.getLogger(ServidorJuego.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
