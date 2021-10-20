package com.utn.infraestructura.persistencia.voluntario;

import com.utn.infraestructura.persistencia.organizacion.JpaOrganizacion;
import com.utn.infraestructura.persistencia.usuario.JpaUsuario;

import javax.persistence.*;

@Entity
@Table(name = "voluntario")
public class JpaVoluntario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private JpaUsuario usuarioJPA;

    @ManyToOne
    private JpaOrganizacion organizacionJPA;

    public JpaVoluntario(Integer id, JpaUsuario usuarioJPA, JpaOrganizacion organizacionJPA) {
        this.id = id;
        this.usuarioJPA = usuarioJPA;
        this.organizacionJPA = organizacionJPA;
    }

    public JpaVoluntario() {
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
