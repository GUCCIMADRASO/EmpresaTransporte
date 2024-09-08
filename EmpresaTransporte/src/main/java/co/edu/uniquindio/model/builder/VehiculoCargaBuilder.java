package co.edu.uniquindio.model.builder;

import co.edu.uniquindio.model.VehiculoCarga;

public class VehiculoCargaBuilder extends VehiculoBuilder<VehiculoCargaBuilder> {

    protected double capacidadCarga;
    protected int numeroEjes;

    public VehiculoCargaBuilder capacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
        return this;
    }
    public VehiculoCargaBuilder numeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
        return this;
    }

    public VehiculoCarga build() {return new VehiculoCarga(placa,modelo,marca,color,capacidadCarga,numeroEjes);}

    @Override
    protected VehiculoCargaBuilder self() {
        return this;
    }
}
