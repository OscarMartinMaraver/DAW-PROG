/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicaexamen;

import clases.Cuenta;

/**
 * Realizar un programa que permita gestionar el saldo de una cuenta corriente. Una
 * vez introducido el saldo inicial, se mostrará un menú que permitirá efectuar
 * diversas acciones como retirar, ingresar, consultar o finalizar
 * @author Oscar Martín Maraver
 */
public class Ejercicio02CuentaCorriente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Variables
        Cuenta gestion;
        
        //Creamos un nuevo objeto tipo Cuenta
        gestion = new Cuenta();
        
        //Mandamos comenzar la gestion de la cuenta
        gestion.gestionarCuenta();
    }
    
}
