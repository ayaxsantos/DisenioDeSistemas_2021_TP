package com.utn.infraestructura.persistencia.usuario.jpa;

import com.utn.infraestructura.persistencia.administrador.jpa.JpaAdministrador;
import com.utn.infraestructura.persistencia.voluntario.jpa.JpaVoluntario;

import javax.persistence.*;

import com.utn.infraestructura.persistencia.persona.jpa.JpaPersona;


@Entity
@Table(name = "usuario")
public class JpaUsuario
{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombreUsuario",nullable = false)
    private String nombreUsuario;

    @Column(name = "contrasenia")
    private String contrasenia;

    @OneToOne
    private JpaPersona unaPersona;

    @OneToOne(mappedBy = "usuarioJPA")
    private JpaVoluntario unVoluntario;

    @OneToOne
    private JpaAdministrador unAdministrador;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public JpaPersona getUnaPersona() {
        return unaPersona;
    }

    public void setUnaPersona(JpaPersona unaPersona) {
        this.unaPersona = unaPersona;
    }

    public JpaVoluntario getUnVoluntario() {
        return unVoluntario;
    }

    public void setUnVoluntario(JpaVoluntario unVoluntario) {
        this.unVoluntario = unVoluntario;
    }

    public JpaAdministrador getUnAdministrador() {
        return unAdministrador;
    }

    public void setUnAdministrador(JpaAdministrador unAdministrador) {
        this.unAdministrador = unAdministrador;
    }
}


