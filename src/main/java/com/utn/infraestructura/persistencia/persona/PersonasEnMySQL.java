
package com.utn.infraestructura.persistencia.persona;

import com.utn.dominio.Personas;
import com.utn.dominio.persona.Persona;
import com.utn.infraestructura.persistencia.contacto.JpaContacto;
import com.utn.infraestructura.persistencia.direccion.JpaDireccion;
import com.utn.infraestructura.persistencia.documento.JpaDocumento;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonasEnMySQL implements Personas {

    @Override
    public Persona obtenerPorNumeroDocumento(int numeroDocumento) {
        return null;
    }

    @Override
    public void guardar(Persona persona) {
        JpaDocumento documentoJPA = new JpaDocumento(null, persona.getDocumento().getTipo(), persona.getDocumento().getNumero());
        JpaDireccion direccionJPA = new JpaDireccion(null, persona.getDomicilio().latitud(), persona.getDomicilio().longitud());
        JpaContacto contactoJPA = new JpaContacto(null, persona.getContactoPersonal().getNombre(), persona.getContactoPersonal().getApellido(), persona.getContactoPersonal().getTelefono(), persona.getContactoPersonal().getEmail());
        List<JpaContacto> contactosJPA = new ArrayList<>();
        persona.getContactos().forEach(unContacto -> contactosJPA.add(new JpaContacto(null,unContacto.getNombre(), unContacto.getApellido(), unContacto.getTelefono(), unContacto.getEmail())));

        //JpaPersona personaJPA = new JpaPersona(null, persona.getFechaNacimiento(), documentoJPA, direccionJPA, contactoJPA, contactosJPA, );


    }

}
