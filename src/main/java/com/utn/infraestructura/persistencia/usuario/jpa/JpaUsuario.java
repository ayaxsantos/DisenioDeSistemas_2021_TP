package com.utn.infraestructura.persistencia.usuario.jpa;

import com.utn.infraestructura.persistencia.administrador.jpa.JpaAdministrador;
import com.utn.infraestructura.persistencia.voluntario.jpa.JpaVoluntario;

import javax.persistence.*;
import java.math.BigInteger;

import com.utn.infraestructura.persistencia.persona.jpa.JpaPersona;


@Entity
@Table(name = "usuario")
public class JpaUsuario
{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "nombreUsuario",nullable = false)
    private String nombreUsuario;

    @Column(name = "contrasenia")
    private BigInteger contrasenia;

    @Column(name = "id_persona")
    private BigInteger idPersona;

    @OneToOne
    @JoinColumn(name = "id_persona",referencedColumnName = "id")
    private JpaPersona unaPersona;

    @OneToOne
    @JoinColumn(name = "id_voluntario",referencedColumnName = "id")
    private JpaVoluntario unVoluntario;

    @OneToOne
    @JoinColumn(name = "id_administrador",referencedColumnName = "id")
    private JpaAdministrador unAdministrador;

    //FK joinear con tablas

    //Generar accessors porfa

}


