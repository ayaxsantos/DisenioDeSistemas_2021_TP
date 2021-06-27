package dominio.notificacion.estrategia;

import dominio.notificacion.mensaje.Mensaje;
import infraestructura.Notificador;

public class WhatsApp implements EstrategiaDeComunicacion {

    private Notificador notificador;
    private final static String PREFIJO = "whatsapp:";

    @Override
    public void enviar(Mensaje mensaje) {
        notificador.enviar(PREFIJO + mensaje.telefonoOrigen(), PREFIJO + mensaje.telefonoDestino(), mensaje.cuerpo());
        System.out.println("Mensaje enviado por WhatsApp!");
    }

    @Override
    public void asignarNotificador(Notificador notificador) {
        this.notificador = notificador;
    }

}