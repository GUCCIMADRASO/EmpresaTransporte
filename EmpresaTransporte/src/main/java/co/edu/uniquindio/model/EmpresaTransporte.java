package co.edu.uniquindio.model;

import co.edu.uniquindio.model.builder.*;
import co.edu.uniquindio.service.*;

import java.util.LinkedList;

public class EmpresaTransporte implements
        ICrudUsuario,
        ICrudPropietario,
        ICrudVehiculoCarga,
        ICrudVehiculoTransporte {

    private String nombre;
    private LinkedList<Propietario> listPropietarios = new LinkedList<>();
    private LinkedList<Usuario> listUsuarios = new LinkedList<>();
    private LinkedList<Vehiculo> listVehiculos = new LinkedList<>();
    private LinkedList<VehiculoTransporte> listVehiculosTransporte = new LinkedList<>();
    private LinkedList<VehiculoCarga> listVehiculosCarga = new LinkedList<>();


    public int calcularPasajerosTransportados(String placa) {
        saturar();
        int contador = 0;
        for (VehiculoTransporte vehiculoTransporte : listVehiculosTransporte) {
            if (vehiculoTransporte.getPlaca().equalsIgnoreCase(placa)) {
                contador = vehiculoTransporte.getListUsuarios().size();
            }
        }
        return contador;
    }

    public int usuariosConSobrepeso() {
        int contador = 0;
        double peso = 80;
        for (VehiculoTransporte vehiculoTransporte : listVehiculosTransporte) {
            for (Usuario usuario : vehiculoTransporte.getListUsuarios()) {
                if (usuario.getPeso() >= peso) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public int contarUsuariosEnRangoDeEdad() {
        int contador = 0;
        int edadMinima = 40;
        int edadMaxima = 60;
        for (VehiculoTransporte vehiculoTransporte : listVehiculosTransporte){
            for (Usuario usuario : vehiculoTransporte.getListUsuarios()) {
                int edad = usuario.getEdad();
                if (edad >= edadMinima && edad <= edadMaxima) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public int contarPropietariosMayoresDe40() {
        int contador = 0;
        for (Propietario propietario : listPropietarios) {
            if (propietario.getEdad() > 40) {
                contador++;
            }
        }
        return contador;
    }


    private void saturar() {
        // Índice
        int i = 0;

        for (VehiculoTransporte vehiculoTransporte : listVehiculosTransporte) {
            int maxPasajeros = vehiculoTransporte.getMaxPasajeros();
            LinkedList<Usuario> usuariosTransportados = vehiculoTransporte.getListUsuarios();

            // Si la lista de usuarios no está inicializada, la inicializamos
            if (usuariosTransportados == null) {
                usuariosTransportados = new LinkedList<>();
                vehiculoTransporte.setListUsuarios(usuariosTransportados);
            }

            // Añadimos usuarios hasta llenar el vehículo, sin exceder el maxPasajeros
            while (usuariosTransportados.size() < maxPasajeros && i < listUsuarios.size()) {
                usuariosTransportados.add(listUsuarios.get(i));
                i++;
            }

            // Si ya no hay más usuarios en listUsuarios, salimos del bucle
            if (i >= listUsuarios.size()) {
                break;
            }
        }
    }

    //******************************************************************
    //          Verificaciones para evitar objetos duplicados
    //******************************************************************

    private Usuario buscarUsuario(int id) {
        Usuario usuarioExistente = null;

        for (Usuario usuario : listUsuarios) {
            if (usuario.getId() == id) {
                usuarioExistente = usuario;
                break;
            }
        }
        return usuarioExistente;
    }
    private Propietario buscarPropietario(String cedula) {
        Propietario propietarioExistente = null;

        for (Propietario propietario : listPropietarios) {
            if (propietario.getCedula().equals(cedula)) {
                propietarioExistente = propietario;
                break;
            }
        }
        return propietarioExistente;
    }
    private Vehiculo buscarVehiculo(String placa) {
        Vehiculo vehiculoExistente = null;

        for (Vehiculo vehiculo : listVehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                vehiculoExistente = vehiculo;
                break;
            }
        }
        return vehiculoExistente;
    }
    private VehiculoCarga buscarVehiculoCarga(String placa) {
        VehiculoCarga vehiculoExistente = null;

        for (VehiculoCarga vehiculo : listVehiculosCarga) {
            if (vehiculo.getPlaca().equals(placa)) {
                vehiculoExistente = vehiculo;
                break;
            }
        }
        return vehiculoExistente;
    }
    private VehiculoTransporte buscarVehiculoTransporte(String placa) {
        VehiculoTransporte vehiculoExistente = null;

        for (VehiculoTransporte vehiculo : listVehiculosTransporte) {
            if (vehiculo.getPlaca().equals(placa)) {
                vehiculoExistente = vehiculo;
                break;
            }
        }
        return vehiculoExistente;
    }
    //******************************************************************
    //                Implementacion de ICrudUsuario
    //******************************************************************

    @Override
    public boolean crearUsuario(int id, UsuarioBuilder usuario) {
        Usuario usuarioExistente = buscarUsuario(id);

        if(usuarioExistente == null){
            Usuario newUsuario = usuario.build();
            listUsuarios.add(newUsuario);
            return true; // Usuario creado correctamente
        }
        return false; // Usuario duplicado
    }

    @Override
    public boolean eliminarUsuario(int id) {
        Usuario usuario = getUsuarioCrud(id);

        if (usuario != null) {
            listUsuarios.remove(usuario);
            return true;  // Usuario eliminado correctamente
        }
        return false;  // No se encontró el usuario
    }

    @Override
    public boolean modificarUsuario(int id, UsuarioBuilder usuario) {
        Usuario usuarioExistente = buscarUsuario(id);

        if (usuarioExistente != null) {
            // Modificar el usuario
            Usuario usuarioMod = usuario.build();
            // Buscar el índice del usuario existente en la lista
            int index = listUsuarios.indexOf(usuarioExistente);
            // Actualizar el usuario en la lista con el usuario modificado
            listUsuarios.set(index, usuarioMod);
            return true;  // Usuario modificado correctamente
        }
        return false;  // El usuario no existe
    }

    @Override
    public Usuario getUsuarioCrud(int id) {
        for (Usuario usuario : listUsuarios) {
            if (usuario.getId() == id) {
                return usuario;  // Usuario encontrado
            }
        }
        return null;  // No se encontró el usuario
    }
    @Override
    public LinkedList<Usuario> getListUsuariosCrud(){return listUsuarios;}

    //******************************************************************
    //               Implementacion de ICrudPropietario
    //******************************************************************

    @Override
    public boolean crearPropietario(String cedula, PropietarioBuilder propietarioBuilder) {
        Propietario propietarioExistente = buscarPropietario(cedula);

        if (propietarioExistente == null) {
            Propietario newPropietario = propietarioBuilder.build();
            listPropietarios.add(newPropietario);
            return true; // Propietario creado correctamente
        }
        return false; // Propietario duplicado
    }

    @Override
    public boolean eliminarPropietario(String cedula) {
        Propietario propietario = getPropietarioCrud(cedula);

        if (propietario != null) {
            listPropietarios.remove(propietario);
            return true;  // Propietario eliminado correctamente
        }
        return false;  // No se encontró el propietario
    }

    @Override
    public boolean modificarPropietario(String cedula, PropietarioBuilder propietarioBuilder) {
        Propietario propietarioExistente = buscarPropietario(cedula);

        if (propietarioExistente != null) {
            // Modificar el propietario
            Propietario propietarioMod = propietarioBuilder.build();
            // Buscar el índice del propietario existente en la lista
            int index = listPropietarios.indexOf(propietarioExistente);
            // Actualizar el propietario en la lista con el propietario modificado
            listPropietarios.set(index, propietarioMod);
            return true;  // Propietario modificado correctamente
        }
        return false;  // El propietario no existe
    }

    @Override
    public Propietario getPropietarioCrud(String cedula) {
        for (Propietario propietario : listPropietarios) {
            if (propietario.getCedula().equals(cedula)) {
                return propietario;  // Propietario encontrado
            }
        }
        return null;  // No se encontró el propietario
    }

    @Override
    public LinkedList<Propietario> getListPropietarioCrud() {
        return listPropietarios;
    }

    //******************************************************************
    //               Implementacion de ICrudVehiculoCarga
    //******************************************************************
    @Override
    public boolean crearVehiculoCarga(String placa, VehiculoCargaBuilder vehiculoCargaBuilder) {
        VehiculoCarga vehiculoExistente = buscarVehiculoCarga(placa);

        if (vehiculoExistente == null) {
            VehiculoCarga newVehiculoCarga = vehiculoCargaBuilder.build();
            listVehiculosCarga.add(newVehiculoCarga);
            return true; // Vehículo de carga creado correctamente
        }
        return false; // Vehículo de carga duplicado
    }

    @Override
    public boolean eliminarVehiculoCarga(String placa) {
        VehiculoCarga vehiculoCarga = getVehiculoCargaCrud(placa);

        if (vehiculoCarga != null) {
            listVehiculosCarga.remove(vehiculoCarga);
            return true;  // Vehículo de carga eliminado correctamente
        }
        return false;  // No se encontró el vehículo de carga
    }

    @Override
    public boolean modificarVehiculoCarga(String placa, VehiculoCargaBuilder vehiculoCargaBuilder) {
        VehiculoCarga vehiculoExistente = buscarVehiculoCarga(placa);

        if (vehiculoExistente != null) {
            // Modificar el vehículo de carga
            VehiculoCarga vehiculoMod = vehiculoCargaBuilder.build();
            // Buscar el índice del vehículo existente en la lista
            int index = listVehiculosCarga.indexOf(vehiculoExistente);
            // Actualizar el vehículo en la lista con el vehículo modificado
            listVehiculosCarga.set(index, vehiculoMod);
            return true;  // Vehículo de carga modificado correctamente
        }
        return false;  // El vehículo de carga no existe
    }

    @Override
    public VehiculoCarga getVehiculoCargaCrud(String placa) {
        for (VehiculoCarga vehiculo : listVehiculosCarga) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;  // Vehículo de carga encontrado
            }
        }
        return null;  // No se encontró el vehículo de carga
    }

    @Override
    public LinkedList<VehiculoCarga> getListVehiculosCargaCrud() {
        return listVehiculosCarga;
    }
    //******************************************************************
    //             Implementacion de ICrudVehiculoTransporte
    //******************************************************************
    @Override
    public boolean crearVehiculoTransporte(String placa, VehiculoTransporteBuilder vehiculoTransporte) {
        VehiculoTransporte vehiculoExistente = buscarVehiculoTransporte(placa);

        if (vehiculoExistente == null) {
            VehiculoTransporte newVehiculo = vehiculoTransporte.build();
            listVehiculosTransporte.add(newVehiculo);
            return true; // Vehículo de transporte creado correctamente
        }
        return false; // Vehículo de transporte duplicado
    }

    @Override
    public boolean eliminarVehiculoTransporte(String placa) {
        VehiculoTransporte vehiculo = getVehiculoTransporteCrud(placa);

        if (vehiculo != null) {
            listVehiculosTransporte.remove(vehiculo);
            return true;  // Vehículo de transporte eliminado correctamente
        }
        return false;  // No se encontró el vehículo de transporte
    }

    @Override
    public boolean modificarVehiculoTransporte(String placa, VehiculoTransporteBuilder vehiculoTransporteBuilder) {
        VehiculoTransporte vehiculoExistente = buscarVehiculoTransporte(placa);

        if (vehiculoExistente != null) {
            // Modificar el vehículo de transporte
            VehiculoTransporte vehiculoMod = vehiculoTransporteBuilder.build();
            // Buscar el índice del vehículo existente en la lista
            int index = listVehiculosTransporte.indexOf(vehiculoExistente);
            // Actualizar el vehículo en la lista con el vehículo modificado
            listVehiculosTransporte.set(index, vehiculoMod);
            return true;  // Vehículo de transporte modificado correctamente
        }
        return false;  // El vehículo de transporte no existe
    }

    @Override
    public VehiculoTransporte getVehiculoTransporteCrud(String placa) {
        for (VehiculoTransporte vehiculo : listVehiculosTransporte) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;  // Vehículo de transporte encontrado
            }
        }
        return null;  // No se encontró el vehículo de transporte
    }

    @Override
    public LinkedList<VehiculoTransporte> getListVehiculosTransporteCrud() {
        return listVehiculosTransporte;
    }
    //******************************************************************
    //                         Getters y Setters
    //******************************************************************

    public LinkedList<Propietario> getListPropietarios() {return listPropietarios;}

    public LinkedList<Usuario> getListUsuarios() { return listUsuarios;}

    public LinkedList<Vehiculo> getListVehiculos() {return listVehiculos;}

    public LinkedList<VehiculoTransporte> getListVehiculosTransporte() {return listVehiculosTransporte;}

    public LinkedList<VehiculoCarga> getListVehiculosCarga() {return listVehiculosCarga;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}
}