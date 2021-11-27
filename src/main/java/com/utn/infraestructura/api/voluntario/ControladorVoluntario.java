package com.utn.infraestructura.api.voluntario;

import com.utn.casodeuso.voluntario.IniciarSesionVoluntario;
import com.utn.dominio.excepcion.UsuarioNoEncontradoException;
import com.utn.dominio.organizacion.Administrador;
import com.utn.dominio.organizacion.Voluntario;
import com.utn.infraestructura.api.SesionManager;
import com.utn.infraestructura.api.usuario.LoginResponse;
import com.utn.infraestructura.api.usuario.SolicitudIniciarSesion;
import com.utn.infraestructura.persistencia.VoluntariosEnMySQL;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
public class ControladorVoluntario {
    private final IniciarSesionVoluntario iniciarSesion;

    public ControladorVoluntario() {
        this.iniciarSesion = new IniciarSesionVoluntario(new VoluntariosEnMySQL());
    }

    @PostMapping("voluntarios/autenticar")
    public LoginResponse iniciarSesion(@RequestBody SolicitudIniciarSesion solicitud, HttpServletResponse response) {
        try {
            Voluntario voluntario = iniciarSesion.ejecutar(solicitud.nombreUsuario(), solicitud.contrasenia());;
            SesionManager sesionManager =  SesionManager.getInstance();
            String idSesion = sesionManager.crear("voluntario",voluntario);
            System.out.println(idSesion);
            return new LoginResponse(idSesion);
        }
        catch(UsuarioNoEncontradoException e) {
            return new LoginResponse("-1");
        }
    }


}
