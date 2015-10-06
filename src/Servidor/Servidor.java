/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.util.Random;

/**
 *
 * @author yesid caicedo
 */
public class Servidor {

    char[] cadena;

    String cadenaDigitada;
    
    String numerosServidor;

    int numeroAleatorio = 123;

    public Servidor() {
        numeroAleatorio();
    }

    public Servidor(String unaCadena) {
        cadenaDigitada = unaCadena;
        cadena = cadenaDigitada.toCharArray();        
        numerosServidor = String.valueOf(numeroAleatorio);
    }
    
    public void cambiarNumero(String unaCadena){
        cadenaDigitada = unaCadena;
        cadena = cadenaDigitada.toCharArray();
        numerosServidor = String.valueOf(numeroAleatorio);
    }
    
    public String darCadenaDigitada(){
        return cadenaDigitada;
    }
    
    public int darNumeroAleatorio(){
        return numeroAleatorio;
    }
    
    public int darFijas() {
        int fijas = 0;

        for (int i = 0; i < numerosServidor.length(); i++) {
            if (cadena[i] == numerosServidor.charAt(i)) {
                fijas++;
            }
        }
        return fijas;
    }
    
    public int darPicas(){
        int picas = 0;       

        for (int i = 0; i < numerosServidor.length(); i++) {
            if (cadena[i] != numerosServidor.charAt(i)) {
                for (int j = 0; j < numerosServidor.length(); j++) {
                    if (cadena[i]==numerosServidor.charAt(j)) {
                        picas++;
                    }
                }
            }
        }
        return picas;
    }
    
    public final void numeroAleatorio(){
        Random random = new Random();
        numeroAleatorio = random.nextInt(999)+100;
    }

}
