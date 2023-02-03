/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicaexamen;

import clases.GestorAlmacen;

/**
 *
 * @author usuario
 */
public class Ejercicio03Producto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variables
        GestorAlmacen aplicacion;
        
        //Creamos un nuevo almacenamiento de productos
        aplicacion = new GestorAlmacen();
        
        //Mandamos comenzar los pedidos
        aplicacion.gestionarAlmacen();
    }
    
}
