package com.utn.infraestructura;

import com.utn.dominio.Personas;
import com.utn.dominio.Voluntarios;
import com.utn.dominio.animal.Mascota;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.foto.CalidadFoto;
import com.utn.dominio.foto.TamañoFoto;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.organizacion.Voluntario;
import com.utn.dominio.persona.Contacto;
import com.utn.dominio.persona.Direccion;
import com.utn.dominio.persona.Documento;
import com.utn.dominio.persona.Persona;
import com.utn.infraestructura.persistencia.persona.PersonasEnMySQL;
import com.utn.infraestructura.persistencia.voluntario.VoluntariosEnMySQL;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PruebaJPA {

    private Voluntarios voluntarios = new VoluntariosEnMySQL();
    private Personas personas = new PersonasEnMySQL();

    //@BeforeEach
    //void inicializar() { voluntarios = }

    @Test
    public void se_rescata_voluntario_con_sus_usuarios() {
        //Voluntario voluntario = voluntarios.obtenerPorNumeroDNI(5488759);
        Voluntario voluntario = voluntarios.obtenerPorNombreUsuario("pepe");
        System.out.println(" Mi usuario es: " + voluntario.getUsuario().nombreUsuario() + " y contraseña: " + voluntario.getUsuario().getContraseña());
    }

    @Test
    public void se_persiste_voluntario_en_db(){
        Organizacion organizacion = new Organizacion("nombre", new Direccion(3,3), null, CalidadFoto.BAJA);
        Usuario usuario = new Usuario("pepe", "hola1234");
        Voluntario voluntario = new Voluntario(usuario, organizacion);
        voluntarios.guardar(voluntario);
    }

    @Test
    public void se_rescata_persona_de_db(){

    }

    @Test
    public void se_persiste_persona_en_db(){
        Contacto contactoTest = new Contacto("Eduardo","Bavutti","+54 9 11 8755-7845","ebavutti@gmail.com");
        LocalDate nacimientoTest = LocalDate.of(1990,04,27);
        Documento documentoTest = new Documento("DNI", 38554127);
        Direccion domicilioTest = new Direccion(1742.38,2394.2);
        Contacto otroContactoTest = new Contacto("Isabela", "Ferriera", "+54 9 11 7855-4121", "iferriera@gmail.com");
        Usuario usuarioTest = new Usuario("edubavutti", "1990isaedu");

        Direccion domicilioOrgTest = new Direccion(5447.358, 5648.74);
        Usuario usuarioVolTest = new Usuario("volOrg", "324");
        Organizacion organizacionTest = new Organizacion("PatitasJugetonas", domicilioOrgTest, TamañoFoto.GRANDE, CalidadFoto.BAJA);
        Voluntario voluntarioTest = new Voluntario(usuarioVolTest, organizacionTest);
        organizacionTest.agregarPreguntaAdopcion("Tu animal tiene vacunas?");
        organizacionTest.agregarPreguntaAdopcion("Tu animal es jugeton?");
        organizacionTest.añadirVoluntario(voluntarioTest);

        /*Mascota mascotaTest = new Mascota(1, "Sol", );
        Mascota otraMascotaTest = new Mascota(2,);*/

        usuarioTest.añadirOrganizacion(organizacionTest);
        Persona personaTest = new Persona(contactoTest, nacimientoTest, documentoTest, domicilioTest, otroContactoTest, usuarioTest, 32);
        organizacionTest.añadirPersona(personaTest);

        //personas.
    }
}
