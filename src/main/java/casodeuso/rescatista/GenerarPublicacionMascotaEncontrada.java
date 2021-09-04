package casodeuso.rescatista;

import dominio.Personas;
import dominio.Organizaciones;

import dominio.persona.Direccion;
import dominio.organizacion.Organizacion;
import dominio.publicacion.Publicacion;
import dominio.publicacion.PublicacionMascotaEncontrada;

public class GenerarPublicacionMascotaEncontrada {

    private final Personas personas;
    private final Organizaciones organizaciones;

    public GenerarPublicacionMascotaEncontrada(Organizaciones organizaciones, Personas personas) {
        this.organizaciones = organizaciones;
        this.personas = personas;
    }

    public void ejecutar(int numeroDocumentoRescatista, int idOrganizacion, Double latitud, Double longitud, String estadoMascota) {
        Direccion direccionMascotaEncontrada = new Direccion(latitud, longitud);
        Publicacion publicacion = new PublicacionMascotaEncontrada(numeroDocumentoRescatista, direccionMascotaEncontrada, estadoMascota);
        Organizacion organizacion = organizaciones.obtenerPorId(idOrganizacion);
        organizacion.añadirPublicacionMascotaEncontrada(publicacion);
        organizaciones.guardar(organizacion);
    }

}