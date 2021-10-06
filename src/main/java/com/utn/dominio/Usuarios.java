package com.utn.dominio;

import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.organizacion.Voluntario;

public interface Usuarios {
    Usuario obtenerPorId(int idUsuario);
}
