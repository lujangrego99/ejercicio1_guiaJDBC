package tienda;

import tienda.servicios.FabricanteServicio;
import tienda.servicios.ProductoServicio;

public class TiendaMain {

    public static void main(String[] args) throws Exception {
    
        
        ProductoServicio productoservicio = new ProductoServicio();
        FabricanteServicio fabricanteservicio = new FabricanteServicio();
        
        productoservicio.listarProductos();
        
    }
    
}
