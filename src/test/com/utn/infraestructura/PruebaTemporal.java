package com.utn.infraestructura;

import com.utn.dominio.*;
import com.utn.dominio.animal.Animal;
import com.utn.dominio.animal.Mascota;
import com.utn.dominio.animal.Sexo;
import com.utn.dominio.animal.Tamaño;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.organizacion.CalidadFoto;
import com.utn.dominio.organizacion.TamañoFoto;
import com.utn.dominio.notificacion.estrategia.Email;
import com.utn.dominio.notificacion.estrategia.SMS;
import com.utn.dominio.notificacion.estrategia.WhatsApp;
import com.utn.dominio.organizacion.Administrador;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.organizacion.Voluntario;
import com.utn.dominio.persona.*;
import com.utn.dominio.publicacion.Preferencia;
import com.utn.dominio.publicacion.PublicacionBusquedaAdopcion;
import com.utn.dominio.publicacion.PublicacionMascotaEnAdopcion;
import com.utn.dominio.publicacion.PublicacionMascotaEncontrada;
import com.utn.infraestructura.notificador.NotificadorEmail;
import com.utn.infraestructura.notificador.NotificadorTwilio;
import com.utn.infraestructura.persistencia.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class PruebaTemporal {

    private final Voluntarios voluntarios = new VoluntariosEnMySQL();
    private final Personas personas = new PersonasEnMySQL();
    private final Organizaciones organizaciones = new OrganizacionesEnMySQL();

    //@BeforeEach
    //void inicializar() { voluntarios = }

    @Test
    public void se_rescata_voluntario_con_sus_usuarios() {
        //Voluntario voluntario = voluntarios.obtenerPorNumeroDNI(5488759);
        Voluntario voluntario = voluntarios.obtenerPorNombreUsuario("pepe");
        System.out.println(" Mi usuario es: " + voluntario.getUsuario() + " y contraseña: " + voluntario.getContrasenia());
    }

    @Test
    public void se_persiste_voluntario_en_db() {
        Organizacion organizacion = new Organizacion("nombre", new Direccion(3, 3), TamañoFoto.GRANDE, CalidadFoto.BAJA);
        Voluntario voluntario = new Voluntario("pepe", "hola1234", organizacion);

        organizacion.añadirVoluntario(voluntario);

        voluntarios.guardar(voluntario);
    }

    @Test
    public void se_rescata_persona_de_db() {
        Persona persona = personas.obtenerPorNumeroDocumento(38554127, TipoDocumento.DNI.getDescripcion());

        System.out.println("Hola" + persona);

    }

    @Test
    public void se_rescata_usuario_de_db() {
        Usuarios usuarios = new UsuariosEnMySQL();
        Usuario usuario = usuarios.obtenerPorNombreUsuario("pepebavutti");
        System.out.println("Hola" + usuario);
    }

    @Test
    public void se_rescata_admin_de_db() {
        Administradores administradores = new AdministradoresEnMySQL();
        Administrador administrador = administradores.obtenerPorNombreUsuario("pepeOwner");
        System.out.println("Hola " + administrador.getUsuario());
    }

    @Test
    public void se_persiste_persona_en_db() {
        OrganizacionesEnMySQL per = new OrganizacionesEnMySQL();
        Contacto contactoTest = new Contacto("Celes", "", "+54 9 11 8755-7845", "ebavutti@gmail.com");
        LocalDate nacimientoTest = LocalDate.of(1990, 4, 27);
        Documento documentoTest = new Documento(TipoDocumento.DNI, 38554127);
        Direccion domicilioTest = new Direccion(1742.38, 2394.2);
        Contacto otroContactoTest = new Contacto("Isabela", "Ferriera", "+54 9 11 7855-4121", "iferriera@gmail.com");
        Usuario usuarioTest = new Usuario("pepebavutti", "noSeQuePoner...");

        Direccion domicilioOrgTest = new Direccion(5447.358, 5648.74);

        Organizacion organizacionTest = new Organizacion("Patitas Juguetonas", domicilioOrgTest, TamañoFoto.GRANDE, CalidadFoto.BAJA);
        Voluntario voluntarioTest = new Voluntario("volOrg", "324ae41gg", organizacionTest);
        Administrador administradorTest = new Administrador("adminOrg","32ad965min", organizacionTest);

        organizacionTest.agregarPreguntaAdopcion("Tu animal tiene vacunas?");
        organizacionTest.agregarPreguntaAdopcion("Tu animal es jugeton?");
        organizacionTest.añadirVoluntario(voluntarioTest);
        Mascota mascotaTest = new Mascota("Solange", "Sol", 5, Animal.PERRO, Sexo.HEMBRA, Tamaño.GRANDE,
                "Soy muy linda y tierna");

        mascotaTest.añadirFoto("foto1.png");
        mascotaTest.añadirFoto("foto2.png");
        mascotaTest.añadirCaracteristica("Vacuna", "Si");
        mascotaTest.añadirCaracteristica("Parasitos", "No");

        Mascota otraMascotaTest = new Mascota("Pepa", "Pepita", 1, Animal.GATO, Sexo.HEMBRA, Tamaño.CHICO,
                "Me gusta jugar con lana");

        otraMascotaTest.añadirFoto("foto1.jpg");
        otraMascotaTest.añadirFoto("foto2.jpg");
        otraMascotaTest.añadirCaracteristica("Parasitos", "No");
        otraMascotaTest.añadirCaracteristica("Garras", "Si");
        otraMascotaTest.añadirCaracteristica("Perdida de Pelo", "No");

        Persona personaTest = new Persona(contactoTest, nacimientoTest, documentoTest, domicilioTest, otroContactoTest, usuarioTest, 32);
        organizacionTest.añadirPersona(personaTest);
        personaTest.añadirMascota(mascotaTest);
        personaTest.añadirMascota(otraMascotaTest);

        organizacionTest.añadirPublicacionBusquedaAdopcion(new PublicacionBusquedaAdopcion(personaTest, new ArrayList<String>() {{
            add("Hola");
            add("Adios");
        }}));
        organizacionTest.añadirPublicacionMascotaEnAdopcion(new PublicacionMascotaEnAdopcion(personaTest, mascotaTest, new ArrayList<String>() {{
            add("Debe ser");
            add("Por dogshow");
        }}));
        organizacionTest.añadirPublicacionMascotaEncontrada(new PublicacionMascotaEncontrada(personaTest, new Direccion(20, 23), "Todo okey"));

        organizacionTest.añadirCaracteristica("Perrito gordito");
        organizacionTest.agregarPreguntaAdopcion("Cuanto pesa??");
        organizacionTest.agregarPreguntaQuieroAdoptar("Tiene patio??");
        personaTest.setPreferencia(new Preferencia(Sexo.HEMBRA, Animal.PERRO, Tamaño.CHICO));

        organizacionTest.añadirAdministrador(administradorTest);

        personaTest.setEsAdoptante(false);

        contactoTest.añadirMedioDeComunicacion(new SMS(new NotificadorTwilio(), false));
        contactoTest.añadirMedioDeComunicacion(new Email(new NotificadorEmail(), true));
        contactoTest.añadirMedioDeComunicacion(new WhatsApp(new NotificadorTwilio(), true));
        otroContactoTest.añadirMedioDeComunicacion(new WhatsApp(new NotificadorTwilio(), true));
        otroContactoTest.añadirMedioDeComunicacion(new Email(new NotificadorEmail(), false));

        per.guardar(organizacionTest);
    }

    @Test
    public void se_persiste_organizacion_en_db() {
        OrganizacionesEnMySQL per = new OrganizacionesEnMySQL();

        Direccion domicilioOrgTest = new Direccion(5447.358, 5648.74);
        Organizacion organizacionTest = new Organizacion("Peluditos al rescate", domicilioOrgTest, TamañoFoto.GRANDE, CalidadFoto.BAJA);
        Organizacion organizacionTest2 = new Organizacion("Animalitos en espera", domicilioOrgTest, TamañoFoto.GRANDE, CalidadFoto.BAJA);


        per.guardar(organizacionTest);
        per.guardar(organizacionTest2);
    }

    @Test
    public void se_actualiza_persona() {
        Persona persona = personas.obtenerPorNumeroDocumento(38554127, TipoDocumento.DNI.getDescripcion());
        persona.getUsuario().setNombreUsuario("InserteUsuarioGenerico");
        persona.setPreferencia(new Preferencia(Sexo.MACHO, Animal.GATO, Tamaño.GRANDE));
        persona.setEsAdoptante(true);
        persona.añadirMascota(new Mascota("nombre", "String apodo", 25, Animal.PERRO, Sexo.HEMBRA, Tamaño.GRANDE, " String descripcionFisica"));

        personas.guardar(persona);
    }

    @Test
    public void llenar_base_de_datos_con_datos_de_prueba() {
        //TODO : mascota caracteristicas rellenar
        //TODO : mascota fotos rellenar
        Contacto con1 = new Contacto("Juan", "Perez", "+54 9 11 75848544", "juanperez@gmail.com");
        Usuario usr1 = new Usuario("juanperez", "per@31Juan");
        Persona per1 = new Persona(con1, LocalDate.of(1990, 4, 27), new Documento(TipoDocumento.DNI, 386514987), new Direccion(12133, 19783), new Contacto("Sofia", "Perez", "+54 9 11 74148879", "sofiaperez@gmail.com"), usr1, 10);
        Mascota masc1 = new Mascota("Mascota1", "Mascota1", 5, Animal.PERRO, Sexo.HEMBRA, Tamaño.GRANDE, "desc Mascota1");
        Mascota masc2 = new Mascota("Mascota2", "Mascota2", 12, Animal.PERRO, Sexo.MACHO, Tamaño.CHICO, "desc Mascota2");
        Mascota masc3 = new Mascota("Mascota3", "Mascota3", 7, Animal.GATO, Sexo.HEMBRA, Tamaño.MEDIANO, "desc Mascota3");
        per1.añadirMascota(masc1);
        per1.añadirMascota(masc2);
        per1.añadirMascota(masc3);
        per1.setPreferencia(new Preferencia(Sexo.HEMBRA, Animal.PERRO, Tamaño.CHICO));

        Contacto con2 = new Contacto("Esteban", "Sanchez", "+54 9 11 1243321", "estbansanchez@gmail.com");
        Usuario usr2 = new Usuario("estebanSanchez", "est.ez231");
        Persona per2 = new Persona(con2, LocalDate.of(1967, 11, 21), new Documento(TipoDocumento.LICENCIA, 7889875), new Direccion(44488, 13454), new Contacto("Ricardo", "Sanchez", "+54 9 11 78554123", "ricsan@gmail.com"), usr2, 1);
        Mascota masc8 = new Mascota("Mascota8", "Mascota8", 21, Animal.PERRO, Sexo.HEMBRA, Tamaño.GRANDE, "desc Mascota8");
        per2.añadirMascota(masc8);
        per2.setPreferencia(new Preferencia(Sexo.MACHO, Animal.PERRO, Tamaño.GRANDE));

        Contacto con3 = new Contacto("Jose", "Diaz", "+54 9 11 000000", "josediaz@gmail.com");
        Usuario usr3 = new Usuario("josaz", "josesito31-42");
        Persona per3 = new Persona(con3, LocalDate.of(1987, 6, 12), new Documento(TipoDocumento.DNI, 14788695), new Direccion(45646, 13877), new Contacto("Marta", "diaz", "+54 9 11 78445689", "martitadiaz@gmail.com"), usr3, 3);
        Mascota masc4 = new Mascota("Mascota4", "Mascota4", 5, Animal.PERRO, Sexo.HEMBRA, Tamaño.GRANDE, "desc Mascota4");
        Mascota masc5 = new Mascota("Mascota5", "Mascota5", 99, Animal.GATO, Sexo.HEMBRA, Tamaño.MEDIANO, "desc Mascota5");
        Mascota masc6 = new Mascota("Mascota6", "Mascota6", 1, Animal.PERRO, Sexo.MACHO, Tamaño.CHICO, "desc Mascota6");
        Mascota masc7 = new Mascota("Mascota7", "Mascota7", 3, Animal.GATO, Sexo.MACHO, Tamaño.GRANDE, "desc Mascota7");
        per3.añadirMascota(masc4);
        per3.añadirMascota(masc5);
        per3.añadirMascota(masc6);
        per3.añadirMascota(masc7);
        per3.setPreferencia(new Preferencia(Sexo.HEMBRA, Animal.GATO, Tamaño.MEDIANO));

        Contacto con4 = new Contacto("Karen", "Lopez", "+54 9 11 1564566", "karenlopez@gmail.com");
        Usuario usr4 = new Usuario("karenlopez", "karendelbarrio@42");
        Persona per4 = new Persona(con4, LocalDate.of(1970, 2, 1), new Documento(TipoDocumento.DNI, 11111119), new Direccion(97548, 16489), new Contacto("Lucas", "Perez", "+54 9 11 74148879", "lucasperez@gmail.com"), usr4, 7);
        per4.setPreferencia(new Preferencia(Sexo.MACHO, Animal.GATO, Tamaño.GRANDE));

        Contacto con5 = new Contacto("Peppa", "Pig", "+54 9 11 ", "peppitalacerdita@gmail.com");
        Usuario usr5 = new Usuario("peppapig", "peppa65%12");
        Persona per5 = new Persona(con5, LocalDate.of(2002, 4, 27), new Documento(TipoDocumento.PASAPORTE, 788899777), new Direccion(12133, 19783), new Contacto("Peppe", "Pig", "+54 9 11 13547891", "peppeelcerdo@gmail.com"), usr5, 28);
        per5.setPreferencia(new Preferencia(Sexo.MACHO, Animal.PERRO, Tamaño.CHICO));

        Contacto con6 = new Contacto("Lionel", "Messi", "+54 9 11 78874569", "traemelacopa@gmail.com");
        Usuario usr6 = new Usuario("lioeluno", "messi-10-barca");
        Persona per6 = new Persona(con6, LocalDate.of(1921, 1, 1), new Documento(TipoDocumento.DNI, 15447875), new Direccion(4564236, 138177), new Contacto("Diego", "Maradona", "+54 9 11 47887542", "eldiegote10@gmail.com"), usr6, 100);
        per6.setPreferencia(new Preferencia(Sexo.HEMBRA, Animal.GATO, Tamaño.CHICO));

        Contacto con7 = new Contacto("Kun", "Aguero", "+54 9 11 48678654", "elkun@gmail.com");
        Usuario usr7 = new Usuario("kunaguero", "457elkun@42");
        Persona per7 = new Persona(con7, LocalDate.of(1945, 2, 11), new Documento(TipoDocumento.LICENCIA, 19115119), new Direccion(135468, 286489), new Contacto("Lionel", "Messi", "+54 9 11 78874569", "traemelacopa@gmail.com"), usr7, 165);
        per7.setPreferencia(new Preferencia(Sexo.MACHO, Animal.PERRO, Tamaño.GRANDE));

        Contacto con8 = new Contacto("Celeste", "Rubino", "+54 9 11 78774112", "celesterubino@gmail.com");
        Usuario usr8 = new Usuario("celesrubi", "rubi99celes@");
        Persona per8 = new Persona(con8, LocalDate.of(1998, 1, 13), new Documento(TipoDocumento.PASAPORTE, 74487), new Direccion(564789, 148477), new Contacto("Pepe", "Rubino", "+54 9 11 78745521", "peperubino@gmail.com"), usr8, 79);
        per8.setPreferencia(new Preferencia(Sexo.MACHO, Animal.PERRO, Tamaño.MEDIANO));

        con1.añadirMedioDeComunicacion(new SMS(new NotificadorTwilio(), false));
        con1.añadirMedioDeComunicacion(new WhatsApp(new NotificadorTwilio(), true));
        con2.añadirMedioDeComunicacion(new Email(new NotificadorEmail(), true));
        con3.añadirMedioDeComunicacion(new WhatsApp(new NotificadorTwilio(), true));
        con4.añadirMedioDeComunicacion(new WhatsApp(new NotificadorTwilio(), true));
        con5.añadirMedioDeComunicacion(new Email(new NotificadorEmail(), true));
        con5.añadirMedioDeComunicacion(new WhatsApp(new NotificadorTwilio(), false));
        con6.añadirMedioDeComunicacion(new SMS(new NotificadorTwilio(), true));
        con7.añadirMedioDeComunicacion(new Email(new NotificadorEmail(), true));
        con8.añadirMedioDeComunicacion(new WhatsApp(new NotificadorTwilio(), true));
        con8.añadirMedioDeComunicacion(new Email(new NotificadorTwilio(), false));

        Organizacion org1 = new Organizacion("Patitas locas", new Direccion(1233, 13123), TamañoFoto.GRANDE, CalidadFoto.BAJA);
        Organizacion org2 = new Organizacion("Mascotas en casa", new Direccion(41233, 16423), TamañoFoto.GRANDE, CalidadFoto.ALTA);
        Organizacion org3 = new Organizacion("Dulce hogar", new Direccion(12422, 13753), TamañoFoto.NORMAL, CalidadFoto.MEDIA);
        Organizacion org4 = new Organizacion("Peludones", new Direccion(12533, 13443), TamañoFoto.NORMAL, CalidadFoto.ALTA);
        Organizacion org5 = new Organizacion("Tu compañerito", new Direccion(12533, 19123), TamañoFoto.CHICA, CalidadFoto.BAJA);

        org1.añadirCaracteristica("Car1Org1");
        org1.añadirCaracteristica("Car2Org1");
        org1.añadirCaracteristica("Car1Org1");
        org2.añadirCaracteristica("Car1Org2");
        org2.añadirCaracteristica("Car2Org2");
        org2.añadirCaracteristica("Car3Org2");
        org3.añadirCaracteristica("Car1Org3");
        org3.añadirCaracteristica("Car2Org3");
        org4.añadirCaracteristica("Car1Org4");
        org5.añadirCaracteristica("Car1Org5");
        org5.añadirCaracteristica("Car2Org5");
        org5.añadirCaracteristica("Car3Org5");

        org1.agregarPreguntaAdopcion("PregAdop1Org1");
        org1.agregarPreguntaAdopcion("PregAdop2Org1");
        org1.agregarPreguntaAdopcion("PregAdop3Org1");
        org2.agregarPreguntaAdopcion("PregAdop1Org2");
        org2.agregarPreguntaAdopcion("PregAdop2Org2");
        org3.agregarPreguntaAdopcion("PregAdop1Org3");
        org3.agregarPreguntaAdopcion("PregAdop2Org3");
        org4.agregarPreguntaAdopcion("PregAdop1Org4");
        org5.agregarPreguntaAdopcion("PregAdop1Org5");
        org5.agregarPreguntaAdopcion("PregAdop2Org5");

        org1.agregarPreguntaQuieroAdoptar("PregQuieroAdoptar1Org1");
        org1.agregarPreguntaQuieroAdoptar("PregQuieroAdoptar2Org1");
        org1.agregarPreguntaQuieroAdoptar("PregQuieroAdoptar3Org1");
        org2.agregarPreguntaQuieroAdoptar("PregQuieroAdoptar1Org2");
        org2.agregarPreguntaQuieroAdoptar("PregQuieroAdoptar2Org2");
        org3.agregarPreguntaQuieroAdoptar("PregQuieroAdoptar1Org3");
        org3.agregarPreguntaQuieroAdoptar("PregQuieroAdoptar2Org3");
        org4.agregarPreguntaQuieroAdoptar("PregQuieroAdoptar1Org4");
        org5.agregarPreguntaQuieroAdoptar("PregQuieroAdoptar1Org5");
        org5.agregarPreguntaQuieroAdoptar("PregQuieroAdoptar2Org5");

        org1.añadirMascota(masc1);
        org3.añadirMascota(masc2);
        org1.añadirMascota(masc3);
        org2.añadirMascota(masc8);
        org4.añadirMascota(masc4);
        org4.añadirMascota(masc5);
        org5.añadirMascota(masc6);
        org3.añadirMascota(masc7);

        PublicacionMascotaEncontrada pub1 = new PublicacionMascotaEncontrada(per8, new Direccion(1233, 13123), "Todo oki (?");
        pub1.agregarFoto("foto1.png");
        pub1.agregarFoto("foto2.png");
        PublicacionMascotaEncontrada pub2 = new PublicacionMascotaEncontrada(per8, new Direccion(7874, 4587), "Patita lastimada");
        pub2.agregarFoto("foto1.png");
        pub2.agregarFoto("foto2.png");
        PublicacionMascotaEncontrada pub3 = new PublicacionMascotaEncontrada(per7, new Direccion(45878, 9897), "Tiene parasitos");
        pub3.agregarFoto("foto1.png");
        pub3.agregarFoto("foto2.png");
        pub3.agregarFoto("foto3.png");
        PublicacionMascotaEncontrada pub4 = new PublicacionMascotaEncontrada(per6, new Direccion(1233, 13123), "Hambriento");
        pub4.agregarFoto("foto1.png");
        PublicacionMascotaEncontrada pub5 = new PublicacionMascotaEncontrada(per7, new Direccion(1, 65464), "Perfecto");
        PublicacionMascotaEncontrada pub6 = new PublicacionMascotaEncontrada(per2, new Direccion(241443, 123333), "Asustado");
        org1.añadirPublicacionMascotaEncontrada(pub1);
        org1.añadirPublicacionMascotaEncontrada(pub2);
        org2.añadirPublicacionMascotaEncontrada(pub3);
        org4.añadirPublicacionMascotaEncontrada(pub4);
        org5.añadirPublicacionMascotaEncontrada(pub5);
        org5.añadirPublicacionMascotaEncontrada(pub6);

        org1.añadirPublicacionMascotaEnAdopcion(new PublicacionMascotaEnAdopcion(per1, per1.getMascotas().get(1), new ArrayList<String>(){{add("Si"); add("No");}}));
        org2.añadirPublicacionMascotaEnAdopcion(new PublicacionMascotaEnAdopcion(per1, per1.getMascotas().get(2), new ArrayList<String>(){{add("Si"); add("Si");}}));
        org2.añadirPublicacionMascotaEnAdopcion(new PublicacionMascotaEnAdopcion(per2, per2.getMascotas().get(0), new ArrayList<String>(){{add("No");add("No");}}));
        org5.añadirPublicacionMascotaEnAdopcion(new PublicacionMascotaEnAdopcion(per3, per3.getMascotas().get(0), new ArrayList<String>(){{add("No"); add("No");}}));

        org1.añadirPublicacionBusquedaAdopcion(new PublicacionBusquedaAdopcion(per5, new ArrayList<String>(){{add("Patio"); add("Pasto");}}));
        org2.añadirPublicacionBusquedaAdopcion(new PublicacionBusquedaAdopcion(per6, new ArrayList<String>(){{add("Pileta");}}));
        org4.añadirPublicacionBusquedaAdopcion(new PublicacionBusquedaAdopcion(per8, new ArrayList<String>(){{add("Balcon"); add("Plantas");}}));

        Administrador admin1 = new Administrador("pepeOwner", "pepeo#123", org1);
        Administrador admin2 = new Administrador("juanOwner", "juan_cito(?123", org2);
        Administrador admin3 = new Administrador("mariaOwner", "maria_unica123", org3);
        Administrador admin4 = new Administrador("pedroOwner", "pedro_elduenio@123", org4);
        Administrador admin5 = new Administrador("joseOwner", "jose_nosequeponer%123", org5);

        org1.añadirAdministrador(admin1);
        admin1.darAltaNuevoAdministrador("martaAdmin", "martita&123");
        org2.añadirAdministrador(admin2);
        org3.añadirAdministrador(admin3);
        admin3.darAltaNuevoAdministrador("celesteAdmin", "celeste_f123");
        org4.añadirAdministrador(admin4);
        org5.añadirAdministrador(admin5);

        Voluntario vol1 = new Voluntario("pepeVol", "pepe1rsd23", org1);
        Voluntario vol6 = new Voluntario("martaVol", "martita123", org1);
        Voluntario vol2 = new Voluntario("juanVol", "juan_cito(?123", org2);
        Voluntario vol3 = new Voluntario("mariaVol", "maria_unica123", org3);
        Voluntario vol4 = new Voluntario("pedroVol", "pedro_elduenio123", org4);
        Voluntario vol5 = new Voluntario("joseVol", "jose_nosequeponer123", org5);

        org1.añadirVoluntario(vol1);
        org1.añadirVoluntario(vol6);
        org2.añadirVoluntario(vol2);
        org3.añadirVoluntario(vol3);
        org4.añadirVoluntario(vol4);
        org5.añadirVoluntario(vol5);

        personas.guardar(per1);
        personas.guardar(per2);
        personas.guardar(per3);
        personas.guardar(per4);
        personas.guardar(per5);
        personas.guardar(per6);
        personas.guardar(per7);

        organizaciones.guardar(org1);
        organizaciones.guardar(org2);
        organizaciones.guardar(org3);
        organizaciones.guardar(org4);
        organizaciones.guardar(org5);
        personas.guardar(per8);

    }
}


