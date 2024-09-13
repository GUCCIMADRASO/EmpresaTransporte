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

    //Genera los datos de prueba

    private ModelFactory() {
        inicializarDatos();
    }

    //Singleton para una unica instancia

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    //Llama al metodo para calcular pasajeros transportados

    public int calcularPasajerosTransportados(String placa) {
        return empresaTransporte.calcularPasajerosTransportados(placa);
    }

    //Llama al metodo para contar usuarios con sobrepeso

    public int contarUsuariosConSobrepeso(double peso){
        return empresaTransporte.contarUsuariosConSobrepeso(peso);
    }

    //Llama al metodo para contar usuarios con sobre peso

    public int contarUsuariosEnRangoDeEdad(int edadMinima,int edadMaxima){
        return empresaTransporte.contarUsuariosEnRangoDeEdad(edadMinima,edadMaxima);
    }

    //Llama al metodo para contar propietarios mayores de 40 años

    public int contarPropietariosMayoresDe40(int edad){
        return empresaTransporte.contarPropietariosMayoresDe40(edad);
    }

    //******************************************************************
    //                 Implementacion de ICrudUsuario
    //******************************************************************

    //Metodo para crear un usuario

    @Override
    public boolean crearUsuario(int id,UsuarioBuilder usuario) {
        return empresaTransporte.crearUsuario(id,usuario);
    }

    //Metodo para eliminar un usuario

    @Override
    public boolean eliminarUsuario(int id) {
        return empresaTransporte.eliminarUsuario(id);
    }

    //Metodo para modificar un usuario

    @Override
    public boolean modificarUsuario(int id, UsuarioBuilder usuario) {
        return empresaTransporte.modificarUsuario(id,usuario);
    }

    //Metodo para obtener un usuario

    @Override
    public Usuario getUsuarioCrud(int id) {
        return empresaTransporte.getUsuarioCrud(id);
    }

    //Metodo para obtener una lista de usuarios

    @Override
    public LinkedList<Usuario> getListUsuarioCrud() {
        return empresaTransporte.getListUsuarioCrud();
    }

    //******************************************************************
    //                 Implementacion de ICrudPropietario
    //******************************************************************

    //Metodo para crear un propietario

    @Override
    public boolean crearPropietario(String cedula, PropietarioBuilder propietario) {
        return empresaTransporte.crearPropietario(cedula, propietario);
    }

    //Metodo para eliminar un propietario

    @Override
    public boolean eliminarPropietario(String cedula) {
        return empresaTransporte.eliminarPropietario(cedula);
    }

    //Metodo para modificar un propietario

    @Override
    public boolean modificarPropietario(String cedula, PropietarioBuilder propietario) {
        return empresaTransporte.modificarPropietario(cedula, propietario);
    }

    //Metodo para obtener un propietario

    @Override
    public Propietario getPropietarioCrud(String cedula) {
        return empresaTransporte.getPropietarioCrud(cedula);
    }

    //Metodo para obtener una lista de propietarios

    @Override
    public LinkedList<Propietario> getListPropietarioCrud() {
        return empresaTransporte.getListPropietarioCrud();
    }

    //******************************************************************
    //               Implementacion de ICrudVehiculoCarga
    //******************************************************************

    //Metodo para crear un vehiculo de carga

    @Override
    public boolean crearVehiculoCarga(String placa, VehiculoCargaBuilder vehiculoCarga) {
        return empresaTransporte.crearVehiculoCarga(placa, vehiculoCarga);
    }

    //Metodo para eliminar un vehiculo de carga

    @Override
    public boolean eliminarVehiculoCarga(String placa) {
        return empresaTransporte.eliminarVehiculoCarga(placa);
    }

    //Metodo para modificar un vehiculo de carga

    @Override
    public boolean modificarVehiculoCarga(String placa, VehiculoCargaBuilder vehiculoCarga) {
        return empresaTransporte.modificarVehiculoCarga(placa, vehiculoCarga);
    }

    //Metodo para obtener un vehiculo de carga

    @Override
    public VehiculoCarga getVehiculoCargaCrud(String placa) {
        return empresaTransporte.getVehiculoCargaCrud(placa);
    }

    //Metodo para obtener una lista de vehiculo de carga

    @Override
    public LinkedList<VehiculoCarga> getListVehiculoCargaCrud() {
        return empresaTransporte.getListVehiculoCargaCrud();
    }

    //******************************************************************
    //             Implementacion de ICrudVehiculoTransporte
    //******************************************************************

    //Metodo para crear un vehiculo de transporte

    @Override
    public boolean crearVehiculoTransporte(String placa, VehiculoTransporteBuilder vehiculoTransporte) {
        return empresaTransporte.crearVehiculoTransporte(placa, vehiculoTransporte);
    }

    //Metodo para eliminar un vehiculo de transporte

    @Override
    public boolean eliminarVehiculoTransporte(String placa) {
        return empresaTransporte.eliminarVehiculoTransporte(placa);
    }

    //Metodo para modificar un vehiculo de transporte

    @Override
    public boolean modificarVehiculoTransporte(String placa, VehiculoTransporteBuilder vehiculoTransporte) {
        return empresaTransporte.modificarVehiculoTransporte(placa, vehiculoTransporte);
    }

    //Metodo para obtener un vehiculo de transporte

    @Override
    public VehiculoTransporte getVehiculoTransporteCrud(String placa) {
        return empresaTransporte.getVehiculoTransporteCrud(placa);
    }

    //Metodo para obtener una lista de vehiculo de transporte

    @Override
    public LinkedList<VehiculoTransporte> getListVehiculoTransporteCrud() {
        return empresaTransporte.getListVehiculoTransporteCrud();
    }

    //Metodo para generar datos de prueba

    private static void inicializarDatos() {
        empresaTransporte = new EmpresaTransporte();
        empresaTransporte.setNombre("Transportes XYZ");

        // Crear vehículos de carga
        VehiculoCarga vehiculoCarga1 = VehiculoCarga.builder().placa("ABC123").modelo("F-150")
                .marca("Ford").color("Rojo").capacidadCarga(1500.5).numeroEjes(2).build();
        VehiculoCarga vehiculoCarga2 = VehiculoCarga.builder().placa("DEF456").modelo("Ram 2500")
                .marca("Dodge").color("Negro").capacidadCarga(2000.0).numeroEjes(4).build();
        VehiculoCarga vehiculoCarga3 = VehiculoCarga.builder().placa("GHI789").modelo("Tundra")
                .marca("Toyota").color("Blanco").capacidadCarga(1800.7).numeroEjes(3).build();
        VehiculoCarga vehiculoCarga4 = VehiculoCarga.builder().placa("JKL012").modelo("Silverado")
                .marca("Chevrolet").color("Azul").capacidadCarga(2200.2).numeroEjes(4).build();

        // Crear vehículos de transporte
        VehiculoTransporte vehiculoTransporte1 = VehiculoTransporte.builder().placa("MNO345")
                .modelo("Sprinter").marca("Mercedes-Benz").color("Plata").maxPasajeros(4).build();
        VehiculoTransporte vehiculoTransporte2 = VehiculoTransporte.builder().placa("PQR678")
                .modelo("Hiace").marca("Toyota").color("Blanco").maxPasajeros(3).build();
        VehiculoTransporte vehiculoTransporte3 = VehiculoTransporte.builder().placa("STU901")
                .modelo("Transit").marca("Ford").color("Negro").maxPasajeros(4).build();
        VehiculoTransporte vehiculoTransporte4 = VehiculoTransporte.builder().placa("VWX234")
                .modelo("Ducato").marca("Fiat").color("Gris").maxPasajeros(2).build();

        // Crear propietarios
        Propietario propietario1 = Propietario.builder().nombre("Juan Perez").edad(60)
                .cedula("123456789").email("juan@example.com").celular("3001234567").build();
        Propietario propietario2 = Propietario.builder().nombre("Maria Gomez").edad(35)
                .cedula("987654321").email("maria@example.com").celular("3009876543").build();
        Propietario propietario3 = Propietario.builder().nombre("Carlos Ruiz").edad(22)
                .cedula("112233445").email("carlos@example.com").celular("3001122334").build();
        Propietario propietario4 = Propietario.builder().nombre("Ana Martinez").edad(45)
                .cedula("556677889").email("ana@example.com").celular("3005566778").build();

        // Crear usuarios
        Usuario usuario1 = Usuario.builder().nombre("Carl").edad(41).peso(70).id(1010).build();
        Usuario usuario2 = Usuario.builder().nombre("Camilo").edad(50).peso(75).id(2020).build();
        Usuario usuario3 = Usuario.builder().nombre("Cesar").edad(27).peso(85).id(3030).build();
        Usuario usuario4 = Usuario.builder().nombre("Daniel").edad(18).peso(75).id(4040).build();

        // Asignación de vehículos a propietarios
        propietario1.setVehiculoCarga(vehiculoCarga1);
        propietario2.setVehiculoCarga(vehiculoCarga2);
        propietario3.setVehiculoCarga(vehiculoCarga3);
        propietario4.setVehiculoCarga(vehiculoCarga4);

        // Asignación en EmpresaTransporte
        empresaTransporte.getListPropietario().add(propietario1);
        empresaTransporte.getListPropietario().add(propietario2);
        empresaTransporte.getListPropietario().add(propietario3);
        empresaTransporte.getListPropietario().add(propietario4);

        empresaTransporte.getListVehiculoCarga().add(vehiculoCarga1);
        empresaTransporte.getListVehiculoCarga().add(vehiculoCarga2);
        empresaTransporte.getListVehiculoCarga().add(vehiculoCarga3);
        empresaTransporte.getListVehiculoCarga().add(vehiculoCarga4);

        empresaTransporte.getListVehiculoTransporte().add(vehiculoTransporte1);
        empresaTransporte.getListVehiculoTransporte().add(vehiculoTransporte2);
        empresaTransporte.getListVehiculoTransporte().add(vehiculoTransporte3);
        empresaTransporte.getListVehiculoTransporte().add(vehiculoTransporte4);

        empresaTransporte.getListUsuario().add(usuario1);
        empresaTransporte.getListUsuario().add(usuario2);
        empresaTransporte.getListUsuario().add(usuario3);
        empresaTransporte.getListUsuario().add(usuario4);
    }
}