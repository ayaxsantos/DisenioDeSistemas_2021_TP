package accion.rescatista;

import dominio.Personas;
import dominio.Publicaciones;

import dominio.persona.Persona;
import dominio.persona.Direccion;

import dominio.publicacion.Publicacion;
import dominio.publicacion.PublicacionMascotaEncontrada;

public class GenerarPublicacionMascotaEncontrada {

    private final Publicaciones publicaciones;
    private final Personas personas;

    public GenerarPublicacionMascotaEncontrada(Publicaciones publicaciones, Personas personas) {
        this.publicaciones = publicaciones;
        this.personas = personas;
    }

    public void ejecutar(int numeroDocumentoRescatista, Double latitud, Double longitud, String estadoMascota) {
        Persona personaRescatista = personas.obtenerPorNumeroDocumento(numeroDocumentoRescatista);
        Direccion direccionMascotaEncontrada = new Direccion(latitud, longitud);
        Publicacion publicacionMascotaEncontrada = new PublicacionMascotaEncontrada(personaRescatista, direccionMascotaEncontrada, estadoMascota);
        publicaciones.guardar(publicacionMascotaEncontrada);
    }

}