package co.edu.uniquindio.model.builder;

import co.edu.uniquindio.model.Usuario;
import co.edu.uniquindio.model.VehiculoTransporte;

public class UsuarioBuilder {
    protected String nombre;
    protected int edad;
    protected double peso;
    protected int id;
    protected VehiculoTransporte vehiculoTransporte;

    public UsuarioBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public UsuarioBuilder edad(int edad) {
        this.edad = edad;
        return this;
    }
    public UsuarioBuilder peso(double peso) {
        this.peso = peso;
        return this;
    }
    public UsuarioBuilder id(int id) {
        this.id = id;
        return this;
    }
    public UsuarioBuilder vehiculoTransporte(VehiculoTransporte vehiculoTransporte) {
        this.vehiculoTransporte = vehiculoTransporte;
        return this;
    }
    public Usuario build() {
        return new Usuario(nombre, edad, peso,id,vehiculoTransporte);
    }

}
