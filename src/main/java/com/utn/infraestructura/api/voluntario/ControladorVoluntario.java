package com.utn.infraestructura.api.voluntario;

import com.utn.casodeuso.organizacion.ObtenerPublicacionesMascotaEnAdopcion;
import com.utn.casodeuso.voluntario.IniciarSesionVoluntario;
import com.utn.dominio.excepcion.UsuarioNoEncontradoException;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.organizacion.Voluntario;
import com.utn.dominio.publicacion.Publicacion;
import com.utn.dominio.publicacion.PublicacionMascotaEnAdopcion;
import com.utn.infraestructura.api.SesionManager;
import com.utn.infraestructura.api.usuario.LoginResponse;
import com.utn.infraestructura.api.usuario.SolicitudIniciarSesion;
import com.utn.infraestructura.persistencia.OrganizacionesEnMySQL;
import com.utn.infraestructura.persistencia.VoluntariosEnMySQL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class ControladorVoluntario {
    private final IniciarSesionVoluntario iniciarSesion;
    private final ObtenerPublicacionesMascotaEnAdopcion obtenerPublicacionesMascotaEnAdopcion;

    public ControladorVoluntario() {
        this.iniciarSesion = new IniciarSesionVoluntario(new VoluntariosEnMySQL());
        this.obtenerPublicacionesMascotaEnAdopcion = new ObtenerPublicacionesMascotaEnAdopcion(new OrganizacionesEnMySQL());
    }

    @PostMapping("voluntarios/autenticar")
    public LoginResponse iniciarSesion(@RequestBody SolicitudIniciarSesion solicitud, HttpServletResponse response) {
        try {
            Voluntario voluntario = iniciarSesion.ejecutar(solicitud.nombreUsuario(), solicitud.contrasenia());
            ;
            SesionManager sesionManager = SesionManager.getInstance();
            String idSesion = sesionManager.crear("voluntario", voluntario);
            System.out.println(idSesion);
            return new LoginResponse(idSesion);
        } catch (UsuarioNoEncontradoException e) {
            return new LoginResponse("-1");
        }
    }

/*    @GetMapping("voluntario/organizacion/panelVoluntario")

    @GetMapping("organizacion/panelVoluntario")
    public ResponseEntity acceder(@RequestHeader("Authorization") String idVoluntario) {
        Voluntario voluntario = this.obtenerVolSesionManager(idVoluntario);
        Organizacion organizacion = voluntario.getOrganizacion();

        List<PublicacionMascotaEnAdopcion> publicaciones = obtenerPublicacionesMascotaEnAdopcion.ejecutar(nombreOrganizacion)
                .stream().filter(Publicacion::isEstaVisible).collect(Collectors.toList());

        return ResponseEntity.status(200).body(unaRespuesta);
    }*/


    private Voluntario obtenerVolSesionManager(String idVoluntario) {
        SesionManager sesionManager = SesionManager.getInstance();
        Map<String, Object> unosDatos = sesionManager.obtenerAtributos(idVoluntario);
        return (Voluntario) unosDatos.get("voluntario");
    }

}
