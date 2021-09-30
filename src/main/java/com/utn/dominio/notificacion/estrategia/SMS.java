package com.utn.dominio.notificacion.estrategia;

import com.utn.dominio.Notificador;
import com.utn.dominio.notificacion.mensaje.Mensaje;

public class SMS implements EstrategiaDeComunicacion {

    private final Notificador notificador;

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