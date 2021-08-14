package accion.Duenio;

import dominio.Personas;
import dominio.notificacion.mensaje.Mensaje;
import dominio.notificacion.mensaje.MensajeMascotaEncontradaPorDuenioEnPublicacion;
import dominio.persona.Persona;

public class ConfirmarMascotaEncontrada {

    private Personas personas;


    public ConfirmarMascotaEncontrada(Personas personas) {
        this.personas = personas;
    }


    public void ejecutar(int numeroDocumentoRescatista, int numeroDocumentoDuenio){
        Persona personaRescatista = personas.obtenerPorNumeroDocumento(numeroDocumentoRescatista);
        Persona personaDuenio = personas.obtenerPorNumeroDocumento(numeroDocumentoDuenio);
        Mensaje mensaje = new MensajeMascotaEncontradaPorDuenioEnPublicacion(personaDuenio);
        personaRescatista.notificar(mensaje);
    }

}
