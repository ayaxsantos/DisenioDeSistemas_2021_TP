package dominio.notificacion;

public abstract class MedioDeComunicacion {

    private boolean esPreferido;

    public MedioDeComunicacion(boolean esPreferido) {
        this.esPreferido = esPreferido;
    }

    public abstract void notificar(Mensaje mensaje);

    public boolean esPreferido() {
        return this.esPreferido;
    }

}