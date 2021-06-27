package dominio.autenticacion;

import dominio.persona.Persona;

public class Usuario {

    private final String usuario;
    private final String contraseña;
    private Persona persona;

    public Usuario(String usuario, String contraseña) {
        ValidadorContraseña.ejecutar(contraseña);
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

}