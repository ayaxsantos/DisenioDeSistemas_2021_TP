package dominio.persona;

import dominio.notificacion.Contacto;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public abstract class Persona {

    private final String nombre;
    private final String apellido;
    private final LocalDateTime fechaNacimiento;
    private final int numeroDocumento;
    private final String domicilio;
    private final List<Contacto> contactos = new ArrayList<>();

    public Persona(String nombre, String apellido, LocalDateTime fechaNacimiento, int numeroDocumento, String domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroDocumento = numeroDocumento;
        this.domicilio = domicilio;
    }

    public void añadirContacto(Contacto unContacto){
        contactos.add(unContacto);
    }

    public String nombre() {
        return this.nombre;
    }

    public String apellido() {
        return this.apellido;
    }

    public List<Contacto> contactos() {
        return this.contactos;
    }

}