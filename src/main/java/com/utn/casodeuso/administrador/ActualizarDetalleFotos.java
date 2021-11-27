package com.utn.casodeuso.administrador;

import com.utn.dominio.Administradores;
import com.utn.dominio.organizacion.Administrador;
import com.utn.dominio.organizacion.CalidadFoto;
import com.utn.dominio.organizacion.TamañoFoto;

public class ActualizarDetalleFotos
{
    Administradores administradores;

    public ActualizarDetalleFotos(Administradores administradores) {
        this.administradores = administradores;
    }

    public void ejecutar(String nombreUsuario, String unTamaño, String unaCalidad)
    {
        Administrador unAdministrador = this.administradores.obtenerPorNombreUsuario(nombreUsuario);
        unAdministrador.definirTamañoFoto(TamañoFoto.buscar(unTamaño));
        unAdministrador.definirCalidadFoto(CalidadFoto.buscar(unaCalidad));
        administradores.guardar(unAdministrador);
    }
}
