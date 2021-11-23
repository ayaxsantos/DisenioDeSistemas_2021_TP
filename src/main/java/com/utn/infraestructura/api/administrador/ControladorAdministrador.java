package com.utn.infraestructura.api.administrador;

import com.utn.casodeuso.administrador.AccederAdministrador;
import com.utn.casodeuso.organizacion.ObtenerTodasLasOrganizaciones;
import com.utn.casodeuso.usuario.ObtenerOrganizaciones;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.excepcion.UsuarioNoEncontradoException;
import com.utn.dominio.excepcion.UsuarioNoEsAdministradorException;
import com.utn.dominio.foto.CalidadFoto;
import com.utn.dominio.foto.TamañoFoto;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.infraestructura.api.SesionManager;
import com.utn.infraestructura.persistencia.AdministradoresEnMySQL;
import com.utn.infraestructura.persistencia.OrganizacionesEnMySQL;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@CrossOrigin
public class ControladorAdministrador
{
    private final AccederAdministrador accederAdministrador;
    private final ObtenerTodasLasOrganizaciones obtenerOrganizaciones;

    public ControladorAdministrador() {
        this.obtenerOrganizaciones = new ObtenerTodasLasOrganizaciones(new OrganizacionesEnMySQL());
        this.accederAdministrador = new AccederAdministrador(new AdministradoresEnMySQL(),new OrganizacionesEnMySQL());
    }

    @GetMapping("organizacion/{nombreOrganizacion}/panelAdministracion")
    public ResponseEntity acceder(@PathVariable("nombreOrganizacion") String nombreOrganizacion,
                                  @RequestHeader("Authorization") String idSesion)
    {
        try {

            Usuario unUsuario = this.obtenerUsuarioSesionManager(idSesion);

            Organizacion unaOrganizacion = accederAdministrador.ejecutar(unUsuario.nombreUsuario(), nombreOrganizacion);

            CalidadFoto unaCalidad = unaOrganizacion.calidadFoto();
            TamañoFoto unTamaño = unaOrganizacion.tamañoFoto();

            List<String> unosUsuarios = unaOrganizacion.getPersonas().stream().map(
                    unaPersona -> unaPersona.getUsuario().nombreUsuario()
            ).collect(Collectors.toList());

            List<String> unasCaracteristicas = unaOrganizacion.getCaracteristicas();

            RespuestaAcceso unaRespuesta = new RespuestaAcceso();
            unaRespuesta.setUsuariosSinPrivilegios(unosUsuarios);
            unaRespuesta.setNombreUsuario(unUsuario.nombreUsuario());
            unaRespuesta.setCalidadFoto(unaCalidad);
            unaRespuesta.setTamañoFoto(unTamaño);
            unaRespuesta.setCaracteristicas(unasCaracteristicas);

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

    @GetMapping("/organizaciones")
    public ResponseEntity obtenerOrganizaciones()
    {
        List<Organizacion> unasOrganizaciones = obtenerOrganizaciones.ejecutar();
        List<String> nombresOrganizaciones = unasOrganizaciones.stream().map(
                unaOrg -> unaOrg.getNombre()
        ).collect(Collectors.toList());

        RespuestaOrganizaciones respuesta = new RespuestaOrganizaciones();
        respuesta.setNombresOrganizaciones(nombresOrganizaciones);

        return ResponseEntity.status(200).body(respuesta);
    }

    private Usuario obtenerUsuarioSesionManager(String idSesion)
    {
        SesionManager sesionManager = SesionManager.getInstance();

        Map<String, Object> unosDatos = sesionManager.obtenerAtributos(idSesion);
        return (Usuario) unosDatos.get("usuario");
    }
}
