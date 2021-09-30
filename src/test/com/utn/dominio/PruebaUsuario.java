package com.utn.dominio;

import com.utn.dominio.excepcion.CredencialesInvalidasException;
import com.utn.dominio.foto.TamañoFoto;
import com.utn.dominio.foto.CalidadFoto;
import com.utn.dominio.organizacion.Organizacion;

import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.excepcion.ContraseñaCortaException;
import com.utn.dominio.excepcion.ContraseñaDebilException;
import com.utn.dominio.excepcion.OrganizacionNoEncontradaException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static com.utn.dominio.FixtureUsuario.*;

public class PruebaUsuario {

    @Test
    public void un_usuario_con_contraseña_segura_se_genera_correctamente() {
        Usuario usuario = new Usuario(nombreUsuario, contraseñaSegura);
        Assertions.assertEquals(usuario.nombreUsuario(), nombreUsuario);
    }

    @Test
    public void un_usuario_con_contraseña_debil_lanza_una_excepcion() {
        Assertions.assertThrows(ContraseñaDebilException.class,
            () -> new Usuario(nombreUsuario, contraseñaDebil));
    }

    @Test
    public void un_usuario_con_contraseña_corta_lanza_una_excepcion() {
        Assertions.assertThrows(ContraseñaCortaException.class,
            () -> new Usuario(nombreUsuario, contraseñaCorta));
    }

    @Test
    public void un_usuario_inicia_sesion_correctamente() {
        //Dado un usuario generado previamente en el sistema
        Usuario usuario = new Usuario(nombreUsuario, contraseñaSegura);
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
        Usuario usuario = new Usuario(nombreUsuario, contraseñaSegura);
        usuario.setEstaLogueado(true);
        usuario.cerrarSesion();
        Assertions.assertFalse(usuario.estaLogueado());
    }

    @Test
    public void un_usuario_intenta_iniciar_sesion_con_contraseña_invalida() {
    //Dado un usuario generado previamente en el sistema
        Usuario usuario = new Usuario(nombreUsuario, contraseñaSegura);
        //Cuando intento iniciar sesion con credenciales validas
        String nombreUsuarioValido = "ccalvoromero";
        String contraseñaInvalida = "cualquiercosa";
        //Entonces el usuario se loguea correctamente
        Assertions.assertThrows(CredencialesInvalidasException.class,
            () -> usuario.iniciarSesion(nombreUsuarioValido, contraseñaInvalida));
    }

    @Test
    public void se_añade_una_organizacion_correctamente() {
        Usuario usuario = new Usuario(nombreUsuario, contraseñaSegura);
        Organizacion organizacion = new Organizacion(new TamañoFoto(1,1), CalidadFoto.BAJA);
        usuario.añadirOrganizacion(organizacion);
        Assertions.assertEquals(1, usuario.organizacionesPertenecientes().size());
    }

    @Test
    public void se_elige_una_organizacion_correctamente() {
        Usuario usuario = new Usuario(nombreUsuario, contraseñaSegura);
        Organizacion organizacion = new Organizacion(new TamañoFoto(1,1), CalidadFoto.BAJA);
        usuario.añadirOrganizacion(organizacion);
        usuario.elegirOrganizacionActual(organizacion);
        Assertions.assertEquals(organizacion, usuario.organizacionActual());
    }

    @Test
    public void se_elige_una_organizacion_inexistente() {
        Usuario usuario = new Usuario(nombreUsuario, contraseñaSegura);
        Organizacion organizacion = new Organizacion(new TamañoFoto(1,1), CalidadFoto.BAJA);
        Assertions.assertThrows(OrganizacionNoEncontradaException.class,
                () -> usuario.elegirOrganizacionActual(organizacion));
    }

}
