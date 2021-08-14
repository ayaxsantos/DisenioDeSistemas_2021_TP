package dominio.publicacion;

import dominio.persona.Direccion;
import dominio.persona.Persona;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Publicacion {

    private final Persona rescatista;
    private final Direccion ubicacionMascota;
    private final String estadoMascota;
    private final List<String> fotosMascota = new ArrayList<>();
    private final LocalDateTime fecha;
    private boolean estaVisible;

    public Publicacion(Persona rescatista, Direccion ubicacionMascota, String estadoMascota) {
        this.rescatista = rescatista;
        this.ubicacionMascota = ubicacionMascota;
        this.estadoMascota = estadoMascota;
        this.fecha = LocalDateTime.now();
        this.estaVisible = false;
    }

    public void estaVisible(boolean estaVisible){
        this.estaVisible = estaVisible;
    }

}