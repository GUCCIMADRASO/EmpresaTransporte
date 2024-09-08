package co.edu.uniquindio.model;

import co.edu.uniquindio.model.builder.VehiculoCargaBuilder;

public class VehiculoCarga extends Vehiculo {

    private double capacidadCarga;
    private int numeroEjes;

    public VehiculoCarga(String placa, String modelo, String marca, String color, double capacidad, int numeroEjes) {
        super(placa, modelo, marca, color);
        this.capacidadCarga = capacidad;
        this.numeroEjes = numeroEjes;
    }

    public VehiculoCarga() {}

    public static VehiculoCargaBuilder Builder(){return new VehiculoCargaBuilder();}

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

    public String toString1() {
        return " " +
                "capacidadCarga=" + capacidadCarga +
                ", numeroEjes=" + numeroEjes +
                '}';
    }
}
