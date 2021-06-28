package accion;

import dominio.animal.Mascota;
import dominio.persona.Dueño;
import dominio.persona.Rescatista;
import dominio.notificacion.mensaje.Mensaje;
import dominio.notificacion.mensaje.MensajeMascotaEncontrada;

import infraestructura.personas.Personas;

public class NotificarMascotaEncontrada {

    private final Personas personas;

    public NotificarMascotaEncontrada(Personas personas) {
        this.personas = personas;
    }

    public void ejecutar(int numeroDocumentoRescatista, int numeroDocumentoDueño, int idMascota){
        Dueño dueño = (Dueño) personas.obtenerPorNumeroDocumento(numeroDocumentoDueño);
        Rescatista rescatista = (Rescatista) personas.obtenerPorNumeroDocumento(numeroDocumentoRescatista);
        Mascota mascota = dueño.buscarMascota(idMascota);
        Mensaje mensaje = new MensajeMascotaEncontrada(rescatista, mascota);
        dueño.notificar(mensaje);
    }

}