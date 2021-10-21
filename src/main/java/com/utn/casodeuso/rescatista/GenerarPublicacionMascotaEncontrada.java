package com.utn.casodeuso.rescatista;

import com.utn.dominio.Personas;
import com.utn.dominio.Organizaciones;

import com.utn.dominio.persona.Persona;
import com.utn.dominio.persona.Direccion;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.publicacion.PublicacionMascotaEncontrada;

public class GenerarPublicacionMascotaEncontrada {

    private final Personas personas;
    private final Organizaciones organizaciones;

    public GenerarPublicacionMascotaEncontrada(Organizaciones organizaciones, Personas personas) {
        this.organizaciones = organizaciones;
        this.personas = personas;
    }

    public void ejecutar(int numeroDocumentoRescatista, String nombreOrganizacion, Double latitud, Double longitud, String estadoMascota) {
        Direccion direccionMascotaEncontrada = new Direccion(latitud, longitud);
        Persona personaRescatista = personas.obtenerPorNumeroDocumento(numeroDocumentoRescatista);
        PublicacionMascotaEncontrada publicacion = new PublicacionMascotaEncontrada(personaRescatista, direccionMascotaEncontrada, estadoMascota);
        Organizacion organizacion = organizaciones.obtenerPorNombre(nombreOrganizacion);
        organizacion.añadirPublicacionMascotaEncontrada(publicacion);
        organizaciones.guardar(organizacion);
    }

}