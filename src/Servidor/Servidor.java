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

    char[] numeroAleatorio;

    public Servidor() {
        numeroAleatorio();
        numerosServidor = new String(numeroAleatorio);
    }

    public Servidor(String unaCadena) {
        cadena = unaCadena.toCharArray();
        numerosServidor = new String(numeroAleatorio);
    }

    public void cambiarNumero(String unaCadena) {
        cadenaDigitada = unaCadena;
        cadena = cadenaDigitada.toCharArray();
    }
    
    public String darCadenaDigitada(){
        return cadenaDigitada;
    }
    
    public String darNumeroServidor() {
        return numerosServidor;
    }
    
    public char[] darNumeroAleatorio() {
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

    public int darPicas() {
        int picas = 0;
        for (int i = 0; i < numerosServidor.length(); i++) {
            if (cadena[i] != numerosServidor.charAt(i)) {
                for (int j = 0; j < numerosServidor.length(); j++) {
                    if (cadena[i] == numerosServidor.charAt(j)) {
                        picas++;
                    }
                }
            }
        }
        return picas;
    }

    public final void numeroAleatorio() {
        Random random = new Random();
        numeroAleatorio = new char[4];
        int contador = 0;
        while (contador<numeroAleatorio.length) {
            String numero = String.valueOf(random.nextInt(9) + 1);
            if (!numeroExiste(numeroAleatorio, numero)) {
                numeroAleatorio[contador] = numero.charAt(0);
                contador++;
            }

        }
    }

    public boolean numeroExiste(char[] unNumero, String numero) {
        boolean existe = false;
        int contador = 0;
        while (contador < unNumero.length && !existe) {
            if (unNumero[contador] == numero.charAt(0)) {
                existe = true;
            }
            contador++;
        }
        return existe;
    }

}
