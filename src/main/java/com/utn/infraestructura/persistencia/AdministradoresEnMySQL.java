package com.utn.infraestructura.persistencia;

import com.utn.dominio.Administradores;
import com.utn.dominio.organizacion.Administrador;


public class AdministradoresEnMySQL implements Administradores
{
    @Override
    public Administrador obtenerPorNombreUsuario(String nombreUsuario)
    {
        EntityManagerHelper.beginTransaction();

        Administrador unAdministrador = (Administrador) EntityManagerHelper.getEntityManager()
                .createQuery( "FROM Administrador adm WHERE EXISTS (FROM Usuario usr WHERE usr.usuario = '"
                        + nombreUsuario +"' AND adm.usuario = usr)").getSingleResult();

        EntityManagerHelper.commit();
        return unAdministrador;
    }
}