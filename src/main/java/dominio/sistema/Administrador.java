package dominio.sistema;

import dominio.autenticacion.Usuario;
import dominio.organizacion.Organizacion;
import dominio.organizacion.Caracteristica;

public class Administrador {

    private final Usuario usuario;
    private final Organizacion organizacion;

    public Administrador(Usuario unUsuario, Organizacion unaOrganizacion) {
        this.organizacion = unaOrganizacion;
        this.usuario = unUsuario;
    }

    public void definirTamañoFoto(int alto, int ancho) {
        organizacion.tamañoFoto(alto, ancho);
    }

    public void definirCalidadFoto(String calidad) {
        organizacion.calidadFoto(calidad);
    }

    public void añadirCaracteristica(Caracteristica unaCaracteristica) {
        organizacion.añadirCaracteristica(unaCaracteristica);
    }

    public void quitarCaracteristica(Caracteristica unaCaracteristica) {
        organizacion.quitarCaracteristica(unaCaracteristica);
    }

    public Administrador crearAdministrador(Usuario unUsuario, Organizacion unaOrganizacion) {
        return new Administrador(unUsuario, unaOrganizacion);
    }

}