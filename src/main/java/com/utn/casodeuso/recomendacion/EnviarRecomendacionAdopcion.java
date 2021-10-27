package com.utn.casodeuso.recomendacion;

import java.util.List;
import java.util.TimerTask;
import java.util.stream.Collectors;

import com.utn.dominio.Organizaciones;
import com.utn.dominio.persona.Persona;
import com.utn.dominio.publicacion.Preferencia;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.notificacion.mensaje.Mensaje;
import com.utn.dominio.notificacion.mensaje.MensajeRecomendacionesAdopcion;
import com.utn.dominio.publicacion.PublicacionMascotaEnAdopcion;

public class EnviarRecomendacionAdopcion extends TimerTask {

    private final Organizaciones organizaciones;

    public EnviarRecomendacionAdopcion(Organizaciones organizaciones) {
        this.organizaciones = organizaciones;
    }

    public void run() {
        List<Organizacion> todasOrganizaciones = organizaciones.obtenerTodas();
        todasOrganizaciones.forEach(organizacion -> {
            List<PublicacionMascotaEnAdopcion> publicaciones = organizacion.publicacionesMascotaEnAdopcion();
            List<Persona> adoptantesActivos = organizacion.adoptantesActivos();
            adoptantesActivos.forEach(adoptante -> {
                List<String> recomendaciones = this.determinarRecomendaciones(adoptante, publicaciones);
                Mensaje mensaje = new MensajeRecomendacionesAdopcion(adoptante, recomendaciones);
                adoptante.getContactoPersonal().notificar(mensaje);
            });
        });
    }

    private List<String> determinarRecomendaciones(Persona personaAdoptante, List<PublicacionMascotaEnAdopcion> publicacionesAdopcion) {
        Preferencia preferenciaAdoptante = personaAdoptante.preferencia();
        return publicacionesAdopcion.stream()
            .filter(publicacionAdopcion -> this.condicionesParaFiltrar(publicacionAdopcion, preferenciaAdoptante))
            .map(Object::toString)
            .collect(Collectors.toList());
    }

    private boolean condicionesParaFiltrar(PublicacionMascotaEnAdopcion publicacion, Preferencia preferenciaAdoptante) {
        return preferenciaAdoptante.equals(publicacion.obtenerFisionomia());
    }

}