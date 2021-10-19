package com.utn.infraestructura.persistencia.organizacion.jpa;

import com.utn.dominio.Voluntarios;
import com.utn.dominio.organizacion.Voluntario;
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
    private Integer id;

    @OneToMany(mappedBy = "organizacionJPA")
    private List<JpaVoluntario> voluntarios;

    @OneToMany(mappedBy = "idOrganizacion")
    private List<JpaAdministrador> unosAdministrador;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<JpaVoluntario> getVoluntarios() {
        return voluntarios;
    }

    public void setVoluntarios(List<JpaVoluntario> voluntarios) {
        this.voluntarios = voluntarios;
    }

    public List<JpaAdministrador> getUnosAdministrador() {
        return unosAdministrador;
    }

    public void setUnosAdministrador(List<JpaAdministrador> unosAdministrador) {
        this.unosAdministrador = unosAdministrador;
    }

    //Generar accessors.

}
