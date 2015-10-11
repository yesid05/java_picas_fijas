/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import ClaseRemota.IJuegoRMI;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.rmi.RemoteException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yesid caicedo
 */
public class PanelTabla extends JPanel {
    
    private JTable tablaDatos;
    
    private DefaultTableModel tablaModelo;
    
    private JScrollPane scrollPaneTabla;
    
    private GridBagConstraints gbc;

    public PanelTabla() {
        
        setLayout(new GridBagLayout());
        
        tablaDatos = new JTable(new DefaultTableModel(null, new Object[]{"Fijas", "Picas", "Número digitado"}));
        tablaModelo = (DefaultTableModel) tablaDatos.getModel();
        scrollPaneTabla = new JScrollPane(tablaDatos);

        scrollPaneTabla.setPreferredSize(
                new Dimension(400, 200));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 10;
        gbc.weighty = 10;
        gbc.fill = GridBagConstraints.BOTH;

        add(scrollPaneTabla, gbc);
    }
    
    public void llenarTabla(IJuegoRMI juego) throws RemoteException{
        tablaModelo.addRow(new Object[]{juego.darFijas(),juego.darPicas(),juego.darNumeroDigitado()});        
    }

}
