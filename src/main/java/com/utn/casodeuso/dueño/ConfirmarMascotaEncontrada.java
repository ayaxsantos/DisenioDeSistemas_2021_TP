package com.utn.casodeuso.dueño;

import com.utn.dominio.Personas;
import com.utn.dominio.persona.Persona;
import com.utn.dominio.notificacion.mensaje.Mensaje;
import com.utn.dominio.notificacion.mensaje.MensajeConfirmarMascotaEncontrada;
import org.springframework.stereotype.Component;


public class ConfirmarMascotaEncontrada {

    private final Personas personas;

    public ConfirmarMascotaEncontrada(Personas personas) {
        this.personas = personas;
    }

    public void ejecutar(int numeroDocumentoRescatista, int numeroDocumentoDueño){
        Persona personaRescatista = personas.obtenerPorNumeroDocumento(numeroDocumentoRescatista);
        Persona personaDueño = personas.obtenerPorNumeroDocumento(numeroDocumentoDueño);

        Mensaje mensaje = new MensajeConfirmarMascotaEncontrada(personaDueño);
        personaRescatista.notificar(mensaje);
    }

}