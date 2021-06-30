package dominio.persona;

public class UbicacionPersona {

    private Double latitud;
    private Double longitud;

    public UbicacionPersona(Double latitud, Double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Double latitud(){
        return this.latitud;
    }
    public Double longitud(){
        return this.longitud;
    }

}