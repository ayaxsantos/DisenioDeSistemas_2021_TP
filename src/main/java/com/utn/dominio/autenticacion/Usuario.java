package com.utn.dominio.autenticacion;

import com.utn.dominio.EntidadPersistente;
import com.utn.dominio.excepcion.CredencialesInvalidasException;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario extends EntidadPersistente {

    @Column
    private String usuario;

    @Column
    private String contrasenia;

    @Transient
    private boolean estaLogueado = false;

    public Usuario() {}

    public Usuario(String usuario, String contrasenia) {
        ValidadorContraseña.ejecutar(contrasenia);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public void iniciarSesion(String usuario, String contraseña) {
        if(!this.usuario.equals(usuario) || !this.contrasenia.equals(contraseña))
            throw new CredencialesInvalidasException();
        this.estaLogueado = true;
    }

    public void cerrarSesion() {
        this.estaLogueado = false;
    }

    public void setNombreUsuario(String nombreUsuario)
    {
        this.usuario = nombreUsuario;
    }

    public String nombreUsuario() {
        return this.usuario;
    }

    public boolean estaLogueado() {
        return estaLogueado;
    }

    public void setEstaLogueado(boolean estaLogueado) {
        this.estaLogueado = estaLogueado;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

}
/*
@Entity
@Table(name = "usuario")
public class Usuario extends EntidadPersistente {

    @Column
    private String usuario;

    @Column
    private String contraseña;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Organizacion> organizacionesPertenecientes;

    @Transient
    private Organizacion organizacionActual;

    @Transient
    private boolean estaLogueado = false;

    public Usuario() {}

    public Usuario(String usuario, String contraseña) {
        ValidadorContraseña.ejecutar(contraseña);
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.organizacionesPertenecientes = new ArrayList<>();
    }

    public void iniciarSesion(String usuario, String contraseña) {
        if(!this.usuario.equals(usuario) || !this.contraseña.equals(contraseña))
            throw new CredencialesInvalidasException();
        this.estaLogueado = true;
    }

    public void cerrarSesion() {
        this.estaLogueado = false;
    }

    public void setNombreUsuario(String nombreUsuario)
    {
        this.usuario = nombreUsuario;
    }

    public void elegirOrganizacionActual(Organizacion unaOrganizacion) {
        this.organizacionActual = this.organizacionesPertenecientes.stream()
            .filter(organizacion -> organizacion.equals(unaOrganizacion))
            .findFirst()
            .orElseThrow(OrganizacionNoEncontradaException::new);
    }

    public void añadirOrganizacion(Organizacion organizacion) {
        this.organizacionesPertenecientes.add(organizacion);
    }

    public String nombreUsuario() {
        return this.usuario;
    }

    public boolean estaLogueado() {
        return estaLogueado;
    }

    public void setEstaLogueado(boolean estaLogueado) {
        this.estaLogueado = estaLogueado;
    }

    public List<Organizacion> organizacionesPertenecientes() {
        return organizacionesPertenecientes;
    }

    public Organizacion organizacionActual() {
        return organizacionActual;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setOrganizacionesPertenecientes(List<Organizacion> unasOrganizaciones) {
        this.organizacionesPertenecientes.addAll(unasOrganizaciones);
    }

    public String getUsuario() {
        return usuario;
    }

}*/
