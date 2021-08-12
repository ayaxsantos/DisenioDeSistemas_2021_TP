package infraestructura;

import dominio.excepcion.EmailNoEnviadoException;
import dominio.Notificador;
import infraestructura.notificador.NotificadorEmail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import static infraestructura.FixtureNotificadorEmail.*;

public class PruebaNotificadorEmail {

    private Notificador notificadorEmail;

    @BeforeEach
    void inicializar() {
        notificadorEmail = new NotificadorEmail();
    }

    @Test
    public void se_envia_un_email_correctamente() {
        notificadorEmail.enviar(emailOrigen, emailDestinoValido, asunto, cuerpo);
    }

    @Test
    public void se_envia_un_email_y_lanza_una_excepcion() {
        Assertions.assertThrows(EmailNoEnviadoException.class, () ->
            notificadorEmail.enviar(emailOrigen, emailDestinoInvalido, asunto, cuerpo));
    }

}