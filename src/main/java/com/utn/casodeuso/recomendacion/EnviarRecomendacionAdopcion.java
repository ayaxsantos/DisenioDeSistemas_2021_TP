package com.utn.casodeuso.recomendacion;

/*
5. Se deben generar y enviar recomendaciones semanales de adopción de mascotas.

El sistema, además, debe generar y enviar recomendaciones semanales de adopción para las personas que
están interesadas en adoptar. Es necesario que las recomendaciones sean óptimas, es decir, que se tengan
en cuenta las preferencias y comodidades de las personas, así como también las características propias y
necesarias de la mascota.

 */

import java.util.List;
import java.util.TimerTask;
import java.util.stream.Collectors;

import com.utn.dominio.Organizaciones;
import com.utn.dominio.animal.Mascota;
import com.utn.dominio.persona.Persona;
import com.utn.dominio.publicacion.Preferencia;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.notificacion.mensaje.Mensaje;
import com.utn.dominio.notificacion.estrategia.EstrategiaDeComunicacion;
import com.utn.dominio.notificacion.mensaje.MensajeRecomendacionesAdopcion;
import com.utn.dominio.publicacion.PublicacionMascotaEnAdopcion;
import com.utn.infraestructura.persistencia.mascota.MascotasEnMySQL;

public class EnviarRecomendacionAdopcion extends TimerTask {

    private final Organizaciones organizaciones;
    private final EstrategiaDeComunicacion estrategiaDeComunicacion;
    private final MascotasEnMySQL mascotasEnMySQL;

    public EnviarRecomendacionAdopcion(Organizaciones organizaciones, EstrategiaDeComunicacion estrategiaDeComunicacion, MascotasEnMySQL mascotasEnMySQL) {
        this.organizaciones = organizaciones;
        this.estrategiaDeComunicacion = estrategiaDeComunicacion;
        this.mascotasEnMySQL = mascotasEnMySQL;
    }

    public void run() {
        List<Organizacion> todasOrganizaciones = organizaciones.obtenerTodas();
        todasOrganizaciones.forEach(organizacion -> {
            List<PublicacionMascotaEnAdopcion> publicaciones = organizacion.publicacionesMascotaEnAdopcion();
            List<Persona> adoptantesActivos = organizacion.adoptantesActivos();
            adoptantesActivos.forEach(adoptante -> {
                List<String> recomendaciones = this.determinarRecomendaciones(adoptante, publicaciones);
                Mensaje mensaje = new MensajeRecomendacionesAdopcion(adoptante, recomendaciones);
                estrategiaDeComunicacion.enviar(mensaje);
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
        Mascota mascota = mascotasEnMySQL.obtenerPorId(publicacion.getIdMascota());
        return mascota.animal() == preferenciaAdoptante.animal()
                && mascota.tamaño() == preferenciaAdoptante.tamaño()
                && mascota.sexo() == preferenciaAdoptante.sexo();
    }

}