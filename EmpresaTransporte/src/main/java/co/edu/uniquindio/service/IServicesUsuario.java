package co.edu.uniquindio.service;

public interface IServicesUsuario {
    int calcularPasajerosTransportados(String placa);
    int contarUsuariosConSobrepeso(double peso);
    int contarUsuariosEnRangoDeEdad(int edadMinima,int edadMaxima);
}