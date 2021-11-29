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
        this.organizacion.añadirCaracteristica(caracteristica);
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
