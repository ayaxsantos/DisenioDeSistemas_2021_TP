package dominio;

public class Usuario {

    private final String usuario;
    private final String contraseña;

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        ValidadorContraseña.ejecutar(contraseña);
        this.contraseña = contraseña;
    }

}