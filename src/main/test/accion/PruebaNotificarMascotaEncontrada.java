package accion;

import dominio.animal.Mascota;
import dominio.persona.Dueño;
import dominio.persona.Rescatista;
import dominio.notificacion.Contacto;
import dominio.notificacion.estrategia.SMS;
import dominio.notificacion.estrategia.Email;
import dominio.notificacion.estrategia.WhatsApp;
import dominio.notificacion.estrategia.EstrategiaDeComunicacion;
import dominio.excepcion.MascotaNoCorrespondeADueñoException;

import infraestructura.Personas;
import infraestructura.Notificador;

import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.atLeast;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.any;
import static accion.FixtureNotificarMascotaEncontrada.*;

public class PruebaNotificarMascotaEncontrada {

    private Personas personas;
    private Notificador notificador;
    private NotificarMascotaEncontrada notificarMascotaEncontrada;

    private Dueño dueño;
    private Mascota mascota;
    private Rescatista rescatista;

    private Contacto contactoDueño;
    private Contacto contactoRescatista;

    private EstrategiaDeComunicacion sms;
    private EstrategiaDeComunicacion email;
    private EstrategiaDeComunicacion whatsApp;

    @BeforeEach
    void inicializar() {
        notificador = Mockito.mock(Notificador.class);
        email = new Email(notificador);
        sms = new SMS(notificador);
        whatsApp = new WhatsApp(notificador);
        personas = Mockito.mock(Personas.class);
        notificarMascotaEncontrada = new NotificarMascotaEncontrada(personas);
    }

    @Test
    public void se_notifica_al_dueño_que_se_encontro_su_mascota() {
        dado_un_rescatista_y_un_dueño_con_mascota_existente();
        dados_que_los_dueños_y_rescatistas_estan_registrados(dueño, rescatista);
        dada_que_la_notificacion_al_dueño_es_existosa(numeroSMSRescatista, numeroContactoDueño, asuntoMascotaEncontrada, mensajeMascotaEncontrada);
        cuando_notificamos_al_dueño_que_se_encontro_su_mascota(numeroDocumentoRescatista, numeroDocumentoDueño, idMascotaEncontradaExistente);
        entonces_al_dueño_se_le_envia_al_menos_un_mensaje(asuntoMascotaEncontrada, mensajeMascotaEncontrada);
    }

    @Test
    public void no_se_notifica_al_dueño_cuando_una_mascota_encontrada_no_le_corresponde() {
        dado_un_rescatista_y_un_dueño_con_mascota_existente();
        dados_que_los_dueños_y_rescatistas_estan_registrados(dueño, rescatista);
        Assertions.assertThrows(MascotaNoCorrespondeADueñoException.class, () ->
            cuando_notificamos_al_dueño_que_se_encontro_su_mascota(numeroDocumentoRescatista, numeroDocumentoDueño, idMascotaEncontradaNoExistente));
    }

    private void dado_un_rescatista_y_un_dueño_con_mascota_existente() {
        mascota = crearMascota(idMascotaEncontradaExistente);
        dueño = crearDueño();
        contactoDueño = crearContacto(dueño, numeroContactoDueño, emailDueño);
        contactoDueño.añadirMedioDeComunicacion(sms, noEsPreferido);
        contactoDueño.añadirMedioDeComunicacion(email, esPreferido);
        contactoDueño.añadirMedioDeComunicacion(whatsApp, noEsPreferido);
        dueño.añadirContacto(contactoDueño);
        dueño.añadirMascota(mascota);
        rescatista = crearRescatista();
        contactoRescatista = crearContacto(rescatista, numeroSMSRescatista, emailRescatista);
        rescatista.añadirContacto(contactoRescatista);
        mensajeMascotaEncontrada = mensajeMascotaEncontrada(rescatista, mascota);
    }

    private void dados_que_los_dueños_y_rescatistas_estan_registrados(Dueño dueño, Rescatista rescatista) {
        Mockito.when(personas.obtenerPorNumeroDocumento(numeroDocumentoRescatista)).thenReturn(rescatista);
        Mockito.when(personas.obtenerPorNumeroDocumento(numeroDocumentoDueño)).thenReturn(dueño);
    }

    private void dada_que_la_notificacion_al_dueño_es_existosa(String origen, String destino, String asunto, String mensaje) {
        Mockito.doNothing().when(notificador).enviar(origen, destino, asunto, mensaje);
    }

    private void cuando_notificamos_al_dueño_que_se_encontro_su_mascota(int numeroDocumentoRescatista, int numeroDocumentoDueño, int idMascota) {
        notificarMascotaEncontrada.ejecutar(numeroDocumentoRescatista, numeroDocumentoDueño, idMascota);
    }

    private void entonces_al_dueño_se_le_envia_al_menos_un_mensaje(String asunto, String mensaje) {
       Mockito.verify(notificador, atLeast(1)).enviar(any(String.class), any(String.class), eq(asunto), eq(mensaje));
    }

}