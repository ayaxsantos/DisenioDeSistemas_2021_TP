package dominio.notificacion;

import dominio.notificacion.mensaje.Mensaje;
import dominio.notificacion.estrategia.EstrategiaDeComunicacion;

public class MedioDeComunicacion {

    private final EstrategiaDeComunicacion estrategiaDeComunicacion;
    private final boolean esPreferido;

    public MedioDeComunicacion(EstrategiaDeComunicacion estrategiaDeComunicacion, boolean esPreferido) {
        this.estrategiaDeComunicacion = estrategiaDeComunicacion;
        this.esPreferido = esPreferido;
    }

    public void enviar(Mensaje mensaje) {
        this.estrategiaDeComunicacion.enviar(mensaje);
    }

    public boolean esPreferido() {
        return this.esPreferido;
    }

}