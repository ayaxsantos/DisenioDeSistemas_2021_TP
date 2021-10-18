package com.utn.infraestructura.presentacion.dto;

public class DatosUsuario {
    
    private boolean confirmacion;

    public void setConfirmacion(boolean unaConfirmacion)
    {
        this.confirmacion = unaConfirmacion;
    }
    
    public boolean getConfirmacion()
    {
        return this.confirmacion;
    }
}
