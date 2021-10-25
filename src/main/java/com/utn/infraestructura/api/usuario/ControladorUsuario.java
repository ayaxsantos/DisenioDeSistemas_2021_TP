package com.utn.infraestructura.api.usuario;

import com.utn.casodeuso.usuario.CerrarSesion;
import com.utn.casodeuso.usuario.IniciarSesion;

import com.utn.infraestructura.persistencia.UsuariosEnMySQL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorUsuario {

    private final IniciarSesion iniciarSesion;
    private final CerrarSesion cerrarSesion;

    public ControladorUsuario() {
        this.iniciarSesion = new IniciarSesion(new UsuariosEnMySQL());
        this.cerrarSesion = new CerrarSesion(new UsuariosEnMySQL());
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

}