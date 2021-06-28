package dominio.notificacion.estrategia;

import dominio.notificacion.mensaje.Mensaje;
import infraestructura.Notificador;
import infraestructura.implementacion.NotificadorEmail;

public class Email implements EstrategiaDeComunicacion {

    private final Notificador notificador;

    public Email() {
        this.notificador = new NotificadorEmail();
    }

    public Email(Notificador notificador) {
        this.notificador = notificador;
    }

    @Override
    public void enviar(Mensaje mensaje) {
        System.out.println(mensaje.cuerpo());
        notificador.enviar("no_email_origen", mensaje.emailDestino(), mensaje.asunto(), mensaje.cuerpo());
        System.out.println("Mensaje enviado por email!");
    }

}