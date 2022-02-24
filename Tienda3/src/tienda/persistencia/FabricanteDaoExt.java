package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.servicios.FabricanteServicio;

public class FabricanteDaoExt extends DAO {

    private final FabricanteServicio fabricanteServicio;

    public FabricanteDaoExt() {
        this.fabricanteServicio = new FabricanteServicio();
    }

    public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante");
            }
            String sql = "INSERT INTO Fabricante (codigo, nombre) "
                    + "VALUES ( '" + fabricante.getCodigo() + "' , '" + fabricante.getNombre() + " );";

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el Fabricante que desea modificar");
            }
            String sql = "UPDATE Fabricante SET "
                    + "  nombre = '" + fabricante.getNombre()
                    + " WHERE id = '" + fabricante.getCodigo() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarFabricante(int codigo) throws Exception {
        try {
            String sql = "DELETE FROM Fabricante WHERE id = " + codigo + "";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Fabricante buscarFabricantePorId(int codigo) throws Exception {
        try {
            String sql = "SELECT * FROM Fabricante WHERE id = " + codigo + "";
            consultarBase(sql);
            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));

//                mascota.setRaza(resultado.getString(3));
//                Integer idUsuario = resultado.getInt(4);
                 fabricante = fabricanteServicio.buscarFabricantePorId(codigo);
//                mascota.setUsuario(usuario);
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Fabricante> listarFabricantes() throws Exception {
        try {
            String sql = "SELECT * FROM Fabricante ";
            consultarBase(sql);
            Fabricante fabricante = null;
            Collection<Fabricante> fabricantes = new ArrayList();
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));

//                
//                Integer idUsuario = resultado.getInt(4);
                fabricante = fabricanteServicio.buscarFabricantePorId(resultado.getInt(1));
//                mascota.setUsuario(usuario);

                fabricantes.add(fabricante);
            }
            desconectarBase();
            return fabricantes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

}
