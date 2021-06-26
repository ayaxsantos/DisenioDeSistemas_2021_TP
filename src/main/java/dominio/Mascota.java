package dominio;

import java.util.List;
import java.util.Map;

public class Mascota {
    
    private String nombre;
    private Animal animal;
    private String apodo;
    private Integer edad;
    private Sexo sexo;
    private String descripcionFisica;
    private List<Foto> fotos;
    private Map<Caracteristica, String> caracteristicas;


    public Mascota(String nombre, Animal animal, String apodo, Integer edad, Sexo sexo, String descripcionFisica){
        this.nombre = nombre;
        this.animal = animal;
        this.apodo = apodo;
        this.edad = edad;
        this.sexo = sexo;
        this.descripcionFisica = descripcionFisica;
    }

    public void anadirFoto(Foto unaFoto){
        fotos.add(unaFoto);
    }

}
