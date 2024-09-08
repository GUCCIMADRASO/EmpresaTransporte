package co.edu.uniquindio.model;

import co.edu.uniquindio.model.builder.UsuarioBuilder;

public class Usuario {
    private String nombre;
    private int edad;
    private double peso;
    private int id;
    private Vehiculo vehiculo;

    public Usuario(String nombre, int edad, double peso,int id, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.id = id;
        this.vehiculo = vehiculo;
    }
    public Usuario() {}


    public static UsuarioBuilder Builder(){
        return new UsuarioBuilder();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public Vehiculo getVehiculo() { return vehiculo; }

    @Override
    public String toString() {
        return "{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", peso='" + peso + '\'' +
                ", vehiculo=" + vehiculo +
                '}';
    }
}
