package com.utn.infraestructura.api.persona;

import com.utn.casodeuso.adoptante.QuererAdoptarMascota;
import com.utn.casodeuso.persona.RegistrarPersona;
import com.utn.dominio.Personas;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.persona.Persona;
import com.utn.infraestructura.api.SesionManager;
import com.utn.infraestructura.persistencia.PersonasEnMySQL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResponseEntity registroPersona(@RequestBody SolicitudRegistrarPersona solicitudRegistrarPersona)
    {
        registrarPersona.ejecutar(solicitudRegistrarPersona.getNombreUsuario(),
                solicitudRegistrarPersona.getTipoDocumento(),solicitudRegistrarPersona.getNumeroDocumento(),
                solicitudRegistrarPersona.getFechaNacimiento(),solicitudRegistrarPersona.getLatitud(),
                solicitudRegistrarPersona.getLongitud(),solicitudRegistrarPersona.getMediosPreferidos(),
                solicitudRegistrarPersona.getUnosContactos());

        return ResponseEntity.status(200).build();
    }

    @GetMapping("persona/documento")
    public ResponseEntity obtenerDocumento(@RequestHeader("Authorization") String idSesion){
        Usuario usuario = this.obtenerUsuarioSesionManager(idSesion);
        Persona persona = new PersonasEnMySQL().obtenerPorNombreDeUsuario(usuario.getUsuario());

        return ResponseEntity.status(200).body(persona.getDocumento());
    }

    @PostMapping("mascotas-en-adopcion/adoptar")
    public ResponseEntity quererAdoptar(@RequestBody SolicitudQuieroAdoptar solicitudQuieroAdoptar,
                                        @RequestHeader("Authorization") String idSesionAdoptante)
    {
        Usuario unUsuarioAdoptante = this.obtenerUsuarioSesionManager(idSesionAdoptante);

        quererAdoptarMascota.ejecutar(
                unUsuarioAdoptante.getUsuario(),
                solicitudQuieroAdoptar.getNombreUsuarioDuenio());
        return ResponseEntity.status(200).build();
    }

    private Usuario obtenerUsuarioSesionManager(String idSesion)
    {
        SesionManager sesionManager = SesionManager.getInstance();

        Map<String, Object> unosDatos = sesionManager.obtenerAtributos(idSesion);
        return (Usuario) unosDatos.get("usuario");
    }
}
