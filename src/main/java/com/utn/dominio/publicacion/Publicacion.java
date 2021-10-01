package com.utn.dominio.publicacion;

import com.utn.dominio.persona.Persona;

import java.time.LocalDateTime;

public abstract class Publicacion {

    private final Persona persona;
    private boolean estaVisible;
    private final LocalDateTime fecha;

    public Publicacion(Persona persona) {
        this.persona = persona;
        this.estaVisible = false;
        this.fecha = LocalDateTime.now();
    }

    public void estaVisible(boolean estaVisible){
        this.estaVisible = estaVisible;
    }

}