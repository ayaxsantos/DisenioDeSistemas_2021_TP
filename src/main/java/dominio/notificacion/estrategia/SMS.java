package dominio.notificacion.estrategia;

import dominio.notificacion.mensaje.Mensaje;
import infraestructura.Notificador;

public class SMS implements EstrategiaDeComunicacion {

    private Notificador notificador;

    @Override
    public void enviar(Mensaje mensaje) {
        notificador.enviar(mensaje.telefonoOrigen(), mensaje.telefonoDestino(), mensaje.cuerpo());
        System.out.println("Mensaje enviado por correo SMS!");
    }

    @Override
    public void asignarNotificador(Notificador notificador) {
        this.notificador = notificador;
    }

}