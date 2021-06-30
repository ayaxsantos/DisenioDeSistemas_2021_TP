package accion;

import dominio.animal.Sexo;
import dominio.animal.Animal;
import dominio.animal.Mascota;

import dominio.animal.Tamaño;
import dominio.persona.Contacto;
import dominio.notificacion.estrategia.SMS;
import dominio.notificacion.estrategia.Email;
import dominio.notificacion.estrategia.WhatsApp;
import dominio.notificacion.estrategia.EstrategiaDeComunicacion;

import dominio.persona.Persona;
import dominio.persona.Documento;

import dominio.persona.UbicacionPersona;
import infraestructura.notificador.Notificador;

import java.time.LocalDateTime;

public class FixtureNotificarMascotaEncontrada {

    protected static final int idMascotaEncontradaExistente = 33333;
    protected static final int idMascotaEncontradaNoExistente = 55555;
    private static final String nombreMascota = "Ayudante de Santa";
    private static final Animal animal = Animal.PERRO;
    private static final String apodo = "Huesos";
    private static final int edad = 10;
    private static final Sexo sexo = Sexo.MACHO;
    private static final Tamaño tamaño = Tamaño.CHICO;
    private static final String descripcionFisica = "Chiquito y dormilon";

    protected static final int numeroDocumentoDueño = 11111;
    private static final String nombreDueño = "Camila";
    private static final String apellidoDueño = "Berro";
    private static final LocalDateTime fechaNacimientoDueño = LocalDateTime.now();
    private static final UbicacionPersona direccionDueño = new UbicacionPersona(-34.58805543938273, -58.39709555890073);
    private static final String emailDueño = "ccalvoromero@gmail.com";
    protected static final String numeroDueño = "+5491134561101";

    private static final String nombreContactoDueño = "Ayax";
    private static final String apellidoContactoDueño = "Santos";
    private static final String emailContactoDueño = "ccalvoromero@gmail.com";
    private static final String numeroContactoDueño = "+5491123961279";

    private static final boolean esPreferido = true;
    private static final boolean noEsPreferido = false;

    protected static final int numeroDocumentoRescatista = 22222;
    private static final String nombreRescatista = "Celeste";
    private static final String apellidoRescatista = "Fernandez";
    private static final LocalDateTime fechaNacimientoRescatista = LocalDateTime.now();
    private static final UbicacionPersona direccionRescatista = new UbicacionPersona(-34.46013439745161, -58.80857841888721);
    protected static final String numeroSMSRescatista = "+12252247262";
    protected static final String numeroWhatsappRescatista = "+14155238886";
    private static final String emailRescatista = "celestefernandez@gmail.com";

    private static final String nombreContactoRescatista = "Juan";
    private static final String apellidoContactoRescatista = "Yarbuh";
    private static final String emailContactoRescatista = "juani@gmail.com";
    private static final String numeroContactoRescatista = "+5491173619611";

    private static final String tipoDocumento = "DNI";

    protected static String mensajeMascotaEncontrada = "";
    protected static final String asuntoMascotaEncontrada = "[Importante] Rescate de Patitas";

    public static Mascota mascota;
    protected static Persona personaDueño;
    public static Persona personaRescatista;

    private static Contacto contactoDueño;
    private static Contacto contactoRescatista;
    private static Contacto otroContactoDueño;
    private static Contacto otroContactoRescatista;

    private static Documento documentoDueño;
    private static Documento documentoRescatista;

    private static EstrategiaDeComunicacion sms;
    private static EstrategiaDeComunicacion email;
    private static EstrategiaDeComunicacion whatsApp;

    protected static void inicializarEstrategiasDeNotificacion(Notificador notificador) {
        email = new Email(notificador);
        sms = new SMS(notificador);
        whatsApp = new WhatsApp(notificador);
    }

    public static void inicializarMascota() {
        mascota = crearMascota(idMascotaEncontradaExistente, nombreMascota, animal, apodo, edad, sexo, tamaño, descripcionFisica);
    }

    protected static void inicializarDueño() {
        otroContactoDueño = crearContacto(nombreContactoDueño, apellidoContactoDueño, numeroContactoDueño, emailContactoDueño);
        otroContactoDueño.añadirMedioDeComunicacion(sms, noEsPreferido);
        otroContactoDueño.añadirMedioDeComunicacion(email, esPreferido);
        otroContactoDueño.añadirMedioDeComunicacion(whatsApp, noEsPreferido);
        documentoDueño = crearDocumento(tipoDocumento, numeroDocumentoDueño);
        contactoDueño = crearContacto(nombreDueño, apellidoDueño, numeroDueño, emailDueño);
        contactoDueño.añadirMedioDeComunicacion(sms, esPreferido);
        personaDueño = crearPersona(contactoDueño, fechaNacimientoDueño, documentoDueño, direccionDueño, otroContactoDueño);
        personaDueño.dueño().añadirMascota(mascota);
    }

    public static void inicializarRescatista() {
        otroContactoRescatista = crearContacto(nombreContactoRescatista, apellidoContactoRescatista, numeroContactoRescatista, emailContactoRescatista);
        documentoRescatista = crearDocumento(tipoDocumento, numeroDocumentoRescatista);
        contactoRescatista = crearContacto(nombreRescatista, apellidoRescatista,  numeroSMSRescatista, emailRescatista);
        personaRescatista = crearPersona(contactoRescatista, fechaNacimientoRescatista, documentoRescatista, direccionRescatista, otroContactoRescatista);
        mensajeMascotaEncontrada = mensajeMascotaEncontrada(personaRescatista, mascota);
    }

    private static Mascota crearMascota(int id, String nombre, Animal animal, String apodo, int edad, Sexo sexo, Tamaño tamaño, String descripcionFisica) {
        return new Mascota(id, nombre, animal, apodo, edad, sexo, tamaño, descripcionFisica);
    }

    private static Persona crearPersona(Contacto contacto, LocalDateTime fechaNacimiento, Documento documento, UbicacionPersona direccion, Contacto otroContacto) {
        return new Persona(contacto, fechaNacimiento, documento, direccion, otroContacto);
    }

    private static Documento crearDocumento(String tipo, Integer numero) {
        return new Documento(tipo, numero);
    }

    private static Contacto crearContacto(String nombre, String apellido, String telefono, String email) {
        return new Contacto(nombre, apellido, telefono, email);
    }

    private static String mensajeMascotaEncontrada(Persona personaRescatista, Mascota mascota) {
        return "Hola, soy " + personaRescatista.nombre() + " y encontré a " + mascota.nombre() + ". " +
           "Mi número es " + personaRescatista.telefono() + " y mi email es " + personaRescatista.email();
    }

}