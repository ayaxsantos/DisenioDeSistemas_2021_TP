package casodeuso.rescatista;

import dominio.animal.Mascota;
import dominio.persona.Persona;
import dominio.notificacion.mensaje.Mensaje;
import dominio.notificacion.mensaje.MensajeNotificarMascotaEncontrada;

import dominio.Personas;

public class NotificarMascotaEncontrada {

    private final Personas personas;

    public NotificarMascotaEncontrada(Personas personas) {
        this.personas = personas;
    }

    public void ejecutar(int numeroDocumentoRescatista, int numeroDocumentoDueño, int idMascota){
        Persona personaDueño =  personas.obtenerPorNumeroDocumento(numeroDocumentoDueño);
        Persona personaRescatista = personas.obtenerPorNumeroDocumento(numeroDocumentoRescatista);
        Mascota mascota = personaDueño.dueño().buscarMascota(idMascota);
        Mensaje mensaje = new MensajeNotificarMascotaEncontrada(personaRescatista, mascota);
        personaDueño.notificar(mensaje);
    }

}