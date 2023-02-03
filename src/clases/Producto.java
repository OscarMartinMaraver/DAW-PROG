/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Scanner;

/**
 * Clase para crear un <strong>producto</strong> con una serie de atributos:
 * <ul>
 * <li><strong>Código</strong> – Código que le asociaremos a cada producto.</li>
 * <li><strong>Nombre</strong> – Nombre del producto.</li>
 * <li><strong>Cantidad</strong> – Cantidad del producto que tenemos en la tienda.</li>
 * <li><strong>Precio</strong> – Precio por unidad del producto.</li>
 * <li><strong>posicionEnAlmacén</strong> – Se trata de un atibuto de clase que nos indica
 * la posición que ocupa cada objeto producto dentro de la array de producto, lo que nos permitirá eliminar un producto
 * de la misma. Este variará (incremento y decremento) en función de la operación.</li>
 * <li><strong>productoCreado</strong> – un atributo de clase que va incrementado con cada objeto de clase creado y que será usado para
 * asignar un código numero correlativo a cada producto. Este no decrementa, por lo que si tras eliminar un producto
 * se crea uno nuevo, el código asignado a este continuará incrementandose para que no exista repeticiones de códigos de producto.</li>
 * </ul>
 * @author Martin Maraver
 */
public class Producto {

// ATRIBUTOS DE CLASE: Común para todos los objetos clase Producto creados
    static int posicionEnAlmacen; //Para indicar la posición que ocupará en el almacen cada producto
    static int productoCreado;     //Servirá para conocer el número de productos creado y asignar un código numerico.
    
// ATRIBUTOS DE OBJETO: cada producto tendrá su propio valor para representar estas características
// ------------------------------------------------------------------------------------------------
// Atributos de objeto constantes (representan características "inmutables" del objeto producto creado)
    private final String nombre;     // Nombre del producto creado
    private final int codigo;       // Codigo asignado al  producto creado

// Atributos de objeto variables (representan características "mutables" del objeto producto creado)
    private int cantidad;   //La cantidad de determinado producto se podrá modificar en un menú.
    private double precio;  //el precio del producto se podrá cambiar una vez creado.


   
    
//CONSTRUCTOR PARA UN OBJETO DE LA CLASE PRODUCTO (Creacion del objeto con parámetros de entrada)
    
    /**
     * Constructor de la clase.Crea un objeto Producto asignando como valores de
     * sus atributos los datos solicitados al usuario por pantalla.
     * @param nombreUsu - Variable String que recoge el nombre del producto indicado por usuario e introducido como parámetro del constructor
     * @param cantidadUsu - Variable int que recoge la cantidad del producto indicado por usuario e introducido como parámetro del constructor
     * @param precioUsu - Variable double que recoge el precio del producto indicado por usuario e introducido como parámetro del constructor
     */
    public Producto(String nombreUsu, int cantidadUsu, double precioUsu) {
        Producto.posicionEnAlmacen++;
        Producto.productoCreado++;
        this.nombre = nombreUsu;
        this.codigo = Producto.productoCreado;
        this.cantidad=cantidadUsu;
        this.precio = precioUsu;  
    }
    
    
    //METODOS GETTER (muestra los valores de los atributos del objeto)
    
    /**
     * 
     * @return Atributo nombre del producto
     */
    public String getNombre(){
        return this.nombre;
    }
    /**
     * 
     * @return Atributo codigo del producto (entero). Es un número consecutivo que coincide con el número
     * de objetos creados. No decrementa, para que no pueda repetirse en caso de eleiminar algún objeto
     */
    public int getCodigo(){
        return this.codigo;
    }
    /**
     * 
     * @return Atributo cantidad (entero)
     */
    public int getCantidad(){
        return this.cantidad;
    }
    /**
     * 
     * @return  Atributo precio (double).
     */
    public double getPrecio(){
        return this.precio;
    }
    
    @Override
    public String toString() {
        String pCreado = String.format("El producto creado ha sido %s con el código %d cuya cantidad es %d "
                + "y su precio %.2f€ por unidad.\n", this.nombre, this.codigo, this.cantidad, this.precio);
        return pCreado;
    }
    
    //METODOS SETTER (Asignan valores a los atributos)
    
    /**
     * Método que asigna un nuevo valor al atributo <strong>precio</strong>, 
     * el cual será llamado desde el menún de producto
     * en la clase <strong>GestorAlmacen</strong>.
     * @return -Nuevo valor del atributo <strong>precio</strong>(double)
     */
    public double modificarPrecio(){ 
        Scanner teclado=new Scanner(System.in); 
        System.out.println("introduzca el nuevo precio: ");
        double nuevoPrecio;
        nuevoPrecio=teclado.nextDouble();
        this.precio=nuevoPrecio;
        return precio;
    }
    
    /**
     * Método que asigna un nuevo valor al atributo <strong>cantidad</strong>, 
     * el cual será llamado desde el menún de producto
     * en la clase <strong>GestorAlmacen</strong>.
     * @return -Nuevo valor del atributo <strong>cantidad</strong>(int).
     */
    public int modificarCantidad(){ 
        Scanner teclado=new Scanner(System.in); 
        System.out.println("Asigne nueva cantidad disponible: ");
        int nuevaCantidad;
        nuevaCantidad=teclado.nextInt();
        this.cantidad=nuevaCantidad;
        return cantidad;
    }
}
