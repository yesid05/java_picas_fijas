/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ClaseRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author yesid caicedo
 */
public interface IJuegoRMI extends Remote{
    
    public void digitarNumero(String numero) throws RemoteException;
    
    public String darNumeroDigitado() throws RemoteException;
    
    public int darFijas() throws RemoteException;
    
    public int darPicas() throws RemoteException;
    
}
