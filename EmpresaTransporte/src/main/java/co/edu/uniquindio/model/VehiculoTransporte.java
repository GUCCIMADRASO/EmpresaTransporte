package co.edu.uniquindio.model;

import co.edu.uniquindio.model.builder.VehiculoTransporteBuilder;

import java.util.LinkedList;

public class VehiculoTransporte extends Vehiculo {

    private int maxPasajeros;
    private Usuario usuario;
    private LinkedList<Usuario> listUsuarios;

    public VehiculoTransporte(String placa, String modelo, String marca, String color,int maxPasajeros) {
        super(placa, modelo, marca, color);
        this.maxPasajeros = maxPasajeros;
        listUsuarios = new LinkedList<>();
    }

    public VehiculoTransporte() {}

    public static VehiculoTransporteBuilder Builder(){return new VehiculoTransporteBuilder();}

    public int getMaxPasajeros() {
        return maxPasajeros;
    }

    public void setMaxPasajeros(int maxPasajeros) {
        this.maxPasajeros = maxPasajeros;
    }

    public Usuario getUsuario() {return usuario;}

    public void setUsuario(Usuario usuario) {this.usuario = usuario;}

    public void setListUsuarios(LinkedList<Usuario> usuarios) {this.listUsuarios = usuarios;}

    public LinkedList<Usuario> getListUsuarios() {return listUsuarios;}

    public String datosUsuarios(){
        String mensaje = "";
        for (Usuario usuario: listUsuarios){
            mensaje += " nombre = " + usuario.getNombre() + " edad = " + usuario.getEdad() + " peso " + usuario.getPeso() + " ";
        }
        return mensaje;
    }
}
