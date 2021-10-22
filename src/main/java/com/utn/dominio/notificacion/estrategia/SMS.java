package com.utn.dominio.notificacion.estrategia;

import com.utn.dominio.Notificador;
import com.utn.dominio.notificacion.MedioDeComunicacion;
import com.utn.dominio.notificacion.mensaje.Mensaje;

import javax.persistence.*;

@Entity
@DiscriminatorValue("sms")
public class SMS extends MedioDeComunicacion {


    public SMS(Notificador notificador, boolean esPreferido) {
        super(notificador, esPreferido);
    }

    public SMS() {

    }

    @Override
    public void enviar(Mensaje mensaje) {
        System.out.println(mensaje.cuerpo());
        notificador.enviar(mensaje.telefonoOrigen(), mensaje.telefonoDestino(), mensaje.asunto(), mensaje.cuerpo());
        System.out.println("Mensaje enviado por correo SMS!");
    }

}