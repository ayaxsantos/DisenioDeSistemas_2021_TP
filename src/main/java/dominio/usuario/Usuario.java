package dominio.usuario;

import dominio.roles.Persona;

public class Usuario {

    private final String usuario;
    private final String contraseña;
    private Persona persona;

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        ValidadorContraseña.ejecutar(contraseña);
        this.contraseña = contraseña;
    }

    public void completarInformacionPersonal(){

    }

}