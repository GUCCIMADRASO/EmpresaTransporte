package co.edu.uniquindio;

import co.edu.uniquindio.factory.ModelFactory;
import co.edu.uniquindio.model.*;
import java.util.LinkedList;

public class MainTransporte {

    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        requisitos(modelFactory);
        crudUsuario(modelFactory);
        crudPropietarios(modelFactory);
        crudVehiculoCarga(modelFactory);
        crudVehiculoTransporte(modelFactory);
        System.out.println("***************************************************************************");
    }

    //******************************************************************
    //                             Requisitos
    //******************************************************************

    public static void requisitos(ModelFactory modelFactory) {
        calcularPasajerosTransportados(modelFactory);
        usuariosConSobrepeso(modelFactory);
        contarUsuariosEnRangoDeEdad(modelFactory);
        contarPropietariosMayoresDe40(modelFactory);
    }

    public static void calcularPasajerosTransportados(ModelFactory modelFactory) {
        int contador = modelFactory.calcularPasajerosTransportados("MNO345");
        System.out.println("***************************************************************************");
        System.out.println("El numero de pasajeros transportados por el vehiculo MNO345 es: " + contador);
    }

    public static void usuariosConSobrepeso(ModelFactory modelFactory) {
        int contador = modelFactory.usuariosConSobrepeso();
        System.out.println("***************************************************************************");
        System.out.println("El numero de usuarios con un peso mayor a 80 es: " + contador);
    }

    public static void contarUsuariosEnRangoDeEdad(ModelFactory modelFactory) {
        int contador = modelFactory.contarUsuariosEnRangoDeEdad();
        System.out.println("***************************************************************************");
        System.out.println("El numero de usuarios con una edad entre 40 y 60 es: " + contador);
    }

    public static void contarPropietariosMayoresDe40(ModelFactory modelFactory) {
        int contador = modelFactory.contarPropietariosMayoresDe40();
        System.out.println("***************************************************************************");
        System.out.println("El numero de propietarios mayores a 40 años es: " + contador);
    }

    //******************************************************************
    //                            Usuario
    //******************************************************************

    public static void crudUsuario(ModelFactory modelFactory) {
        crearUsuario(modelFactory);
        modificarUsuario(modelFactory);
        getUsuarioCrud(modelFactory);
        getListUsuarioCrud(modelFactory);
        eliminarUsuario(modelFactory);
    }

    public static void crearUsuario(ModelFactory modelFactory) {
        boolean estado = modelFactory.crearUsuario(1111,Usuario.Builder().nombre("Jhan Carlos").edad(23).peso(60).id(1111));
        System.out.println("***************************************************************************");
        System.out.println("El proceso de crear un usuario ha finalizado con un estado de: " + estado);
    }

    public static void eliminarUsuario(ModelFactory modelFactory) {
        boolean estado = modelFactory.eliminarUsuario(1111);
        System.out.println("***************************************************************************");
        System.out.println("El proceso de eliminar un usuario ha finalizado con un estado de: " + estado);
    }

    public static void modificarUsuario(ModelFactory modelFactory) {
        boolean estado = modelFactory.modificarUsuario(1111,Usuario.Builder().nombre("Jhan Carlos").edad(23).peso(60).id(1111));
        System.out.println("***************************************************************************");
        System.out.println("El proceso de modificar un usuario ha finalizado con un estado de: " + estado);
    }

    public static void getUsuarioCrud(ModelFactory modelFactory) {
        Usuario usuario = modelFactory.getUsuarioCrud(1111);
        System.out.println("***************************************************************************");
        System.out.println("El usuario con id 1111 es: " + usuario);
    }

    public static void getListUsuarioCrud(ModelFactory modelFactory) {
        LinkedList<Usuario> usuarios = modelFactory.getListUsuariosCrud();
        System.out.println("***************************************************************************");
        System.out.println("La lista de usuarios es: " + usuarios);
    }

    //******************************************************************
    //                           Propietario
    //******************************************************************

    public static void crudPropietarios(ModelFactory modelFactory) {
        crearPropietario(modelFactory);
        modificarPropietario(modelFactory);
        getPropietarioCrud(modelFactory);
        getListPropietarioCrud(modelFactory);
        eliminarPropietario(modelFactory);
    }

    public static void crearPropietario(ModelFactory modelFactory) {
        boolean estado = modelFactory.crearPropietario("111111111", Propietario.Builder().nombre("Daniel").edad(60).cedula("111111111").email("dani@example.com").celular("3051234567"));
        System.out.println("***************************************************************************");
        System.out.println("El proceso de crear un propietario ha finalizado con un estado de: " + estado);
    }

    public static void eliminarPropietario(ModelFactory modelFactory) {
        boolean estado = modelFactory.eliminarPropietario("111111111");
        System.out.println("***************************************************************************");
        System.out.println("El proceso de eliminar un propietario ha finalizado con un estado de: " + estado);
    }

    public static void modificarPropietario(ModelFactory modelFactory) {
        boolean estado = modelFactory.modificarPropietario("111111111",Propietario.Builder().nombre("Daniel").edad(60).cedula("111111111").email("dani@example.com").celular("3051234567"));
        System.out.println("***************************************************************************");
        System.out.println("El proceso de modificar un propietario ha finalizado con un estado de: " + estado);
    }

    public static void getPropietarioCrud(ModelFactory modelFactory) {
        Propietario propietario = modelFactory.getPropietarioCrud("111111111");
        System.out.println("***************************************************************************");
        System.out.println("El propietario con cedula 11111111 es: " + propietario);
    }

    public static void getListPropietarioCrud(ModelFactory modelFactory) {
        LinkedList<Propietario> propietarios = modelFactory.getListPropietarioCrud();
        System.out.println("***************************************************************************");
        System.out.println("La lista de propietarios es: " + propietarios);
    }

    //******************************************************************
    //                         VehiculoCarga
    //******************************************************************

    public static void crudVehiculoCarga(ModelFactory modelFactory) {
        crearVehiculoCarga(modelFactory);
        modificarVehiculoCarga(modelFactory);
        getVehiculoCargaCrud(modelFactory);
        getListVehiculosCargaCrud(modelFactory);
        eliminarVehiculoCarga(modelFactory);
    }

    public static void crearVehiculoCarga(ModelFactory modelFactory) {
        boolean estado = modelFactory.crearVehiculoCarga("XYZ789", VehiculoCarga.Builder().placa("XYZ789").modelo("F-150").marca("Ford").color("Verde").capacidadCarga(1900.5).numeroEjes(4));
        System.out.println("***************************************************************************");
        System.out.println("El proceso de crear un vehículo de carga ha finalizado con un estado de: " + estado);
    }

    public static void eliminarVehiculoCarga(ModelFactory modelFactory) {
        boolean estado = modelFactory.eliminarVehiculoCarga("XYZ789");
        System.out.println("***************************************************************************");
        System.out.println("El proceso de eliminar un vehículo de carga ha finalizado con un estado de: " + estado);
    }

    public static void modificarVehiculoCarga(ModelFactory modelFactory) {
        boolean estado = modelFactory.modificarVehiculoCarga("XYZ789", VehiculoCarga.Builder().placa("XYZ789").modelo("F-150").marca("Ford").color("Verde").capacidadCarga(1900.5).numeroEjes(4));
        System.out.println("***************************************************************************");
        System.out.println("El proceso de modificar un vehículo de carga ha finalizado con un estado de: " + estado);
    }

    public static void getVehiculoCargaCrud(ModelFactory modelFactory) {
        VehiculoCarga vehiculoCarga = modelFactory.getVehiculoCargaCrud("XYZ789");
        System.out.println("***************************************************************************");
        System.out.println("El vehículo de carga con placa XYZ789 es: " + vehiculoCarga);
    }

    public static void getListVehiculosCargaCrud(ModelFactory modelFactory) {
        LinkedList<VehiculoCarga> vehiculosCarga = modelFactory.getListVehiculosCargaCrud();
        System.out.println("***************************************************************************");
        System.out.println("La lista de vehículos de carga es: " + vehiculosCarga);
    }

    //******************************************************************
    //                       VehiculoTransporte
    //******************************************************************

    public static void crudVehiculoTransporte(ModelFactory modelFactory) {
        crearVehiculoTransporte(modelFactory);
        modificarVehiculoTransporte(modelFactory);
        getVehiculoTransporteCrud(modelFactory);
        getListVehiculosTransporteCrud(modelFactory);
        eliminarVehiculoTransporte(modelFactory);
    }

    public static void crearVehiculoTransporte(ModelFactory modelFactory) {
        boolean estado = modelFactory.crearVehiculoTransporte("LMN456", VehiculoTransporte.Builder().placa("LMN456").modelo("Sprinter").marca("Mercedes-Benz").color("Azul").maxPasajeros(4));
        System.out.println("***************************************************************************");
        System.out.println("El proceso de crear un vehículo de transporte ha finalizado con un estado de: " + estado);
    }

    public static void eliminarVehiculoTransporte(ModelFactory modelFactory) {
        boolean estado = modelFactory.eliminarVehiculoTransporte("LMN456");
        System.out.println("***************************************************************************");
        System.out.println("El proceso de eliminar un vehículo de transporte ha finalizado con un estado de: " + estado);
    }

    public static void modificarVehiculoTransporte(ModelFactory modelFactory) {
        boolean estado = modelFactory.modificarVehiculoTransporte("LMN456", VehiculoTransporte.Builder().placa("LMN456").modelo("Sprinter").marca("Mercedes-Benz").color("Azul").maxPasajeros(4));
        System.out.println("***************************************************************************");
        System.out.println("El proceso de modificar un vehículo de transporte ha finalizado con un estado de: " + estado);
    }

    public static void getVehiculoTransporteCrud(ModelFactory modelFactory) {
        VehiculoTransporte vehiculoTransporte = modelFactory.getVehiculoTransporteCrud("LMN456");
        System.out.println("***************************************************************************");
        System.out.println("El vehículo de transporte con placa LMN456 es: " + vehiculoTransporte);
    }

    public static void getListVehiculosTransporteCrud(ModelFactory modelFactory) {
        LinkedList<VehiculoTransporte> vehiculosTransporte = modelFactory.getListVehiculosTransporteCrud();
        System.out.println("***************************************************************************");
        System.out.println("La lista de vehículos de transporte es: " + vehiculosTransporte);
    }
}
