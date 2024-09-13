package co.edu.uniquindio.model;

import co.edu.uniquindio.model.builder.UsuarioBuilder;

public class Usuario {
    private String nombre;
    private int edad;
    private double peso;
    private int id;
    private VehiculoTransporte vehiculoTransporte;

    //Constructos de usuario

    public Usuario(String nombre, int edad, double peso,int id, VehiculoTransporte vehiculoTransporte) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.id = id;
        this.vehiculoTransporte = vehiculoTransporte;
    }

    //Metodo para crear un usuario con el builder

    public static UsuarioBuilder builder(){
        return new UsuarioBuilder();
    }

    //Getters y Setters

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

    public Vehiculo getVehiculoTransporte() { return vehiculoTransporte; }

    //Metodo toString

    @Override
    public String toString() {
        return "{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", peso='" + peso + '\'' +
                ", vehiculo=" + vehiculoTransporte +
                '}';
    }
}
