package tienda.Servicios;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.Entidades.Fabricante;
import tienda.Entidades.Producto;
import tienda.Persistencia.FabricanteDAO;
import tienda.Persistencia.ProductoDAO;
import tienda.Tienda;

public class serviceTienda {

    FabricanteDAO aa = new FabricanteDAO();
    ProductoDAO bb = new ProductoDAO();

    public void listarFabricante() {
        System.out.println("Muestra el nombre de todos los fabricantes ");
        try {

            ArrayList<Fabricante> fabri = aa.listarFabricante();

            for (Fabricante fabricante : fabri) {
                System.out.println("nombre: " + fabricante.getNombre() + ", codigo: " + fabricante.getCodigo());
            }
        } catch (Exception ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void listarProducto() {

        System.out.println("Estos son todos los productos ");
        try {

            ArrayList<Producto> pro = bb.listarProducto();

            for (Producto p : pro) {
                System.out.println(p.getNombre());
            }
        } catch (Exception ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void listarProductoNombrePrecio() {

        System.out.println("Muestra el nombre y precio de todos los productos ");
        try {

            ArrayList<Producto> productoNombrePrecio = bb.listarProductoNombrePrecio();

            for (Producto p : productoNombrePrecio) {
                System.out.println("nombre: " + p.getNombre() + " Precio " + p.getPrecio());
            }
        } catch (Exception ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void listarProductoPrecioEntre() {

        System.out.println("Muestra el nombre  de todos los productos con precio entre 120 y 202 ");
        try {

            ArrayList<Producto> productoNombrePrecioEntre = bb.listarProductoPrecioEntre();

            for (Producto p : productoNombrePrecioEntre) {
                System.out.println("nombre: " + p.getNombre() + ", Precio: " + p.getPrecio());
            }
        } catch (Exception ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void listarProductoPortatil() {

        System.out.println("Muestra el nombre  de todos los productos portatil");
        try {

            ArrayList<Producto> listarProductoPortatil = bb.listarProductoPortatil();

            for (Producto p : listarProductoPortatil) {
                System.out.println("nombre: " + p.getNombre());
            }
        } catch (Exception ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void listarProductoMasBarato() {

        System.out.println("Muestra el nombre  y precio del producto mas barato");
        try {

            ArrayList<Producto> listarProductoPortatil = bb.listarProductoMasBarato();

            for (Producto p : listarProductoPortatil) {
                System.out.println("nombre: " + p.getNombre() + " , precio: " + p.getPrecio());
            }
        } catch (Exception ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertarProducto(String a, Double b, int c) {

        bb.insertarProducto(a, b, c);

    }

    public void insertarFabricante(String a) {

        aa.agregarFabricante(a);

    }

    public boolean verificarProductoExistente(String name) {

        return bb.verificarProductoExistente(name);

    }
    
    
        
    
    public void modificarProducto(String a, Double b, int c){
    
    bb.modificarProducto(a, b, c);
    
    }


}
