/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Scanner;
import utilidades.ES;

/**
 * Esta clase mostrará un menú que permitirá efectuar las siguientes
 * operaciones: 1. Hacer un reintegro, se pedirá la cantidad a retirar. 2. Hacer
 * un ingreso, se pedirá la cantidad a ingresar. 3. Consultar el saldo y el
 * número de reintegros e ingresos realizados. 4. Finalizar las operaciones.
 * Debe confirmar si realmente desea salir e informar del saldo al final de
 * todas las operaciones.
 *
 * @author Oscar Martín Maraver
 */
public class Cuenta {

    //----------------------------------------------
    //          Declaración de variables 
    //----------------------------------------------
    //Constantes
    private final int HACER_REINTEGRO = 1;
    private final int HACER_INGRESO = 2;
    private final int CONSULTAR_SALDO = 3;
    private final int FINALIZAR = 4;

    // Atributos de objeto variables (representan el estado del objetoGestorCuenta en un instante dado)
    private double saldo;

    //CONSTRUCTORES
    /**
     * Constructor por defecto de la clase usado para crear objeto inicializando el atributo
     * saldo acorde con la cantidad inicial introducida por el cliente
     */
    public Cuenta() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el saldo inicial de su cuenta");
        saldo = teclado.nextDouble(); //Inialización de la variable para almacenar el saldo de la cuenta
    }

    public void gestionarCuenta() {
        //Variables        
        boolean terminar = false;

        // Variables de entrada
        int opcionElegida;
        String confirmarSalida;

        // Objeto clase Scanner para introducir cantidades en los metodos reintegro e ingresar
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //               Procesamiento 
        //----------------------------------------------
        do {
            System.out.println("\nBienvenido a su banco");
            System.out.println("-------------------------");
            System.out.println(HACER_REINTEGRO + ".- Hacer un reintegro.");
            System.out.println(HACER_INGRESO + ".- Hacer un ingreso.");
            System.out.println(CONSULTAR_SALDO + ".- Consultar saldo actual.");
            System.out.println(FINALIZAR + ".- Apagar aplicación.");
            opcionElegida = ES.leeEntero("elija una opción:", 1, 4); //Leeremos un número entero entre 1 y 4.

            switch (opcionElegida) {
                case HACER_REINTEGRO: //Retiraremos saldo
                    System.out.println("Introduzca la cantidad a retirar");
                    double cantRetirar;
                    cantRetirar = teclado.nextDouble();
                    if (cantRetirar > saldo) {
                        System.out.println("La cantidad introducida es superior al saldo de su cuenta");
                    } else {
                        reintegro(cantRetirar); // Llamar al método reintegro
                        System.out.printf("Tras la retirada de %.2f € su saldo actual es: %.2f €.\n", cantRetirar, saldo);
                    }
                    break;

                case HACER_INGRESO: //Ingresaremos saldo
                    System.out.println("Introduzca la cantidad a ingresar");
                    double cantIngresar;
                    cantIngresar = teclado.nextDouble();
                    ingreso(cantIngresar); // Llamar al método ingreso
                    System.out.printf("Tras el ingreso de %.2f € su saldo actual es: %.2f €.\n", cantIngresar, saldo);
                    break;

                case CONSULTAR_SALDO: // Mostraremos el saldo actual.
                    //Llamar al método mostrarSaldo
                    mostrarSaldo();
                    break;

                case FINALIZAR:
                    confirmarSalida = ES.leeRespuesta("¿Está seguro que desea finalizar? S/N");
                    if (confirmarSalida.equals("S")) {
                        System.out.printf("El saldo actual de su cuenta es de %.2f €\n", saldo);
                        System.out.println("Que tenga usted un buen dia");
                        terminar = true;
                    } else {
                        terminar = false;
                    }
                    break;
            }

        } while (!terminar);
        System.out.println("Finalizando aplicación...\n");
    }

    /**
     * Método que calcula el saldo tras solicitar la retirada de parte del mismo
     * Si el valo introducido es superior al saldo, indica dicha circunstancia y
     * no se efectua la operacion
     *
     * @param cantRetirar Cantidad que solicita el usuario retirar de su cuenta
     * @return Devuelve el saldo de la cuenta tras la retirada de efectivo
     */
    public double reintegro(double cantRetirar) {
        saldo = saldo - cantRetirar;
        return saldo;
    }

    /**
     * Metodo que calcula el saldo tras hacer un ingreso
     *
     * @param cantIngresar Cantidad que quiere ingresar el usuario
     * @return Devuelve el saldo de la cuenta tras el ingreso
     */
    public double ingreso(double cantIngresar) {
        saldo = saldo + cantIngresar;
        return saldo;
    }

    /**
     * Método para mostrar el saldo actual de la cuenta
     */
    public void mostrarSaldo() {
        System.out.printf("El saldo actual de su cuenta es de %.2f €\n", saldo);
    }
}
