package casodeuso.recomendacion;

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

import dominio.Organizaciones;
import dominio.persona.Persona;
import dominio.publicacion.Preferencia;
import dominio.organizacion.Organizacion;
import dominio.notificacion.mensaje.Mensaje;
import dominio.publicacion.Publicacion;
import dominio.notificacion.estrategia.EstrategiaDeComunicacion;
import dominio.notificacion.mensaje.MensajeRecomendacionesAdopcion;

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
            List<Persona> adoptantesActivos = organizacion.adoptantesActivos();
            adoptantesActivos.forEach(adoptante -> {
                List<String> recomendaciones = this.determinarRecomendaciones(adoptante, publicaciones);
                Mensaje mensaje = new MensajeRecomendacionesAdopcion(adoptante, recomendaciones);
                estrategiaDeComunicacion.enviar(mensaje);
            });
        });
    }

    private List<String> determinarRecomendaciones(Persona personaAdoptante, List<Publicacion> publicacionesAdopcion) {
        Preferencia preferenciaAdoptante = personaAdoptante.preferencia();
        return publicacionesAdopcion.stream()
            .filter(publicacionAdopcion -> this.condicionesParaFiltrar(publicacionAdopcion, preferenciaAdoptante))
            .map(Object::toString)
            .collect(Collectors.toList());
    }

    private boolean condicionesParaFiltrar(Publicacion publicacionAdopcion, Preferencia preferenciaAdoptante) {
        // Pasarle comodidades y preferencias de cada uno
        // matchear con publicaciones que se adecuen a lo que busca el adoptante activo
        // guardar las mascotas en publicacionAdopcion en vez del idmascota asi tenemos acceso directo :)
        return true;
    }

}