package com.utn.infraestructura.persistencia.usuario;

import com.utn.infraestructura.persistencia.organizacion.JpaOrganizacion;

import javax.persistence.*;

import java.util.List;


@Entity
@Table(name = "usuario")
public class JpaUsuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String usuario;

    @Column
    private String contraseña;

    @Column
    private boolean estaLogueado;

    @ManyToMany
    private List<JpaOrganizacion> organizacionesJPA;

    public JpaUsuario(Integer id, String usuario, String contraseña, boolean estaLogueado, List<JpaOrganizacion> organizacionesJPA) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.estaLogueado = estaLogueado;
        this.organizacionesJPA = organizacionesJPA;
    }

    public JpaUsuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isEstaLogueado() {
        return estaLogueado;
    }

    public void setEstaLogueado(boolean estaLogueado) {
        this.estaLogueado = estaLogueado;
    }

    public List<JpaOrganizacion> getOrganizacionesJPA() {
        return organizacionesJPA;
    }

    public void setOrganizacionesJPA(List<JpaOrganizacion> organizacionesJPA) {
        this.organizacionesJPA = organizacionesJPA;
    }
}


