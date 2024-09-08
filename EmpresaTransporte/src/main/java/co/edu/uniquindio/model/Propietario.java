package co.edu.uniquindio.model;

import co.edu.uniquindio.model.builder.PropietarioBuilder;

import java.util.Collection;

public class Propietario {

    private String nombre;
    private int edad;
    private String cedula;
    private String email;
    private String celular;
    private Vehiculo vehiculo;
    private Collection<Vehiculo> vehiculos;

    public Propietario(String nombre, int edad, String cedula, String email, String celular, Vehiculo vehiculo, Collection<Vehiculo> vehiculos) {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.email = email;
        this.celular = celular;
        this.vehiculo = vehiculo;
        this.vehiculos = vehiculos;
    }

    public static PropietarioBuilder Builder(){
        return new PropietarioBuilder();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    @Override
    public String toString() {
        return "{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }
}
