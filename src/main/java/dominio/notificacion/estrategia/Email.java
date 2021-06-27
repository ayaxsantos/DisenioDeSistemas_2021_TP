package dominio.notificacion.estrategia;

import dominio.notificacion.mensaje.Mensaje;
import infraestructura.Notificador;

public class Email implements EstrategiaDeComunicacion {

    private Notificador notificador;

    @Override
    public void enviar(Mensaje mensaje) {
        System.out.println(mensaje.cuerpo());
        System.out.println("Mensaje enviado por email!");
    }

    @Override
    public void asignarNotificador(Notificador notificador) {
        this.notificador = notificador;
    }

}