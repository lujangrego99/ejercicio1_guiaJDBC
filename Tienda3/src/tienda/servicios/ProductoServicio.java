package tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.persistencia.FabricanteDaoExt;
import tienda.persistencia.ProductoDaoExt;

public class ProductoServicio {

    Scanner leer = new Scanner(System.in);

    private final ProductoDaoExt dao;

    public ProductoServicio() {
        this.dao = new ProductoDaoExt();
    }

    public void CrearProducto() throws Exception {

        try {
            int codigo = leer.nextInt();
            //Validamos
            if (dao.buscarProductoPorId(codigo) != null) {
                throw new Exception("Ya existe un producto con el codigo indicado " + codigo);
            }
            Producto producto = new Producto();
            System.out.println("ingrese el codigo del producto");
            producto.setCodigo(codigo);
            dao.guardarProducto(producto);
            System.out.println("ingrese el nombre del producto");
            producto.setNombre(leer.nextLine());
            System.out.println("ingrese el precio del producto");
            producto.setPrecio(leer.nextInt());
            System.out.println("ingrese el codigo del fabricante");
            producto.setCodigoFabricante(leer.nextInt());
            dao.guardarProducto(producto);

        } catch (Exception e) {
            throw e;
        }
    }
    
     public void modificarClaveProducto(int codigo, String nombre, int precio, int codigoFabricante) throws Exception {

        try {

            //Validamos
            if (codigo > 0) {
                throw new Exception("Debe indicar el codigo");
            }

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            if (precio > 0) {
                throw new Exception("Debe indicar el precio");
            }
            
            if (codigoFabricante < 0) {
                throw new Exception("Debe indicar el codigo Fabricante");
            }

            //Buscamos
            Producto  producto = buscarProductoPorId(codigo);

            dao.modificarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarMascota(int id) throws Exception {

        try {

            //Validamos 
            if (id < 0) {
                throw new Exception("Debe indicar el Id");
            }
            dao.eliminarProducto(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarProductoPorId(int codigo) throws Exception {

        try {

            //Validamos
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            Producto producto = dao.buscarProductoPorId(codigo);
            //Verificamos
            if (producto == null) {
                throw new Exception("No se econtró producto para el codigo ingresado");
            }

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarProductos() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductos() throws Exception {

        try {

            //Listamos los mascotas
            Collection<Producto> productos = dao.listarProductos();

            //Imprimimos los mascotas
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
