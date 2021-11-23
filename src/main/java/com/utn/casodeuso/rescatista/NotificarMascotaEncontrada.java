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

    public void ejecutar(int numeroDocumentoRescatista, String tipoDocumentoRescatista, int numeroDocumentoDueño, String tipoDocumentoDueño, String nombreMascota){
        Persona personaDueño =  personas.obtenerPorNumeroDocumento(numeroDocumentoDueño, tipoDocumentoDueño);
        Persona personaRescatista = personas.obtenerPorNumeroDocumento(numeroDocumentoRescatista, tipoDocumentoRescatista);


        Mascota mascota = personaDueño.buscarMascota(nombreMascota);
        Mensaje mensaje = new MensajeNotificarMascotaEncontrada(personaRescatista, mascota);

        personaDueño.notificar(mensaje);
    }

}