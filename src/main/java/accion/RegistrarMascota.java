package accion;

import dominio.animal.Animal;
import dominio.animal.Sexo;
import dominio.persona.Dueño;
import dominio.animal.Mascota;
import dominio.persona.Persona;
import infraestructura.personas.Personas;

import java.util.List;

public class RegistrarMascota {

    private Mascota unaMascota;
    private List<Persona> unasPersonas;

    private Personas personas;

    public void ejecutar(Integer documentoDueño, Integer id, String nombre, Animal tipoAnimal, String apodo, Integer edad, Sexo sexo, String descripcionFisica){
        unaMascota = new Mascota(id, nombre, tipoAnimal, apodo, edad, sexo, descripcionFisica);
        Persona unaPersona = personas.obtenerPorNumeroDocumento(documentoDueño);
        unaPersona.dueño().añadirMascota(unaMascota);
    }




}

