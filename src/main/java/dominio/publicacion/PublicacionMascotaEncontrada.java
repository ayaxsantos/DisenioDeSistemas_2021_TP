package dominio.publicacion;

import dominio.persona.Direccion;
import dominio.persona.Persona;
import java.util.ArrayList;
import java.util.List;

public class PublicacionMascotaEncontrada extends Publicacion {

    private final Persona rescatista;
    private final Direccion ubicacionMascota;
    private final String estadoMascota;
    private final List<String> fotosMascota = new ArrayList<>();

    public PublicacionMascotaEncontrada(Persona rescatista, Direccion ubicacionMascota, String estadoMascota) {
        this.rescatista = rescatista;
        this.ubicacionMascota = ubicacionMascota;
        this.estadoMascota = estadoMascota;
    }

}