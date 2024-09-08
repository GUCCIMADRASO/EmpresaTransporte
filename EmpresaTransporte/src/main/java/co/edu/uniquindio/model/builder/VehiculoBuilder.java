package co.edu.uniquindio.model.builder;


import co.edu.uniquindio.model.Vehiculo;

public abstract class VehiculoBuilder<T extends VehiculoBuilder<T>> {
    protected String placa;
    protected String modelo;
    protected String marca;
    protected String color;

    public T placa(String placa) {
        this.placa = placa;
        return self();
    }

    public T modelo(String modelo) {
        this.modelo = modelo;
        return self();
    }

    public T marca(String marca) {
        this.marca = marca;
        return self();
    }

    public T color(String color) {
        this.color = color;
        return self();
    }

    // Metodo abstracto para construir el vehiculo
    public abstract Vehiculo build();

    // Metodo para obtener la instancia actual del Builder
    protected abstract T self();
}