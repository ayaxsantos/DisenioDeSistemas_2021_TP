package dominio.notificacion.estrategia;

import dominio.notificacion.mensaje.Mensaje;
import infraestructura.Notificador;

public class SMS implements EstrategiaDeComunicacion {

    private Notificador notificador;

    public SMS(Notificador notificador) {
        this.notificador = notificador;
    }

    @Override
    public void enviar(Mensaje mensaje) {
        System.out.println(mensaje.cuerpo());
        notificador.enviar(mensaje.telefonoOrigen(), mensaje.telefonoDestino(), mensaje.cuerpo());
        System.out.println("Mensaje enviado por correo SMS!");
    }

}