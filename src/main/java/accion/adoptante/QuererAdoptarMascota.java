package accion.adoptante;

import dominio.Personas;
import dominio.persona.Persona;
import dominio.notificacion.mensaje.Mensaje;
import dominio.notificacion.mensaje.MensajeQuererAdoptarMascota;

public class QuererAdoptarMascota {

    private final Personas personas;

    public QuererAdoptarMascota(Personas personas) {
        this.personas = personas;
    }

    public void ejecutar(int numeroDocumentoAdoptante, int numeroDocumentoDueño) {
        Persona personaAdopante = personas.obtenerPorNumeroDocumento(numeroDocumentoAdoptante);
        Persona personaDueño = personas.obtenerPorNumeroDocumento(numeroDocumentoDueño);
        Mensaje mensaje = new MensajeQuererAdoptarMascota(personaAdopante);
        personaDueño.notificar(mensaje);
    }

}