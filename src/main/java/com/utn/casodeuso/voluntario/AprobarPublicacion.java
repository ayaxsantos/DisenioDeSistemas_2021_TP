package com.utn.casodeuso.voluntario;

import com.utn.dominio.Voluntarios;
import com.utn.dominio.Publicaciones;
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

        publicaciones.guardar(publicacion);
    }

}