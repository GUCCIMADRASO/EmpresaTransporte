package co.edu.uniquindio.model.builder;

import co.edu.uniquindio.model.Propietario;
import co.edu.uniquindio.model.VehiculoCarga;

import java.util.LinkedList;

public class PropietarioBuilder {
    protected String nombre;
    protected int edad;
    protected String cedula;
    protected String email;
    protected String celular;
    protected VehiculoCarga vehiculoCarga;
    protected LinkedList<VehiculoCarga> listVehiculoCarga;

    public PropietarioBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PropietarioBuilder edad(int edad) {
        this.edad = edad;
        return this;
    }

    public PropietarioBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public PropietarioBuilder email(String email) {
        this.email = email;
        return this;
    }

    public PropietarioBuilder celular(String celular) {
        this.celular = celular;
        return this;
    }

    public PropietarioBuilder vehiculoCarga(VehiculoCarga vehiculoaCarga) {
        this.vehiculoCarga = vehiculoCarga;
        return this;
    }

    public PropietarioBuilder listVehiculoCarga(LinkedList<VehiculoCarga> listVehiculoCarga) {
        this.listVehiculoCarga = listVehiculoCarga;
        return this;
    }

    public Propietario build() {
        return new Propietario(nombre, edad, cedula, email, celular, vehiculoCarga, listVehiculoCarga);
    }

}