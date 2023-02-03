/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicaexamen;

import java.util.Scanner;

/**
 * Crea una aplicación que, preguntando inicialmente la cantidad de números con
 * los que vamos a trabajar, pregunte todos los números y los vaya guardando en
 * un array. Al introducir todos los números haremos un recorrido del array,
 * procesamos estos datos y calcularemos la media de números introducidos, el
 * mayor número introducido y el menor número introducido.
 *
 * @author Oscar Martin Maraver
 */
public class Ejercicio01Array {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Variables de entrada
        int numero; //Número que intorduce el usuario y se almacena en el array
        int tamaño; //Tamaño del array introducido por el usuario

        //Variables auxiliares
        int[] arrayNumeros; // Declaración de array para almacenar los números introducidos
        int suma = 0;        //Acumulador para almacenar la suma de todos los numeros del array
        int auxiliar;   //Variable auxiliar para intercambiar numeros y ordenarlos

        //Variables de salida
        double media; //numero real para almacenar la media aritmética

        //Clase scanner para introduccion de dato por teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("Indique con cuantos números desea trabajar");

        //Inialización variables
        tamaño = teclado.nextInt();
        arrayNumeros = new int[tamaño]; //Creación del array reservando para el un espacio en memoria.

        for (int i = 0; i < arrayNumeros.length; i++) {
            try{
            System.out.println("Indique el número " + (i + 1) + "º");
            numero = teclado.nextInt();
            arrayNumeros[i] = numero;
            }catch(Exception e){
                System.out.println("El dato introducido no es válido. Introduzca un numero entero");
                teclado=new Scanner(System.in);
                i--;
            }
        }

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        for (int i = 0; i < arrayNumeros.length; i++) {
            suma += arrayNumeros[i];
        }
        media = (double) suma / arrayNumeros.length;

        for (int i = 0; i < arrayNumeros.length - 1; i++) {
            for (int j = i + 1; j < arrayNumeros.length; j++) {
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
        System.out.printf("El menor de los numeros introducidos es el %d y el mayor es %d.\n", arrayNumeros[0], arrayNumeros[arrayNumeros.length - 1]);
        System.out.printf("La suma de todos los numeros es %d y la media aritmética  es: %.2f\n", suma, media);
    }

}
