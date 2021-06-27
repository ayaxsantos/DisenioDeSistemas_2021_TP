package dominio.organizacion;

import dominio.persona.Dueño;
import dominio.persona.Rescatista;
import dominio.persona.Voluntario;

import java.util.ArrayList;
import java.util.List;

public class Organizacion {

    private final List<Dueño> dueños = new ArrayList<>();
    private final List<Rescatista> rescatistas = new ArrayList<>();
    private final List<Voluntario> voluntarios = new ArrayList<>();

    public void añadirDueño(Dueño dueño) {
        dueños.add(dueño);
    }

}