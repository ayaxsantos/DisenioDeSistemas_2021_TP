package com.utn.dominio.notificacion.mensaje;

import com.utn.dominio.animal.Mascota;
import com.utn.dominio.persona.Persona;

public class MensajeNotificarMascotaEncontrada extends Mensaje {

    public MensajeNotificarMascotaEncontrada(Persona personaRescatista, Mascota mascota) {
        super("Hola, soy " + personaRescatista.nombre() + " y encontré a " + mascota.getNombre() + ". " +
            "Mi número es " + personaRescatista.telefono() + " y mi email es " + personaRescatista.email(),
            "[Importante] Rescate de Patitas", personaRescatista.telefono());
    }


}