package com.utn.dominio.autenticacion;

import java.util.List;
import java.util.ArrayList;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.excepcion.CredencialesInvalidasException;
import com.utn.dominio.excepcion.OrganizacionNoEncontradaException;

public class Usuario {

    private final String usuario;
    private final String contraseña;
    private final List<Organizacion> organizacionesPertenecientes;
    private Organizacion organizacionActual;
    private boolean estaLogueado = false;

    public Usuario(String usuario, String contraseña) {
        ValidadorContraseña.ejecutar(contraseña);
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.organizacionesPertenecientes = new ArrayList<>();
    }

    public boolean existe(String unUsuario) {
        return this.usuario.equals(unUsuario);
    }

    public void iniciarSesion(String usuario, String contraseña) {
        if(!this.usuario.equals(usuario) || !this.contraseña.equals(contraseña))
            throw new CredencialesInvalidasException();
        this.estaLogueado = true;
    }

    public void cerrarSesion() {
        this.estaLogueado = false;
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

}