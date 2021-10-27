package com.utn.casodeuso.persona;

import com.utn.dominio.Personas;
import com.utn.dominio.notificacion.MedioDeComunicacion;
import com.utn.dominio.notificacion.estrategia.Email;
import com.utn.dominio.notificacion.estrategia.SMS;
import com.utn.dominio.notificacion.estrategia.WhatsApp;
import com.utn.dominio.persona.*;
import com.utn.infraestructura.api.persona.DatosContacto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class RegistrarPersona {
    private final Personas personas;

    public RegistrarPersona(Personas personas) {
        this.personas = personas;
    }

    public void ejecutar(String nombreUsuario, TipoDocumento tipoDocumento, int numeroDocumento,
                         LocalDate fechaNacimiento, int latitud, int longitud, List<String> mediosPreferidos,
                         List<DatosContacto> datosContactos) {
        Persona persona = personas.obtenerPorNombreDeUsuario(nombreUsuario);
        persona.setDocumento(new Documento(tipoDocumento, numeroDocumento));
        persona.setFechaNacimiento(fechaNacimiento);
        persona.setDomicilio(new Direccion(latitud, longitud));
        List<Contacto> unosContactos = datosContactos.stream().map(
                unosDatos -> this.datosAContacto(unosDatos)
        ).collect(Collectors.toList());

        //TODO: Delegar esto, repeticion de logica!!
        List<MedioDeComunicacion> mediosDeComunicacion = mediosPreferidos.stream().map(
                unMedio -> this.obtenerMediosDeComunicacion(unMedio)
        ).collect(Collectors.toList());

        persona.getContactoPersonal().setMediosDeComunicacion(mediosDeComunicacion);
        persona.setContactos(unosContactos);

        personas.guardar(persona);
    }

    private Contacto datosAContacto(DatosContacto datos)
    {
        Contacto unContacto = new Contacto(datos.getNombre(),datos.getApellido(),
                datos.getTelefono(),datos.getEmail());
        List<MedioDeComunicacion> mediosComunicacion = datos.getMediosComunicacion().stream().map(
                unMedio -> this.obtenerMediosDeComunicacion(unMedio)
        ).collect(Collectors.toList());
        unContacto.setMediosDeComunicacion(mediosComunicacion);
        return unContacto;
    }

    private MedioDeComunicacion obtenerMediosDeComunicacion(String unMedio)
    {
        switch (unMedio)
        {
            case "WhatsApp":
                return new WhatsApp(null,false);
            case "Email":
                return new Email(null,false);
            case "SMS":
                return new SMS(null,false);
            default: return null;
        }
    }
}
