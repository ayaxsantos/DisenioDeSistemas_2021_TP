package com.utn.dominio.publicacion;

import java.util.List;
import java.util.ArrayList;

import com.utn.dominio.persona.Direccion;
import com.utn.dominio.persona.Persona;
import javax.persistence.*;

@Entity
@Table(name = "publicacionMascotaEncontrada")
public class PublicacionMascotaEncontrada extends Publicacion {

    @OneToOne(cascade = CascadeType.ALL)
    private Direccion ubicacionMascota;

    @Column
    private String estadoMascota;

    @ElementCollection
    private List<String> fotosMascota;

    public PublicacionMascotaEncontrada(Persona personaRescatista, Direccion ubicacionMascota, String estadoMascota) {
        super(personaRescatista);
        this.ubicacionMascota = ubicacionMascota;
        this.estadoMascota = estadoMascota;
        this.fotosMascota = new ArrayList<>();
    }

    public PublicacionMascotaEncontrada() {

    }
}