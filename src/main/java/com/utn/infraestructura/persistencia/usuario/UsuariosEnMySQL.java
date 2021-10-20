package com.utn.infraestructura.persistencia.usuario;

import java.util.ArrayList;
import java.util.List;

import com.utn.dominio.Usuarios;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.infraestructura.persistencia.EntityManagerHelper;
import org.springframework.stereotype.Repository;

@Repository
public class UsuariosEnMySQL implements Usuarios {

    @Override
    public Usuario obtenerPorNombreUsuario(String nombreUsuario)
    {
        EntityManagerHelper.beginTransaction();
        Usuario unUsuario = (Usuario) EntityManagerHelper.getEntityManager()
                .createQuery("from Usuario usu where usu.usuario = '" + nombreUsuario + "'").getSingleResult();

        EntityManagerHelper.commit();

        return unUsuario;
    }

}
