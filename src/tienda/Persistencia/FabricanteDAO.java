package tienda.Persistencia;

import java.util.ArrayList;
import tienda.Entidades.Fabricante;

public class FabricanteDAO extends DAO {

    public ArrayList<Fabricante> listarFabricante() throws Exception {

        try {
            String query = "SELECT codigo, nombre FROM fabricante";
            consultarBase(query);
            Fabricante fabricante = null;
            ArrayList<Fabricante> listFabricante = new ArrayList();

            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));

                listFabricante.add(fabricante);
            }
            return listFabricante;

        } catch (Exception e) {
            System.out.println("Se produjo un error");
        } finally {
            desconectarBase();
        }
        return null;

    }

    public void agregarFabricante(String a) {

        try {

            String sql = "INSERT INTO tienda.fabricante (nombre)VALUES('" + a + "')";

            insertarModificarEliminar(sql);

        } catch (Exception e) {
        }

    }

}
