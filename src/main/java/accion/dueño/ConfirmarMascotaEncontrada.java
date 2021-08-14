package accion.dueño;

import dominio.Personas;
import dominio.persona.Persona;
import dominio.notificacion.mensaje.Mensaje;
import dominio.notificacion.mensaje.MensajeConfirmarMascotaEncontrada;

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