import dominio.Usuario;
import dominio.excepciones.ContraseñaCortaException;
import dominio.excepciones.ContraseñaDebilException;

public class Main {

    public static void main(String[] args) {
        generarUsuario("Usuario1", "12345");
        generarUsuario("Usuario2", "Cont321Ho@13");
        generarUsuario("Usuario3", "password");
        generarUsuario("Usuario4", "kj2@3");
        generarUsuario("Usuario4", "Ho23@·Hola");
    }

    public static void generarUsuario(String usuario, String contraseña) {
        try {
            new Usuario(usuario, contraseña);
            System.out.println("Se genero correctamente: " + usuario);
        } catch (ContraseñaDebilException e) {
            System.out.println("No se pudo generar el usuario: " + usuario + ", contrasenia debil");
        } catch (ContraseñaCortaException e) {
            System.out.println("No se pudo generar el usuario: " + usuario + ", contrasenia corta");
        }

    }

}
