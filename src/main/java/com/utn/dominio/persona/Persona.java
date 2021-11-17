package com.utn.dominio.persona;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import com.utn.dominio.EntidadPersistente;
import com.utn.dominio.animal.Mascota;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.publicacion.Preferencia;
import com.utn.dominio.notificacion.mensaje.Mensaje;
import com.utn.dominio.excepcion.MascotaNoEncontradaException;

import javax.persistence.*;

@Entity
@Table(name = "persona")
public class Persona extends EntidadPersistente {

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="contactoPersonal_id")
    private Contacto contactoPersonal;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaNacimiento;

    @OneToOne(cascade = CascadeType.ALL)
    private Documento documento;

    @OneToOne(cascade = CascadeType.ALL)
    private Direccion domicilio;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Contacto> contactos = new ArrayList<>();

    //TODO En SQL se esta creando una tabla auxiliar donde relaciona PK de Mascota con PK de Persona. (Relacionado con TODO de Mascota)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id")
    private List<Mascota> mascotas;

    @ManyToOne(cascade = CascadeType.ALL)
    private Preferencia preferencia;

    @Column
    private boolean esAdoptante;

    @Transient
    private int radioHogares;

    public Persona(Contacto contactoPersonal, LocalDate fechaNacimiento, Documento documento,
                   Direccion domicilio, Contacto otroContacto, Usuario usuario, Integer radioHogares) {
        this.contactoPersonal = contactoPersonal;
        this.fechaNacimiento = fechaNacimiento;
        this.documento = documento;
        this.domicilio = domicilio;
        this.contactos.add(otroContacto);
        this.usuario = usuario;
        this.radioHogares = radioHogares;
        this.mascotas = new ArrayList<>();
        this.esAdoptante = false;
    }

    public Persona() {}

    public boolean esAdoptante() {
        return esAdoptante;
    }

    public void setEsAdoptante(boolean esAdoptante) {
        this.esAdoptante = esAdoptante;
    }

    public void notificar(Mensaje mensaje) {
        this.contactoPersonal.notificar(mensaje);
        this.contactos.forEach(unContacto -> unContacto.notificar(mensaje));
    }

    public Mascota buscarMascota(String nombreMascota) {
        return mascotas.stream()
                .filter(unaMascota -> unaMascota.getNombre().equals(nombreMascota))
                .findFirst().orElseThrow(MascotaNoEncontradaException::new);
    }

    public void avisoDeBaja(Mensaje unMensaje){
        this.contactoPersonal.notificar(unMensaje);
    }

    public void añadirContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public void añadirMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    public void radioHogares(int radioDeHogares) {
        this.radioHogares = radioDeHogares;
    }

    public String nombre() {
        return this.contactoPersonal.nombre();
    }

    public String telefono() {
        return this.contactoPersonal.telefono();
    }

    public String email() {
        return this.contactoPersonal.email();
    }

    public int numeroDocumento() {
        return this.documento.numero();
    }

    public Direccion domicilio() {
        return this.domicilio;
    }

    public int radioHogares() {
        return this.radioHogares;
    }

    public Preferencia preferencia() {
        return this.preferencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Contacto getContactoPersonal() {
        return contactoPersonal;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Documento getDocumento() {
        return documento;
    }

    public Direccion getDomicilio() {
        return domicilio;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public int getRadioHogares() {
        return radioHogares;
    }

    public void setRadioHogares(int radioHogares) {
        this.radioHogares = radioHogares;
    }

    public Preferencia getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Preferencia preferencia) {
        this.preferencia = preferencia;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public void setDomicilio(Direccion domicilio) {
        this.domicilio = domicilio;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public void setContactoPersonal(Contacto contactoPersonal) {
        this.contactoPersonal = contactoPersonal;
    }

}