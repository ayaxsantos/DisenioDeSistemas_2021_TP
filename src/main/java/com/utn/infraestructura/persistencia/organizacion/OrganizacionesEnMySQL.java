package com.utn.infraestructura.persistencia.organizacion;

import com.utn.dominio.Organizaciones;
import com.utn.dominio.foto.CalidadFoto;
import com.utn.dominio.foto.TamañoFoto;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.persona.Direccion;
import com.utn.infraestructura.persistencia.calidadFoto.JpaCalidadFoto;
import com.utn.infraestructura.persistencia.direccion.JpaDireccion;
import com.utn.infraestructura.persistencia.tamañoFoto.JpaTamañoFoto;
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

        JpaOrganizacion jpaOrganizacion = (JpaOrganizacion) EntityManagerHelper.getEntityManager()
        .createQuery("from JpaOrganizacion org where org.id = " + idOrganizacion).getSingleResult();

        EntityManagerHelper.commit();
        Organizacion unaOrganizacion = this.convertirOrganizacion(jpaOrganizacion);
        return unaOrganizacion;
    }

    @Override
    public void guardar(Organizacion organizacion){
        JpaOrganizacion jpaOrganizacion = new JpaOrganizacion();
    }

    // Nota de Ayax: Codigo Repetido!!!!!!! Abstraer!!!!!!!!!!
    public Organizacion convertirOrganizacion(JpaOrganizacion jpaOrganizacion)
    {
        JpaDireccion direccionObtenida = jpaOrganizacion.getDireccionJPA();
        Direccion unaDireccion = new Direccion(direccionObtenida.getLatitud(), direccionObtenida.getLongitud());

        TamañoFoto unTamaño = this.conversionToTamañoFoto(jpaOrganizacion.getTamañoFotoJPA());
        CalidadFoto unaCalidad = this.conversionToCalidadFoto(jpaOrganizacion.getCalidadFotoJPA());

        Organizacion unaOrganizacion = new Organizacion(jpaOrganizacion.getNombre(),
                unaDireccion,
                unTamaño,
                unaCalidad);

        return unaOrganizacion;
    }

    public TamañoFoto conversionToTamañoFoto(JpaTamañoFoto tamañoObtenido)
    {
        return TamañoFoto.values()[tamañoObtenido.ordinal()];
    }

    public CalidadFoto conversionToCalidadFoto(JpaCalidadFoto calidadObtenida)
    {
        return CalidadFoto.values()[calidadObtenida.ordinal()];
    }

}
