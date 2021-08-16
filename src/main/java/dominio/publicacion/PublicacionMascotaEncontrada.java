package dominio.publicacion;

import java.util.List;
import java.util.ArrayList;

import dominio.persona.Direccion;

public class PublicacionMascotaEncontrada extends Publicacion {

    private final Direccion ubicacionMascota;
    private final String estadoMascota;
    private final List<String> fotosMascota = new ArrayList<>();

    public PublicacionMascotaEncontrada(int numeroDocumentoRescatista, Direccion ubicacionMascota, String estadoMascota) {
        super(numeroDocumentoRescatista);
        this.ubicacionMascota = ubicacionMascota;
        this.estadoMascota = estadoMascota;
    }

}