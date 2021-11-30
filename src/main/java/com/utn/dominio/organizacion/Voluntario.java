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
        publicacion.setEstaVisible(true);
    }

    public void rechazarPublicacion(Publicacion publicacion) {
        publicacion.setEstaVisible(false);
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }
}