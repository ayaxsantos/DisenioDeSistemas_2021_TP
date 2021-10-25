package com.utn.infraestructura.api.persona;

import com.utn.casodeuso.persona.RegistrarPersona;
import com.utn.infraestructura.persistencia.PersonasEnMySQL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ControladorPersona
{
    private RegistrarPersona registrarPersona;

    public ControladorPersona() {
        this.registrarPersona = new RegistrarPersona(new PersonasEnMySQL());
    }

    //TODO Terminar
    @PostMapping("usuario/registroPersona")
    public ResponseEntity registroPersona(@RequestBody SolicitudRegistrarPersona solicitudRegistrarPersona )
    {
        registrarPersona.ejecutar(solicitudRegistrarPersona.getNombreUsuario(),
                solicitudRegistrarPersona.getTipoDocumento(),solicitudRegistrarPersona.getNumeroDocumento(),
                solicitudRegistrarPersona.getFechaNacimiento(),solicitudRegistrarPersona.getLatitud(),
                solicitudRegistrarPersona.getLongitud(),solicitudRegistrarPersona.getMediosPreferidos(),
                solicitudRegistrarPersona.getUnosContactos());

        return ResponseEntity.status(200).build();
    }
}
