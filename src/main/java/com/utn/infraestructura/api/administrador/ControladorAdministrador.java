package com.utn.infraestructura.api.administrador;

import com.utn.casodeuso.administrador.AccederAdministrador;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.excepcion.UsuarioNoEncontradoException;
import com.utn.dominio.excepcion.UsuarioNoEsAdministradorException;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.infraestructura.api.SesionManager;
import com.utn.infraestructura.persistencia.AdministradoresEnMySQL;
import com.utn.infraestructura.persistencia.OrganizacionesEnMySQL;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import java.util.Map;


@RestController
@CrossOrigin
public class ControladorAdministrador
{
    private final AccederAdministrador accederAdministrador;

    public ControladorAdministrador() {
        this.accederAdministrador = new AccederAdministrador(new AdministradoresEnMySQL(),new OrganizacionesEnMySQL());
    }

    @GetMapping("organizacion/panelAdministracion")
    public ResponseEntity acceder(@RequestBody SolicitudAcceder solicitudAcceder, @RequestHeader("Authorization") String idSesion)
    {
        try {
            SesionManager sesionManager = SesionManager.getInstance();

            Map<String, Object> unosDatos = sesionManager.obtenerAtributos(idSesion);
            Usuario unUsuario = (Usuario) unosDatos.get("usuario");

            Organizacion unaOrganizacion = accederAdministrador.ejecutar(unUsuario.nombreUsuario(),
                    solicitudAcceder.getNombreOrganizacion());

            RespuestaAcceso unaRespuesta = new RespuestaAcceso();
            unaRespuesta.setUnaOrganizacion(unaOrganizacion);
            unaRespuesta.setNombreUsuario(unUsuario.nombreUsuario());
            
            return ResponseEntity.status(200).body(unaRespuesta);
        }
        catch(UsuarioNoEncontradoException | NullPointerException e)
        {
            return ResponseEntity.status(404).build();
        }
        catch(UsuarioNoEsAdministradorException e)
        {
            return ResponseEntity.status(402).build();
        }
    }
}
