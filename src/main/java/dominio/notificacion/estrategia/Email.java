package dominio.notificacion.estrategia;

import dominio.notificacion.mensaje.Mensaje;

public class Email implements EstrategiaDeComunicacion {

    @Override
    public void enviar(Mensaje mensaje) {
        System.out.println(mensaje.cuerpo());
        System.out.println("Mensaje enviado por email!");
    }

}