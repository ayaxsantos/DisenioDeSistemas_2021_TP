package dominio.notificacion.mensaje;

import dominio.publicacion.Publicacion;

public class MensajePublicacionQuieroAdoptar extends Mensaje {

    public MensajePublicacionQuieroAdoptar(Publicacion publicacion) {
        super("cuerpo", "asunto", "telefonoOrigen");
    }

}