package com.utn.infraestructura.api.publicacion;

import java.util.List;

import com.utn.dominio.publicacion.PublicacionMascotaEnAdopcion;
import org.springframework.http.HttpStatus;
import com.utn.dominio.publicacion.Publicacion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.utn.infraestructura.persistencia.OrganizacionesEnMySQL;
import com.utn.casodeuso.organizacion.ObtenerPublicacionesMascotaEnAdopcion;

@RestController
public class ControladorPublicacion {

    private final ObtenerPublicacionesMascotaEnAdopcion obtenerPublicacionesMascotaEnAdopcion;

    public ControladorPublicacion() {
        this.obtenerPublicacionesMascotaEnAdopcion = new ObtenerPublicacionesMascotaEnAdopcion(new OrganizacionesEnMySQL());
    }

    @GetMapping("/organizacion/{nombreOrganizacion}/publicacionesMascotaAdopcion")
    public ResponseEntity<List<PublicacionMascotaEnAdopcion>> publicacionesMascotaEnAdopcion(@PathVariable("nombreOrganizacion") String nombreOrganizacion) {
        List<PublicacionMascotaEnAdopcion> publicaciones = obtenerPublicacionesMascotaEnAdopcion.ejecutar(nombreOrganizacion);
        return new ResponseEntity<>(publicaciones, HttpStatus.OK);
    }
}
