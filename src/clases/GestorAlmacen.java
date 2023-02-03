/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Random;
import java.util.Scanner;
import utilidades.ES;

/**
 *
 * @author Oscar Martín Maraver
 */
public class GestorAlmacen {

    //----------------------------------------------
    //          Declaración de variables 
    //----------------------------------------------
    //Constantes
    private final int TAMAÑO_ALMACEN = 150;
    private final byte STOCK_MIN = 5;
    private final int CARGAR = 1;
    private final int CREAR = 2;
    private final int BUSCAR = 3;
    private final int ELIMINAR = 4;
    private final int MOSTRAR = 5;
    private final int STOCK_BAJO = 6;
    private final int SALIR = 7;

    // Atributos de objeto variables (representan el estado del objeto GestorProductos en un instante dado)
    private Producto[] existenciasProducto; //Declaración de un array de objetos Producto para almacenar cada objeto fabricado

    /**
     * Constructor por defecto de la clase usado para inicializar el array <strong>existenciasProductos </strong>
     * que almacenará los objetos, y cuyo tamaño será acorde con la constante <strong>TAMAÑO_ALMACEN</strong>.
     */
    public GestorAlmacen() {
        existenciasProducto = new Producto[TAMAÑO_ALMACEN]; //Inalización del array con 150 posiciones para almacenar objetos Producto

    }

    public void gestionarAlmacen() {
        //Variables        
        boolean terminar = false;

        // Variables de entrada
        int opcionElegida;
        String confirmarSalida;

        //----------------------------------------------
        //               Procesamiento 
        //----------------------------------------------
        do {
            System.out.println("\nGestor del almacen. ¿Que operación desea realizar?");
            System.out.println("----------------------------------------------------");
            System.out.println(CARGAR + ".- Cargar productos en el programa automáticamente.");
            System.out.println(CREAR + ".- Agregar un producto.");
            System.out.println(BUSCAR + ".- Buscar un producto.");
            System.out.println(ELIMINAR + ".- Eliminar un producto.");
            System.out.println(MOSTRAR + ".- Mostrar productos (todos).");
            System.out.println(STOCK_BAJO + ".- Productos con Stock bajo.");
            System.out.println(SALIR + ".- Salir de la aplicación.");
            opcionElegida = ES.leeEntero("Elija una opción:", 1, 7); //Leeremos un número entero entre 1 y 7.

            switch (opcionElegida) {
                case CARGAR: //Crea cuator objetos de la clase producto y los ingresa en el array
                    cargarProducto();
                    System.out.println("Se ha procedido a cargar productos por defecto");
                    break;

                case CREAR: //Crea un producto y almacena en el almacen
                    System.out.println("Creando producto ");
                    insertarProducto();
                    break;

                case BUSCAR: // Llamamos al método de busqueda
                    buscarProducto();
                    break;

                case ELIMINAR: 
                    eliminarProducto();    
                    break;

                case MOSTRAR: // Mostraremos los productos que hay almacenados en el array.
                    mostrarProductos();

                    break;
                case STOCK_BAJO: // Mostraremos aquellos productos con un stock inferior a 5.
                    mostrarStockBajo();

                    break;
                case SALIR:
                    confirmarSalida = ES.leeRespuesta("¿Está seguro que desea finalizar? S/N");
                    if (confirmarSalida.equals("S")) {
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
     * Metodo para crear un número de productos de prueba desisgnados por el
     * usuario e indtorducirlos en el almacén.Utiliza el constructor de la clase
     * Producto asignando mediante un bucle un numero aleatorio al precio y a la
     * cantidad en cada vuelta.
     *
     */
    public void cargarProducto() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el numero de productos a cargar por defecto(Al menos 4): ");
        Random r = new Random();
        int cantidadProducto = 0;
        do {
            try{
            cantidadProducto = Integer.parseInt(teclado.nextLine());
            }catch (NumberFormatException e){
               System.out.println("El dato introducido no es un valor numérico valido");
            }
            if (cantidadProducto >= 4) {
                String nombreUsu;
                for (int i = 0; i < cantidadProducto; i++) {
                    int cantidadUsu = r.nextInt(50);
                    double precioUsu = r.nextDouble() * 10;
                    nombreUsu = "Prueba N" + (Producto.productoCreado + 1);
                    Producto nuevoProducto = new Producto(nombreUsu, cantidadUsu, precioUsu);
                    existenciasProducto[Producto.posicionEnAlmacen - 1] = nuevoProducto;
                    System.out.println(nuevoProducto);
                }
            } else {
                System.out.println("El número introducido debe ser un número entero mayor o igual a 4.");
            }
        } while (cantidadProducto < 4);
    }

    /**
     * Método para crear una nueva instancia de la clase Producto y almacenarla
     * en un array tipo objeto Producto con tantas posiciones como indica la
     * constante <strong>TAMAÑO_ALMACEN</strong> Posteriormente se almacena el
     * objeto en la array usando el contador de productos creados para indicar
     * la posición en el mismo (como el contador empieza en 1, hay que restarle
     * 1 para asignar posición 0).
     */
    public void insertarProducto() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el nombre del producto:");
        String nombreUsu = teclado.nextLine();
        System.out.println("Introduzca la cantidad de producto a almacenar:");
        int cantidadUsu = teclado.nextInt();
        System.out.println("Introduzca el precio del producto:");
        double precioUsu = teclado.nextDouble();
        Producto nuevoProducto = new Producto(nombreUsu, cantidadUsu, precioUsu);
        existenciasProducto[Producto.posicionEnAlmacen - 1] = nuevoProducto;
        System.out.println(nuevoProducto);
    }

    public void buscarProducto() {
        //Variables de entrada
        String criterioBusqueda;
        String nombreBusqueda;
        int codigoBusqueda = 0;
        
        //Variables auxiliares
        boolean encontrado = false;
        
        //Clase Scanner para introducir datos
        Scanner teclado = new Scanner(System.in);
        
        //Variables de salida
        int posicion;
        
        do {
            System.out.println("¿Quiere buscar por codigo o por nombre? ('COD' o 'NOM')");
            criterioBusqueda = teclado.nextLine().toUpperCase();
        } while (!"COD".equals(criterioBusqueda) && !"NOM".equals(criterioBusqueda));

        if ("NOM".equals(criterioBusqueda)) {
            System.out.println("Indique el NOMBRE del producto a buscar:");
            nombreBusqueda = teclado.nextLine().toLowerCase(); //paso a minusculas paracomparar
            for (int i = 0; i < existenciasProducto.length && existenciasProducto[i] != null; i++) {
                if (existenciasProducto[i].getNombre().toLowerCase().equals(nombreBusqueda)){
                    posicion = i;
                    encontrado=true;
                    System.out.println("Producto encontrado en la posición " + (posicion+1) + " del almacén");
                    menuProducto(posicion);
                }
            }
        } else {
            System.out.println("Indique el CODIGO del producto a buscar:");
            try{
            codigoBusqueda = Integer.parseInt(teclado.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Debe introducir un código numérico");
            }
            for (int i = 0; i < existenciasProducto.length && existenciasProducto[i] != null; i++) {
                if (existenciasProducto[i].getCodigo() == codigoBusqueda){
                    posicion = i;
                    encontrado=true;
                    System.out.println("Producto encontrado en la posición " + (posicion+1) + " del almacén");
                    menuProducto(posicion);
                }
            }
        } 
        
        if(!encontrado){
        System.out.println("Lo sentimos, producto no encontrado");
        }
    }
/**
 * El método sirve para hacer null una posición concreta del array y hacer retoceder una posición 
 * todos aquellos elementos que se encuentren delante del mismo. Una vez eliminado un objeto de 
 * una posición concreta, se decrementa el parámetro de clase <strong>posicionEnAlmacen</strong> pues
 * es el utilizado para asignar la última posición del array en la que se inserta un objeto por los métodos
 * <strong>insertarProducto()</strong> y <strong>cargarProducto()</strong>, por lo que de no decrementar
 * dejaria un hueco entre los objetos que quedan en el array y el siguiente objeto insertado.
 * El atributo <strong>productoCreado</strong> es utilizado para asignar el código al objeto de la clase Producto,
 * por lo que este no se vuelve a repetir al eliminar un producto en concreto ya que no se decrementa.
 */
    
    public void eliminarProducto() {
        Scanner teclado = new Scanner(System.in);
        boolean terminar = false;
        String confirmarEliminar;
        int posicion=0;
        do {
            System.out.println("Indique la posición ocupada por el producto que desea eliminar");
            try{
            posicion = Integer.parseInt(teclado.nextLine()) - 1;       //Posicion indicada-1(el array comienza en 0)
            }catch (NumberFormatException e){
                System.out.println("Debe introducir un número entero");
            }
            if(posicion<0){
                System.out.println("La posición introducida debe ser mayor de 0");
            }else if(existenciasProducto[posicion] == null) {
                System.out.println("El producto que desea eliminar no existe");
            } else {
                System.out.println("El producto que va eliminara es: ");
                System.out.printf("Codigo: %d, Nombre: %s.\n", existenciasProducto[posicion].getCodigo(), existenciasProducto[posicion].getNombre());

                confirmarEliminar = ES.leeRespuesta("¿Está seguro que desea eliminar? S/N");
                if (confirmarEliminar.equals("S")) {
                    existenciasProducto[posicion] = null; //Eliminamos el objeto en la posicion indicada
                    for (int i = posicion; i <= existenciasProducto.length - 2; i++) {
                        existenciasProducto[i] = existenciasProducto[i + 1]; // y movemos los objetos una posición hacia atras
                    }
                    Producto.posicionEnAlmacen--; //Decremento el número de productos en el almacén.
                    terminar = true;
                } else {
                    System.out.println("El producto no ha sido eliminado.");
                    terminar = true;
                }
            }
        } while (!terminar);
    }
    
    
   /**
    * El método es llamada cuando se encuentra un rpoducto desde el menú principal y su
    * función es la de ofrecer otro submeno para ver y manipular los atributos del producto
    * en cuestión llamando a los métodos getter y setter de la clase Producto.
    * @param i El parámetro utilizado por el método es u número entero que corresponde
    * con la posición del objeto de la clase PRoducto dentro de la array
    */ 
    
    public void menuProducto(int i) {
        
        //Variables        
        boolean terminar = false;

        // Variables de entrada
        int opcionElegida;

        do {
            System.out.println("\n¿Que desea realizar con el siguiente producto?");
            System.out.println(existenciasProducto[i].getNombre());
            System.out.println();
            System.out.println("1.- Ver precio del producto.");
            System.out.println("2.- Modificar el precio del producto.");
            System.out.println("3.- Ver la cantidad del producto.");
            System.out.println("4.- Modificar la cantidad del producto.");
            System.out.println("5.- Volver al menú pricipal.");
            opcionElegida = ES.leeEntero("Elija una opción:", 1, 5); //Leeremos un número entero entre 1 y 5.

            switch (opcionElegida) {
                case 1:
                    System.out.printf("El precio actual del producto %s es de %.2f €.\n", existenciasProducto[i].getNombre(), existenciasProducto[i].getPrecio());
                    break;

                case 2:
                    existenciasProducto[i].modificarPrecio();
                    System.out.printf("El nuevo precio del producto %s es de %.2f €.\n", existenciasProducto[i].getNombre(), existenciasProducto[i].getPrecio());
                    break;

                case 3:
                    System.out.printf("La cantidad actual del producto %s es de %d.\n", existenciasProducto[i].getNombre(), existenciasProducto[i].getCantidad());
                    break;

                case 4:
                    existenciasProducto[i].modificarCantidad();
                    System.out.printf("La nueva cantidad del producto %s es de %d.\n", existenciasProducto[i].getNombre(), existenciasProducto[i].getCantidad());
                    break;

                case 5:
                    terminar = true;
                    break;
            }

        } while (!terminar);

    }
    
    /**
     * El método <strong> mostrarProducto</strong> realiza un recorrido por la
     * array donde se almacenan los objetos tipo Producto hasta encontrar la
     * primera posición vacia (es importante por ello mantener compcata el
     * array) y muestra los datos de los distintos productos usando sus métodos
     * getter. En caso de encontrar la primera posición vacia, notifica que no
     * hay productos en el almacen.
     */
    public void mostrarProductos() {
        if (existenciasProducto[0] == null) {
            System.out.println("El almacén aún está vacío.");
        } else {
            for (int i = 0; i < existenciasProducto.length && existenciasProducto[i] != null; i++) {
                System.out.printf("Codigo: %d, Nombre: %s, Cantidad: %d, Precio %.2f€\n", existenciasProducto[i].getCodigo(), existenciasProducto[i].getNombre(), existenciasProducto[i].getCantidad(), existenciasProducto[i].getPrecio());
            }
        }
    }

    /**
     * El método <strong> mostrarStockBajo</strong> realiza un recorrido por la
     * array donde se almacenan los objetos tipo Producto hasta encontrar la
     * primera posición vacia (es importante por ello mantener compcata el
     * array), muestra los datos de los distintos productos usando sus métodos
     * getter siempre que el atributo cantidad sea menor que cinco.
     */
    public void mostrarStockBajo() {
        System.out.println("ATENCIÓN: De los siguientes productos quedan menos de 5 unidades en existencia:");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        for (int i = 0; i < existenciasProducto.length && existenciasProducto[i] != null; i++) {
            if (existenciasProducto[i].getCantidad() < STOCK_MIN) {
                System.out.printf("* Del producto %s con código: %d, quedan %d unidades en stock\n", existenciasProducto[i].getNombre(), existenciasProducto[i].getCodigo(), existenciasProducto[i].getCantidad());
            }
        }
    }
}
