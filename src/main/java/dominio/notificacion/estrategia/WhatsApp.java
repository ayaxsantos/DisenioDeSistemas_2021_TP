package dominio.notificacion.estrategia;

import dominio.notificacion.mensaje.Mensaje;

import infraestructura.notificador.Notificador;
import infraestructura.notificador.NotificadorTwilio;

public class WhatsApp implements EstrategiaDeComunicacion {

    private final Notificador notificador;
    private final String prefijo = "whatsapp:";

    public WhatsApp() {
        this.notificador = new NotificadorTwilio();
    }

    public WhatsApp(Notificador notificador) {
        this.notificador = notificador;
    }

    @Override
    public void enviar(Mensaje mensaje) {
        notificador.enviar(prefijo + mensaje.telefonoOrigen(), prefijo + mensaje.telefonoDestino(), mensaje.asunto(), mensaje.cuerpo());
        System.out.println("Mensaje enviado por WhatsApp!");
    }

}