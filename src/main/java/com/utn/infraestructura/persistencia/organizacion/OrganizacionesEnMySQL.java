package com.utn.infraestructura.persistencia.organizacion;

import com.utn.dominio.Organizaciones;
import com.utn.dominio.organizacion.Organizacion;
import org.springframework.stereotype.Repository;

import com.utn.infraestructura.persistencia.EntityManagerHelper;

import java.util.List;

@Repository
public class OrganizacionesEnMySQL implements Organizaciones {


    @Override
    public List<Organizacion> obtenerTodas(){
        return null;
    }

    @Override
    public Organizacion obtenerPorId(int idOrganizacion)
    {

        EntityManagerHelper.beginTransaction();

        Organizacion unaOrganizacion = (Organizacion) EntityManagerHelper.getEntityManager()
        .createQuery("from Organizacion org where org.id = " + idOrganizacion).getSingleResult();

        EntityManagerHelper.commit();
        return unaOrganizacion;
    }

    @Override
    public void guardar(Organizacion organizacion){
    }
}
