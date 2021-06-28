package dominio.notificacion.estrategia;

import dominio.notificacion.mensaje.Mensaje;
import infraestructura.Notificador;

public interface EstrategiaDeComunicacion {
    void enviar(Mensaje mensaje);
}