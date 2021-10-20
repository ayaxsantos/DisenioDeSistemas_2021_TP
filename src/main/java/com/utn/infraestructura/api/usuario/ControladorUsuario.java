package com.utn.infraestructura.api.usuario;

import com.utn.casodeuso.usuario.CerrarSesion;
import com.utn.casodeuso.usuario.IniciarSesion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorUsuario {

    private final IniciarSesion iniciarSesion;
    private final CerrarSesion cerrarSesion;

    public ControladorUsuario(IniciarSesion iniciarSesion, CerrarSesion cerrarSesion) {
        this.iniciarSesion = iniciarSesion;
        this.cerrarSesion = cerrarSesion;
    }

    @PostMapping("usuarios/autenticar")
    public ResponseEntity<Void> iniciarSesion(@RequestBody SolicitudIniciarSesion solicitudIniciarSesion) {
        iniciarSesion.ejecutar(solicitudIniciarSesion.nombreUsuario(), solicitudIniciarSesion.contraseña());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("usuarios/desconectar")
    public ResponseEntity<Void> cerrarSesion(@RequestBody SolicitudCerrarSesion solicitudCerrarSesion) {
        cerrarSesion.ejecutar(solicitudCerrarSesion.nombreUsuario());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}