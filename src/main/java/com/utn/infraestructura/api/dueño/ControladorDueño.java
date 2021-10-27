package com.utn.infraestructura.api.dueño;

import com.utn.dominio.Personas;
import com.utn.dominio.Organizaciones;
import com.utn.casodeuso.dueño.RegistrarMascota;
import com.utn.casodeuso.dueño.ConfirmarMascotaEncontrada;
import com.utn.casodeuso.dueño.GenerarPublicacionMascotaEnAdopcion;

import com.utn.infraestructura.persistencia.PersonasEnMySQL;
import com.utn.infraestructura.persistencia.OrganizacionesEnMySQL;

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
        Personas personas = new PersonasEnMySQL();
        Organizaciones organizaciones = new OrganizacionesEnMySQL();
        this.registrarMascota = new RegistrarMascota(personas);
        this.generarPublicacionMascotaEnAdopcion = new GenerarPublicacionMascotaEnAdopcion(personas, organizaciones);
        this.confirmarMascotaEncontrada = new ConfirmarMascotaEncontrada(personas);
    }

    @PostMapping("dueños/{numeroDocumento}/mascotas")
    public ResponseEntity<Void> registrarMascota(
        @PathVariable("numeroDocumento") int numeroDocumentoDueño, @RequestBody SolicitudRegistrarMascota solicitud){
            registrarMascota.ejecutar(
                numeroDocumentoDueño, solicitud.nombre(), solicitud.apodo(),
                solicitud.edad(), solicitud.tipoAnimal() , solicitud.sexo(),
                solicitud.tamaño(), solicitud.descripcionFisica(),
                solicitud.fotos(), solicitud.caracteristicas());
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("dueños/{numeroDocumento}/publicacionMascotaEnAdopcion")
    public ResponseEntity<Void> generarPublicacionMascotaEnAdopcion(
        @PathVariable("numeroDocumento") int numeroDocumentoDueño,
        @RequestBody SolicitudGenerarPublicacionMascotaEnAdopcion solicitudGenerarPublicacionMascotaEnAdopcion) {
            generarPublicacionMascotaEnAdopcion.ejecutar(numeroDocumentoDueño,
                solicitudGenerarPublicacionMascotaEnAdopcion.getNombreMascota(),
                solicitudGenerarPublicacionMascotaEnAdopcion.getNombreOrganizacion(),
                solicitudGenerarPublicacionMascotaEnAdopcion.getRespuestasFormulario());
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("dueños/{numeroDocumento}/confirmarMascotaEncontrada")
    public ResponseEntity<Void> confirmarMascotaEncontrada(@PathVariable("numeroDocumento") int numeroDocumentoDueño,
        @RequestBody SolicitudConfirmarMascotaEncontrada solicitudConfirmarMascotaEncontrada) {
            confirmarMascotaEncontrada.ejecutar(
                    solicitudConfirmarMascotaEncontrada.documentoRescatista(),
                    numeroDocumentoDueño);
            return new ResponseEntity<>(HttpStatus.OK);
    }

}