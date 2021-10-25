package com.utn.casodeuso.persona;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.dominio.Personas;
import com.utn.dominio.notificacion.MedioDeComunicacion;
import com.utn.dominio.persona.*;

import java.time.LocalDate;
import java.util.List;

public class RegistrarPersona {
    private final Personas personas;

    public RegistrarPersona(Personas personas) {
        this.personas = personas;
    }

    public void ejecutar(String nombreUsuario, TipoDocumento tipoDocumento, int numeroDocumento, LocalDate fechaNacimiento, int latitud, int longitud, String mediosPreferidos, List<Contacto> unosContactos) {
        Persona persona = personas.obtenerPorNombreDeUsuario(nombreUsuario);
        persona.setDocumento(new Documento(tipoDocumento, numeroDocumento));
        persona.setFechaNacimiento(fechaNacimiento);
        persona.setDomicilio(new Direccion(latitud, longitud));

        List<MedioDeComunicacion> mediosDeComunicacion = this.obtenerMediosDeComunicacion(mediosPreferidos); //TODO

        persona.getContactoPersonal().setMediosDeComunicacion(mediosDeComunicacion);
        persona.setContactos(unosContactos);

        personas.guardar(persona);
    }

    private List<MedioDeComunicacion> obtenerMediosDeComunicacion(String mediosPreferidos) {
        return null;
    }
}