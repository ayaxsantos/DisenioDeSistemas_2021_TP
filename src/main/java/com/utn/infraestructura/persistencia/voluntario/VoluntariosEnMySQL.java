package com.utn.infraestructura.persistencia.voluntario;

import com.utn.dominio.Voluntarios;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.foto.CalidadFoto;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.organizacion.Voluntario;
import com.utn.infraestructura.persistencia.EntityManagerHelper;
import com.utn.infraestructura.persistencia.organizacion.JpaOrganizacion;
import com.utn.infraestructura.persistencia.usuario.JpaUsuario;
import org.springframework.stereotype.Repository;

@Repository
public class VoluntariosEnMySQL implements Voluntarios {

    public Voluntario obtenerPorNombreUsuario(String nombreUsuario) {
        EntityManagerHelper.beginTransaction();

        JpaVoluntario jpaVoluntario = (JpaVoluntario) EntityManagerHelper.getEntityManager()
            .createQuery("FROM JpaVoluntario vol WHERE EXISTS (FROM vol.usuarioJPA usr WHERE usr.usuario = '"
                    + nombreUsuario +"')").getSingleResult();

        EntityManagerHelper.commit();

        JpaOrganizacion organizacionJpa = jpaVoluntario.getOrganizacionJPA();
        JpaUsuario usuarioJpa = jpaVoluntario.getUsuarioJPA();

        //Organizacion organizacion = new Organizacion(nombre, direccion, null, CalidadFoto.BAJA);
        //Usuario usuario = new Usuario(usuarioJpa.getUsuario(), usuarioJpa.getContraseña());
        //Voluntario voluntario = new Voluntario(usuario, organizacion);
        return null;
    }

    /*@Override
    public Voluntario obtenerPorNumeroDNI(int numeroDNI) {
        EntityManagerHelper.beginTransaction();

        JpaVoluntario voluntarioJPA = (JpaVoluntario) EntityManagerHelper.getEntityManager()
                        .createQuery("FROM JpaVoluntario vol where vol.numeroDNI = "+ numeroDNI).getSingleResult();

        EntityManagerHelper.commit();

        Organizacion organizacion = new Organizacion(new TamañoFoto(32,16), CalidadFoto.BAJA);
        Usuario usuario = new Usuario(voluntarioJPA.getUsuarioJPA().getNombreUsuario(), voluntarioJPA.getUsuarioJPA().getContrasenia());
        Voluntario voluntario = new Voluntario(usuario, organizacion);

        return voluntario;
    }*/

    @Override
    public void guardar(Voluntario voluntario) {
        //JpaVoluntario jpaVoluntario = new JpaVoluntario();
        //jpaRepositorioVoluntario.guardar(jpaVoluntario);

        JpaVoluntario voluntarioJpa = new JpaVoluntario();
        JpaUsuario usuarioJpa = new JpaUsuario();
        JpaOrganizacion organizacionJpa = new JpaOrganizacion();

        usuarioJpa.setUsuario(voluntario.getUsuario().nombreUsuario());
        usuarioJpa.setContraseña(voluntario.getUsuario().getContraseña());

        voluntarioJpa.setUsuarioJPA(usuarioJpa);

        EntityManagerHelper.beginTransaction();

        EntityManagerHelper.persist(voluntarioJpa);

        EntityManagerHelper.commit();
    }
}
