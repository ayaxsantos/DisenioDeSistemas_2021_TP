package com.utn.infraestructura.api.persona;

import com.utn.casodeuso.adoptante.QuererAdoptarMascota;
import com.utn.casodeuso.persona.RegistrarPersona;
import com.utn.dominio.Personas;
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
    private final RegistrarPersona registrarPersona;
    private final QuererAdoptarMascota quererAdoptarMascota;

    public ControladorPersona() {
        Personas personasEnMySQL = new PersonasEnMySQL();
        this.quererAdoptarMascota = new QuererAdoptarMascota(personasEnMySQL);
        this.registrarPersona = new RegistrarPersona(personasEnMySQL);
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

    @PostMapping("mascotas-en-adopcion/adoptar")
    public ResponseEntity quererAdoptar(@RequestBody SolicitudQuieroAdoptar solicitudQuieroAdoptar)
    {
        quererAdoptarMascota.ejecutar(
                solicitudQuieroAdoptar.getNombreUsuarioAdoptante(),
                solicitudQuieroAdoptar.getNombreUsuarioAdoptante());
        return ResponseEntity.status(200).build();
    }
}
