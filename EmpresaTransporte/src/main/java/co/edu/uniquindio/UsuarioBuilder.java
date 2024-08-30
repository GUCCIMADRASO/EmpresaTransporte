package co.edu.uniquindio;

public class UsuarioBuilder {
    protected String nombre;
    protected String edad;
    protected double peso;
    protected Vehiculo vehiculo;

    public UsuarioBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public UsuarioBuilder edad(String edad) {
        this.edad = edad;
        return this;
    }
    public UsuarioBuilder peso(double peso) {
        this.peso = peso;
        return this;
    }
    public UsuarioBuilder vehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        return this;
    }
    public Usuario build() {
        return new Usuario(nombre, edad, peso, vehiculo);
    }

}
