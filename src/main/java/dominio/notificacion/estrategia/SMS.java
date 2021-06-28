package dominio.notificacion.estrategia;

import dominio.notificacion.mensaje.Mensaje;

import infraestructura.notificador.Notificador;
import infraestructura.notificador.NotificadorTwilio;

public class SMS implements EstrategiaDeComunicacion {

    private final Notificador notificador;

    public SMS() {
        this.notificador = new NotificadorTwilio();
    }

    public SMS(Notificador notificador) {
        this.notificador = notificador;
    }

    @Override
    public void enviar(Mensaje mensaje) {
        System.out.println(mensaje.cuerpo());
        notificador.enviar(mensaje.telefonoOrigen(), mensaje.telefonoDestino(), mensaje.asunto(), mensaje.cuerpo());
        System.out.println("Mensaje enviado por correo SMS!");
    }

}