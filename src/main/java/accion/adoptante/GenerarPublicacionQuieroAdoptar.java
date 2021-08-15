package accion.adoptante;

import dominio.Personas;
import dominio.Publicaciones;
import dominio.persona.Persona;
import dominio.notificacion.mensaje.Mensaje;
import dominio.notificacion.mensaje.MensajePublicacionQuieroAdoptar;
import dominio.notificacion.estrategia.EstrategiaDeComunicacion;
import dominio.publicacion.Publicacion;
import dominio.publicacion.PublicacionQuieroAdoptar;

import java.util.List;

public class GenerarPublicacionQuieroAdoptar {

    private final Personas personas;
    private final Publicaciones publicaciones;
    private final EstrategiaDeComunicacion estrategiaDeComunicacion;

    public GenerarPublicacionQuieroAdoptar(Personas personas, Publicaciones publicaciones, EstrategiaDeComunicacion estrategiaDeComunicacion) {
        this.personas = personas;
        this.publicaciones = publicaciones;
        this.estrategiaDeComunicacion = estrategiaDeComunicacion;
    }

    public void ejecutar(int numeroDocumentoAdoptante, List<String> preguntasGenerales) {
        Persona personaAdoptante = personas.obtenerPorNumeroDocumento(numeroDocumentoAdoptante);
        Publicacion publicacion = new PublicacionQuieroAdoptar(personaAdoptante, preguntasGenerales);
        publicaciones.guardar(publicacion);
        Mensaje mensaje = new MensajePublicacionQuieroAdoptar(publicacion);
        mensaje.agregarEmailDestino(personaAdoptante.email());
        estrategiaDeComunicacion.enviar(mensaje);
    }

}