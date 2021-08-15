package dominio.publicacion;

import java.util.List;
import java.util.ArrayList;

public class PublicacionDarAdopcion extends Publicacion {

    private final List<String> respuestas = new ArrayList<>();

    public PublicacionDarAdopcion(List<String> respuestas) {
        this.respuestas.addAll(respuestas);
    }

}