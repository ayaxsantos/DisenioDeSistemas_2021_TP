package com.utn.infraestructura.persistencia.administrador.jpa;

import com.utn.infraestructura.persistencia.voluntario.jpa.JpaVoluntario;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "administrador")
public class JpaAdministrador
{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "id_organizacion")
    private Integer idOrganizacion;

    @OneToOne
    @JoinColumn(name = "id_voluntario",referencedColumnName = "id")
    private JpaVoluntario unVoluntario;
}
