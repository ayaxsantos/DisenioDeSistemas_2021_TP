package casodeuso.voluntario;

import dominio.Personas;
import dominio.Publicaciones;
import dominio.persona.Persona;
import dominio.publicacion.Publicacion;

public class AprobarPublicacion {

    private final Publicaciones publicaciones;
    private final Personas personas;

    public AprobarPublicacion(Publicaciones publicaciones, Personas personas) {
        this.publicaciones = publicaciones;
        this.personas = personas;
    }

    public void ejecutar(int idPublicacion, int numeroDocumentoVoluntario){
        Persona personaVoluntaria = personas.obtenerPorNumeroDocumento(numeroDocumentoVoluntario);
        Publicacion publicacion = publicaciones.obtenerPorId(idPublicacion);
        personaVoluntaria.voluntario().aprobarPublicacion(publicacion);
        publicaciones.guardar(publicacion);
    }

}