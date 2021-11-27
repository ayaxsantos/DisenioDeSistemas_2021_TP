package com.utn.dominio.organizacion;

import com.utn.dominio.EntidadPersistente;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.autenticacion.ValidadorContraseña;
import com.utn.dominio.excepcion.CredencialesInvalidasException;
import com.utn.dominio.publicacion.Publicacion;

import javax.persistence.*;

@Entity
public class Voluntario extends Usuario {

    @ManyToOne(cascade = CascadeType.ALL)
    private Organizacion organizacion;

    public Voluntario(String usuario, String contrasenia, Organizacion organizacion) {
        super(usuario, contrasenia);
        this.organizacion = organizacion;
    }

    public Voluntario() {

    }

    public void aprobarPublicacion(Publicacion publicacion){
        publicacion.estaVisible(true);
    }

    public void rechazarPublicacion(Publicacion publicacion) {
        publicacion.estaVisible(false);
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }
}

/*

@Entity
@Table(name = "voluntario")
public class Voluntario extends EntidadPersistente {

    @Column
    private String usuario;

    @Column
    private String contrasenia;

    @ManyToOne(cascade = CascadeType.ALL)
    private Organizacion organizacion;

    @Transient
    private boolean estaLogueado = false;

    public Voluntario(String usuario, String contrasenia, Organizacion organizacion) {
        ValidadorContraseña.ejecutar(contrasenia);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.organizacion = organizacion;
    }

    public Voluntario() {

    }

    public void aprobarPublicacion(Publicacion publicacion){
        publicacion.estaVisible(true);
    }

    public void rechazarPublicacion(Publicacion publicacion) {
        publicacion.estaVisible(false);
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
