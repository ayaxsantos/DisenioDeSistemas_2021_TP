package casodeuso.dueño;

import dominio.Personas;
import dominio.Organizaciones;
import dominio.organizacion.Organizacion;
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
        PublicacionMascotaEnAdopcion publicacion = new PublicacionMascotaEnAdopcion(numeroDocumentoDueño, idMascota, respuestasMascota);
        Organizacion organizacion = organizaciones.obtenerPorId(idOrganizacion);
        organizacion.añadirPublicacionMascotaEnAdopcion(publicacion);
        organizaciones.guardar(organizacion);
    }

}