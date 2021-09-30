package com.utn.dominio.notificacion.estrategia;

import com.utn.dominio.notificacion.mensaje.Mensaje;

public interface EstrategiaDeComunicacion {
    void enviar(Mensaje mensaje);
}