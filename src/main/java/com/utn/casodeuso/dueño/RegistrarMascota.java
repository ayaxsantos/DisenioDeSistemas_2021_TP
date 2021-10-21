package com.utn.casodeuso.dueño;

import java.util.Map;
import java.util.List;

import com.utn.dominio.Personas;
import com.utn.dominio.animal.Sexo;
import com.utn.dominio.animal.Animal;
import com.utn.dominio.animal.Tamaño;
import com.utn.dominio.animal.Mascota;
import com.utn.dominio.persona.Persona;

import org.springframework.stereotype.Component;

@Component
public class RegistrarMascota {

    private final Personas personas;

    public RegistrarMascota(Personas personas) {
        this.personas = personas;
    }

    public void ejecutar(int documentoDueño, int idMascota, String nombre, String tipoAnimal, String apodo, int edad,
        String sexo, String tamaño, String descripcionFisica, List<String> fotos, Map<String, String> caracteristicas){
            Mascota mascota = new Mascota(nombre,
                apodo, edad, Animal.buscar(tipoAnimal), Sexo.buscar(sexo), Tamaño.buscar(tamaño),
                descripcionFisica);
            fotos.forEach(unaFoto -> mascota.añadirFoto(unaFoto));
            caracteristicas.forEach((unaCaracteristica, unaRespuesta) -> mascota.añadirCaracteristica(unaCaracteristica, unaRespuesta)); //TODO testear que funcione bien
            Persona persona = personas.obtenerPorNumeroDocumento(documentoDueño);
            persona.añadirMascota(mascota);
            personas.guardar(persona);
    }

}