package com.utn.infraestructura.persistencia.voluntario.jpa;

import com.utn.dominio.organizacion.Organizacion;
import com.utn.infraestructura.persistencia.organizacion.jpa.JpaOrganizacion;
import com.utn.infraestructura.persistencia.usuario.jpa.JpaUsuario;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "voluntario")
public class JpaVoluntario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer numeroDNI;

    @OneToOne(cascade = CascadeType.ALL)
    private JpaUsuario usuarioJPA;

    @ManyToOne
    private JpaOrganizacion organizacionJPA;

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

    public Integer getNumeroDNI() {
        return numeroDNI;
    }

    public void setNumeroDNI(Integer numeroDNI) {
        this.numeroDNI = numeroDNI;
    }
}
