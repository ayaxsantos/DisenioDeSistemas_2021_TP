package com.utn.infraestructura.presentacion.dto;

import com.utn.casodeuso.usuario.IniciarSesion;
import com.utn.dominio.Mascotas;
import com.utn.dominio.animal.Mascota;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.infraestructura.persistencia.MascotasEnMySQL;
import com.utn.infraestructura.persistencia.UsuariosEnMySQL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UsuarioController
{
    private final Mascotas unasMascotas;

    public UsuarioController()
    {
        this.unasMascotas = new MascotasEnMySQL();
    }

    @PostMapping("user/auth")
    public ResponseEntity login(@RequestBody DatosMascota mascota)
    {
        System.out.println(mascota.getUnid());
        Mascota unaMascota = unasMascotas.obtenerPorId(mascota.getUnid());

        return ResponseEntity.status(201).body(unaMascota);
    }
}
