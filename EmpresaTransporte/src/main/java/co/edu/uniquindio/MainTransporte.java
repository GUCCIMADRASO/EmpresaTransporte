package co.edu.uniquindio;

import co.edu.uniquindio.factory.ModelFactory;
import co.edu.uniquindio.model.*;
import java.util.LinkedList;

public class MainTransporte {

    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        funcionalidadesUsuario(modelFactory);
        contarPropietariosMayoresDe40(modelFactory);
        crudUsuario(modelFactory);
        crudPropietarios(modelFactory);
        crudVehiculoCarga(modelFactory);
        crudVehiculoTransporte(modelFactory);
        System.out.println("***************************************************************************");
    }

    //******************************************************************
    //                             Requisitos
    //******************************************************************

    //Metodo que llama las funcionalidades de Usuario

    public static void funcionalidadesUsuario(ModelFactory modelFactory) {
        calcularPasajerosTransportados(modelFactory);
        contarUsuariosConSobrepeso(modelFactory);
        contarUsuariosEnRangoDeEdad(modelFactory);
    }

    //Llama al metodo para calcular pasajeros transportados

    public static void calcularPasajerosTransportados(ModelFactory modelFactory) {
        int contador = modelFactory.calcularPasajerosTransportados("MNO345");
        System.out.println("***************************************************************************");
        System.out.println("El numero de pasajeros transportados por el vehiculo MNO345 es: " + contador);
    }

    //Llama al metodo para contar usuarios con sobrepeso

    public static void contarUsuariosConSobrepeso(ModelFactory modelFactory) {
        int contador = modelFactory.contarUsuariosConSobrepeso(80.0);
        System.out.println("***************************************************************************");
        System.out.println("El numero de usuarios con un peso mayor a 80 es: " + contador);
    }

    //Llama al metodo para contar usuarios en rango de edad

    public static void contarUsuariosEnRangoDeEdad(ModelFactory modelFactory) {
        int contador = modelFactory.contarUsuariosEnRangoDeEdad(40,60);
        System.out.println("***************************************************************************");
        System.out.println("El numero de usuarios con una edad entre 40 y 60 es: " + contador);
    }

    //Llama al metodo para contar propietarios mayores de 40 años

    public static void contarPropietariosMayoresDe40(ModelFactory modelFactory) {
        int contador = modelFactory.contarPropietariosMayoresDe40(40);
        System.out.println("***************************************************************************");
        System.out.println("El numero de propietarios mayores a 40 años es: " + contador);
    }

    //******************************************************************
    //                            Usuario
    //******************************************************************

    //Metodo que llama las funcionalidades de crudUsuario

    public static void crudUsuario(ModelFactory modelFactory) {
        crearUsuario(modelFactory);
        modificarUsuario(modelFactory);
        getUsuarioCrud(modelFactory);
        getListUsuarioCrud(modelFactory);
        eliminarUsuario(modelFactory);
    }

    //Llama al metodo para crear un usuario

    public static void crearUsuario(ModelFactory modelFactory) {
        boolean estado = modelFactory.crearUsuario(1111,Usuario.builder()
                .nombre("Jhan Carlos").edad(23).peso(60).id(1111));
        System.out.println("***************************************************************************");
        System.out.println("El proceso de crear un usuario ha finalizado con un estado de: " + estado);
    }

    //Llama al metodo para eliminar un usuario

    public static void eliminarUsuario(ModelFactory modelFactory) {
        boolean estado = modelFactory.eliminarUsuario(1111);
        System.out.println("***************************************************************************");
        System.out.println("El proceso de eliminar un usuario ha finalizado con un estado de: " + estado);
    }

    //Llama al metodo para modificar un usuario

    public static void modificarUsuario(ModelFactory modelFactory) {
        boolean estado = modelFactory.modificarUsuario(1111,Usuario.builder()
                .nombre("Jhan Carlos").edad(23).peso(60).id(1111));
        System.out.println("***************************************************************************");
        System.out.println("El proceso de modificar un usuario ha finalizado con un estado de: " + estado);
    }

    //Llama al metodo para obtener un usuario

    public static void getUsuarioCrud(ModelFactory modelFactory) {
        Usuario usuario = modelFactory.getUsuarioCrud(1111);
        System.out.println("***************************************************************************");
        System.out.println("El usuario con id 1111 es: " + usuario);
    }

    //Llama al metodo para obtener una lista de usuarios

    public static void getListUsuarioCrud(ModelFactory modelFactory) {
        LinkedList<Usuario> usuarios = modelFactory.getListUsuarioCrud();
        System.out.println("***************************************************************************");
        System.out.println("La lista de usuarios es: " + usuarios);
    }

    //******************************************************************
    //                           Propietario
    //******************************************************************

    //Metodo que llama las funcionalidades de crudPropietario

    public static void crudPropietarios(ModelFactory modelFactory) {
        crearPropietario(modelFactory);
        modificarPropietario(modelFactory);
        getPropietarioCrud(modelFactory);
        getListPropietarioCrud(modelFactory);
        eliminarPropietario(modelFactory);
    }

    //Llama al metodo para crear un propietario

    public static void crearPropietario(ModelFactory modelFactory) {
        boolean estado = modelFactory.crearPropietario("111111111", Propietario.builder()
                .nombre("Daniel").edad(60).cedula("111111111").email("dani@example.com").celular("3051234567"));
        System.out.println("***************************************************************************");
        System.out.println("El proceso de crear un propietario ha finalizado con un estado de: " + estado);
    }

    //Llama al metodo para eliminar un propietario

    public static void eliminarPropietario(ModelFactory modelFactory) {
        boolean estado = modelFactory.eliminarPropietario("111111111");
        System.out.println("***************************************************************************");
        System.out.println("El proceso de eliminar un propietario ha finalizado con un estado de: " + estado);
    }

    //Llama al metodo para modificar un propietario

    public static void modificarPropietario(ModelFactory modelFactory) {
        boolean estado = modelFactory.modificarPropietario("111111111",Propietario.builder()
                .nombre("Daniel").edad(60).cedula("111111111").email("dani@example.com").celular("3051234567"));
        System.out.println("***************************************************************************");
        System.out.println("El proceso de modificar un propietario ha finalizado con un estado de: " + estado);
    }

    //Llama al metodo para obtener un propietario

    public static void getPropietarioCrud(ModelFactory modelFactory) {
        Propietario propietario = modelFactory.getPropietarioCrud("111111111");
        System.out.println("***************************************************************************");
        System.out.println("El propietario con cedula 11111111 es: " + propietario);
    }

    //Llama al metodo para obtener una lista de propietarios

    public static void getListPropietarioCrud(ModelFactory modelFactory) {
        LinkedList<Propietario> propietarios = modelFactory.getListPropietarioCrud();
        System.out.println("***************************************************************************");
        System.out.println("La lista de propietarios es: " + propietarios);
    }

    //******************************************************************
    //                         VehiculoCarga
    //******************************************************************

    //Metodo que llama las funcionalidades de crudVehiculoCarga

    public static void crudVehiculoCarga(ModelFactory modelFactory) {
        crearVehiculoCarga(modelFactory);
        modificarVehiculoCarga(modelFactory);
        getVehiculoCargaCrud(modelFactory);
        getListVehiculosCargaCrud(modelFactory);
        eliminarVehiculoCarga(modelFactory);
    }

    //Llama al metodo para crear un vehiculo de carga

    public static void crearVehiculoCarga(ModelFactory modelFactory) {
        boolean estado = modelFactory.crearVehiculoCarga("XYZ789", VehiculoCarga.builder()
                .placa("XYZ789").modelo("F-150").marca("Ford").color("Verde").capacidadCarga(1900.5).numeroEjes(4));
        System.out.println("***************************************************************************");
        System.out.println("El proceso de crear un vehículo de carga ha finalizado con un estado de: " + estado);
    }

    //Llama al metodo para eliminar un vehiculo de carga

    public static void eliminarVehiculoCarga(ModelFactory modelFactory) {
        boolean estado = modelFactory.eliminarVehiculoCarga("XYZ789");
        System.out.println("***************************************************************************");
        System.out.println("El proceso de eliminar un vehículo de carga ha finalizado con un estado de: " + estado);
    }

    //Llama al metodo para modificar un vehiculo de carga

    public static void modificarVehiculoCarga(ModelFactory modelFactory) {
        boolean estado = modelFactory.modificarVehiculoCarga("XYZ789", VehiculoCarga.builder()
                .placa("XYZ789").modelo("F-150").marca("Ford").color("Verde").capacidadCarga(1900.5).numeroEjes(4));
        System.out.println("***************************************************************************");
        System.out.println("El proceso de modificar un vehículo de carga ha finalizado con un estado de: " + estado);
    }

    //Llama al metodo para obtener un vehiculo de carga

    public static void getVehiculoCargaCrud(ModelFactory modelFactory) {
        VehiculoCarga vehiculoCarga = modelFactory.getVehiculoCargaCrud("XYZ789");
        System.out.println("***************************************************************************");
        System.out.println("El vehículo de carga con placa XYZ789 es: " + vehiculoCarga);
    }

    //Llama al metodo para obtener una lista de vehiculo de carga

    public static void getListVehiculosCargaCrud(ModelFactory modelFactory) {
        LinkedList<VehiculoCarga> vehiculosCarga = modelFactory.getListVehiculoCargaCrud();
        System.out.println("***************************************************************************");
        System.out.println("La lista de vehículos de carga es: " + vehiculosCarga);
    }

    //******************************************************************
    //                       VehiculoTransporte
    //******************************************************************

    //Metodo que llama las funcionalidades de crudVehiculoTransporte

    public static void crudVehiculoTransporte(ModelFactory modelFactory) {
        crearVehiculoTransporte(modelFactory);
        modificarVehiculoTransporte(modelFactory);
        getVehiculoTransporteCrud(modelFactory);
        getListVehiculosTransporteCrud(modelFactory);
        eliminarVehiculoTransporte(modelFactory);
    }

    //Llama al metodo para crear un vehiculo de transporte

    public static void crearVehiculoTransporte(ModelFactory modelFactory) {
        boolean estado = modelFactory.crearVehiculoTransporte("LMN456", VehiculoTransporte.builder()
                .placa("LMN456").modelo("Sprinter").marca("Mercedes-Benz").color("Azul").maxPasajeros(4));
        System.out.println("***************************************************************************");
        System.out.println("El proceso de crear un vehículo de transporte ha finalizado con un estado de: " + estado);
    }

    //Llama al metodo para eliminar un vehiculo de transporte

    public static void eliminarVehiculoTransporte(ModelFactory modelFactory) {
        boolean estado = modelFactory.eliminarVehiculoTransporte("LMN456");
        System.out.println("***************************************************************************");
        System.out.println("El proceso de eliminar un vehículo de transporte ha finalizado con un estado de: " + estado);
    }

    //Llama al metodo para modificar un vehiculo de transporte

    public static void modificarVehiculoTransporte(ModelFactory modelFactory) {
        boolean estado = modelFactory.modificarVehiculoTransporte("LMN456", VehiculoTransporte.builder()
                .placa("LMN456").modelo("Sprinter").marca("Mercedes-Benz").color("Azul").maxPasajeros(4));
        System.out.println("***************************************************************************");
        System.out.println("El proceso de modificar un vehículo de transporte ha finalizado con un estado de: " + estado);
    }

    //Llama al metodo para modificar un vehiculo de transporte

    public static void getVehiculoTransporteCrud(ModelFactory modelFactory) {
        VehiculoTransporte vehiculoTransporte = modelFactory.getVehiculoTransporteCrud("LMN456");
        System.out.println("***************************************************************************");
        System.out.println("El vehículo de transporte con placa LMN456 es: " + vehiculoTransporte);
    }

    //Llama al metodo para obtener una lista de vehiculo de transporte

    public static void getListVehiculosTransporteCrud(ModelFactory modelFactory) {
        LinkedList<VehiculoTransporte> vehiculosTransporte = modelFactory.getListVehiculoTransporteCrud();
        System.out.println("***************************************************************************");
        System.out.println("La lista de vehículos de transporte es: " + vehiculosTransporte);
    }
}
