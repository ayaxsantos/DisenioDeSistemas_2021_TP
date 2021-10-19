package com.utn.infraestructura.persistencia.usuario;

import com.utn.dominio.Usuarios;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.infraestructura.persistencia.usuario.UsuariosEnMySQL;
import com.utn.infraestructura.persistencia.usuario.jpa.JpaUsuario;
import com.utn.infraestructura.persistencia.usuario.jpa.JpaRepositorioUsuarios;
import org.springframework.stereotype.Repository;

@Repository
public class UsuariosEnMySQL implements Usuarios {

    private final JpaRepositorioUsuarios jpaRepositorioUsuarios;

    public UsuariosEnMySQL(JpaRepositorioUsuarios jpaRepositorioUsuarios) {
        this.jpaRepositorioUsuarios = jpaRepositorioUsuarios;

    }

    @Override
    public Usuario obtenerPorNombreUsuario(String nombreUsuario) {
        JpaUsuario jpaUsuario = jpaRepositorioUsuarios.obtenerPorNombreUsuario(nombreUsuario);
        return null;
    }
}
