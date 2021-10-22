package com.utn.casodeuso.dueño;

import com.utn.dominio.Personas;
import com.utn.dominio.Organizaciones;
import com.utn.dominio.animal.Mascota;
import com.utn.dominio.persona.Persona;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.publicacion.PublicacionMascotaEnAdopcion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenerarPublicacionMascotaEnAdopcion {

    private final Personas personas;
    private final Organizaciones organizaciones;

    public GenerarPublicacionMascotaEnAdopcion(Personas personas, Organizaciones organizaciones) {
        this.personas = personas;
        this.organizaciones = organizaciones;
    }

    public void ejecutar(int numeroDocumentoDueño, String nombreMascota, String nombreOrganizacion, List<String> respuestasMascota) {
        Persona personaDueño = personas.obtenerPorNumeroDocumento(numeroDocumentoDueño);
        Mascota mascotaDeDueño = personaDueño.buscarMascota(nombreMascota);
        Organizacion organizacion = organizaciones.obtenerPorNombre(nombreOrganizacion);


        PublicacionMascotaEnAdopcion publicacion = new PublicacionMascotaEnAdopcion(personaDueño, mascotaDeDueño, respuestasMascota);
        organizacion.añadirPublicacionMascotaEnAdopcion(publicacion);

        organizaciones.guardar(organizacion);
    }

}
