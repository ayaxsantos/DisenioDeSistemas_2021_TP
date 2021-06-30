package accion;

import dominio.animal.Animal;
import dominio.animal.Sexo;
import dominio.animal.Tamaño;

import dominio.animal.Mascota;
import dominio.persona.Persona;
import infraestructura.personas.Personas;

public class RegistrarMascota {

    private final Personas personas;

    public RegistrarMascota(Personas personas) {
        this.personas = personas;
    }

    public void ejecutar(Integer documentoDueño, Integer idMascota, String nombre, Animal tipoAnimal, String apodo, Integer edad, Sexo sexo, Tamaño tamaño, String descripcionFisica){
        Mascota mascota = new Mascota(idMascota, nombre, tipoAnimal, apodo, edad, sexo, tamaño, descripcionFisica);
        Persona persona = personas.obtenerPorNumeroDocumento(documentoDueño);
        persona.dueño().añadirMascota(mascota);
    }

}