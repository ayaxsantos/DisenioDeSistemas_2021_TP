package com.utn.infraestructura.api.usuario;

import com.utn.casodeuso.adoptante.GenerarPublicacionBusquedaAdopcion;
import com.utn.casodeuso.rescatista.BuscarHogarTransito;
import com.utn.casodeuso.rescatista.GenerarPublicacionMascotaEncontrada;
import com.utn.casodeuso.usuario.CerrarSesion;
import com.utn.casodeuso.usuario.IniciarSesion;

import com.utn.casodeuso.usuario.ObtenerOrganizaciones;
import com.utn.casodeuso.usuario.Registrar;
import com.utn.casodeuso.adoptante.QuererAdoptarMascota;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.excepcion.CredencialesInvalidasException;
import com.utn.dominio.excepcion.UsuarioNoEncontradoException;
import com.utn.dominio.excepcion.UsuarioYaRegistradoException;
import com.utn.dominio.hogar.ValidacionHogar;
import com.utn.dominio.hogar.criterios.*;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.infraestructura.hogares.Hogar;
import com.utn.infraestructura.hogares.ServicioHogares;
import com.utn.infraestructura.persistencia.MascotasEnMySQL;
import com.utn.infraestructura.persistencia.OrganizacionesEnMySQL;
import com.utn.infraestructura.persistencia.PersonasEnMySQL;
import com.utn.infraestructura.persistencia.UsuariosEnMySQL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.utn.dominio.Hogares;

import com.utn.dominio.Personas;
import com.utn.dominio.Usuarios;
import com.utn.dominio.Organizaciones;
import com.utn.dominio.Mascotas;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ControladorUsuario {  //Todo: agregar buscarHogarDeTransito

    private final IniciarSesion iniciarSesion;
    private final CerrarSesion cerrarSesion;
    private final ObtenerOrganizaciones obtenerOrganizaciones;
    private final Registrar registrar;
    private final BuscarHogarTransito buscarHogarTransito;

    public ControladorUsuario() {
        Usuarios usuariosEnMySQL = new UsuariosEnMySQL();
        Personas personasEnMySQL = new PersonasEnMySQL();
        Organizaciones organizacionesEnMySQL = new OrganizacionesEnMySQL();
        Mascotas mascotasEnMySQL = new MascotasEnMySQL();
        Hogares hogares = new ServicioHogares();
        
        List<ValidacionHogar> validaciones = new ArrayList<ValidacionHogar>() {{
            add(new CapacidadDisponible());
            add(new Cercania());
            add(new CumpleCaracteristicas());
            add(new TamañoMascota());
            add(new TipoAnimal());
        }};

        this.iniciarSesion = new IniciarSesion(usuariosEnMySQL);
        this.cerrarSesion = new CerrarSesion(usuariosEnMySQL);
        this.obtenerOrganizaciones = new ObtenerOrganizaciones(usuariosEnMySQL);
        this.registrar = new Registrar(usuariosEnMySQL, organizacionesEnMySQL, personasEnMySQL);
        this.buscarHogarTransito = new BuscarHogarTransito(personasEnMySQL, mascotasEnMySQL, hogares, validaciones);
    }

    @PostMapping("usuarios/autenticar")
    public LoginResponse iniciarSesion(@RequestBody SolicitudIniciarSesion solicitudIniciarSesion,
                                        HttpServletResponse response) {
        try {
            Usuario unUsuario = iniciarSesion.ejecutar(solicitudIniciarSesion.nombreUsuario(), solicitudIniciarSesion.contrasenia());
            SesionManager sesionManager =  SesionManager.getInstance();
            String idSesion = sesionManager.crear("usuario",unUsuario);
            System.out.println(idSesion);
            return new LoginResponse(idSesion,true);
        }
        catch(UsuarioNoEncontradoException e) {
            return new LoginResponse("-1",false);
        }
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
        List<Organizacion> organizacionesUsuario = obtenerOrganizaciones.ejecutar(solicitudObtenerOrganizaciones
                .getNombreUsuario());
        return ResponseEntity.status(200).body(organizacionesUsuario);
    }

    @PostMapping("registro") //Todo: contraseña segura catch
    public ResponseEntity registrarUsuario(@RequestBody SolicitudRegistroUsuario solicitudRegistroUsuario)
    {
        try{
            registrar.ejecutar(solicitudRegistroUsuario.getNombre(), solicitudRegistroUsuario.getApellido(),
                solicitudRegistroUsuario.getNombreUsuario(),solicitudRegistroUsuario.getContraseña(),
                solicitudRegistroUsuario.getCorreoElectronico(),solicitudRegistroUsuario.getTelefono(),
                    solicitudRegistroUsuario.getNombreOrganizacion());
        }
        catch(UsuarioYaRegistradoException e){
            return ResponseEntity.status(404).body("Usuario ya registrado");
        }
        return ResponseEntity.status(200).build();
    }

    @GetMapping("buscar-hogar-de-transito")
    public ResponseEntity buscarHogarDeTransito(SolicitudBuscarHogarTransito solicitudBuscarHogarTransito){
        List<Hogar> unosHogares = buscarHogarTransito.ejecutar(solicitudBuscarHogarTransito.getNombreUsuario(),
                solicitudBuscarHogarTransito.getIdMascota());
        return ResponseEntity.status(200).body(unosHogares);
    }

}
