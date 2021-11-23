package com.utn.infraestructura.api.dueño;

import com.utn.casodeuso.dueño.ConfirmarMascotaEncontrada;
import com.utn.casodeuso.dueño.GenerarPublicacionMascotaEnAdopcion;
import com.utn.casodeuso.dueño.RegistrarMascota;
import com.utn.dominio.Organizaciones;
import com.utn.dominio.Personas;
import com.utn.infraestructura.persistencia.OrganizacionesEnMySQL;
import com.utn.infraestructura.persistencia.PersonasEnMySQL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
public class ControladorDueño {

    private final RegistrarMascota registrarMascota;
    private final GenerarPublicacionMascotaEnAdopcion generarPublicacionMascotaEnAdopcion;
    private final ConfirmarMascotaEncontrada confirmarMascotaEncontrada;

    public ControladorDueño() {
        Personas personas = new PersonasEnMySQL();
        Organizaciones organizaciones = new OrganizacionesEnMySQL();
        this.registrarMascota = new RegistrarMascota(personas);
        this.generarPublicacionMascotaEnAdopcion = new GenerarPublicacionMascotaEnAdopcion(personas, organizaciones);
        this.confirmarMascotaEncontrada = new ConfirmarMascotaEncontrada(personas);
    }

    @PostMapping("registrar/mascota")
    public ResponseEntity<Void> registrarMascota(@RequestBody SolicitudRegistrarMascota solicitud) {
  /*      HashMap<String, String> caracteristicas = new HashMap<>();
        solicitud.caracteristicasPreguntas().forEach(caracteristica -> caracteristicas.put(caracteristica, caracteristica.valor()));*/
        registrarMascota.ejecutar(
                solicitud.numeroDocumento(), solicitud.tipoDocumento(), solicitud.nombre(), solicitud.apodo(),
                solicitud.edad(), solicitud.tipoAnimal(), solicitud.sexo(),
                solicitud.tamaño(), solicitud.descripcionFisica(),
                solicitud.fotos(), solicitud.caracteristicas());
        return new ResponseEntity<>(HttpStatus.CREATED);
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