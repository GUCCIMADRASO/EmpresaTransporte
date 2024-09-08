package co.edu.uniquindio.factory;

import co.edu.uniquindio.model.*;
import co.edu.uniquindio.model.builder.*;
import co.edu.uniquindio.service.*;

import java.util.LinkedList;

public class ModelFactory implements
        ICrudUsuario,
        ICrudPropietario,
        ICrudVehiculoCarga,
        ICrudVehiculoTransporte{

    private static ModelFactory instance;
    private static EmpresaTransporte empresaTransporte;

    private ModelFactory() {
        inicializarDatos();
    }

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    public int calcularPasajerosTransportados(String placa) {
        return empresaTransporte.calcularPasajerosTransportados(placa);
    }

    public int usuariosConSobrepeso(){
        return empresaTransporte.usuariosConSobrepeso();
    }

    public int contarUsuariosEnRangoDeEdad(){
        return empresaTransporte.contarUsuariosEnRangoDeEdad();
    }

    public int contarPropietariosMayoresDe40(){
        return empresaTransporte.contarPropietariosMayoresDe40();
    }

    //******************************************************************
    //                 Implementacion de ICrudUsuario
    //******************************************************************

    @Override
    public boolean crearUsuario(int id,UsuarioBuilder usuario) {
        return empresaTransporte.crearUsuario(id,usuario);
    }

    @Override
    public boolean eliminarUsuario(int id) {
        return empresaTransporte.eliminarUsuario(id);
    }

    @Override
    public boolean modificarUsuario(int id, UsuarioBuilder usuario) {
        return empresaTransporte.modificarUsuario(id,usuario);
    }

    @Override
    public Usuario getUsuarioCrud(int id) {
        return empresaTransporte.getUsuarioCrud(id);
    }

    @Override
    public LinkedList<Usuario> getListUsuariosCrud() {
        return empresaTransporte.getListUsuariosCrud();
    }
    //******************************************************************
    //                 Implementacion de ICrudPropietario
    //******************************************************************
    @Override
    public boolean crearPropietario(String cedula, PropietarioBuilder propietario) {
        return empresaTransporte.crearPropietario(cedula, propietario);
    }

    @Override
    public boolean eliminarPropietario(String cedula) {
        return empresaTransporte.eliminarPropietario(cedula);
    }

    @Override
    public boolean modificarPropietario(String cedula, PropietarioBuilder propietario) {
        return empresaTransporte.modificarPropietario(cedula, propietario);
    }

    @Override
    public Propietario getPropietarioCrud(String cedula) {
        return empresaTransporte.getPropietarioCrud(cedula);
    }

    @Override
    public LinkedList<Propietario> getListPropietarioCrud() {
        return empresaTransporte.getListPropietarioCrud();
    }

    //******************************************************************
    //               Implementacion de ICrudVehiculoCarga
    //******************************************************************

    @Override
    public boolean crearVehiculoCarga(String placa, VehiculoCargaBuilder vehiculoCarga) {
        return empresaTransporte.crearVehiculoCarga(placa, vehiculoCarga);
    }

    @Override
    public boolean eliminarVehiculoCarga(String placa) {
        return empresaTransporte.eliminarVehiculoCarga(placa);
    }

    @Override
    public boolean modificarVehiculoCarga(String placa, VehiculoCargaBuilder vehiculoCarga) {
        return empresaTransporte.modificarVehiculoCarga(placa, vehiculoCarga);
    }

    @Override
    public VehiculoCarga getVehiculoCargaCrud(String placa) {
        return empresaTransporte.getVehiculoCargaCrud(placa);
    }

    @Override
    public LinkedList<VehiculoCarga> getListVehiculosCargaCrud() {
        return empresaTransporte.getListVehiculosCargaCrud();
    }
    //******************************************************************
    //             Implementacion de ICrudVehiculoTransporte
    //******************************************************************
    @Override
    public boolean crearVehiculoTransporte(String placa, VehiculoTransporteBuilder vehiculoTransporte) {
        return empresaTransporte.crearVehiculoTransporte(placa, vehiculoTransporte);
    }

    @Override
    public boolean eliminarVehiculoTransporte(String placa) {
        return empresaTransporte.eliminarVehiculoTransporte(placa);
    }

    @Override
    public boolean modificarVehiculoTransporte(String placa, VehiculoTransporteBuilder vehiculoTransporte) {
        return empresaTransporte.modificarVehiculoTransporte(placa, vehiculoTransporte);
    }

    @Override
    public VehiculoTransporte getVehiculoTransporteCrud(String placa) {
        return empresaTransporte.getVehiculoTransporteCrud(placa);
    }

    @Override
    public LinkedList<VehiculoTransporte> getListVehiculosTransporteCrud() {
        return empresaTransporte.getListVehiculosTransporteCrud();
    }

    private static void inicializarDatos() {
        empresaTransporte = new EmpresaTransporte();
        empresaTransporte.setNombre("Transportes XYZ");

        // Crear vehículos de carga
        VehiculoCarga vehiculoCarga1 = VehiculoCarga.Builder().placa("ABC123").modelo("F-150").marca("Ford").color("Rojo").capacidadCarga(1500.5).numeroEjes(2).build();
        VehiculoCarga vehiculoCarga2 = VehiculoCarga.Builder().placa("DEF456").modelo("Ram 2500").marca("Dodge").color("Negro").capacidadCarga(2000.0).numeroEjes(4).build();
        VehiculoCarga vehiculoCarga3 = VehiculoCarga.Builder().placa("GHI789").modelo("Tundra").marca("Toyota").color("Blanco").capacidadCarga(1800.7).numeroEjes(3).build();
        VehiculoCarga vehiculoCarga4 = VehiculoCarga.Builder().placa("JKL012").modelo("Silverado").marca("Chevrolet").color("Azul").capacidadCarga(2200.2).numeroEjes(4).build();

        // Crear vehículos de transporte
        VehiculoTransporte vehiculoTransporte1 = VehiculoTransporte.Builder().placa("MNO345").modelo("Sprinter").marca("Mercedes-Benz").color("Plata").maxPasajeros(4).build();
        VehiculoTransporte vehiculoTransporte2 = VehiculoTransporte.Builder().placa("PQR678").modelo("Hiace").marca("Toyota").color("Blanco").maxPasajeros(3).build();
        VehiculoTransporte vehiculoTransporte3 = VehiculoTransporte.Builder().placa("STU901").modelo("Transit").marca("Ford").color("Negro").maxPasajeros(4).build();
        VehiculoTransporte vehiculoTransporte4 = VehiculoTransporte.Builder().placa("VWX234").modelo("Ducato").marca("Fiat").color("Gris").maxPasajeros(2).build();

        // Crear propietarios
        Propietario propietario1 = Propietario.Builder().nombre("Juan Perez").edad(60).cedula("123456789").email("juan@example.com").celular("3001234567").build();
        Propietario propietario2 = Propietario.Builder().nombre("Maria Gomez").edad(35).cedula("987654321").email("maria@example.com").celular("3009876543").build();
        Propietario propietario3 = Propietario.Builder().nombre("Carlos Ruiz").edad(22).cedula("112233445").email("carlos@example.com").celular("3001122334").build();
        Propietario propietario4 = Propietario.Builder().nombre("Ana Martinez").edad(45).cedula("556677889").email("ana@example.com").celular("3005566778").build();

        // Crear usuarios
        Usuario usuario1 = Usuario.Builder().nombre("Carl").edad(41).peso(70).id(1010).build();
        Usuario usuario2 = Usuario.Builder().nombre("Camilo").edad(50).peso(75).id(2020).build();
        Usuario usuario3 = Usuario.Builder().nombre("Cesar").edad(27).peso(85).id(3030).build();
        Usuario usuario4 = Usuario.Builder().nombre("Daniel").edad(18).peso(75).id(4040).build();

        // Asignación de vehículos a propietarios
        propietario1.setVehiculo(vehiculoCarga1);
        propietario2.setVehiculo(vehiculoCarga2);
        propietario3.setVehiculo(vehiculoCarga3);
        propietario4.setVehiculo(vehiculoCarga4);

        // Asignación en EmpresaTransporte
        empresaTransporte.getListPropietarios().add(propietario1);
        empresaTransporte.getListPropietarios().add(propietario2);
        empresaTransporte.getListPropietarios().add(propietario3);
        empresaTransporte.getListPropietarios().add(propietario4);

        empresaTransporte.getListVehiculosCarga().add(vehiculoCarga1);
        empresaTransporte.getListVehiculosCarga().add(vehiculoCarga2);
        empresaTransporte.getListVehiculosCarga().add(vehiculoCarga3);
        empresaTransporte.getListVehiculosCarga().add(vehiculoCarga4);

        empresaTransporte.getListVehiculosTransporte().add(vehiculoTransporte1);
        empresaTransporte.getListVehiculosTransporte().add(vehiculoTransporte2);
        empresaTransporte.getListVehiculosTransporte().add(vehiculoTransporte3);
        empresaTransporte.getListVehiculosTransporte().add(vehiculoTransporte4);

        empresaTransporte.getListUsuarios().add(usuario1);
        empresaTransporte.getListUsuarios().add(usuario2);
        empresaTransporte.getListUsuarios().add(usuario3);
        empresaTransporte.getListUsuarios().add(usuario4);
    }
}