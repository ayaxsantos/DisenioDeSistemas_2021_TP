package dominio.persona;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

import dominio.notificacion.mensaje.Mensaje;
import dominio.persona.rol.Adoptante;
import dominio.persona.rol.Dueño;
import dominio.persona.rol.Rescatista;
import dominio.persona.rol.Voluntario;

public class Persona {

    private final Contacto contacto;
    private final LocalDateTime fechaNacimiento;
    private final Documento documento;
    private final Direccion domicilio;
    private final List<Contacto> contactos = new ArrayList<>();

    private Dueño dueño;
    private Rescatista rescatista;
    private Voluntario voluntario;
    private Adoptante adoptante;

    public Persona(Contacto contacto, LocalDateTime fechaNacimiento, Documento documento, Direccion domicilio, Contacto otroContacto) {
        this.contacto = contacto;
        this.fechaNacimiento = fechaNacimiento;
        this.documento = documento;
        this.domicilio = domicilio;
        this.contactos.add(otroContacto);
    }

    public String nombre() {
        return this.contacto.nombre();
    }

    public String telefono() {
        return this.contacto.telefono();
    }

    public String email() {
        return this.contacto.email();
    }

    public int numeroDocumento() {
        return this.documento.numero();
    }

    public Direccion domicilio() {
        return this.domicilio;
    }

    public Dueño dueño() {
        if(this.dueño == null)
            this.dueño = new Dueño();
        return this.dueño;
    }

    public Rescatista rescatista() {
        if(this.rescatista == null)
            this.rescatista = new Rescatista();
        return this.rescatista;
    }

    public Voluntario voluntario() {
        if(this.voluntario == null)
            this.voluntario = new Voluntario();
        return this.voluntario;
    }

    public Adoptante adoptante() {
        if(this.adoptante == null)
            this.adoptante = new Adoptante();
        return this.adoptante;
    }

    public void notificar(Mensaje mensaje) {
        this.contacto.notificar(mensaje);
        this.contactos.forEach(unContacto -> unContacto.notificar(mensaje));
    }

    public void añadirContacto(Contacto contacto){
        contactos.add(contacto);
    }

}