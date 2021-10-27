package com.utn.casodeuso.dueño;

import com.utn.dominio.Personas;
import com.utn.dominio.animal.Animal;
import com.utn.dominio.animal.Mascota;
import com.utn.dominio.animal.Sexo;
import com.utn.dominio.animal.Tamaño;
import com.utn.dominio.persona.Persona;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


public class RegistrarMascota {

    private final Personas personas;

    public RegistrarMascota(Personas personas) {
        this.personas = personas;
    }

    public void ejecutar(int documentoDueño, String nombre, String apodo, int edad, String tipoAnimal, String sexo,
                         String tamaño, String descripcionFisica, List<String> fotos,
                         Map<String, String> caracteristicas) {
        Persona persona = personas.obtenerPorNumeroDocumento(documentoDueño);

        Mascota mascota = new Mascota(nombre, apodo, edad, Animal.buscar(tipoAnimal), Sexo.buscar(sexo),
                Tamaño.buscar(tamaño), descripcionFisica);
        fotos.forEach(mascota::añadirFoto);
        caracteristicas.forEach(mascota::añadirCaracteristica);
        persona.añadirMascota(mascota);

        personas.guardar(persona);
    }
}
