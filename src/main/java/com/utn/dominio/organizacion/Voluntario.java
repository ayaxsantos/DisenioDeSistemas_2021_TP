package com.utn.dominio.organizacion;

import com.utn.dominio.EntidadPersistencia;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.publicacion.Publicacion;

import javax.persistence.*;

@Entity
@Table(name = "voluntario")
public class Voluntario extends EntidadPersistencia {

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_organizacion", referencedColumnName = "id")
    private Organizacion organizacion;

    public Voluntario(Usuario usuario, Organizacion organizacion) {
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }
}