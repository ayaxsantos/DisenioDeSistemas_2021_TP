package com.utn.infraestructura.persistencia.usuario;

import java.util.ArrayList;
import java.util.List;

import com.utn.dominio.Usuarios;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.persona.Direccion;
import com.utn.dominio.foto.TamañoFoto;
import com.utn.dominio.foto.CalidadFoto;
import com.utn.infraestructura.persistencia.calidadFoto.JpaCalidadFoto;
import com.utn.infraestructura.persistencia.direccion.JpaDireccion;
import com.utn.infraestructura.persistencia.organizacion.JpaOrganizacion;
import com.utn.infraestructura.persistencia.EntityManagerHelper;
import com.utn.infraestructura.persistencia.tamañoFoto.JpaTamañoFoto;
import org.springframework.stereotype.Repository;

@Repository
public class UsuariosEnMySQL implements Usuarios {

    @Override
    public Usuario obtenerPorNombreUsuario(String nombreUsuario)
    {
        EntityManagerHelper.beginTransaction();
        JpaUsuario jpaUsuario = (JpaUsuario) EntityManagerHelper.getEntityManager()
                .createQuery("from JpaUsuario usu where usu.usuario = '" + nombreUsuario + "'").getSingleResult();

        EntityManagerHelper.commit();

        Usuario unUsuario = new Usuario(jpaUsuario.getUsuario(),jpaUsuario.getContraseña());

        List<JpaOrganizacion> organizacionesObtenidas = jpaUsuario.getOrganizacionesJPA();
        List<Organizacion> unasOrganizaciones = new ArrayList<>();

        organizacionesObtenidas.forEach(unaOrganizacionJpa ->
                unasOrganizaciones.add(this.convertirOrganizacion(unaOrganizacionJpa)));

        unUsuario.setOrganizacionesPertenecientes(unasOrganizaciones);
        return unUsuario;
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
