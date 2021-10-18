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
    @Column(name = "id_voluntario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private JpaUsuario usuarioJPA;


    @ManyToOne
    private JpaOrganizacion organizacion;

    public JpaVoluntario() {
    }


    //@JoinColumn(name = "id_organizacion",referencedColumnName = "id")
    //private JpaOrganizacion OrganizacionJpa;


    //Generar accessors.

}
