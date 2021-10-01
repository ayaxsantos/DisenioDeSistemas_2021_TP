package com.utn.dominio.organizacion;

import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.foto.TamañoFoto;

public class Administrador {

    private final Usuario usuario;
    private final Organizacion organizacion;

    public Administrador(Usuario usuario, Organizacion organizacion) {
        this.organizacion = organizacion;
        this.usuario = usuario;
    }

    public void definirTamañoFoto(TamañoFoto unTamaño) {
        organizacion.tamañoFoto(unTamaño);
    }

    public void definirCalidadFoto(String calidad) {
        organizacion.calidadFoto(calidad);
    }

    public void añadirCaracteristica(String caracteristica) {
        organizacion.añadirCaracteristica(caracteristica);
    }

    public void quitarCaracteristica(String caracteristica) {
        organizacion.quitarCaracteristica(caracteristica);
    }

    public Administrador darAltaNuevoAdministrador(Usuario usuario, Organizacion organizacion) {
        return new Administrador(usuario, organizacion);
    }

}