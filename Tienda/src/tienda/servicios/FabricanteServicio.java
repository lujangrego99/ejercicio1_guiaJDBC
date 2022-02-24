package tienda.servicios;

import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDaoExt;

public class FabricanteServicio {

    Scanner leer = new Scanner(System.in);

    private FabricanteDaoExt dao;

    public FabricanteServicio() {
        this.dao = new FabricanteDaoExt();
    }

    public void CrearFabricante() throws Exception {

        try {
            int codigo = leer.nextInt();
            //Validamos
            if (dao.buscarFabricantePorId(codigo) != null) {
                throw new Exception("Ya existe un fabricante con el codigo indicado " + codigo);
            }
            Fabricante fabricante = new Fabricante();
            System.out.println("ingrese el nombre del fabricante");
            fabricante.setNombre(leer.nextLine());
            System.out.println("ingrese el codigo del fabricante");
            fabricante.setCodigo(codigo);
            dao.guardarFabricante(fabricante);

        } catch (Exception e) {
            throw e;
        }
    }
}
