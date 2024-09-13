package co.edu.uniquindio.model.builder;

import co.edu.uniquindio.model.VehiculoTransporte;

public class VehiculoTransporteBuilder extends VehiculoBuilder<VehiculoTransporteBuilder>{
    protected int maxPasajeros;

    public VehiculoTransporteBuilder maxPasajeros(int maxPasajeros) {
        this.maxPasajeros = maxPasajeros;
        return this;
    }

    @Override
    public VehiculoTransporte build() {
        return new VehiculoTransporte(placa,modelo,marca,color,maxPasajeros);
    }

    @Override
    protected VehiculoTransporteBuilder self() {
        return this;
    }
}