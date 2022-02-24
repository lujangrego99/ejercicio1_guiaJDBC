package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;
import tienda.servicios.ProductoServicio;

public class ProductoDaoExt extends DAO {
    
//    private final ProductoServicio productoServicio;
//
//    public MascotaDAO() {
//        this.usuarioService = new UsuarioService();
//    }

    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el mascota");
            }
            String sql = "INSERT INTO Producto ( codigo,nombre, precio, codigoFabricante) "
                    + "VALUES ( '" + producto.getCodigo() + "' , '" + producto.getNombre() + "' ," + producto.getPrecio() +"' ," + producto.getCodigoFabricante() +" );";

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }
            String sql = "UPDATE Producto SET "
                    + " codigo = '" + producto.getCodigo() + "' , raza = '" + producto.getNombre() + "' , idUsuario = " + producto.getPrecio()
                    + " WHERE id = '" +  producto.getCodigoFabricante() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarProducto(int codigo) throws Exception {
        try {
            String sql = "DELETE FROM Producto WHERE id = " + codigo + "";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Producto buscarProductoPorId(int codigo) throws Exception {
        try {
            String sql = "SELECT * FROM Mascota WHERE id = " + codigo + "";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                
               // Integer idUsuario = resultado.getInt(4);
                
                //Producto producto = productoServicio.buscarProductoPorId(int codigo);
                
               // producto.setUsuario(usuario);
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listarProductos() throws Exception {
        try {
            String sql = "SELECT * FROM Producto ";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                
                // Integer idUsuario = resultado.getInt(4);
                
                //Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
               // mascota.setUsuario(usuario);
                //mascotas.add(mascota);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}
