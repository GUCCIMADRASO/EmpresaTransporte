package co.edu.uniquindio.service;

import co.edu.uniquindio.model.EmpresaTransporte;
import java.util.LinkedList;

public interface ICrudEmpresaTransporte {
    boolean crearEmpresaTransporte(String nombre);
    boolean eliminarEmpresaTransporte(String nombre);
    boolean modificarEmpresaTransporte(String nombre);
    EmpresaTransporte getEmpresaTransporte(String nombre);
    LinkedList<EmpresaTransporte> getListEmpresaTransportes();
}
