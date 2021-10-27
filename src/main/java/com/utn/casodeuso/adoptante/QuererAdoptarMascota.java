package com.utn.casodeuso.adoptante;

import com.utn.dominio.Personas;
import com.utn.dominio.persona.Persona;
import com.utn.dominio.notificacion.mensaje.Mensaje;
import com.utn.dominio.notificacion.mensaje.MensajeQuererAdoptarMascota;

public class QuererAdoptarMascota {

    private final Personas personas;

    public QuererAdoptarMascota(Personas personas) {
        this.personas = personas;
    }

    public void ejecutar(String nombreUsuarioAdoptante, String nombreUsuarioDueño) {
        Persona personaAdoptante = personas.obtenerPorNombreDeUsuario(nombreUsuarioAdoptante);
        Persona personaDueño = personas.obtenerPorNombreDeUsuario(nombreUsuarioDueño);

        Mensaje mensaje = new MensajeQuererAdoptarMascota(personaAdoptante);
        personaDueño.notificar(mensaje);
    }

}