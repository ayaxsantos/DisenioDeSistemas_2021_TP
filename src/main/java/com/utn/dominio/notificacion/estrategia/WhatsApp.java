package com.utn.dominio.notificacion.estrategia;

import com.utn.dominio.Notificador;
import com.utn.dominio.notificacion.MedioDeComunicacion;
import com.utn.dominio.notificacion.mensaje.Mensaje;

import javax.persistence.*;

@Entity
@DiscriminatorValue("whatsapp")
public class WhatsApp extends MedioDeComunicacion {

    @Transient
    private final String prefijo = "whatsapp:";

    public WhatsApp(Notificador notificador, boolean esPreferido) {
        super(notificador, esPreferido);
    }

    public WhatsApp() {

    }

    @Override
    public void enviar(Mensaje mensaje) {
        notificador.enviar(prefijo + mensaje.telefonoOrigen(), prefijo + mensaje.telefonoDestino(), mensaje.asunto(), mensaje.cuerpo());
        System.out.println("Mensaje enviado por WhatsApp!");
    }

}