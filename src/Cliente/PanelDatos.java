/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author yesid caicedo
 */
public class PanelDatos extends JPanel implements ActionListener, KeyListener {

    private JLabel lblNumero;

    private JTextField txtNumero;

    private JButton btnAceptar;

    private JButton btnCancelar;

    private GridBagConstraints gbc;

    private InterfazCliente interfaz;

    public PanelDatos(InterfazCliente i) {
        interfaz = i;
        setLayout(new GridBagLayout());

        lblNumero = new JLabel("Digite un número:");
        txtNumero = new JTextField(15);
        txtNumero.addKeyListener(this);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        btnAceptar.addKeyListener(this);
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        add(lblNumero, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        add(txtNumero, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.NONE;
        add(btnAceptar, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.NONE;
        add(btnCancelar, gbc);
    }
    
    public String darTexto(){
        return txtNumero.getText();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAceptar) {
            interfaz.jugar();
        }
        if (e.getSource()
                == btnCancelar) {
            interfaz.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
       if (e.getSource() == txtNumero) {
            if (((e.getKeyChar() < '1') || (e.getKeyChar() > '9')) && (e.getKeyChar() != '\b' /*corresponde a BACK_SPACE*/)) {
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            interfaz.jugar();
        }
        if (e.getSource() == txtNumero) {
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       if (e.getSource() == txtNumero) {
        }
    }

}
