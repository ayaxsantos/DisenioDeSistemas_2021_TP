package dominio.notificacion.estrategia;

import dominio.Notificador;
import dominio.notificacion.mensaje.Mensaje;

public class Email implements EstrategiaDeComunicacion {

    private final Notificador notificador;

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