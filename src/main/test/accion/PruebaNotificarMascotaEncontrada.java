package accion;

import dominio.persona.Persona;
import accion.rescatista.NotificarMascotaEncontrada;
import dominio.excepcion.MascotaNoEncontradaException;

import dominio.Personas;
import dominio.Notificador;

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

    @BeforeEach
    void inicializar() {
        personas = Mockito.mock(Personas.class);
        notificarMascotaEncontrada = new NotificarMascotaEncontrada(personas);
        notificador = Mockito.mock(Notificador.class);
        inicializarEstrategiasDeNotificacion(notificador);
    }

    @Test
    public void se_notifica_al_dueño_que_se_encontro_su_mascota() {
        dado_un_rescatista_y_un_dueño_con_mascota_existente();
        dados_que_los_dueños_y_rescatistas_estan_registrados(personaDueño, personaRescatista);
        dada_que_la_notificacion_al_dueño_es_exitosa(numeroSMSRescatista, numeroDueño, asuntoMascotaEncontrada, mensajeMascotaEncontrada);
        cuando_notificamos_al_dueño_que_se_encontro_su_mascota(numeroDocumentoRescatista, numeroDocumentoDueño, idMascotaEncontradaExistente);
        entonces_al_dueño_se_le_envia_al_menos_un_mensaje(asuntoMascotaEncontrada, mensajeMascotaEncontrada);
    }

    @Test
    public void no_se_notifica_al_dueño_cuando_una_mascota_encontrada_no_le_corresponde() {
        dado_un_rescatista_y_un_dueño_con_mascota_existente();
        dados_que_los_dueños_y_rescatistas_estan_registrados(personaDueño, personaRescatista);
        Assertions.assertThrows(MascotaNoEncontradaException.class, () ->
            cuando_notificamos_al_dueño_que_se_encontro_su_mascota(numeroDocumentoRescatista, numeroDocumentoDueño, idMascotaEncontradaNoExistente));
    }

    private void dado_un_rescatista_y_un_dueño_con_mascota_existente() {
        inicializarMascota();
        inicializarDueño();
        inicializarRescatista();
    }

    private void dados_que_los_dueños_y_rescatistas_estan_registrados(Persona personaDueño, Persona personaRescatista) {
        Mockito.when(personas.obtenerPorNumeroDocumento(numeroDocumentoRescatista)).thenReturn(personaRescatista);
        Mockito.when(personas.obtenerPorNumeroDocumento(numeroDocumentoDueño)).thenReturn(personaDueño);
    }

    private void dada_que_la_notificacion_al_dueño_es_exitosa(String origen, String destino, String asunto, String mensaje) {
        Mockito.doNothing().when(notificador).enviar(origen, destino, asunto, mensaje);
    }

    private void cuando_notificamos_al_dueño_que_se_encontro_su_mascota(int numeroDocumentoRescatista, int numeroDocumentoDueño, int idMascota) {
        notificarMascotaEncontrada.ejecutar(numeroDocumentoRescatista, numeroDocumentoDueño, idMascota);
    }

    private void entonces_al_dueño_se_le_envia_al_menos_un_mensaje(String asunto, String mensaje) {
       Mockito.verify(notificador, atLeast(1)).enviar(any(String.class), any(String.class), eq(asunto), eq(mensaje));
    }

}