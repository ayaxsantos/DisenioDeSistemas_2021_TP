package com.utn.infraestructura.api.dueño;

import com.utn.casodeuso.dueño.ConfirmarMascotaEncontrada;
import com.utn.casodeuso.dueño.RegistrarMascota;
import com.utn.casodeuso.dueño.GenerarPublicacionMascotaEnAdopcion;

import com.utn.infraestructura.persistencia.OrganizacionesEnMySQL;
import com.utn.infraestructura.persistencia.PersonasEnMySQL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ControladorDueño {

    private final RegistrarMascota registrarMascota;
    private final GenerarPublicacionMascotaEnAdopcion generarPublicacionMascotaEnAdopcion;
    private final ConfirmarMascotaEncontrada confirmarMascotaEncontrada;

    public ControladorDueño(){
        this.registrarMascota = new RegistrarMascota(new PersonasEnMySQL());
        this.generarPublicacionMascotaEnAdopcion = new GenerarPublicacionMascotaEnAdopcion(new PersonasEnMySQL(),new OrganizacionesEnMySQL());
        this.confirmarMascotaEncontrada = new ConfirmarMascotaEncontrada(new PersonasEnMySQL());
    }

    @PostMapping("dueños/{numeroDocumento}/mascotas")
    public ResponseEntity<Void> registrarMascota(
        @PathVariable("numeroDocumento") int numeroDocumentoDueño, @RequestBody SolicitudRegistrarMascota solicitud){
            registrarMascota.ejecutar(
                numeroDocumentoDueño, solicitud.nombre(),
                solicitud.apodo(), solicitud.edad(), solicitud.tipoAnimal() ,solicitud.sexo(), solicitud.tamaño(), solicitud.descripcionFisica(),
                solicitud.fotos(), solicitud.caracteristicas());
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //TODO eliminar si no hace falta
    /*@PostMapping("dueños/{numeroDocumento}/publicaciones")
    public ResponseEntity<Void> generarPublicacionMascotaEnAdopcion(
        @PathVariable("numeroDocumento") int numeroDocumentoDueño,
        @RequestBody SolicitudGenerarPublicacionMascotaEnAdopcion solicitudGenerarPublicacionMascotaEnAdopcion) {
            generarPublicacionMascotaEnAdopcion.ejecutar(numeroDocumentoDueño,
                solicitudGenerarPublicacionMascotaEnAdopcion.idMascota(),
                solicitudGenerarPublicacionMascotaEnAdopcion.idOrganizacion(),
                solicitudGenerarPublicacionMascotaEnAdopcion.respuestasMascota());
            return new ResponseEntity<>(HttpStatus.CREATED);
    }*/

    @PostMapping("dueños/{numeroDocumento}/publicaciones")
    public ResponseEntity<Void> generarPublicacionMascotaEnAdopcion(
        @PathVariable("numeroDocumento") int numeroDocumentoDueño,
        @RequestBody SolicitudGenerarPublicacionMascotaEnAdopcion solicitudGenerarPublicacionMascotaEnAdopcion) {
            generarPublicacionMascotaEnAdopcion.ejecutar(numeroDocumentoDueño,
                solicitudGenerarPublicacionMascotaEnAdopcion.nombreMascota(),
                solicitudGenerarPublicacionMascotaEnAdopcion.nombreOrganizacion(),
                solicitudGenerarPublicacionMascotaEnAdopcion.respuestasMascota());
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("dueños/{numeroDocumento}/publicacionesEncontrada")
    public ResponseEntity<Void> confirmarMascotaEncontrada(
        @PathVariable("numeroDocumento") int numeroDocumentoDueño,
        @RequestBody SolicitudConfirmarMascotaEncontrada solicitudConfirmarMascotaEncontrada) {
            confirmarMascotaEncontrada.ejecutar(solicitudConfirmarMascotaEncontrada.documentoRescatista(), numeroDocumentoDueño);
            return new ResponseEntity<>(HttpStatus.OK);
    }

}