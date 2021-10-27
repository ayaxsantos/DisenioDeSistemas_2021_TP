package com.utn.infraestructura.api.usuario;

import com.utn.casodeuso.adoptante.GenerarPublicacionBusquedaAdopcion;
import com.utn.casodeuso.rescatista.BuscarHogarTransito;
import com.utn.casodeuso.rescatista.GenerarPublicacionMascotaEncontrada;
import com.utn.casodeuso.usuario.CerrarSesion;
import com.utn.casodeuso.usuario.IniciarSesion;

import com.utn.casodeuso.usuario.ObtenerOrganizaciones;
import com.utn.casodeuso.usuario.Registrar;
import com.utn.casodeuso.adoptante.QuererAdoptarMascota;
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

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorUsuario {  //Todo: agregar buscarHogarDeTransito

    private final IniciarSesion iniciarSesion;
    private final CerrarSesion cerrarSesion;
    private final ObtenerOrganizaciones obtenerOrganizaciones;
    private final Registrar registrar;
    private final QuererAdoptarMascota quererAdoptarMascota;
    private final GenerarPublicacionBusquedaAdopcion generarPublicacionBusquedaAdopcion;
    private final GenerarPublicacionMascotaEncontrada generarPublicacionMascotaEncontrada;
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
        this.quererAdoptarMascota = new QuererAdoptarMascota(personasEnMySQL);
        this.generarPublicacionBusquedaAdopcion = new GenerarPublicacionBusquedaAdopcion(personasEnMySQL, organizacionesEnMySQL);
        this.generarPublicacionMascotaEncontrada = new GenerarPublicacionMascotaEncontrada(organizacionesEnMySQL, personasEnMySQL);
        this.buscarHogarTransito = new BuscarHogarTransito(personasEnMySQL, mascotasEnMySQL, hogares, validaciones);
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

    @PostMapping("mascotas-en-adopcion/adoptar")
    public ResponseEntity quererAdoptar(@RequestBody SolicitudQuieroAdoptar solicitudQuieroAdoptar)
    {
        quererAdoptarMascota.ejecutar(
                solicitudQuieroAdoptar.getNombreUsuarioAdoptante(),
                solicitudQuieroAdoptar.getNombreUsuarioAdoptante());
        return ResponseEntity.status(200).build();
    }

    @PostMapping("generar-publicacion-busqueda-adopcion")
    public ResponseEntity generarPublicacionBusquedaAdopcion(
            @RequestBody SolicitudGenerarPublicacionBusquedaAdopcion solicitudGenerarPublicacionBusquedaAdopcion)
    {
        generarPublicacionBusquedaAdopcion.ejecutar(
                solicitudGenerarPublicacionBusquedaAdopcion.getNombreUsuario(),
                solicitudGenerarPublicacionBusquedaAdopcion.getNombreOrganizacion(),
                solicitudGenerarPublicacionBusquedaAdopcion.getComodidades());
        return  ResponseEntity.status(200).build();
    }

    @PostMapping("ingresar-mascota-encontrada")
    public ResponseEntity generarPublicacionMascotaEncontrada(
            @RequestBody SolicitudCompletarFormularioMascotaEncontrada solicitudCompletarFormularioMascotaEncontrada)
    {
        generarPublicacionMascotaEncontrada.ejecutar(
                solicitudCompletarFormularioMascotaEncontrada.getNombreUsuario(),
                solicitudCompletarFormularioMascotaEncontrada.getNombreOrganizacion(),
                solicitudCompletarFormularioMascotaEncontrada.getLatitud(),
                solicitudCompletarFormularioMascotaEncontrada.getLongitud(),
                solicitudCompletarFormularioMascotaEncontrada.getEstadoDeLaMascota()
        );
        return ResponseEntity.status(200).build();
    }

    @GetMapping("buscar-hogar-de-transito")
    public ResponseEntity buscarHogarDeTransito(SolicitudBuscarHogarTransito solicitudBuscarHogarTransito){
        List<Hogar> unosHogares = buscarHogarTransito.ejecutar(solicitudBuscarHogarTransito.getNombreUsuario(),
                solicitudBuscarHogarTransito.getIdMascota());
        return ResponseEntity.status(200).body(unosHogares);
    }

}
