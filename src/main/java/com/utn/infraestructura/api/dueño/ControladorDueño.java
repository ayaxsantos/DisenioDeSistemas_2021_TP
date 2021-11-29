package com.utn.infraestructura.api.dueño;

import com.utn.casodeuso.dueño.ConfirmarMascotaEncontrada;
import com.utn.casodeuso.dueño.GenerarPublicacionMascotaEnAdopcion;
import com.utn.casodeuso.dueño.ObtenerMascotas;
import com.utn.casodeuso.dueño.RegistrarMascota;
import com.utn.dominio.Organizaciones;
import com.utn.dominio.Personas;
import com.utn.dominio.animal.Mascota;
import com.utn.dominio.persona.TipoDocumento;
import com.utn.infraestructura.persistencia.OrganizacionesEnMySQL;
import com.utn.infraestructura.persistencia.PersonasEnMySQL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class ControladorDueño {

    private final RegistrarMascota registrarMascota;
    private final GenerarPublicacionMascotaEnAdopcion generarPublicacionMascotaEnAdopcion;
    private final ConfirmarMascotaEncontrada confirmarMascotaEncontrada;
    private final ObtenerMascotas obtenerMascotas;

    public ControladorDueño() {
        Personas personas = new PersonasEnMySQL();
        Organizaciones organizaciones = new OrganizacionesEnMySQL();
        this.registrarMascota = new RegistrarMascota(personas, organizaciones);
        this.generarPublicacionMascotaEnAdopcion = new GenerarPublicacionMascotaEnAdopcion(personas);
        this.confirmarMascotaEncontrada = new ConfirmarMascotaEncontrada(personas);
        this.obtenerMascotas = new ObtenerMascotas(personas);
    }

    @PostMapping("registrar/mascota")
    public ResponseEntity<Void> registrarMascota(@RequestBody SolicitudRegistrarMascota solicitud) {
        registrarMascota.ejecutar(solicitud.organizacion(), solicitud.numeroDocumento(), solicitud.getTipoDocumento(), solicitud.nombre(), solicitud.apodo(),
                solicitud.edad(), solicitud.tipoAnimal(), solicitud.sexo(),
                solicitud.tamaño(), solicitud.descripcionFisica(),
                solicitud.fotos(), solicitud.caracteristicas());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("duenio/mascotas")
    public ResponseEntity mascotas(@RequestHeader("numero") int numeroDocumento, @RequestHeader("tipo") TipoDocumento tipoDocumento) {
        List<Mascota> mascotas = obtenerMascotas.ejecutar(numeroDocumento, tipoDocumento);
        List<RespuestaMascotas> mascotasResponse = mascotas.stream().map(mascota -> new RespuestaMascotas(
                mascota.getNombre(),
                mascota.getFotosNormalizadas().stream().findFirst().orElseThrow(RuntimeException::new),
                mascota.getOrganizacion().getNombre())).collect(Collectors.toList());

        return ResponseEntity.status(200).body(mascotasResponse);
    }

/*
    @PostMapping("dueños/registrar/publicacion/mascotaEnAdopcion")
    public ResponseEntity<Void> generarPublicacionMascotaEnAdopcion(@RequestBody SolicitudGenerarPublicacionMascotaEnAdopcion solicitud) {
        generarPublicacionMascotaEnAdopcion.ejecutar(numeroDocumentoDueño,
                solicitud.getNombreMascota(),
                solicitud.getNombreOrganizacion(),
                solicitud.getRespuestasFormulario());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
*/

/*    @PostMapping("dueños/{numeroDocumento}/confirmarMascotaEncontrada")
    public ResponseEntity<Void> confirmarMascotaEncontrada(@PathVariable("numeroDocumento") int numeroDocumentoDueño,
                                                           @RequestBody SolicitudConfirmarMascotaEncontrada solicitudConfirmarMascotaEncontrada) {
        confirmarMascotaEncontrada.ejecutar(
                solicitudConfirmarMascotaEncontrada.documentoRescatista(),
                numeroDocumentoDueño);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

}