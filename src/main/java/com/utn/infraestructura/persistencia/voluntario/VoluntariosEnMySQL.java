package com.utn.infraestructura.persistencia.voluntario;

import com.utn.dominio.Voluntarios;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.foto.CalidadFoto;
import com.utn.dominio.foto.TamañoFoto;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.organizacion.Voluntario;
import com.utn.infraestructura.persistencia.EntityManagerHelper;
import com.utn.infraestructura.persistencia.organizacion.jpa.JpaOrganizacion;
import com.utn.infraestructura.persistencia.usuario.jpa.JpaUsuario;
import com.utn.infraestructura.persistencia.voluntario.jpa.JpaRepositorioVoluntario;
import com.utn.infraestructura.persistencia.voluntario.jpa.JpaVoluntario;
import org.springframework.stereotype.Repository;

@Repository
public class VoluntariosEnMySQL implements Voluntarios {

    private final JpaRepositorioVoluntario jpaRepositorioVoluntario;

    public VoluntariosEnMySQL(JpaRepositorioVoluntario jpaRepositorioVoluntario) {
        this.jpaRepositorioVoluntario = jpaRepositorioVoluntario;
    }

    public Voluntario obtenerPorNombreUsuario(String nombreUsuario) {
        EntityManagerHelper.beginTransaction();

        JpaVoluntario jpaVoluntario = (JpaVoluntario) EntityManagerHelper.getEntityManager()
            .createQuery("select vol.id, vol.usuarioJPA, vol.organizacionJPA from JpaVoluntario vol, vol.usuarioJPA usr where usr.nombreUsuario = '" + nombreUsuario + "'").getSingleResult();

        EntityManagerHelper.commit();

        JpaOrganizacion organizacionJpa = jpaVoluntario.getOrganizacionJPA();
        JpaUsuario usuarioJpa = jpaVoluntario.getUsuarioJPA();

        Organizacion organizacion = new Organizacion(new TamañoFoto(32,16), CalidadFoto.BAJA);
        Usuario usuario = new Usuario(usuarioJpa.getNombreUsuario(), usuarioJpa.getContrasenia());
        Voluntario voluntario = new Voluntario(usuario, organizacion);
        return voluntario;
    }

    public void guardar(Voluntario voluntario) {
        //JpaVoluntario jpaVoluntario = new JpaVoluntario();
        //jpaRepositorioVoluntario.guardar(jpaVoluntario);

        JpaVoluntario voluntarioJpa = new JpaVoluntario();
        JpaUsuario usuarioJpa = new JpaUsuario();
        JpaOrganizacion organizacionJpa = new JpaOrganizacion();

        usuarioJpa.setNombreUsuario(voluntario.getUsuario().nombreUsuario());
        usuarioJpa.setContrasenia(voluntario.getUsuario().getContraseña());

        voluntarioJpa.setUsuarioJPA(usuarioJpa);

        EntityManagerHelper.beginTransaction();

        EntityManagerHelper.persist(voluntarioJpa);

        EntityManagerHelper.commit();
    }
}
