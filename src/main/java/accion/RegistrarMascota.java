package accion;

import dominio.animal.Animal;
import dominio.animal.Sexo;
import dominio.animal.Tamaño;
import dominio.persona.Dueño;
import dominio.animal.Mascota;
import dominio.persona.Persona;
import infraestructura.personas.Personas;

import java.util.List;

public class RegistrarMascota {

    private Mascota unaMascota;

    private Personas personas;

    public void ejecutar(Integer documentoDueño, Integer id, String nombre, Animal tipoAnimal, String apodo, Integer edad, Sexo sexo, Tamaño tamaño, String descripcionFisica){
        unaMascota = new Mascota(id, nombre, tipoAnimal, apodo, edad, sexo, tamaño, descripcionFisica);
        Persona unaPersona = personas.obtenerPorNumeroDocumento(documentoDueño);
        unaPersona.dueño().añadirMascota(unaMascota);
    }




}

