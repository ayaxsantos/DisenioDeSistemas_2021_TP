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
            .createQuery("FROM JpaVoluntario vol WHERE EXISTS (FROM vol.usuarioJPA usr WHERE usr.nombreUsuario = '"
                    + nombreUsuario +"')").getSingleResult();

        EntityManagerHelper.commit();

        JpaOrganizacion organizacionJpa = jpaVoluntario.getOrganizacionJPA();
        JpaUsuario usuarioJpa = jpaVoluntario.getUsuarioJPA();

        Organizacion organizacion = new Organizacion(new TamañoFoto(32,16), CalidadFoto.BAJA);
        Usuario usuario = new Usuario(usuarioJpa.getNombreUsuario(), usuarioJpa.getContrasenia());
        Voluntario voluntario = new Voluntario(5488759, usuario, organizacion);
        return voluntario;
    }

    @Override
    public Voluntario obtenerPorNumeroDNI(int numeroDNI) {
        EntityManagerHelper.beginTransaction();

        JpaVoluntario voluntarioJPA = (JpaVoluntario) EntityManagerHelper.getEntityManager()
                        .createQuery("FROM JpaVoluntario vol where vol.numeroDNI = "+ numeroDNI).getSingleResult();

        EntityManagerHelper.commit();

        Organizacion organizacion = new Organizacion(new TamañoFoto(32,16), CalidadFoto.BAJA);
        Usuario usuario = new Usuario(voluntarioJPA.getUsuarioJPA().getNombreUsuario(), voluntarioJPA.getUsuarioJPA().getContrasenia());
        Voluntario voluntario = new Voluntario(voluntarioJPA.getNumeroDNI(), usuario, organizacion);

        return voluntario;
    }

    @Override
    public void guardar(Voluntario voluntario) {
        //JpaVoluntario jpaVoluntario = new JpaVoluntario();
        //jpaRepositorioVoluntario.guardar(jpaVoluntario);

        JpaVoluntario voluntarioJpa = new JpaVoluntario();
        JpaUsuario usuarioJpa = new JpaUsuario();
        JpaOrganizacion organizacionJpa = new JpaOrganizacion();

        usuarioJpa.setNombreUsuario(voluntario.getUsuario().nombreUsuario());
        usuarioJpa.setContrasenia(voluntario.getUsuario().getContraseña());

        voluntarioJpa.setUsuarioJPA(usuarioJpa);
        voluntarioJpa.setNumeroDNI(voluntario.getNumeroDNI());

        EntityManagerHelper.beginTransaction();

        EntityManagerHelper.persist(voluntarioJpa);

        EntityManagerHelper.commit();
    }
}
