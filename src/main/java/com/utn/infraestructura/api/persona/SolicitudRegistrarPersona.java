package com.utn.infraestructura.api.persona;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.dominio.persona.Contacto;
import com.utn.dominio.persona.TipoDocumento;

import java.time.LocalDate;
import java.util.List;

public class SolicitudRegistrarPersona
{
    @JsonProperty
    private String nombreUsuario;

    @JsonProperty
    private TipoDocumento tipoDocumento;

    @JsonProperty
    private int numeroDocumento;

    //TODO: Conversion de tipos en la fecha
    @JsonProperty
    private LocalDate fechaNacimiento;

    @JsonProperty
    private int latitud;

    @JsonProperty
    private int longitud;

    @JsonProperty
    private String mediosPreferidos;

    //Todo: Revisar contactos, generar nueva clase para comunicacion
    @JsonProperty
    private List<Contacto> unosContactos;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getMediosPreferidos() {
        return mediosPreferidos;
    }

    public void setMediosPreferidos(String mediosPreferidos) {
        this.mediosPreferidos = mediosPreferidos;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public List<Contacto> getUnosContactos() {
        return unosContactos;
    }

    public void setUnosContactos(List<Contacto> unosContactos) {
        this.unosContactos = unosContactos;
    }
}
