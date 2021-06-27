package dominio.notificacion.mensaje;

import dominio.animal.Mascota;
import dominio.persona.Rescatista;

public class MensajeMascotaEncontrada extends Mensaje {

    public MensajeMascotaEncontrada(Rescatista rescatista, Mascota mascota) {
        super("Hola, soy " + rescatista.nombre() + " y encontré a " + mascota.nombre() + ". " +
            "Mi número es " + rescatista.telefonoPersonal() + " y mi email es " + rescatista.emailPersonal(),
            "[Importante] Rescate de Patitas", rescatista.telefonoPersonal());
    }

}