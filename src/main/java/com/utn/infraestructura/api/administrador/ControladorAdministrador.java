package com.utn.infraestructura.api.administrador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.ResponseEntity;

public class ControladorAdministrador
{
    @PostMapping("organizacion/panelAdministracion")
    public ResponseEntity acceder(@RequestBody SolicitudAcceder solicitudAcceder)
    {
        //accesoAdministrador.ejecutar();
        return ResponseEntity.status(200).build();
    }
}
