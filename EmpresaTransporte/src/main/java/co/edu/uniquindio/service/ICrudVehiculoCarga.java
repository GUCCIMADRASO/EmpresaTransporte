package co.edu.uniquindio.service;

import co.edu.uniquindio.model.VehiculoCarga;
import co.edu.uniquindio.model.builder.VehiculoCargaBuilder;
import java.util.LinkedList;

public interface ICrudVehiculoCarga {
    boolean crearVehiculoCarga(String placa,VehiculoCargaBuilder vehiculoCarga);
    boolean eliminarVehiculoCarga(String placa);
    boolean modificarVehiculoCarga(String placa,VehiculoCargaBuilder vehiculoCarga);
    VehiculoCarga getVehiculoCargaCrud(String placa);
    LinkedList<VehiculoCarga> getListVehiculoCargaCrud();
}