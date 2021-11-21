package com.utn.infraestructura.api.publicacion;

import java.util.List;
import java.util.Map;

import com.utn.casodeuso.adoptante.GenerarPublicacionBusquedaAdopcion;
import com.utn.casodeuso.rescatista.GenerarPublicacionMascotaEncontrada;
import com.utn.dominio.Organizaciones;
import com.utn.dominio.Personas;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.publicacion.PublicacionMascotaEnAdopcion;
import com.utn.infraestructura.api.SesionManager;
import com.utn.infraestructura.persistencia.PersonasEnMySQL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.utn.infraestructura.persistencia.OrganizacionesEnMySQL;
import com.utn.casodeuso.organizacion.ObtenerPublicacionesMascotaEnAdopcion;

@RestController
@CrossOrigin
public class ControladorPublicacion {

    private final ObtenerPublicacionesMascotaEnAdopcion obtenerPublicacionesMascotaEnAdopcion;
    private final GenerarPublicacionBusquedaAdopcion generarPublicacionBusquedaAdopcion;
    private final GenerarPublicacionMascotaEncontrada generarPublicacionMascotaEncontrada;

    public ControladorPublicacion(){
        Personas personasEnMySQL = new PersonasEnMySQL();
        Organizaciones organizacionesEnMySQL = new OrganizacionesEnMySQL();
        this.generarPublicacionBusquedaAdopcion = new GenerarPublicacionBusquedaAdopcion(personasEnMySQL, organizacionesEnMySQL);
        this.generarPublicacionMascotaEncontrada = new GenerarPublicacionMascotaEncontrada(organizacionesEnMySQL, personasEnMySQL);
        this.obtenerPublicacionesMascotaEnAdopcion = new ObtenerPublicacionesMascotaEnAdopcion(new OrganizacionesEnMySQL());
    }

    @PostMapping("ingresar-mascota-encontrada")
    public ResponseEntity generarPublicacionMascotaEncontrada(
            @RequestBody SolicitudCompletarFormularioMascotaEncontrada solicitudCompletarFormularioMascotaEncontrada,
            @RequestHeader("Authorization") String idSesion)
    {
        Usuario unUsuario = this.obtenerUsuarioSesionManager(idSesion);

        generarPublicacionMascotaEncontrada.ejecutar(
                unUsuario.nombreUsuario(),
                solicitudCompletarFormularioMascotaEncontrada.getNombreOrganizacion(),
                solicitudCompletarFormularioMascotaEncontrada.getLatitud(),
                solicitudCompletarFormularioMascotaEncontrada.getLongitud(),
                solicitudCompletarFormularioMascotaEncontrada.getEstadoDeLaMascota()
        );
        return ResponseEntity.status(200).build();
    }

    @PostMapping("generar-publicacion-busqueda-adopcion")
    public ResponseEntity generarPublicacionBusquedaAdopcion(
            @RequestBody SolicitudGenerarPublicacionBusquedaAdopcion solicitudGenerarPublicacionBusquedaAdopcion,
            @RequestHeader("Authorization") String idSesion)
    {
        Usuario unUsuario = this.obtenerUsuarioSesionManager(idSesion);

        generarPublicacionBusquedaAdopcion.ejecutar(
                unUsuario.nombreUsuario(),
                solicitudGenerarPublicacionBusquedaAdopcion.getNombreOrganizacion(),
                solicitudGenerarPublicacionBusquedaAdopcion.getComodidades());
        return  ResponseEntity.status(200).build();
    }

    @GetMapping("/organizacion/{nombreOrganizacion}/publicacionesMascotaAdopcion")
    public ResponseEntity<List<PublicacionMascotaEnAdopcion>> publicacionesMascotaEnAdopcion(@PathVariable("nombreOrganizacion") String nombreOrganizacion) {
        List<PublicacionMascotaEnAdopcion> publicaciones = obtenerPublicacionesMascotaEnAdopcion.ejecutar(nombreOrganizacion);
        return new ResponseEntity<>(publicaciones, HttpStatus.OK);
    }

    private Usuario obtenerUsuarioSesionManager(String idSesion)
    {
        SesionManager sesionManager = SesionManager.getInstance();

        Map<String, Object> unosDatos = sesionManager.obtenerAtributos(idSesion);
        return (Usuario) unosDatos.get("usuario");
    }
}
