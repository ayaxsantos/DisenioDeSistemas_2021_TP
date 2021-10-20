package com.utn.infraestructura;

import com.utn.dominio.Voluntarios;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.foto.CalidadFoto;
import com.utn.dominio.foto.TamañoFoto;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.organizacion.Voluntario;
import com.utn.infraestructura.persistencia.voluntario.VoluntariosEnMySQL;
import com.utn.infraestructura.persistencia.voluntario.jpa.JpaRepositorioVoluntario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PruebaVoluntario {

    @Autowired
    private JpaRepositorioVoluntario repoVol;
    private Voluntarios voluntarios = new VoluntariosEnMySQL(repoVol);

    //@BeforeEach
    //void inicializar() { voluntarios = }

    @Test
    public void se_rescata_voluntario_con_sus_usuarios() {
        //Voluntario voluntario = voluntarios.obtenerPorNumeroDNI(5488759);
        Voluntario voluntario = voluntarios.obtenerPorNombreUsuario("pepe");
        System.out.println("DNI: " + voluntario.getNumeroDNI() + " Mi usuario es: " + voluntario.getUsuario().nombreUsuario() + " y contraseña: " + voluntario.getUsuario().getContraseña());
    }

    @Test
    public void se_persiste_voluntario_en_db(){
        TamañoFoto tamañoFoto = new TamañoFoto(32,16);
        Organizacion organizacion = new Organizacion(tamañoFoto, CalidadFoto.BAJA);
        Usuario usuario = new Usuario("pepe", "hola1234");
        Voluntario voluntario = new Voluntario(5488759, usuario, organizacion);
        voluntarios.guardar(voluntario);
    }
}
