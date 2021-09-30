package tienda;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.Entidades.Fabricante;
import tienda.Persistencia.FabricanteDAO;
import tienda.Servicios.serviceTienda;

public class Tienda {

    public static void main(String[] args) {

        
        serviceTienda service = new serviceTienda();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        boolean flag = true;
   

        do {
            System.out.println("**********************BIENVENIDO A TIENDA ************************************");
            System.out.println("                   Elija la opcion que desee                                  ");
            System.out.println("0- lista el nombre de todos los fabricantes                                   ");
            System.out.println("1- Lista el nombre de todos los productos que hay en la tabla producto        ");
            System.out.println("2- Lista los nombres y los precios de todos los productos de la tabla producto");
            System.out.println("3- Listar aquellos productos que su precio esté entre 120 y 202               ");
            System.out.println("4- Buscar y listar todos los Portátiles de la tabla producto                  ");
            System.out.println("5- Listar el nombre y el precio del producto más barato                       ");
            System.out.println("6- Ingresar un producto a la base de datos                                    ");
            System.out.println("7- Ingresar un fabricante a la base de datos                                  ");
            System.out.println("8- Editar un producto con datos a elección                                    ");
            System.out.println("9- salir                                                                      ");
            System.out.println("******************************************************************************");
            switch (sc.next()) {

                case "0":
                    service.listarFabricante();

                    break;

                case "1":
                    service.listarProducto();
                    break;

                case "2":
                    
                    service.listarProductoNombrePrecio();
                    break;
                case "3":
                    
                    service.listarProductoPrecioEntre();
                    break;
                case "4":
                    service.listarProductoPortatil();
                    break;
                    
                case "5":
                    service.listarProductoMasBarato();
                    break;
                case "6":
                    System.out.println("Ingrese nombre del producto");
                    
                    String nombre= sc.next();
                    System.out.println("Ingrese precio del producto");
                    Double precio= sc.nextDouble();
                    
                    
                    service.listarFabricante();
                    
                    
                    
                    System.out.println("Ingrese codigo del fabricante del producto");
                    int codigoFab= sc.nextInt();
                    
                    service.insertarProducto(nombre,precio,codigoFab);
    
                    break;
                case "7":
                    
                    System.out.println("Ingrese el nombre del fabricante a insertar");
                    
                    service.insertarFabricante(sc.next());
                    break;
                case "8":
                    
                    
                    service.listarProducto();
                    System.out.println("Ingrese el nombre del  producto que desea modificar");
                    
                    nombre= sc.next();
                    
                   while (!service.verificarProductoExistente(nombre)) {
                        
                        System.out.println("el producto ingresado no se encuentra");
                        System.out.println("Ingrese de nuevo el nombre del producto");
                          nombre= sc.next();
                   
                   }
                    
                    System.out.println("Ingrese el precio");
                    
                    
                    precio= sc.nextDouble();
                    
                    System.out.println("Ingrese el fabricante");
                    codigoFab= sc.nextInt();
                    
                    service.modificarProducto(nombre, precio, codigoFab);
                    System.out.println("El producto ha sido modificado");
                 service.listarProducto();
                    
                    
                    break;
                case "9":
                    
                    System.out.println("Finalizando . . . ");
                    flag=false;
                    break;

                default: System.out.println("Dato ingresado invalido.Vuelva a intentarlo ");

            }

        } while (flag);

    }

}
