package com.utn.dominio.organizacion;

import com.utn.dominio.EntidadPersistencia;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.foto.TamañoFoto;

import javax.persistence.*;

@Entity
@Table(name = "administrador")
public class Administrador extends EntidadPersistencia {

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    private Organizacion organizacion;

    public Administrador(Usuario usuario, Organizacion organizacion) {
        this.organizacion = organizacion;
        this.usuario = usuario;
    }

    public Administrador()
    {

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

    public Usuario getUsuario() {
        return usuario;
    }

}