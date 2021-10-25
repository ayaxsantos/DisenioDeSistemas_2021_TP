package com.utn.dominio;

import java.util.Optional;
import com.utn.dominio.autenticacion.Usuario;

public interface Usuarios {
    Usuario obtenerPorNombreUsuario(String nombreUsuario);
    void guardar(Usuario unUsuario);
}