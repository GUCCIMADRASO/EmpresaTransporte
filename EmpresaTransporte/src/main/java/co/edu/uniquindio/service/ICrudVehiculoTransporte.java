package co.edu.uniquindio.service;

import co.edu.uniquindio.model.VehiculoTransporte;
import co.edu.uniquindio.model.builder.VehiculoTransporteBuilder;
import java.util.LinkedList;

public interface ICrudVehiculoTransporte {
    boolean crearVehiculoTransporte(String placa,VehiculoTransporteBuilder vehiculoTransporte);
    boolean eliminarVehiculoTransporte(String placa);
    boolean modificarVehiculoTransporte(String placa,VehiculoTransporteBuilder vehiculoTransporte);
    VehiculoTransporte getVehiculoTransporteCrud(String placa);
    LinkedList<VehiculoTransporte> getListVehiculosTransporteCrud();
}
