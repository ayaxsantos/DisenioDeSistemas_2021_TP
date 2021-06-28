package dominio.notificacion.estrategia;

import dominio.notificacion.mensaje.Mensaje;
import infraestructura.Notificador;
import infraestructura.implementacion.NotificadorTwilio;

public class WhatsApp implements EstrategiaDeComunicacion {

    private final Notificador notificador;
    private final static String PREFIJO = "whatsapp:";

    public WhatsApp() {
        this.notificador = new NotificadorTwilio();
    }

    public WhatsApp(Notificador notificador) {
        this.notificador = notificador;
    }

    @Override
    public void enviar(Mensaje mensaje) {
        notificador.enviar(PREFIJO + mensaje.telefonoOrigen(), PREFIJO + mensaje.telefonoDestino(), mensaje.asunto(), mensaje.cuerpo());
        System.out.println("Mensaje enviado por WhatsApp!");
    }

}