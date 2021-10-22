package com.utn.dominio.notificacion.estrategia;

import com.utn.dominio.Notificador;
import com.utn.dominio.notificacion.MedioDeComunicacion;
import com.utn.dominio.notificacion.mensaje.Mensaje;

import javax.persistence.*;

@Entity
@DiscriminatorValue("email")
public class Email extends MedioDeComunicacion {

    public Email(Notificador notificador, boolean esPreferido) {
        super(notificador, esPreferido);
    }

    public Email() {

    }

    @Override
    public void enviar(Mensaje mensaje) {
        System.out.println(mensaje.cuerpo());
        notificador.enviar("no_email_origen", mensaje.emailDestino(), mensaje.asunto(), mensaje.cuerpo());
        System.out.println("Mensaje enviado por email!");
    }
}