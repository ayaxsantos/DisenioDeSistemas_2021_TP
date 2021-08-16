package accion.recomendacion;

/*
5. Se deben generar y enviar recomendaciones semanales de adopción de mascotas.

El sistema, además, debe generar y enviar recomendaciones semanales de adopción para las personas que
están interesadas en adoptar. Es necesario que las recomendaciones sean óptimas, es decir, que se tengan
en cuenta las preferencias y comodidades de las personas, así como también las características propias y
necesarias de la mascota.

 */

import dominio.Organizaciones;
import dominio.organizacion.Organizacion;
import dominio.notificacion.mensaje.Mensaje;
import dominio.notificacion.estrategia.EstrategiaDeComunicacion;
import dominio.notificacion.mensaje.MensajeRecomendacionesAdopcion;
import dominio.persona.Persona;
import dominio.publicacion.Publicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class EnviarRecomendacionAdopcion extends TimerTask {

    private final Organizaciones organizaciones;
    private final EstrategiaDeComunicacion estrategiaDeComunicacion;

    public EnviarRecomendacionAdopcion(Organizaciones organizaciones, EstrategiaDeComunicacion estrategiaDeComunicacion) {
        this.organizaciones = organizaciones;
        this.estrategiaDeComunicacion = estrategiaDeComunicacion;
    }

    public void run() {
        List<Organizacion> todasOrganizaciones = organizaciones.obtenerTodas();
        todasOrganizaciones.forEach(organizacion -> {
            List<Publicacion> publicaciones = organizacion.publicacionesMascotaEnAdopcion();
            List<Persona> personasAdoptantesActivos = organizacion.adoptantesActivos();
            personasAdoptantesActivos.forEach(personaAdoptante -> {
                List<String> recomendaciones = this.determinarRecomendaciones(personaAdoptante, publicaciones);
                Mensaje mensaje = new MensajeRecomendacionesAdopcion(personaAdoptante, recomendaciones);
                estrategiaDeComunicacion.enviar(mensaje);
            });
        });
    }

    private List<String> determinarRecomendaciones(Persona personaAdoptante, List<Publicacion> publicaciones) {
        return new ArrayList<>();
    }

}