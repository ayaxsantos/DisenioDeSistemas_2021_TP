package dominio.notificacion.mensaje;

import dominio.animal.Mascota;
import dominio.persona.Persona;

public class MensajeNotificarMascotaEncontrada extends Mensaje {

    public MensajeNotificarMascotaEncontrada(Persona personaRescatista, Mascota mascota) {
        super("Hola, soy " + personaRescatista.nombre() + " y encontré a " + mascota.nombre() + ". " +
            "Mi número es " + personaRescatista.telefono() + " y mi email es " + personaRescatista.email(),
            "[Importante] Rescate de Patitas", personaRescatista.telefono());
    }


}