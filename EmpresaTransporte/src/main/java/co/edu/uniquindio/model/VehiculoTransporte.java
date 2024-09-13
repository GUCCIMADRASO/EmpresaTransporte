package co.edu.uniquindio.model;

import co.edu.uniquindio.model.builder.VehiculoTransporteBuilder;

import java.util.LinkedList;

public class VehiculoTransporte extends Vehiculo {

    private int maxPasajeros;
    private Usuario usuario;
    private LinkedList<Usuario> listUsuario;

    //Constructos de vehiculo transporte con los atributos de vehiculo

    public VehiculoTransporte(String placa, String modelo, String marca, String color,int maxPasajeros) {
        super(placa, modelo, marca, color);
        this.maxPasajeros = maxPasajeros;
        listUsuario = new LinkedList<>();
    }

    //Metodo para crear un vehiculo de transporte con el builder

    public static VehiculoTransporteBuilder builder(){return new VehiculoTransporteBuilder();}

    //Getters y Setters

    public int getMaxPasajeros() {
        return maxPasajeros;
    }

    public void setMaxPasajeros(int maxPasajeros) {
        this.maxPasajeros = maxPasajeros;
    }

    public Usuario getUsuario() {return usuario;}

    public void setUsuario(Usuario usuario) {this.usuario = usuario;}

    public void setListUsuario(LinkedList<Usuario> usuarios) {this.listUsuario = usuarios;}

    public LinkedList<Usuario> getListUsuario() {return listUsuario;}
}
