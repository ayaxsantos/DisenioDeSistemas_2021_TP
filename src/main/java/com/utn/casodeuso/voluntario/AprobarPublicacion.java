package com.utn.casodeuso.voluntario;

import com.utn.dominio.Voluntarios;
import com.utn.dominio.Publicaciones;
import com.utn.dominio.notificacion.mensaje.Mensaje;
import com.utn.dominio.organizacion.Voluntario;
import com.utn.dominio.publicacion.Publicacion;

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

        Mensaje mensaje = new Mensaje("Tu publicación ha sido aprobada, " +
                "con el siguiente link puedes dar de baja la publicación: " +
                "https://heroku.com/publicaciones/busquedaDeAdopcion/" + unVoluntario.getOrganizacion(),
                                      " Publicacion aprobada");

        publicacion.getPersona().notificar(mensaje);

        publicaciones.guardar(publicacion);
    }

}