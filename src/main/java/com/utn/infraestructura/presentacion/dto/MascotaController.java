package com.utn.infraestructura.presentacion.dto;

import com.utn.dominio.animal.Mascota;

import com.utn.infraestructura.persistencia.mascota.MascotasEnMySQL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController
{
    private MascotasEnMySQL repositorioMascotas;

   // public MascotaController()
    //{
   //     this.repositorioMascotas = new MascotasEnMySQL();
    //}

    @PostMapping("/RegistrarMascota")
    public ResponseEntity registrarMascota(@RequestBody Mascota unaMascota)
    {
        System.out.println("Creando una Mascota.../n");
        repositorioMascotas.guardar(unaMascota);
        return ResponseEntity.status(200).body(unaMascota);
    }
}
