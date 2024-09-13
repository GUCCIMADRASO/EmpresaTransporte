package co.edu.uniquindio.model;

import co.edu.uniquindio.model.builder.PropietarioBuilder;
import java.util.LinkedList;

public class Propietario {

    private String nombre;
    private int edad;
    private String cedula;
    private String email;
    private String celular;
    private VehiculoCarga vehiculoCarga;
    private LinkedList<VehiculoCarga> listVehiculoCarga;

    //Constructos de propietario

    public Propietario(String nombre, int edad, String cedula, String email, String celular, VehiculoCarga vehiculoCarga, LinkedList<VehiculoCarga> listVehiculoCarga) {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.email = email;
        this.celular = celular;
        this.vehiculoCarga = vehiculoCarga;
        this.listVehiculoCarga = listVehiculoCarga;
    }

    //Metodo para crear un propietario con el builder

    public static PropietarioBuilder builder(){
        return new PropietarioBuilder();
    }

    //Getters y Setters

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

    public Vehiculo getVehiculoCarga() {
        return vehiculoCarga;
    }

    public void setVehiculoCarga(VehiculoCarga vehiculoCarga) { this.vehiculoCarga = vehiculoCarga; }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LinkedList<VehiculoCarga> getListVehiculoCarga() {
        return listVehiculoCarga;
    }

    //Metodo toString

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
