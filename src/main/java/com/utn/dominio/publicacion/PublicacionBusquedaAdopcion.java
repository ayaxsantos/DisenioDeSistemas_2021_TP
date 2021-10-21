package com.utn.dominio.publicacion;

import java.util.List;
import java.util.ArrayList;

import com.utn.dominio.persona.Persona;

import javax.persistence.*;

@Entity
@Table(name = "publicacionBusquedaAdopcion")
public class PublicacionBusquedaAdopcion extends Publicacion {

    @ManyToOne(cascade = CascadeType.ALL)
    private Preferencia preferencia;

    @ElementCollection
    private List<String> comodidades;

    //TODO por que se pasa persona y una preferencia, cuando la misma preferencia se encuentra en la persona?
    public PublicacionBusquedaAdopcion(Persona personaAdoptante, Preferencia preferencia, List<String> comodidades) {
        super(personaAdoptante);
        this.preferencia = preferencia;
        this.comodidades = new ArrayList<>();
        this.comodidades.addAll(comodidades);
    }

    public PublicacionBusquedaAdopcion() {

    }
}