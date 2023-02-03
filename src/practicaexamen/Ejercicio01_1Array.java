/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicaexamen;

import java.util.Scanner;

/**
 * Igual que el ejercicio 01, pero en lugar de especificar cuantos números va a
 * introducir, se irán pidiendo números hasta que se escriba la palabra fin.
 *
 * @author Oscar Martin Maraver
 */
public class Ejercicio01_1Array {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Variables de entrada
        int numero; //Número que introduce el usuario y se almacena en el array
        

        //Variables auxiliares
        int[] arrayNumeros = new int[100]; // Declaración de array para almacenar los números introducidos
        //Le doy tamaño fijo grande para ir metiendo numeros sin que se llene
        int suma = 0;     //Acumulador para almacenar la suma de todos los numeros del array
        int auxiliar; //Variable auxiliar para intercambiar numeros y ordenarlos
        int contador = 0;
        boolean continuar = true; //boleano para seguir solicitando numeros
        
        //Variables de salida
        double media; //numero real para almacenar la media aritmética

        //Clase scanner para introduccion de dato por teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        do {
            System.out.println("Introduzca un número para almacenar o fin para salir");
            String entradaUsu = teclado.nextLine();

            try {
                if (!entradaUsu.equalsIgnoreCase("fin")) {
                    numero = Integer.parseInt(entradaUsu);
                    arrayNumeros[contador] = numero;
                    contador++;
                } else {
                    continuar = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Indique número entero o la palabra fin.");
            }
        } while (continuar);

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        for (int i = 0; i < contador; i++) {
            suma += arrayNumeros[i];
        }
        media = (double) suma / contador;

        for (int i = 0; i < contador - 1; i++) {
            for (int j = i + 1; j < contador; j++) {
                if (arrayNumeros[i] > arrayNumeros[j]) {
                    auxiliar = arrayNumeros[i];
                    arrayNumeros[i] = arrayNumeros[j];
                    arrayNumeros[j] = auxiliar;
                }
            }
        }
        //----------------------------------------------
        //                 Resultados
        //----------------------------------------------
        System.out.printf("El menor de los numeros introducidos es el %d y el mayor es %d.\n", arrayNumeros[0], arrayNumeros[contador - 1]);
        System.out.printf("Se han introducido %d números, la suma de todos ellos es %d y la media aritmética  es: %.2f\n",contador, suma, media);
    }

}
