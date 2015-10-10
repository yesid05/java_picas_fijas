/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor;

import ClaseRemota.IJuegoRMI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author yesid caicedo
 */
public class JuegoRMI extends UnicastRemoteObject implements IJuegoRMI{
    
    private transient Juego juego;
    
    protected JuegoRMI() throws RemoteException{
        juego = new Juego();
    }

    @Override
    public void digitarNumero(String numero) throws RemoteException {
        juego.cambiarNumero(numero);
    }

    @Override
    public int darFijas() throws RemoteException {
        return juego.darFijas();
    }

    @Override
    public int darPicas() throws RemoteException {
        return juego.darPicas();
    }

    @Override
    public String darNumeroDigitado() throws RemoteException {
        return juego.darCadenaDigitada();
    }
    
}
