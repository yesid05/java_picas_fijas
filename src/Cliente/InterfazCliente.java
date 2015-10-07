/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Servidor.Servidor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yesid caicedo
 */
public class InterfazCliente extends JFrame implements ActionListener, KeyListener {

    private Servidor servidor;

    private JTable tablaDatos;

    private JScrollPane scrollPaneTabla;

    private DefaultTableModel tablaModelo;

    private JLabel lblExplicacion;

    private JLabel lblNumero;

    private JTextField txtNumero;

    private JButton btnAceptar;

    private JButton btnCancelar;

    public InterfazCliente() {
        servidor = new Servidor();
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

        GridBagConstraints gbc = new GridBagConstraints();
        JPanel panelInformacion = new JPanel(new GridBagLayout());

        lblExplicacion = new JLabel();
        lblExplicacion.setFont(new Font("Arial", 1, 18));
        lblExplicacion.setForeground(new Color(204, 0, 0));
        lblExplicacion.setText("<html><p>El servidor genera tres números aleatorios,</p>"
                + "<p>escriba tres números, si alguno de los números</p>"
                + "<p>está en la posición en que se encuentra en el servidor</p>"
                + "<p>se mostrara como fija, si el numero está en la secuencia</p>"
                + "<p>paro no en la posición correcta se mostrara como pica.</p></html>");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.NONE;
        panelInformacion.add(lblExplicacion, gbc);

        lblNumero = new JLabel("Digite un número:");
        txtNumero = new JTextField(15);
        txtNumero.addKeyListener(this);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        btnAceptar.addKeyListener(this);
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);

        JPanel panelDatos = new JPanel(new GridBagLayout());

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        panelDatos.add(lblNumero, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        panelDatos.add(txtNumero, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.NONE;
        panelDatos.add(btnAceptar, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.NONE;
        panelDatos.add(btnCancelar, gbc);

        JPanel panelTabla = new JPanel(new GridBagLayout());
        tablaDatos = new JTable(new DefaultTableModel(null, new Object[]{"Fijas", "Picas", "Número digitado"}));
        tablaModelo = (DefaultTableModel) tablaDatos.getModel();
        scrollPaneTabla = new JScrollPane(tablaDatos);
        scrollPaneTabla.setPreferredSize(new Dimension(400, 200));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 10;
        gbc.weighty = 10;
        gbc.fill = GridBagConstraints.BOTH;
        panelTabla.add(scrollPaneTabla, gbc);

        add(panelInformacion, BorderLayout.NORTH);
        add(panelDatos, BorderLayout.CENTER);
        add(panelTabla, BorderLayout.SOUTH);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        InterfazCliente interfaz = new InterfazCliente();
        interfaz.pack();
        interfaz.setResizable(false);
        interfaz.setLocationRelativeTo(null);
        interfaz.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAceptar) {
            jugar();
        }
        if (e.getSource()
                == btnCancelar) {
            dispose();
        }
    }

    public void llenarTabla() {
        tablaModelo.addRow(new Object[]{servidor.darFijas(), servidor.darPicas(), servidor.darCadenaDigitada()});
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
            jugar();
        }
        if (e.getSource() == txtNumero) {
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == txtNumero) {
        }
    }

    public void jugar() {
        try {
            int numero = Integer.valueOf(txtNumero.getText());
            servidor.cambiarNumero("" + numero);
            if (servidor.darFijas() == 4) {
                JOptionPane.showMessageDialog(this, "Ganaste!!", "Ganador", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Fijas: " + servidor.darFijas() + "\nPicas: " + servidor.darPicas(), "Fijas y picas", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("" + servidor.darNumeroServidor());
                llenarTabla();
            }
        } catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(this, "Digite un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
