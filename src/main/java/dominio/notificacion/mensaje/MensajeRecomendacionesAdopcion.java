package dominio.notificacion.mensaje;

import dominio.persona.Persona;

import java.util.List;

public class MensajeRecomendacionesAdopcion extends Mensaje {

    public MensajeRecomendacionesAdopcion(Persona personaAdoptante, List<String> recomendaciones) {
        super("cuerpo", "asunto", "telefonoOrigen");
    }

}
