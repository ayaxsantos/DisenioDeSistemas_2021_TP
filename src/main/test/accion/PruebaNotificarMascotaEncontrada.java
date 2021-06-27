package accion;

import infraestructura.Personas;
import infraestructura.Notificador;
import dominio.excepcion.MascotaNoCorrespondeADueñoException;

import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.atLeast;
import static accion.FixtureNotificarMascotaEncontrada.*;

public class PruebaNotificarMascotaEncontrada {

    private Personas personas;
    private Notificador notificador;
    private NotificarMascotaEncontrada notificarMascotaEncontrada;

    @BeforeEach
    void initialize() {
        notificador = Mockito.mock(Notificador.class);
        email.asignarNotificador(notificador);
        sms.asignarNotificador(notificador);
        whatsApp.asignarNotificador(notificador);
        personas = Mockito.mock(Personas.class);
        notificarMascotaEncontrada = new NotificarMascotaEncontrada(personas);
    }

    @Test
    public void se_notifica_al_dueño_que_se_encontro_su_mascota() {
        dados_dueños_y_rescatistas_registrados();
        dada_una_notificacion_existosa();
        cuando_notificamos_al_dueño_que_se_encontro_su_mascota(numeroDocumentoRescatista, numeroDocumentoDueño, idMascotaEncontradaExistente);
        entonces_al_dueño_se_le_envia_el_mensaje_correspondiente();
    }

    @Test
    public void no_se_notifica_al_dueño_cuando_una_mascota_encontrada_no_le_corresponde() {
        dados_dueños_y_rescatistas_registrados();
        Assertions.assertThrows(MascotaNoCorrespondeADueñoException.class, () ->
            cuando_notificamos_al_dueño_que_se_encontro_su_mascota(numeroDocumentoRescatista, numeroDocumentoDueño, idMascotaEncontradaNoExistente));
    }

    private void dados_dueños_y_rescatistas_registrados() {
        Mockito.when(personas.obtenerPorNumeroDocumento(numeroDocumentoRescatista)).thenReturn(unRescatista);
        Mockito.when(personas.obtenerPorNumeroDocumento(numeroDocumentoDueño)).thenReturn(unDueño);
    }

    private void dada_una_notificacion_existosa() {
        Mockito.doNothing().when(notificador).enviar(numeroSMSRescatista, numeroContactoDueño, mensajeMascotaEncontrada);
    }

    private void cuando_notificamos_al_dueño_que_se_encontro_su_mascota(int numeroDocumentoRescatista, int numeroDocumentoDueño, int idMascota) {
        notificarMascotaEncontrada.ejecutar(numeroDocumentoRescatista, numeroDocumentoDueño, idMascota);
    }

    private void entonces_al_dueño_se_le_envia_el_mensaje_correspondiente() {
       Mockito.verify(notificador, atLeast(1)).enviar(numeroSMSRescatista, numeroContactoDueño, mensajeMascotaEncontrada);
    }

}