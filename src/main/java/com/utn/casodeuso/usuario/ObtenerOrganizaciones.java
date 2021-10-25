package com.utn.casodeuso.usuario;

import com.utn.dominio.Organizaciones;
import com.utn.dominio.Usuarios;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.excepcion.CredencialesInvalidasException;
import com.utn.dominio.organizacion.Organizacion;

import java.util.List;

public class ObtenerOrganizaciones
{
    private final Usuarios usuarios;
    private final Organizaciones organizaciones;

    public ObtenerOrganizaciones(Usuarios usuarios, Organizaciones organizaciones) {
        this.usuarios = usuarios;
        this.organizaciones = organizaciones;
    }

    public List<Organizacion> ejecutar(String nombreUsuario)
    {
        Usuario unUsuario = usuarios.obtenerPorNombreUsuario(nombreUsuario);

        return unUsuario.organizacionesPertenecientes();
    }

}
