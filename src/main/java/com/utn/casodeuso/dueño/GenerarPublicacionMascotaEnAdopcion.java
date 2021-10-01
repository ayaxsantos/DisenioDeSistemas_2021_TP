package com.utn.casodeuso.dueño;

import com.utn.dominio.Personas;
import com.utn.dominio.Organizaciones;
import com.utn.dominio.persona.Persona;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.publicacion.PublicacionMascotaEnAdopcion;

import java.util.List;

public class GenerarPublicacionMascotaEnAdopcion {

    private final Personas personas;
    private final Organizaciones organizaciones;

    public GenerarPublicacionMascotaEnAdopcion(Personas personas, Organizaciones organizaciones) {
        this.personas = personas;
        this.organizaciones = organizaciones;
    }

    public void ejecutar(int numeroDocumentoDueño, int idMascota, int idOrganizacion, List<String> respuestasMascota) {
        Persona personaDueño = personas.obtenerPorNumeroDocumento(numeroDocumentoDueño);
        PublicacionMascotaEnAdopcion publicacion = new PublicacionMascotaEnAdopcion(personaDueño, idMascota, respuestasMascota);
        Organizacion organizacion = organizaciones.obtenerPorId(idOrganizacion);
        organizacion.añadirPublicacionMascotaEnAdopcion(publicacion);
        organizaciones.guardar(organizacion);
    }

}