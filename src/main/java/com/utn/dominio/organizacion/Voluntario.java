package com.utn.dominio.organizacion;

import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.publicacion.Publicacion;

public class Voluntario {

    private final int numeroDNI;
    private final Usuario usuario;
    private final Organizacion organizacion;

    public Voluntario(int numeroDNI, Usuario usuario, Organizacion organizacion) {
        this.numeroDNI = numeroDNI;
        this.usuario = usuario;
        this.organizacion = organizacion;
    }

    public void aprobarPublicacion(Publicacion publicacion){
        publicacion.estaVisible(true);
    }

    public void rechazarPublicacion(Publicacion publicacion) {
        publicacion.estaVisible(false);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public int getNumeroDNI() {
        return numeroDNI;
    }
}