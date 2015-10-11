/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import ClaseRemota.IJuegoRMI;
import java.awt.BorderLayout;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author yesid caicedo
 */
public class InterfazCliente extends JFrame{

    private static IJuegoRMI juego;
    
    private PanelAyuda panelAyuda;
    
    private PanelDatos panelDatos;
    
    private PanelTabla panelTabla;

    public InterfazCliente() {
        try {
            Registry registry = LocateRegistry.getRegistry(5555);
            juego = (IJuegoRMI)registry.lookup("Juego");            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en el servidor","Error",JOptionPane.ERROR_MESSAGE);
        }
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
        
        panelAyuda = new PanelAyuda();
        
        panelDatos = new PanelDatos(this);
        
        panelTabla = new PanelTabla();
        

        add(panelAyuda, BorderLayout.NORTH);
        add(panelDatos, BorderLayout.CENTER);
        add(panelTabla, BorderLayout.SOUTH);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {

        InterfazCliente interfaz = new InterfazCliente();
        interfaz.pack();
        interfaz.setResizable(false);
        interfaz.setLocationRelativeTo(null);
        interfaz.setVisible(true);
          
    }

    public void llenarTabla(IJuegoRMI j) throws RemoteException {
        panelTabla.llenarTabla(j);
    }

    public void jugar() {
        try {
            int numero = Integer.valueOf(panelDatos.darTexto());
            juego.digitarNumero(""+numero);
            if (juego.darFijas() == 4) {
                JOptionPane.showMessageDialog(this, "Ganaste!!", "Ganador", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Fijas: " + juego.darFijas() + "\nPicas: " + juego.darPicas(), "Fijas y picas", JOptionPane.INFORMATION_MESSAGE);
//                System.out.println("" + juego.darNumeroServidor());
                llenarTabla(juego);
            }
        } catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(this, "Digite un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(this, "Error en el servidor...", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
