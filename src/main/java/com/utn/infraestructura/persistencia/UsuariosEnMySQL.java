package com.utn.infraestructura.persistencia;

import com.utn.dominio.Usuarios;
import com.utn.dominio.autenticacion.Usuario;

import java.util.Optional;


public class UsuariosEnMySQL implements Usuarios {

    @Override
    public Optional<Usuario> obtenerPorNombreUsuario(String nombreUsuario) {
        EntityManagerHelper.beginTransaction();

        Usuario unUsuario = (Usuario) EntityManagerHelper
                .getEntityManager()
                .createQuery("select usu from Usuario usu where usu.usuario = ?1",Usuario.class)
                .setParameter(1,nombreUsuario)
                .getSingleResult();

        EntityManagerHelper.commit();

        return Optional.of(unUsuario);
    }

}