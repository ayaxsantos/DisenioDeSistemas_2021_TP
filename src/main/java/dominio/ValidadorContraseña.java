package dominio;

import java.util.ArrayList;
import java.util.List;

public class ValidadorContraseña {

    private static final List<CriteriosValidacion> criterios = new ArrayList<CriteriosValidacion>() {{
        add(new ContraseñaDebil());
        add(new ContraseñaCorta());
    }};

    public static void ejecutar(String contraseña) {
        criterios.forEach(criterio  -> criterio.validar(contraseña));
    }

}