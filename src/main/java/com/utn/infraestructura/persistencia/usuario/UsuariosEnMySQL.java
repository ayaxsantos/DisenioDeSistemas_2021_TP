package com.utn.infraestructura.persistencia.usuario;

import com.utn.dominio.Usuarios;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.infraestructura.persistencia.usuario.UsuariosEnMySQL;
import com.utn.infraestructura.persistencia.usuario.jpa.JpaUsuario;
import com.utn.infraestructura.persistencia.usuario.jpa.JpaRepositorioUsuarios;

public class UsuariosEnMySQL implements Usuarios {

    private final JpaRepositorioUsuarios jpaRepositorioUsuarios;

    public UsuariosEnMySQL(JpaRepositorioUsuarios jpaRepositorioUsuarios) {
        this.jpaRepositorioUsuarios = jpaRepositorioUsuarios;

    }

    @Override
    public Usuario obtenerPorId(int idUsuario) {
        JpaUsuario jpaUsuario = jpaRepositorioUsuarios.obtenerPorId(idUsuario);
        return null;
    }
}
