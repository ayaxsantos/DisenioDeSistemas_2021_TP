package dominio.roles;

import dominio.Contacto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Persona {

    private String nombre;
    private String apellido;
    private LocalDateTime fechaNacimiento;
    private int numeroDocumento;
    private String domicilio;
    private Contacto contactoPersonal;
    private List<Contacto> contactos;
    private List<Rol> roles;

    public void notificar(){
        contactoPersonal.notificar("");
        contactos.forEach(p -> p.notificar(""));
    }

    public Persona(String nombre, String apellido, LocalDateTime fechaNacimiento, int numeroDocumento, String domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroDocumento = numeroDocumento;
        this.domicilio = domicilio;
        this.contactoPersonal = new contactoPersonal();
        this.contactos = new ArrayList<Contacto>();
        this.roles = new ArrayList<Rol>();
    }

    public void añadirContacto(Contacto unContacto){
        contactos.add(unContacto);
    }

    public void añadirRol(Rol unRol){
        roles.add(unRol);
    }

}
