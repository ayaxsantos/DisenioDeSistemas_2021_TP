package dominio.notificacion.estrategia;

import dominio.notificacion.mensaje.Mensaje;
import infraestructura.Notificador;

public class WhatsApp implements EstrategiaDeComunicacion {

    private Notificador notificador;
    private final static String PREFIJO = "whatsapp:";

    public WhatsApp(Notificador notificador) {
        this.notificador = notificador;
    }

    @Override
    public void enviar(Mensaje mensaje) {
        notificador.enviar(PREFIJO + mensaje.telefonoOrigen(), PREFIJO + mensaje.telefonoDestino(), mensaje.cuerpo());
        System.out.println("Mensaje enviado por WhatsApp!");
    }

}