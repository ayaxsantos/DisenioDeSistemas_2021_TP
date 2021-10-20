package com.utn.infraestructura.persistencia.usuario;

import java.util.Optional;
import com.utn.dominio.Usuarios;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.infraestructura.persistencia.EntityManagerHelper;

import org.springframework.stereotype.Repository;

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