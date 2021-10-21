package com.utn.dominio.publicacion;

import java.util.List;
import java.util.ArrayList;

import com.utn.dominio.animal.Mascota;
import com.utn.dominio.persona.Persona;

import javax.persistence.*;

@Entity
@Table(name = "publicacionMascotaEnAdopcion")
public class PublicacionMascotaEnAdopcion extends Publicacion {

    @ElementCollection
    private List<String> respuestas = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private Mascota mascota;

    public PublicacionMascotaEnAdopcion(Persona personaDueño, Mascota mascota, List<String> respuestas) {
        super(personaDueño);
        this.mascota = mascota;
        this.respuestas.addAll(respuestas);
    }

    public PublicacionMascotaEnAdopcion() {

    }

    public Preferencia obtenerFisionomia() {
        return new Preferencia(mascota.getSexo(), mascota.getAnimal(), mascota.getTamaño());
    }

    public Mascota getMascota() {
        return mascota;
    }

}