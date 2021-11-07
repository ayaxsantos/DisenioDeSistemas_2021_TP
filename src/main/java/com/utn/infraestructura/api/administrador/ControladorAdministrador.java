package com.utn.infraestructura.api.administrador;

import com.utn.casodeuso.administrador.AccederAdministrador;
import com.utn.dominio.organizacion.Administrador;
import com.utn.infraestructura.persistencia.AdministradoresEnMySQL;
import com.utn.infraestructura.persistencia.OrganizacionesEnMySQL;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControladorAdministrador
{
    private final AccederAdministrador accederAdministrador;

    public ControladorAdministrador() {
        this.accederAdministrador = new AccederAdministrador(new AdministradoresEnMySQL(),new OrganizacionesEnMySQL());
    }

    @GetMapping("organizacion/panelAdministracion")
    public ResponseEntity acceder(@RequestBody SolicitudAcceder solicitudAcceder)
    {
        Administrador unAdministrador = accederAdministrador.ejecutar(solicitudAcceder.getNombreUsuario(),
                solicitudAcceder.getNombreOrganizacion());
        return ResponseEntity.status(200).body(unAdministrador);
    }
}
