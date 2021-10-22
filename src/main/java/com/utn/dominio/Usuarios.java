package com.utn.dominio;

import java.util.Optional;
import com.utn.dominio.autenticacion.Usuario;

public interface Usuarios {
    Optional<Usuario>  obtenerPorNombreUsuario(String nombreUsuario);
}