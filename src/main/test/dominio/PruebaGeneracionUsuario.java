package dominio;

import dominio.autenticacion.Usuario;
import dominio.excepcion.ContraseñaCortaException;
import dominio.excepcion.ContraseñaDebilException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static dominio.FixtureGeneracionUsuario.*;

public class PruebaGeneracionUsuario {

    @Test
    public void un_usuario_con_contraseña_segura_se_genera_correctamente() {
        Usuario usuario = new Usuario(nombreUsuario, contraseñaSegura, persona);
        Assertions.assertEquals(usuario.nombreUsuario(), nombreUsuario);
    }

    @Test
    public void un_usuario_con_contraseña_debil_lanza_una_excepcion() {
        Assertions.assertThrows(ContraseñaDebilException.class,
            () -> new Usuario(nombreUsuario, contraseñaDebil, persona));
    }

    @Test
    public void un_usuario_con_contraseña_corta_lanza_una_excepcion() {
        Assertions.assertThrows(ContraseñaCortaException.class,
            () -> new Usuario(nombreUsuario, contraseñaCorta, persona));
    }

}