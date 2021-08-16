package dominio.publicacion;

import java.util.List;
import java.util.ArrayList;

public class PublicacionMascotaEnAdopcion extends Publicacion {

    private final List<String> respuestas = new ArrayList<>();
    private final int idMascota;

    public PublicacionMascotaEnAdopcion(int numeroDocumentoDueño, int idMascota, List<String> respuestas) {
        super(numeroDocumentoDueño);
        this.idMascota = idMascota;
        this.respuestas.addAll(respuestas);
    }

}