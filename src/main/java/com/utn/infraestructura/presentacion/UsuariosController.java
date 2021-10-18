package com.utn.infraestructura.presentacion;
import com.utn.dominio.excepcion.CredencialesInvalidasException;
import com.utn.infraestructura.presentacion.dto.DatosUsuario;

import com.utn.dominio.autenticacion.Usuario;

import com.utn.infraestructura.persistencia.usuario.UsuariosEnMySQL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuariosController {
    private final UsuariosEnMySQL repositorioUsuarios;

    public UsuariosController() {
        this.repositorioUsuarios = new UsuariosEnMySQL();
    }

    @GetMapping("RescateDePatitas/IniciarSesion/{nombreUsuario} & {contraseña}")
    public ResponseEntity<DatosUsuario> verificarCredenciales(@PathVariable String nombreUsuario, @PathVariable String contraseña) {
        Usuario unUsuario = repositorioUsuarios.obtenerPorNombreUsuario(nombreUsuario);
        try {
            unUsuario.iniciarSesion(nombreUsuario, contraseña);
        } catch (CredencialesInvalidasException e) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).build();
    }
}
