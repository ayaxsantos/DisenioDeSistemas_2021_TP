package accion.dueño;

import dominio.Publicaciones;
import dominio.publicacion.Publicacion;
import dominio.publicacion.PublicacionDarAdopcion;

import java.util.List;

public class GenerarPublicacionDarAdopcion {

    private final Publicaciones publicaciones;

    public GenerarPublicacionDarAdopcion(Publicaciones publicaciones) {
        this.publicaciones = publicaciones;
    }

    public void ejecutar(List<String> respuestasMascota) {
        Publicacion publicacion = new PublicacionDarAdopcion(respuestasMascota); //TODO Deberiamos agregar mascota?
        publicaciones.guardar(publicacion);
    }

}