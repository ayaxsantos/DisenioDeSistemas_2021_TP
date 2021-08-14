package dominio.notificacion.mensaje;

import dominio.persona.Persona;

public class MensajeMascotaEncontradaPorDuenioEnPublicacion extends Mensaje{
    public MensajeMascotaEncontradaPorDuenioEnPublicacion(Persona personaDuenio) {
        super("Hola, soy " + personaDuenio.nombre() + "y encontré a mi mascota en una de tus publicaciones" + "."
                + "Mi número es " + personaDuenio.telefono() + " y mi email es " + personaDuenio.email(),
                "[Importante] Rescate de Patitas", personaDuenio.telefono());
    }
}
