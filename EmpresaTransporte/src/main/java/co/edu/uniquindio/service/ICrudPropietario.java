package co.edu.uniquindio.service;

import co.edu.uniquindio.model.Propietario;
import co.edu.uniquindio.model.builder.PropietarioBuilder;

import java.util.LinkedList;

public interface ICrudPropietario {
    boolean crearPropietario(String cedula, PropietarioBuilder propietario);
    boolean eliminarPropietario(String cedula);
    boolean modificarPropietario(String cedula,PropietarioBuilder propietario);
    Propietario getPropietarioCrud(String cedula);
    LinkedList<Propietario> getListPropietarioCrud();
}