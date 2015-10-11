/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author yesid caicedo
 */
public class PanelAyuda extends JPanel{
    
    private JLabel lblExplicacion;
    
    private GridBagConstraints gbc;

    public PanelAyuda() {
        setLayout(new GridBagLayout());
        
        lblExplicacion = new JLabel();
        lblExplicacion.setFont(new Font("Arial", 1, 18));
        lblExplicacion.setForeground(new Color(204, 0, 0));
        lblExplicacion.setText("<html><p>El servidor genera cuatro números aleatorios,</p>"
                + "<p>escriba cuatro números, si alguno de los números</p>"
                + "<p>está en la posición en que se encuentra en el servidor</p>"
                + "<p>se mostrara como fija, si el numero está en la secuencia</p>"
                + "<p>paro no en la posición correcta se mostrara como pica.</p></html>");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.NONE;
        add(lblExplicacion,gbc);
    }
    
    
    
}
