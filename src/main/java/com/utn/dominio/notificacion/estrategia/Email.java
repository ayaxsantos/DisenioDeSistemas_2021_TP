package com.utn.dominio.notificacion.estrategia;

import com.utn.dominio.Notificador;
import com.utn.dominio.notificacion.mensaje.Mensaje;

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