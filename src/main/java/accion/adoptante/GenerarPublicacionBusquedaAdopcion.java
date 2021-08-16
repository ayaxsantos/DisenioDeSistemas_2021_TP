package accion.adoptante;

import dominio.Organizaciones;
import dominio.Personas;
import dominio.organizacion.Organizacion;
import dominio.persona.Persona;
import dominio.notificacion.mensaje.Mensaje;
import dominio.notificacion.mensaje.MensajePublicacionQuieroAdoptar;
import dominio.notificacion.estrategia.EstrategiaDeComunicacion;
import dominio.persona.Preferencia;
import dominio.publicacion.Publicacion;
import dominio.publicacion.PublicacionBusquedaAdopcion;

import java.util.List;

public class GenerarPublicacionBusquedaAdopcion {

    private final Personas personas;
    private final Organizaciones organizaciones;
    private final EstrategiaDeComunicacion estrategiaDeComunicacion;

    public GenerarPublicacionBusquedaAdopcion(Personas personas, Organizaciones organizaciones, EstrategiaDeComunicacion estrategiaDeComunicacion) {
        this.personas = personas;
        this.organizaciones = organizaciones;
        this.estrategiaDeComunicacion = estrategiaDeComunicacion;
    }

    public void ejecutar(int numeroDocumentoAdoptante, int idOrganizacion, Preferencia preferencia, List<String> comodidades) {
        Publicacion publicacion = new PublicacionBusquedaAdopcion(numeroDocumentoAdoptante, preferencia, comodidades);
        Organizacion organizacion = organizaciones.obtenerPorId(idOrganizacion);
        organizacion.añadirPublicacionBusquedaAdopcion(publicacion);
        organizaciones.guardar(organizacion);
        Mensaje mensaje = new MensajePublicacionQuieroAdoptar(publicacion);
        Persona personaAdoptante = personas.obtenerPorNumeroDocumento(numeroDocumentoAdoptante);
        mensaje.agregarEmailDestino(personaAdoptante.email());
        estrategiaDeComunicacion.enviar(mensaje);
    }

}