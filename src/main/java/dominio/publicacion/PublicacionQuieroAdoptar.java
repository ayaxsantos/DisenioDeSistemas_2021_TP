package dominio.publicacion;

import dominio.persona.Persona;

import java.util.ArrayList;
import java.util.List;

public class PublicacionQuieroAdoptar extends Publicacion {

    private final Persona personaAdoptante;
    private final List<String> preguntasGenerales = new ArrayList<>();

    public PublicacionQuieroAdoptar(Persona personaAdoptante, List<String> preguntasGenerales) {
        this.personaAdoptante = personaAdoptante;
        this.preguntasGenerales.addAll(preguntasGenerales);
    }

}
