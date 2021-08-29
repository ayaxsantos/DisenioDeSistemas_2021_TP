package casodeuso.dueño;

import dominio.Personas;
import dominio.persona.Persona;

import dominio.animal.Sexo;
import dominio.animal.Animal;
import dominio.animal.Tamaño;
import dominio.animal.Mascota;

import java.util.List;

public class RegistrarMascota {

    private final Personas personas;

    public RegistrarMascota(Personas personas) {
        this.personas = personas;
    }

    public void ejecutar(int documentoDueño, int idMascota, String nombre, Animal tipoAnimal,
        String apodo, int edad, Sexo sexo, Tamaño tamaño, String descripcionFisica, List<String> fotos){
            Mascota mascota = new Mascota(idMascota, nombre, tipoAnimal, apodo, edad, sexo, tamaño, descripcionFisica, fotos);
            Persona persona = personas.obtenerPorNumeroDocumento(documentoDueño);
            persona.dueño().añadirMascota(mascota);
            personas.guardar(persona);
    }

}