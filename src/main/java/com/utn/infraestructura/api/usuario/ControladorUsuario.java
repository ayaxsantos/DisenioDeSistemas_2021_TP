package com.utn.infraestructura.api.usuario;

import com.utn.casodeuso.usuario.CerrarSesion;
import com.utn.casodeuso.usuario.IniciarSesion;

import com.utn.casodeuso.usuario.ObtenerOrganizaciones;
import com.utn.casodeuso.usuario.Registrar;
import com.utn.dominio.excepcion.UsuarioYaRegistradoException;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.infraestructura.persistencia.OrganizacionesEnMySQL;
import com.utn.infraestructura.persistencia.UsuariosEnMySQL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;

@RestController
public class ControladorUsuario {

    private final IniciarSesion iniciarSesion;
    private final CerrarSesion cerrarSesion;
    private final ObtenerOrganizaciones obtenerOrganizaciones;
    private final Registrar registrar;

    public ControladorUsuario() {
        this.iniciarSesion = new IniciarSesion(new UsuariosEnMySQL());
        this.cerrarSesion = new CerrarSesion(new UsuariosEnMySQL());
        this.obtenerOrganizaciones = new ObtenerOrganizaciones(new UsuariosEnMySQL(),new OrganizacionesEnMySQL());
        this.registrar = new Registrar(new UsuariosEnMySQL());
    }

    @PostMapping("usuarios/autenticar")
    public ResponseEntity iniciarSesion(@RequestBody SolicitudIniciarSesion solicitudIniciarSesion) {
        iniciarSesion.ejecutar(solicitudIniciarSesion.nombreUsuario(), solicitudIniciarSesion.contraseña());
        return ResponseEntity.status(200).build();
    }

    @PostMapping("usuarios/desconectar")
    public ResponseEntity cerrarSesion(@RequestBody SolicitudCerrarSesion solicitudCerrarSesion) {
        cerrarSesion.ejecutar(solicitudCerrarSesion.nombreUsuario());
        return ResponseEntity.status(200).build();
    }


    @GetMapping("usuarios/organizaciones")
    public ResponseEntity<List<Organizacion>> obtenerOrganizacionesUsuario(
            @RequestBody SolicitudObtenerOrganizaciones solicitudObtenerOrganizaciones)
    {
        List<Organizacion> organizacionesUsuario = obtenerOrganizaciones.ejecutar(solicitudObtenerOrganizaciones.getNombreUsuario());
        return ResponseEntity.status(200).body(organizacionesUsuario);
    }

    @PostMapping("registro")
    public ResponseEntity registrarUsuario(@RequestBody SolicitudRegistroUsuario solicitudRegistroUsuario)
    {
        try{
            registrar.ejecutar(solicitudRegistroUsuario.getNombre(), solicitudRegistroUsuario.getApellido(),
                solicitudRegistroUsuario.getNombreUsuario(),solicitudRegistroUsuario.getContraseña(),
                solicitudRegistroUsuario.getCorreoElectronico(),solicitudRegistroUsuario.getTelefono());
        }
        catch(UsuarioYaRegistradoException e){
            return ResponseEntity.status(404).body("Usuario ya registrado");
        }
        return ResponseEntity.status(200).build();
    }


}
