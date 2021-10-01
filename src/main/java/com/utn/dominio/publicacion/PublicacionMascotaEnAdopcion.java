package com.utn.dominio.publicacion;

import java.util.List;
import java.util.ArrayList;

import com.utn.dominio.persona.Persona;

public class PublicacionMascotaEnAdopcion extends Publicacion {

    private final List<String> respuestas = new ArrayList<>();
    private final int idMascota;

    public PublicacionMascotaEnAdopcion(Persona personaDueño, int idMascota, List<String> respuestas) {
        super(personaDueño);
        this.idMascota = idMascota;
        this.respuestas.addAll(respuestas);
    }

}