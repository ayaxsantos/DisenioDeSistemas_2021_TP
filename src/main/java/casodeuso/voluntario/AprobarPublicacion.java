package casodeuso.voluntario;

import dominio.Voluntarios;
import dominio.Publicaciones;
import dominio.organizacion.Voluntario;
import dominio.publicacion.Publicacion;

public class AprobarPublicacion {

    private final Publicaciones publicaciones;
    private final Voluntarios voluntarios;

    public AprobarPublicacion(Publicaciones publicaciones, Voluntarios voluntarios) {
        this.publicaciones = publicaciones;
        this.voluntarios = voluntarios;
    }

    public void ejecutar(int idPublicacion, String nombreUsuario) {
        Voluntario unVoluntario = voluntarios.obtenerPorNombreUsuario(nombreUsuario);
        Publicacion publicacion = publicaciones.obtenerPorId(idPublicacion);
        unVoluntario.aprobarPublicacion(publicacion);
        publicaciones.guardar(publicacion);
    }

}