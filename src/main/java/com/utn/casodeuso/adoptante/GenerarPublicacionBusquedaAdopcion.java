package com.utn.casodeuso.adoptante;

import com.utn.dominio.Personas;
import com.utn.dominio.persona.Persona;
import com.utn.dominio.publicacion.Preferencia;
import com.utn.dominio.Organizaciones;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.notificacion.mensaje.Mensaje;
import com.utn.dominio.notificacion.mensaje.MensajePublicacionQuieroAdoptar;
import com.utn.dominio.notificacion.estrategia.EstrategiaDeComunicacion;
import com.utn.dominio.publicacion.PublicacionBusquedaAdopcion;

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

    public void ejecutar(int numeroDocumentoAdoptante, String nombreOrganizacion, Preferencia preferencia, List<String> comodidades) {
        Organizacion organizacion = organizaciones.obtenerPorNombre(nombreOrganizacion);
        Persona personaAdoptante = personas.obtenerPorNumeroDocumento(numeroDocumentoAdoptante);
        PublicacionBusquedaAdopcion publicacion = new PublicacionBusquedaAdopcion(personaAdoptante, preferencia, comodidades);
        organizacion.añadirPublicacionBusquedaAdopcion(publicacion);
        organizacion.añadirPersona(personaAdoptante);
        organizaciones.guardar(organizacion);
        Mensaje mensaje = new MensajePublicacionQuieroAdoptar(publicacion);
        mensaje.agregarEmailDestino(personaAdoptante.email());
        estrategiaDeComunicacion.enviar(mensaje);
    }

}