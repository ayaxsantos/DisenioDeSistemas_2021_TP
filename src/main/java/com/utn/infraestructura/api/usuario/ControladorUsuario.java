package com.utn.infraestructura.api.usuario;

import com.utn.casodeuso.usuario.CerrarSesion;
import com.utn.casodeuso.usuario.IniciarSesion;

import com.utn.dominio.autenticacion.Usuario;
import com.utn.infraestructura.persistencia.UsuariosEnMySQL;
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
        //this.iniciarSesion = iniciarSesion;
        this.iniciarSesion = new IniciarSesion(new UsuariosEnMySQL());
        this.cerrarSesion = cerrarSesion;
    }

    @PostMapping("usuarios/autenticar")
    public ResponseEntity<Void> iniciarSesion(@RequestBody SolicitudIniciarSesion solicitudIniciarSesion) {
        System.out.println("Usuario " + solicitudIniciarSesion.nombreUsuario()+ " Contra " + solicitudIniciarSesion.contraseña());
        iniciarSesion.ejecutar(solicitudIniciarSesion.nombreUsuario(), solicitudIniciarSesion.contraseña());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("usuarios/desconectar")
    public ResponseEntity<Void> cerrarSesion(@RequestBody SolicitudCerrarSesion solicitudCerrarSesion) {
        cerrarSesion.ejecutar(solicitudCerrarSesion.nombreUsuario());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}