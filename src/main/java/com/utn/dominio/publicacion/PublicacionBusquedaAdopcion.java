package com.utn.dominio.publicacion;

import java.util.List;
import java.util.ArrayList;

import com.utn.dominio.persona.Persona;

public class PublicacionBusquedaAdopcion extends Publicacion {

    private final Preferencia preferencia;
    private final List<String> comodidades = new ArrayList<>();

    public PublicacionBusquedaAdopcion(Persona personaAdoptante, Preferencia preferencia, List<String> comodidades) {
        super(personaAdoptante);
        this.preferencia = preferencia;
        this.comodidades.addAll(comodidades);
    }

}