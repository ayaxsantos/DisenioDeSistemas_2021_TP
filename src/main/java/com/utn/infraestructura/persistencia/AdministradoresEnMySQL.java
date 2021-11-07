package com.utn.infraestructura.persistencia;

import com.utn.dominio.Administradores;
import com.utn.dominio.organizacion.Administrador;


public class AdministradoresEnMySQL implements Administradores
{
    @Override
    public Administrador obtenerPorId(int idAdministrador)
    {
        EntityManagerHelper.beginTransaction();

        Administrador unAdministrador = (Administrador) EntityManagerHelper.getEntityManager()
                .createQuery( "FROM Administrador adm WHERE adm.id = " + idAdministrador)
                .getResultList();

        EntityManagerHelper.commit();
        return unAdministrador;
    }
}