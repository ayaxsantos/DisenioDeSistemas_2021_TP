package dominio.autenticacion;

import dominio.excepcion.OrganizacionNoEncontradaException;
import dominio.organizacion.Organizacion;
import dominio.persona.Persona;

import java.util.List;

public class Usuario {

    private final String usuario;
    private final String contraseña;
    private List<Organizacion> organizacionesPertenecientes;
    private Organizacion organizacionActual;
    private Persona persona;

    public Usuario(String usuario, String contraseña, Persona persona) {
        ValidadorContraseña.ejecutar(contraseña);
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.persona = persona;
    }

    public Persona persona(){
        return this.persona;
    }

    public void cerrarSesion() {
        System.out.println("Sesion cerrada");
    }

    public void iniciarSesion(String unUsuario, String unaContraseña) {
        if (unUsuario.equals(this.usuario) && unaContraseña.equals(this.contraseña))
            System.out.println("Sesion iniciada");
        else System.out.println("Sesion fallida");
    }

    public void elegirOrganizacion(Organizacion unaOrganizacion) {
        organizacionActual = this.organizacionesPertenecientes.stream().
                filter(organizacion -> organizacion.equals(unaOrganizacion)).findFirst().orElseThrow(OrganizacionNoEncontradaException::new);
    }

    public void añadirOrganizacion(Organizacion unaOrganizacion) {
        this.organizacionesPertenecientes.add(unaOrganizacion);
    }

    public String nombreUsuario() {
        return this.usuario;
    }
}