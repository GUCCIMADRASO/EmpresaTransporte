package co.edu.uniquindio.service;

import co.edu.uniquindio.model.Usuario;
import co.edu.uniquindio.model.builder.UsuarioBuilder;

import java.util.LinkedList;

public interface ICrudUsuario {
    boolean crearUsuario(int id,UsuarioBuilder usuario);
    boolean eliminarUsuario(int id);
    boolean modificarUsuario(int id,UsuarioBuilder usuario);
    Usuario getUsuarioCrud(int id);
    LinkedList<Usuario> getListUsuarioCrud();
}
