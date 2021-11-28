package com.utn.dominio.organizacion;

import com.utn.dominio.autenticacion.Usuario;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Administrador extends Usuario {

    @ManyToOne(cascade = CascadeType.ALL)
    private Organizacion organizacion;

    public Administrador(String usuario, String contrasenia, Organizacion organizacion) {
        super(usuario, contrasenia);
        this.organizacion = organizacion;
    }

    public Administrador() {
    }

    public void definirTamañoFoto(TamañoFoto unTamaño) {
        organizacion.tamañoFoto(unTamaño);
    }

    public void definirCalidadFoto(CalidadFoto unaCalidad) {
        organizacion.calidadFoto(unaCalidad);
    }

    public void añadirCaracteristica(String caracteristica) {
        organizacion.añadirCaracteristica(caracteristica);
    }

    public void darAltaNuevoAdministrador(String usuario, String contrasenia) {
        Administrador adminNuevo = new Administrador(usuario, contrasenia, this.organizacion);
        this.organizacion.añadirAdministrador(adminNuevo);
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public String nombreOrganizacionAdministrada()
    {
        return this.organizacion.getNombre();
    }
}

/*
@Entity
@Table(name = "administrador")
public class Administrador extends EntidadPersistente {

    @Column
    private String usuario;

    @Column
    private String contrasenia;

    @ManyToOne(cascade = CascadeType.ALL)
    private Organizacion organizacion;

    @Transient
    private boolean estaLogueado = false;

    public Administrador(String usuario, String contrasenia, Organizacion organizacion) {
        ValidadorContraseña.ejecutar(contrasenia);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.organizacion = organizacion;
    }

    public Administrador()
    {

    }

    public void definirTamañoFoto(TamañoFoto unTamaño) {
        organizacion.tamañoFoto(unTamaño);
    }

    public void definirCalidadFoto(CalidadFoto unaCalidad) {
        organizacion.calidadFoto(unaCalidad);
    }

    public void añadirCaracteristica(String caracteristica) {
        organizacion.añadirCaracteristica(caracteristica);
    }

    public void darAltaNuevoAdministrador(String usuario, String contrasenia) {
        Administrador adminNuevo = new Administrador(usuario, contrasenia, this.organizacion);
        this.organizacion.añadirAdministrador(adminNuevo);
    }

    public void iniciarSesion(String usuario, String contraseña) {
        if(!this.usuario.equals(usuario) || !this.contrasenia.equals(contraseña))
            throw new CredencialesInvalidasException();
        this.estaLogueado = true;
    }

    public void cerrarSesion() {
        this.estaLogueado = false;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }
}*/
