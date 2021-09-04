package dominio;

import dominio.autenticacion.Usuario;
import dominio.excepcion.ContraseñaCortaException;
import dominio.excepcion.ContraseñaDebilException;

import dominio.excepcion.OrganizacionNoEncontradaException;
import dominio.foto.CalidadFoto;
import dominio.foto.TamañoFoto;
import dominio.organizacion.Organizacion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static dominio.FixtureUsuario.*;

public class PruebaUsuario {

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

    @Test
    public void un_usuario_inicia_sesion_correctamente() {
        //Dado un usuario generado previamente en el sistema
        Usuario usuario = new Usuario(nombreUsuario, contraseñaSegura, persona);
        //Cuando intento iniciar sesion con credenciales validas
        String nombreUsuarioValido = "ccalvoromero";
        String contraseñaValida = "Cont321Ho@13";
        usuario.iniciarSesion(nombreUsuarioValido, contraseñaValida);
        //Entonces el usuario se loguea correctamente
        Assertions.assertTrue(usuario.estaLogueado());
    }

    @Test
    public void un_usuario_cierra_sesion_correctamente() {
        //Dado un usuario generado previamente en el sistema
        Usuario usuario = new Usuario(nombreUsuario, contraseñaSegura, persona);
        usuario.setEstaLogueado(true);
        usuario.cerrarSesion();
        Assertions.assertFalse(usuario.estaLogueado());
    }

    @Test
    public void un_usuario_intenta_iniciar_sesion_con_contraseña_invalida() {
    //Dado un usuario generado previamente en el sistema
        Usuario usuario = new Usuario(nombreUsuario, contraseñaSegura, persona);
        //Cuando intento iniciar sesion con credenciales validas
        String nombreUsuarioValido = "ccalvoromero";
        String contraseñaInvalida = "cualquiercosa";
        usuario.iniciarSesion(nombreUsuarioValido, contraseñaInvalida);
        //Entonces el usuario se loguea correctamente
        Assertions.assertFalse(usuario.estaLogueado());
    }

    @Test
    public void se_añade_una_organizacion_correctamente() {
        Usuario usuario = new Usuario(nombreUsuario, contraseñaSegura, persona);
        Organizacion organizacion = new Organizacion(new TamañoFoto(1,1), CalidadFoto.BAJA);
        usuario.añadirOrganizacion(organizacion);
        Assertions.assertEquals(1, usuario.organizacionesPertenecientes().size());
    }

    @Test
    public void se_elige_una_organizacion_correctamente() {
        Usuario usuario = new Usuario(nombreUsuario, contraseñaSegura, persona);
        Organizacion organizacion = new Organizacion(new TamañoFoto(1,1), CalidadFoto.BAJA);
        usuario.añadirOrganizacion(organizacion);
        usuario.elegirOrganizacion(organizacion);
        Assertions.assertEquals(organizacion, usuario.organizacionActual());
    }

    @Test
    public void se_elige_una_organizacion_inexistente() {
        Usuario usuario = new Usuario(nombreUsuario, contraseñaSegura, persona);
        Organizacion organizacion = new Organizacion(new TamañoFoto(1,1), CalidadFoto.BAJA);
        Assertions.assertThrows(OrganizacionNoEncontradaException.class,
                () -> usuario.elegirOrganizacion(organizacion));
    }

}
