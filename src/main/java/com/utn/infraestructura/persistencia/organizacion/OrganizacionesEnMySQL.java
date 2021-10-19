package com.utn.infraestructura.persistencia.organizacion;

import com.utn.dominio.Organizaciones;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.infraestructura.persistencia.organizacion.jpa.JpaOrganizacion;
import com.utn.infraestructura.persistencia.organizacion.jpa.JpaRepositorioOrganizaciones;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganizacionesEnMySQL implements Organizaciones {

    private final JpaRepositorioOrganizaciones jpaRepositorioOrganizaciones;

    public OrganizacionesEnMySQL(JpaRepositorioOrganizaciones jpaRepositorioOrg) {
        this.jpaRepositorioOrganizaciones = jpaRepositorioOrg;
    }

    @Override
    public List<Organizacion> obtenerTodas(){
        List<JpaOrganizacion> jpaOrganizaciones = jpaRepositorioOrganizaciones.obtenerTodos();
        return null;
    }

    @Override
    public Organizacion obtenerPorId(int idOrganizacion){
        JpaOrganizacion jpaOrganizacion = jpaRepositorioOrganizaciones.obtenerPorId(idOrganizacion);
        return null;
    }

    @Override
    public void guardar(Organizacion organizacion){
        JpaOrganizacion jpaOrganizacion = new JpaOrganizacion();
        jpaRepositorioOrganizaciones.guardar(jpaOrganizacion);
    }

}
