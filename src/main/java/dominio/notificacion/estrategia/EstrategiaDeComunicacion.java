package dominio.notificacion.estrategia;

import dominio.notificacion.mensaje.Mensaje;

public interface EstrategiaDeComunicacion {
    void enviar(Mensaje mensaje);
}