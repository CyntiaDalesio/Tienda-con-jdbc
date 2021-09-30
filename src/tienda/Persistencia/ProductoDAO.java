package tienda.Persistencia;

import java.util.ArrayList;
import tienda.Entidades.Producto;

public class ProductoDAO extends DAO {

    public ArrayList<Producto> listarProducto() throws Exception {

        try {
            String query = "SELECT codigo, nombre FROM producto";
            consultarBase(query);
            Producto producto = null;
            ArrayList<Producto> listProducto = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));

                listProducto.add(producto);
            }
            return listProducto;

        } catch (Exception e) {
            System.out.println("Se produjo un error");
        } finally {
            desconectarBase();
        }
        return null;

    }

    public ArrayList<Producto> listarProductoNombrePrecio() throws Exception {

        try {
            String query = "SELECT nombre,precio FROM producto";
            consultarBase(query);
            Producto producto = null;
            ArrayList<Producto> listProductoNombrePrecio = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));

                listProductoNombrePrecio.add(producto);
            }
            return listProductoNombrePrecio;

        } catch (Exception e) {
            System.out.println("Se produjo un error");
        } finally {
            desconectarBase();
        }
        return null;

    }

    public ArrayList<Producto> listarProductoPrecioEntre() throws Exception {

        try {
            String query = "SELECT nombre, precio FROM producto where precio>=120 and precio<=202 order by precio";
            consultarBase(query);
            Producto producto = null;
            ArrayList<Producto> listProductoPrecioEntre = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));

                listProductoPrecioEntre.add(producto);
            }
            return listProductoPrecioEntre;

        } catch (Exception e) {
            System.out.println("Se produjo un error");
        } finally {
            desconectarBase();
        }
        return null;

    }

    public ArrayList<Producto> listarProductoPortatil() throws Exception {

        try {
            String query = "SELECT nombre FROM producto where nombre like 'Portatil%' ";
            consultarBase(query);
            Producto producto = null;
            ArrayList<Producto> listarProductoPortatil = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));

                listarProductoPortatil.add(producto);
            }
            return listarProductoPortatil;

        } catch (Exception e) {
            System.out.println("Se produjo un error");
        } finally {
            desconectarBase();
        }
        return null;

    }

    public ArrayList<Producto> listarProductoMasBarato() throws Exception {

        try {
            String query = "SELECT nombre, precio FROM producto order by precio asc limit 1 ";
            consultarBase(query);
            Producto producto = null;
            ArrayList<Producto> listarProductoMasBarato = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));

                listarProductoMasBarato.add(producto);
            }
            return listarProductoMasBarato;

        } catch (Exception e) {
            System.out.println("Se produjo un error");
        } finally {
            desconectarBase();
        }
        return null;

    }

    public void insertarProducto(String a, Double b, int c) {
        try {

            //String sql= "INSERT INTO producto VALUES ( LAST_INSERT_ID(),'"+a+"',"+b+","+c+" )\n"+""; //por condicion de carrera se puede pisar
            String sql = "INSERT INTO tienda.producto (nombre, precio, codigo_fabricante)VALUES('" + a + "'," + b + "," + c + ")";

            insertarModificarEliminar(sql);

        } catch (Exception e) {
        }
    }

    public boolean verificarProductoExistente(String name) {
        boolean verificar = false;

        try {

            String query = "select nombre from producto where nombre='"+name+"'";
            consultarBase(query);

            if (resultado.next()) {
                verificar = true;
            } else {

                verificar = false;
            }

        } catch (Exception e) {
        }

        return verificar;
    }
    
    
    
    
    public void modificarProducto(String a, double b, int c){
    
    
        try {
 
            String sql = "update  tienda.producto  set precio="+b+",codigo_fabricante="+c+" where nombre='"+a+"'";

            System.out.println(sql);
            insertarModificarEliminar(sql);

        } catch (Exception e) {
        }
    }
    
    }


