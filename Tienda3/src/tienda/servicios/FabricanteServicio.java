package tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
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

    public void modificarClaveFabricante(int codigo, String nombre) throws Exception {

        try {

            //Validamos
            if (codigo > 0) {
                throw new Exception("Debe indicar el codigo");
            }

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            //Buscamos
            Fabricante fabricante = buscarFabricantePorId(codigo);

            dao.modificarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarFabricante(int codigo) throws Exception {

        try {

            //Validamos 
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            dao.eliminarFabricante(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante buscarFabricantePorId(int codigo) throws Exception {

        try {

            //Validamos
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            Fabricante fabricante = dao.buscarFabricantePorId(codigo);
            //Verificamos
            if (fabricante == null) {
                throw new Exception("No se econtró fabricante para el codigo ingresado");
            }

            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Fabricante> listarFabricantes() throws Exception {

        try {

            Collection<Fabricante> fabricantes = dao.listarFabricantes();

            return fabricantes;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirFabricantes() throws Exception {

        try {

            //Listamos los mascotas
            Collection<Fabricante> fabricantes = dao.listarFabricantes();

            //Imprimimos los mascotas
            if (fabricantes.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Fabricante u : fabricantes) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
