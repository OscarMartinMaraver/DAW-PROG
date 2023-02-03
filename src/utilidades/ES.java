/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.util.Scanner;

/**
 *En esta clase encontraremos metodos de entrada-dalida de datos que serán
 * llamados desde otras clases,de forma que se capturen los errores de entrada 
 * sin abortar, en caso de que el usuario introduzca datos no válidos.
 * @author Oscar Martín Maraver
 */
public class ES {
    /**
     * Este método sirve para escribir el mensaje indicado para solicitar la
     * introducción de un dato desde teclado, y espera la introducción de
     * cualquier número entero en el rango de números del tipo int que además
     * sea mayor o igual que el valor mínimo indicado como primer parámetro y
     * menor o igual que el valor m?ximo indicado como segundo parámetro. La
     * lectura se estará repitiendo hasta que el valor suministrado esté en ese
     * rango.
     *
     * @param mensaje Es el mensaje que se muestra para solicitar la
     * introducción del número.
     * @param minimo Es el valor más pequeño dentro del rango de los números
     * enteros tipo int que se aceptar? como válido.
     * @param maximo Es el valor más alto dentro del rango de los números.
     * enteros tipo int que se aceptará como válido.
     * @return El número entero leído.
     * @throws IllegalArgumentException Lanza excepci?n si el parámetro mínimo
     * es mayor que el mínimo.
     */
    public static int leeEntero(String mensaje, int minimo, int maximo) throws IllegalArgumentException {
        int numero = 0;
        boolean leido = false;
        Scanner teclado;

        // Si el valor mínimo es mayor que el m?ximo, lanzamos una excepción
        if (minimo <= maximo) {
            do {
                System.out.println(mensaje);
                try {
                    teclado = new Scanner(System.in);
                    numero = teclado.nextInt();
                    if (numero >= minimo && numero <= maximo) {
                        leido = true;
                    } else {
                        System.out.println("Error: Debe ser un número entero mayor o igual que " + minimo + " y menor o igual que " + maximo + ". ");
                    }
                } catch (Exception e) {
                    System.out.println("Error: No es un número entero válido. ");
                }
            } while (!leido);
        } else {
            throw new IllegalArgumentException("Rango imposible. El valor mínimo no puede ser mayor que el valor m?ximo");
        }
        return numero;
    }

    /**
     * Lee desde teclado una respuesta para una pregunta de tipo Sí o No,
     * mostrando por pantalla la pregunta en cuestión. Sólo se admiten como
     * respuestas S, s, N o bien n.
     *
     * @param mensaje Es el mensaje que se env?a con la pregunta cuya respuesta
     * se espera que sea S o N.
     * @return la cadena "S" si se ha respondido "S" o "s" y la cadena "N" si se
     * ha respondido "N" o "n".
     */
    public static String leeRespuesta(String mensaje) {
        boolean correcta = false;
        String cadena = "";
        Scanner teclado;
        do {
            System.out.println(mensaje);
            try {
                teclado = new Scanner(System.in);
                cadena = teclado.nextLine();
                if (cadena != null && cadena.length() == 1 && ((cadena.equalsIgnoreCase("S")) || (cadena.equalsIgnoreCase("N")))) {
                    correcta = true;
                } else {
                    System.out.println("Error: Solo se admite como respuesta un único carácter, que debe ser 's', 'S', 'n' o 'N'.");
                }
            } catch (Exception e) {
                System.out.println("Error: Ha fallado la entrada de datos.");
            }
        } while (!correcta);
        return cadena.toUpperCase();
    }
}
