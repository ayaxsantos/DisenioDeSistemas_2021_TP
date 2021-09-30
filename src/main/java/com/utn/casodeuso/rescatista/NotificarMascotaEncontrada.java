package com.utn.casodeuso.rescatista;

import com.utn.dominio.animal.Mascota;
import com.utn.dominio.persona.Persona;
import com.utn.dominio.notificacion.mensaje.Mensaje;
import com.utn.dominio.notificacion.mensaje.MensajeNotificarMascotaEncontrada;

import com.utn.dominio.Personas;

public class NotificarMascotaEncontrada {

    private final Personas personas;

    public NotificarMascotaEncontrada(Personas personas) {
        this.personas = personas;
    }

    public void ejecutar(int numeroDocumentoRescatista, int numeroDocumentoDueño, int idMascota){
        Persona personaDueño =  personas.obtenerPorNumeroDocumento(numeroDocumentoDueño);
        Persona personaRescatista = personas.obtenerPorNumeroDocumento(numeroDocumentoRescatista);
        Mascota mascota = personaDueño.buscarMascota(idMascota);
        Mensaje mensaje = new MensajeNotificarMascotaEncontrada(personaRescatista, mascota);
        personaDueño.notificar(mensaje);
    }

}