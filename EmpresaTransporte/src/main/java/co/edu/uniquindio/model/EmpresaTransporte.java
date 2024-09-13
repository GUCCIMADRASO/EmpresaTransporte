package co.edu.uniquindio.model;

import co.edu.uniquindio.model.builder.*;
import co.edu.uniquindio.service.*;

import java.util.LinkedList;

public class EmpresaTransporte implements
        ICrudUsuario,
        ICrudPropietario,
        ICrudVehiculoCarga,
        ICrudVehiculoTransporte,
        IServicesUsuario{

    private String nombre;
    private final LinkedList<Propietario> listPropietario = new LinkedList<>();
    private final LinkedList<Usuario> listUsuario = new LinkedList<>();
    private final LinkedList<VehiculoTransporte> listVehiculoTransporte = new LinkedList<>();
    private final LinkedList<VehiculoCarga> listVehiculoCarga = new LinkedList<>();

    //Metodo para calcular pasajeros transportados

    public int calcularPasajerosTransportados(String placa) {
        saturar();
        int contador = 0;
        for (VehiculoTransporte vehiculoTransporte : listVehiculoTransporte) {
            if (vehiculoTransporte.getPlaca().equalsIgnoreCase(placa)) {
                contador = vehiculoTransporte.getListUsuario().size();
            }
        }
        return contador;
    }

    //Metodo para contar usuarios con sobrepeso

    public int contarUsuariosConSobrepeso(double peso) {
        int contador = 0;
        for (VehiculoTransporte vehiculoTransporte : listVehiculoTransporte) {
            for (Usuario usuario : vehiculoTransporte.getListUsuario()) {
                if (usuario.getPeso() >= peso) {
                    contador++;
                }
            }
        }
        return contador;
    }

    //Metodo para contar usuarios en rango de edad

    public int contarUsuariosEnRangoDeEdad(int edadMinima,int edadMaxima) {
        int contador = 0;
        for (VehiculoTransporte vehiculoTransporte : listVehiculoTransporte){
            for (Usuario usuario : vehiculoTransporte.getListUsuario()) {
                int edad = usuario.getEdad();
                if (edad >= edadMinima && edad <= edadMaxima) {
                    contador++;
                }
            }
        }
        return contador;
    }

    //Metodo para contar propietarios mayores de 40 años

    public int contarPropietariosMayoresDe40(int edad) {
        int contador = 0;
        for (Propietario propietario : listPropietario) {
            if (propietario.getEdad() > edad) {
                contador++;
            }
        }
        return contador;
    }

    //Metodo para saturar los vehiculos de transporte

    private void saturar() {
        // Índice
        int i = 0;

        for (VehiculoTransporte vehiculoTransporte : listVehiculoTransporte) {
            int maxPasajeros = vehiculoTransporte.getMaxPasajeros();
            LinkedList<Usuario> usuariosTransportados = vehiculoTransporte.getListUsuario();

            // Si la lista de usuarios no está inicializada, la inicializamos
            if (usuariosTransportados == null) {
                usuariosTransportados = new LinkedList<>();
                vehiculoTransporte.setListUsuario(usuariosTransportados);
            }

            // Añadimos usuarios hasta llenar el vehículo, sin exceder el maxPasajeros
            while (usuariosTransportados.size() < maxPasajeros && i < listUsuario.size()) {
                usuariosTransportados.add(listUsuario.get(i));
                i++;
            }

            // Si ya no hay más usuarios en listUsuario, salimos del bucle
            if (i >= listUsuario.size()) {
                break;
            }
        }
    }

    //******************************************************************
    //          Verificaciones para evitar objetos duplicados
    //******************************************************************

    //Metodo para buscar un usuario por id

    private Usuario buscarUsuario(int id) {
        Usuario usuarioExistente = null;

        for (Usuario usuario : listUsuario) {
            if (usuario.getId() == id) {
                usuarioExistente = usuario;
                break;
            }
        }
        return usuarioExistente;
    }

    //Metodo para buscar un propietario por cedula

    private Propietario buscarPropietario(String cedula) {
        Propietario propietarioExistente = null;

        for (Propietario propietario : listPropietario) {
            if (propietario.getCedula().equals(cedula)) {
                propietarioExistente = propietario;
                break;
            }
        }
        return propietarioExistente;
    }

    //Metodo para buscar un vehiculo de carga por placa

    private VehiculoCarga buscarVehiculoCarga(String placa) {
        VehiculoCarga vehiculoExistente = null;

        for (VehiculoCarga vehiculo : listVehiculoCarga) {
            if (vehiculo.getPlaca().equals(placa)) {
                vehiculoExistente = vehiculo;
                break;
            }
        }
        return vehiculoExistente;
    }

    //Metodo para buscar un vehiculo de transporte por placa

    private VehiculoTransporte buscarVehiculoTransporte(String placa) {
        VehiculoTransporte vehiculoExistente = null;

        for (VehiculoTransporte vehiculo : listVehiculoTransporte) {
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

    //Metodo para crear un usuario

    @Override
    public boolean crearUsuario(int id, UsuarioBuilder usuario) {
        Usuario usuarioExistente = buscarUsuario(id);

        if(usuarioExistente == null){
            Usuario newUsuario = usuario.build();
            listUsuario.add(newUsuario);
            return true; // Usuario creado correctamente
        }
        return false; // Usuario duplicado
    }

    //Metodo para eliminar un usuario

    @Override
    public boolean eliminarUsuario(int id) {
        Usuario usuario = getUsuarioCrud(id);

        if (usuario != null) {
            listUsuario.remove(usuario);
            return true;  // Usuario eliminado correctamente
        }
        return false;  // No se encontró el usuario
    }

    //Metodo para modificar un usuario

    @Override
    public boolean modificarUsuario(int id, UsuarioBuilder usuario) {
        Usuario usuarioExistente = buscarUsuario(id);

        if (usuarioExistente != null) {
            // Modificar el usuario
            Usuario usuarioMod = usuario.build();
            // Buscar el índice del usuario existente en la lista
            int index = listUsuario.indexOf(usuarioExistente);
            // Actualizar el usuario en la lista con el usuario modificado
            listUsuario.set(index, usuarioMod);
            return true;  // Usuario modificado correctamente
        }
        return false;  // El usuario no existe
    }

    //Metodo para obtener un usuario

    @Override
    public Usuario getUsuarioCrud(int id) {
        for (Usuario usuario : listUsuario) {
            if (usuario.getId() == id) {
                return usuario;  // Usuario encontrado
            }
        }
        return null;  // No se encontró el usuario
    }

    //Metodo para obtener una lista de usuarios

    @Override
    public LinkedList<Usuario> getListUsuarioCrud(){
        return listUsuario;
    }

    //******************************************************************
    //               Implementacion de ICrudPropietario
    //******************************************************************

    //Metodo para crear un propietario

    @Override
    public boolean crearPropietario(String cedula, PropietarioBuilder propietarioBuilder) {
        Propietario propietarioExistente = buscarPropietario(cedula);

        if (propietarioExistente == null) {
            Propietario newPropietario = propietarioBuilder.build();
            listPropietario.add(newPropietario);
            return true; // Propietario creado correctamente
        }
        return false; // Propietario duplicado
    }

    //Metodo para eliminar un propietario

    @Override
    public boolean eliminarPropietario(String cedula) {
        Propietario propietario = getPropietarioCrud(cedula);

        if (propietario != null) {
            listPropietario.remove(propietario);
            return true;  // Propietario eliminado correctamente
        }
        return false;  // No se encontró el propietario
    }

    //Metodo para modificar un propietario

    @Override
    public boolean modificarPropietario(String cedula, PropietarioBuilder propietarioBuilder) {
        Propietario propietarioExistente = buscarPropietario(cedula);

        if (propietarioExistente != null) {
            // Modificar el propietario
            Propietario propietarioMod = propietarioBuilder.build();
            // Buscar el índice del propietario existente en la lista
            int index = listPropietario.indexOf(propietarioExistente);
            // Actualizar el propietario en la lista con el propietario modificado
            listPropietario.set(index, propietarioMod);
            return true;  // Propietario modificado correctamente
        }
        return false;  // El propietario no existe
    }

    //Metodo para obtener un propietario

    @Override
    public Propietario getPropietarioCrud(String cedula) {
        for (Propietario propietario : listPropietario) {
            if (propietario.getCedula().equals(cedula)) {
                return propietario;  // Propietario encontrado
            }
        }
        return null;  // No se encontró el propietario
    }

    //Metodo para obtener una lista de propietarios

    @Override
    public LinkedList<Propietario> getListPropietarioCrud() {
        return listPropietario;
    }

    //******************************************************************
    //               Implementacion de ICrudVehiculoCarga
    //******************************************************************

    //Metodo para crear un vehiculo de carga

    @Override
    public boolean crearVehiculoCarga(String placa, VehiculoCargaBuilder vehiculoCargaBuilder) {
        VehiculoCarga vehiculoExistente = buscarVehiculoCarga(placa);

        if (vehiculoExistente == null) {
            VehiculoCarga newVehiculoCarga = vehiculoCargaBuilder.build();
            listVehiculoCarga.add(newVehiculoCarga);
            return true; // Vehículo de carga creado correctamente
        }
        return false; // Vehículo de carga duplicado
    }

    //Metodo para eliminar un vehiculo de carga

    @Override
    public boolean eliminarVehiculoCarga(String placa) {
        VehiculoCarga vehiculoCarga = getVehiculoCargaCrud(placa);

        if (vehiculoCarga != null) {
            listVehiculoCarga.remove(vehiculoCarga);
            return true;  // Vehículo de carga eliminado correctamente
        }
        return false;  // No se encontró el vehículo de carga
    }

    //Metodo para modificar un vehiculo de carga

    @Override
    public boolean modificarVehiculoCarga(String placa, VehiculoCargaBuilder vehiculoCargaBuilder) {
        VehiculoCarga vehiculoExistente = buscarVehiculoCarga(placa);

        if (vehiculoExistente != null) {
            // Modificar el vehículo de carga
            VehiculoCarga vehiculoMod = vehiculoCargaBuilder.build();
            // Buscar el índice del vehículo existente en la lista
            int index = listVehiculoCarga.indexOf(vehiculoExistente);
            // Actualizar el vehículo en la lista con el vehículo modificado
            listVehiculoCarga.set(index, vehiculoMod);
            return true;  // Vehículo de carga modificado correctamente
        }
        return false;  // El vehículo de carga no existe
    }

    //Metodo para obtener un vehiculo de carga

    @Override
    public VehiculoCarga getVehiculoCargaCrud(String placa) {
        for (VehiculoCarga vehiculo : listVehiculoCarga) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;  // Vehículo de carga encontrado
            }
        }
        return null;  // No se encontró el vehículo de carga
    }

    //Metodo para obtener una lista de vehiculo de carga

    @Override
    public LinkedList<VehiculoCarga> getListVehiculoCargaCrud() {
        return listVehiculoCarga;
    }

    //******************************************************************
    //             Implementacion de ICrudVehiculoTransporte
    //******************************************************************

    //Metodo para crear un vehiculo de transporte

    @Override
    public boolean crearVehiculoTransporte(String placa, VehiculoTransporteBuilder vehiculoTransporte) {
        VehiculoTransporte vehiculoExistente = buscarVehiculoTransporte(placa);

        if (vehiculoExistente == null) {
            VehiculoTransporte newVehiculo = vehiculoTransporte.build();
            listVehiculoTransporte.add(newVehiculo);
            return true; // Vehículo de transporte creado correctamente
        }
        return false; // Vehículo de transporte duplicado
    }

    //Metodo para eliminar un vehiculo de transporte

    @Override
    public boolean eliminarVehiculoTransporte(String placa) {
        VehiculoTransporte vehiculo = getVehiculoTransporteCrud(placa);

        if (vehiculo != null) {
            listVehiculoTransporte.remove(vehiculo);
            return true;  // Vehículo de transporte eliminado correctamente
        }
        return false;  // No se encontró el vehículo de transporte
    }

    //Metodo para modificar un vehiculo de transporte

    @Override
    public boolean modificarVehiculoTransporte(String placa, VehiculoTransporteBuilder vehiculoTransporteBuilder) {
        VehiculoTransporte vehiculoExistente = buscarVehiculoTransporte(placa);

        if (vehiculoExistente != null) {
            // Modificar el vehículo de transporte
            VehiculoTransporte vehiculoMod = vehiculoTransporteBuilder.build();
            // Buscar el índice del vehículo existente en la lista
            int index = listVehiculoTransporte.indexOf(vehiculoExistente);
            // Actualizar el vehículo en la lista con el vehículo modificado
            listVehiculoTransporte.set(index, vehiculoMod);
            return true;  // Vehículo de transporte modificado correctamente
        }
        return false;  // El vehículo de transporte no existe
    }

    //Metodo para obtener un vehiculo de transporte

    @Override
    public VehiculoTransporte getVehiculoTransporteCrud(String placa) {
        for (VehiculoTransporte vehiculo : listVehiculoTransporte) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;  // Vehículo de transporte encontrado
            }
        }
        return null;  // No se encontró el vehículo de transporte
    }

    //Metodo para obtener una lista de vehiculo de transporte

    @Override
    public LinkedList<VehiculoTransporte> getListVehiculoTransporteCrud() {
        return listVehiculoTransporte;
    }

    //******************************************************************
    //                         Getters y Setters
    //******************************************************************

    public LinkedList<Propietario> getListPropietario() {return listPropietario;}

    public LinkedList<Usuario> getListUsuario() { return listUsuario;}

    public LinkedList<VehiculoTransporte> getListVehiculoTransporte() {return listVehiculoTransporte;}

    public LinkedList<VehiculoCarga> getListVehiculoCarga() {return listVehiculoCarga;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}
}