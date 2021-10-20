
package com.utn.infraestructura.persistencia.persona;

import com.utn.infraestructura.persistencia.contacto.JpaContacto;
import com.utn.infraestructura.persistencia.direccion.JpaDireccion;
import com.utn.infraestructura.persistencia.documento.JpaDocumento;
import com.utn.infraestructura.persistencia.mascota.JpaMascota;
import com.utn.infraestructura.persistencia.preferencia.JpaPreferencia;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "persona")
public class JpaPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "DATE")
    private LocalDateTime fechaNacimiento;

    @OneToOne(cascade = CascadeType.ALL)
    private JpaDocumento documentoJPA;

    @OneToOne(cascade = CascadeType.ALL)
    private JpaDireccion direccionJPA;

    @ManyToOne
    private JpaContacto contactoJPA;

    @ManyToMany
    private List<JpaContacto> contactosJPA;

    @OneToMany(cascade = CascadeType.ALL)
    private List<JpaMascota> mascotasJPA;

    @ManyToOne
    private JpaPreferencia preferenciaJPA;

    public JpaPersona(Integer id, LocalDateTime fechaNacimiento, JpaDocumento documentoJPA, JpaDireccion direccionJPA, JpaContacto contactoJPA, List<JpaContacto> contactosJPA, List<JpaMascota> mascotasJPA, JpaPreferencia preferenciaJPA) {
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.documentoJPA = documentoJPA;
        this.direccionJPA = direccionJPA;
        this.contactoJPA = contactoJPA;
        this.contactosJPA = contactosJPA;
        this.mascotasJPA = mascotasJPA;
        this.preferenciaJPA = preferenciaJPA;
    }

    public JpaPersona() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public JpaDocumento getDocumentoJPA() {
        return documentoJPA;
    }

    public void setDocumentoJPA(JpaDocumento documentoJPA) {
        this.documentoJPA = documentoJPA;
    }

    public JpaDireccion getDireccionJPA() {
        return direccionJPA;
    }

    public void setDireccionJPA(JpaDireccion direccionJPA) {
        this.direccionJPA = direccionJPA;
    }

    public List<JpaContacto> getContactosJPA() {
        return contactosJPA;
    }

    public void setContactosJPA(List<JpaContacto> contactosJPA) {
        this.contactosJPA = contactosJPA;
    }

    public List<JpaMascota> getMascotasJPA() {
        return mascotasJPA;
    }

    public void setMascotasJPA(List<JpaMascota> mascotasJPA) {
        this.mascotasJPA = mascotasJPA;
    }

    public JpaPreferencia getPreferenciaJPA() {
        return preferenciaJPA;
    }

    public void setPreferenciaJPA(JpaPreferencia preferenciaJPA) {
        this.preferenciaJPA = preferenciaJPA;
    }
}