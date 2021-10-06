package com.utn.infraestructura.persistencia.voluntario.jpa;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "voluntario")
public class JpaVoluntario
{
    @Id
    @Column(name = "id_voluntario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "id_usuario")
    private BigInteger idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_organizacion",referencedColumnName = "id")
    private BigInteger idOrganizacion;


    //Generar accessors.

}
