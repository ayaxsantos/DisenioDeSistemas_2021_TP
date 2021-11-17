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

    public void estaVisible(boolean estaVisible){
        this.estaVisible = estaVisible;
    }

    public Persona getPersona() {
        return persona;
    }
}