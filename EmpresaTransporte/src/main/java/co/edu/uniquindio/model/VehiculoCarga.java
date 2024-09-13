package co.edu.uniquindio.model;

import co.edu.uniquindio.model.builder.VehiculoCargaBuilder;

public class VehiculoCarga extends Vehiculo {

    private double capacidadCarga;
    private int numeroEjes;

    //Constructos de vehiculo carga con los atributos de vehiculo

    public VehiculoCarga(String placa, String modelo, String marca, String color, double capacidad, int numeroEjes) {
        super(placa, modelo, marca, color);
        this.capacidadCarga = capacidad;
        this.numeroEjes = numeroEjes;
    }

    //Metodo para crear un vehiculo de carga con el builder

    public static VehiculoCargaBuilder builder(){return new VehiculoCargaBuilder();}

    //Getters y Setters

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }
}
