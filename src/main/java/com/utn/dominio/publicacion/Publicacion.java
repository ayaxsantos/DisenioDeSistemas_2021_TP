package com.utn.dominio.publicacion;

import com.utn.dominio.EntidadPersistente;
import com.utn.dominio.persona.Persona;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Publicacion extends EntidadPersistente {

    @Column
    private boolean estaVisible;

    @Column
    private LocalDate fecha;

    @ManyToOne(cascade = CascadeType.ALL)
    private Persona persona;

    public Publicacion(Persona persona) {
        this.persona = persona;
        this.estaVisible = false;
        this.fecha = LocalDate.now();
    }

    public Publicacion() {

    }

    public boolean isEstaVisible() {
        return estaVisible;
    }

    public void setEstaVisible(boolean estaVisible) {
        this.estaVisible = estaVisible;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}