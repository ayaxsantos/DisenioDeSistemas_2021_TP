package accion;

import dominio.animal.Sexo;
import dominio.animal.Animal;
import dominio.animal.Mascota;
import dominio.persona.Dueño;
import dominio.persona.Persona;
import dominio.persona.Rescatista;
import dominio.notificacion.Contacto;

import java.time.LocalDateTime;

public class FixtureNotificarMascotaEncontrada {

    protected static int numeroDocumentoRescatista = 22222;
    protected static int numeroDocumentoDueño = 11111;
    protected static int idMascotaEncontradaExistente = 33333;
    protected static int idMascotaEncontradaNoExistente = 55555;

    protected static String numeroSMSRescatista = "+12252247262";
    protected static String numeroWhatsappRescatista = "+14155238886";
    protected static String numeroContactoDueño = "+5491134561101";

    protected static String emailRescatista = "celestefernandez@gmail.com";
    protected static String emailDueño = "ccalvoromero@gmail.com";

    protected static boolean esPreferido = true;
    protected static boolean noEsPreferido = false;

    protected static String mensajeMascotaEncontrada = "";
    protected static String asuntoMascotaEncontrada = "[Importante] Rescate de Patitas";

    protected static Mascota crearMascota(int idMascota) {
        return new Mascota(idMascota, "Ayudante de Santa", Animal.PERRO , "", 10, Sexo.MACHO, "");
    }

    protected static Dueño crearDueño() {
        return new Dueño("Camila", "Berro", LocalDateTime.now(), numeroDocumentoDueño, "Avenida Siempre Viva 742");
    }

    protected static Rescatista crearRescatista() {
        return new Rescatista("Celeste", "Fernandez",LocalDateTime.now(), numeroDocumentoRescatista, "Calle Falsa 123");
    }

    protected static Contacto crearContacto(Persona persona, String telefono, String email) {
        return new Contacto(persona.nombre(), persona.apellido(), telefono, email);
    }

    protected static String mensajeMascotaEncontrada(Rescatista unRescatista, Mascota unaMascota) {
        return "Hola, soy " + unRescatista.nombre() + " y encontré a " + unaMascota.nombre() + ". " +
           "Mi número es " + unRescatista.telefonoPersonal() + " y mi email es " + unRescatista.emailPersonal();
    }

}