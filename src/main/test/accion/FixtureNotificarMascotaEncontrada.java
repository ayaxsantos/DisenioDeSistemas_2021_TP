package accion;

import dominio.animal.Sexo;
import dominio.animal.Animal;
import dominio.animal.Mascota;
import dominio.notificacion.Contacto;
import dominio.notificacion.estrategia.Email;
import dominio.notificacion.estrategia.SMS;
import dominio.notificacion.estrategia.WhatsApp;
import dominio.persona.Dueño;
import dominio.persona.Rescatista;
import dominio.notificacion.estrategia.EstrategiaDeComunicacion;

import java.time.LocalDateTime;

public class FixtureNotificarMascotaEncontrada {

    protected static int numeroDocumentoRescatista = 22222;
    protected static int numeroDocumentoDueño = 11111;
    protected static int idMascotaEncontradaExistente = 33333;
    protected static int idMascotaEncontradaNoExistente = 55555;

    protected static String numeroSMSRescatista = "+12252247262";
    protected static String numeroWhatsappRescatista = "+14155238886";
    protected static String numeroContactoDueño = "+5491134561101";

    protected static EstrategiaDeComunicacion sms = new SMS();
    protected static EstrategiaDeComunicacion email = new Email();
    protected static EstrategiaDeComunicacion whatsApp = new WhatsApp();

    protected static Mascota unaMascota = crearMascota();
    protected static Dueño unDueño = crearDueño();
    protected static Rescatista unRescatista = crearRescatista();
    protected static String mensajeMascotaEncontrada = mensajeMascotaEncontrada();

    private static Mascota crearMascota() {
        return new Mascota(idMascotaEncontradaExistente, "Ayudante de Santa", Animal.PERRO , "", 10, Sexo.MACHO, "");
    }

    private static Dueño crearDueño() {
        Dueño dueño = new Dueño("Camila", "Berro", LocalDateTime.now(), numeroDocumentoDueño, "Avenida Siempre Viva 742");
        dueño.añadirMascota(unaMascota);
        Contacto contactoDueño = new Contacto(dueño.nombre(), dueño.apellido(), numeroContactoDueño, "camiberro@gmail.com");
        contactoDueño.añadirMedioDeComunicacion(sms, true);
        contactoDueño.añadirMedioDeComunicacion(email, false);
        contactoDueño.añadirMedioDeComunicacion(whatsApp, false);
        dueño.añadirContacto(contactoDueño);
        return dueño;
    }

    private static Rescatista crearRescatista() {
        Rescatista rescatista = new Rescatista("Celeste", "Fernandez",LocalDateTime.now(), numeroDocumentoRescatista, "Calle Falsa 123");
        Contacto contactoRescatista = new Contacto(rescatista.nombre(), rescatista.apellido(), numeroSMSRescatista, "celesfernandez@gmail.com");
        rescatista.añadirContacto(contactoRescatista);
        return rescatista;
    }

    private static String mensajeMascotaEncontrada() {
        return "Hola, soy " + unRescatista.nombre() + " y encontré a " + unaMascota.nombre() + ". " +
           "Mi número es " + unRescatista.telefonoPersonal() + " y mi email es " + unRescatista.emailPersonal();
    }

}