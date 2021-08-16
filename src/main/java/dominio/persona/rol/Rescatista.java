package dominio.persona.rol;

public class Rescatista {

    private int radioDeHogares;

    public int radioDeHogares() {
        return this.radioDeHogares;
    }

    public void asignarRadioHogaresDeseado(int radioDeHogares){
        this.radioDeHogares = radioDeHogares;
    }

}