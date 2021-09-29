package dominio.persona;

public class Direccion {

    private final double latitud;
    private final double longitud;

    public Direccion(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double latitud(){
        return this.latitud;
    }

    public double longitud(){
        return this.longitud;
    }

}