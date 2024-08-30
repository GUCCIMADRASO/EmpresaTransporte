package co.edu.uniquindio;

import java.util.LinkedList;

public class PropietarioBuilder {
    protected String nombre;
    protected int edad;
    protected String cedula;
    protected String email;
    protected String celular;
    protected Vehiculo vehiculo;
    protected LinkedList<Vehiculo> vehiculos;

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

    public PropietarioBuilder vehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        return this;
    }

    public PropietarioBuilder vehiculos(LinkedList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
        return this;
    }

    public Propietario build() {
        return new Propietario(nombre, edad, cedula, email, celular, vehiculo, vehiculos);
    }

}