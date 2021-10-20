package com.utn.infraestructura.persistencia.administrador;

import com.utn.infraestructura.persistencia.organizacion.JpaOrganizacion;
import com.utn.infraestructura.persistencia.usuario.JpaUsuario;
import com.utn.infraestructura.persistencia.voluntario.JpaVoluntario;

import javax.persistence.*;

@Entity
@Table(name = "administrador")
public class JpaAdministrador
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private JpaUsuario usuarioJPA;

    @ManyToOne
    private JpaOrganizacion organizacionJPA;

    public JpaAdministrador(Integer id, JpaUsuario usuarioJPA, JpaOrganizacion organizacionJPA) {
        this.id = id;
        this.usuarioJPA = usuarioJPA;
        this.organizacionJPA = organizacionJPA;
    }

    public JpaAdministrador() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JpaUsuario getUsuarioJPA() {
        return usuarioJPA;
    }

    public void setUsuarioJPA(JpaUsuario usuarioJPA) {
        this.usuarioJPA = usuarioJPA;
    }

    public JpaOrganizacion getOrganizacionJPA() {
        return organizacionJPA;
    }

    public void setOrganizacionJPA(JpaOrganizacion organizacionJPA) {
        this.organizacionJPA = organizacionJPA;
    }
}
