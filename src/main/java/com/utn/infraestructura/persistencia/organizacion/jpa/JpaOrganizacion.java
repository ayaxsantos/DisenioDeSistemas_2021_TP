package com.utn.infraestructura.persistencia.organizacion.jpa;

import com.utn.infraestructura.persistencia.administrador.jpa.JpaAdministrador;
import com.utn.infraestructura.persistencia.voluntario.jpa.JpaVoluntario;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "organizacion")
public class JpaOrganizacion
{
    @Id
    @Column(name = "id_organizacion")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "nombre_organizacion")
    private String nombreOrganizacion;

    @Column(name = "id_direccion")
    private BigInteger idDireccion;

    @Column(name = "id_tamaño_foto")
    private BigInteger idTamañoFoto;

    @Column(name = "id_calidad_foto")
    private BigInteger idCalidadFoto;

    @OneToMany(mappedBy = "idOrganizacion")
    private List<JpaVoluntario> unosVoluntarios;

    @OneToMany(mappedBy = "idOrganizacion")
    private List<JpaAdministrador> unosAdministrador;

    //Generar accessors.

}
