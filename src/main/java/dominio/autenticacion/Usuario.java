package dominio.autenticacion;

import dominio.persona.Persona;
import dominio.organizacion.Organizacion;
import dominio.excepcion.OrganizacionNoEncontradaException;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private final String usuario;
    private final String contraseña;
    private List<Organizacion> organizacionesPertenecientes;
    private Organizacion organizacionActual;
    private Persona persona;
    private boolean estaLogueado = false;

    public Usuario(String usuario, String contraseña, Persona persona) {
        ValidadorContraseña.ejecutar(contraseña);
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.persona = persona;
        this.organizacionesPertenecientes = new ArrayList<>();
    }

    public Persona persona(){
        return this.persona;
    }

    public boolean existe(String unUsuario) {
        return this.usuario.equals(unUsuario);
    }

    public void iniciarSesion(String usuario, String contraseña) {
        this.estaLogueado = this.usuario.equals(usuario) && this.contraseña.equals(contraseña);
    }

    public void cerrarSesion() {
        this.estaLogueado = false;
    }

    public void elegirOrganizacion(Organizacion unaOrganizacion) {
        organizacionActual = this.organizacionesPertenecientes.stream()
            .filter(organizacion -> organizacion.equals(unaOrganizacion))
            .findFirst()
            .orElseThrow(OrganizacionNoEncontradaException::new);
    }

    public void añadirOrganizacion(Organizacion organizacion) {
        this.organizacionesPertenecientes.add(organizacion);
    }

    public String nombreUsuario() {
        return this.usuario;
    }

    public boolean estaLogueado() {
        return estaLogueado;
    }

    public void setEstaLogueado(boolean estaLogueado) {
        this.estaLogueado = estaLogueado;
    }

    public List<Organizacion> organizacionesPertenecientes() {
        return organizacionesPertenecientes;
    }

    public Organizacion organizacionActual() {
        return organizacionActual;
    }
}