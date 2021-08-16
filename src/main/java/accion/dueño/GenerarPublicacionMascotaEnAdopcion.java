package accion.dueño;

import dominio.Organizaciones;
import dominio.Personas;
import dominio.organizacion.Organizacion;
import dominio.persona.Persona;
import dominio.publicacion.Publicacion;
import dominio.publicacion.PublicacionMascotaEnAdopcion;

import java.util.List;

public class GenerarPublicacionMascotaEnAdopcion {

    private final Personas personas;
    private final Organizaciones organizaciones;

    public GenerarPublicacionMascotaEnAdopcion(Personas personas, Organizaciones organizaciones) {
        this.personas = personas;
        this.organizaciones = organizaciones;
    }

    public void ejecutar(int numeroDocumentoDueño, int idMascota, int idOrganizacion, List<String> respuestasMascota) {
        Publicacion publicacion = new PublicacionMascotaEnAdopcion(numeroDocumentoDueño, idMascota, respuestasMascota);
        Organizacion organizacion = organizaciones.obtenerPorId(idOrganizacion);
        organizacion.añadirPublicacionMascotaEnAdopcion(publicacion);
        organizaciones.guardar(organizacion);
    }

}