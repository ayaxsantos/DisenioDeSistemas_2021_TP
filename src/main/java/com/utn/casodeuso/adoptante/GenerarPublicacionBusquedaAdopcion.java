package com.utn.casodeuso.adoptante;

import com.utn.dominio.Personas;
import com.utn.dominio.notificacion.estrategia.Email;
import com.utn.dominio.persona.Persona;
import com.utn.dominio.Organizaciones;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.notificacion.mensaje.Mensaje;
import com.utn.dominio.notificacion.mensaje.MensajePublicacionQuieroAdoptar;
import com.utn.dominio.publicacion.PublicacionBusquedaAdopcion;
import com.utn.infraestructura.notificador.NotificadorEmail;

import java.util.List;

public class GenerarPublicacionBusquedaAdopcion {

    private final Personas personas;
    private final Organizaciones organizaciones;

    public GenerarPublicacionBusquedaAdopcion(Personas personas, Organizaciones organizaciones) {
        this.personas = personas;
        this.organizaciones = organizaciones;
    }

    public void ejecutar(int numeroDocumentoAdoptante, String nombreOrganizacion, List<String> comodidades) {
        Organizacion organizacion = organizaciones.obtenerPorNombre(nombreOrganizacion);
        Persona personaAdoptante = personas.obtenerPorNumeroDocumento(numeroDocumentoAdoptante);

        PublicacionBusquedaAdopcion publicacion = new PublicacionBusquedaAdopcion(personaAdoptante, comodidades);
        organizacion.añadirPublicacionBusquedaAdopcion(publicacion);
        organizacion.añadirPersona(personaAdoptante);

        organizaciones.guardar(organizacion);

        Mensaje mensaje = new MensajePublicacionQuieroAdoptar(publicacion);
        mensaje.agregarEmailDestino(personaAdoptante.email());
        Email email = new Email(new NotificadorEmail(), false);
        email.enviar(mensaje);
    }
}
