package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;

public class FabricanteDaoExt  extends DAO{
    
 //private final UsuarioService usuarioService;

//    public MascotaDAO() {
//        this.usuarioService = new UsuarioService();
//    }

    public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante");
            }
            String sql = "INSERT INTO Fabricante (codigo, nombre) "
                    + "VALUES ( '" + fabricante.getCodigo() + "' , '" + fabricante.getNombre() +  " );";

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
                    + " WHERE id = '" + fabricante.getCodigo()+ "'";
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
//                Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
//                mascota.setUsuario(usuario);
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Fabricante> listarFabricante() throws Exception {
        try {
            String sql = "SELECT * FROM Mascota ";
            consultarBase(sql);
            Fabricante fabricante = null;
            Collection<Fabricante> fabricantes = new ArrayList();
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                
//                
//                Integer idUsuario = resultado.getInt(4);
//                Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
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
