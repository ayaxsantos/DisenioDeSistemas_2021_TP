package com.utn.dominio.organizacion;

import com.utn.dominio.EntidadPersistente;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.autenticacion.ValidadorContraseña;
import com.utn.dominio.excepcion.CredencialesInvalidasException;
import com.utn.dominio.publicacion.Publicacion;
import com.utn.dominio.publicacion.PublicacionBusquedaAdopcion;
import com.utn.dominio.publicacion.PublicacionMascotaEnAdopcion;
import com.utn.dominio.publicacion.PublicacionMascotaEncontrada;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

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

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public List<PublicacionMascotaEncontrada> getPublicacionesMascotaEncontradaPendientes() {
        return this.organizacion.getPublicacionesMascotaEncontrada().stream()
                .filter(publicacion -> !publicacion.isEstaVisible()).collect(Collectors.toList());
    }

    public List<PublicacionMascotaEnAdopcion> getPublicacionesMascotaEnAdopcionPendientes() {
        return this.organizacion.getPublicacionesMascotaEnAdopcion().stream().
                filter(publicacion -> !publicacion.isEstaVisible()).collect(Collectors.toList());
    }

    public List<PublicacionBusquedaAdopcion> getPublicacionesBusquedaAdopcionPendientes() {
        return this.organizacion.getPublicacionesBusquedaAdopcion().stream().
                filter(publicacion -> !publicacion.isEstaVisible()).collect(Collectors.toList());
    }
}