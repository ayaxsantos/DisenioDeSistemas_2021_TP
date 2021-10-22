package com.utn.infraestructura.persistencia;

import com.utn.dominio.Usuarios;
import com.utn.dominio.autenticacion.Usuario;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuariosEnMySQL implements Usuarios {

    @Override
    public Optional<Usuario> obtenerPorNombreUsuario(String nombreUsuario) {
        EntityManagerHelper.beginTransaction();

        Usuario unUsuario = (Usuario) EntityManagerHelper
                .getEntityManager()
                .createQuery("from Usuario usu where usu.usuario = '" + nombreUsuario + "'")
                .getSingleResult();
        EntityManagerHelper.commit();

        return Optional.of(unUsuario);
    }

}