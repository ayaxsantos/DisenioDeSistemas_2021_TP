package com.utn.dominio.notificacion;

import com.utn.dominio.EntidadPersistencia;
import com.utn.dominio.Notificador;
import com.utn.dominio.notificacion.mensaje.Mensaje;
import com.utn.dominio.notificacion.estrategia.EstrategiaDeComunicacion;

import javax.persistence.*;

//TODO que se genere 1 sola tabla donde tiene las 6 altenativas. SMS-Email-Whatsapp con no preferido y SMS-Email-Whatsapp con preferido. Porque sino crea de mas con id unicos.
@Entity
@Table(name = "medioDeComunicacion")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class MedioDeComunicacion extends EntidadPersistencia {

    @Transient
    protected Notificador notificador;

    @Column
    private boolean esPreferido;

    public MedioDeComunicacion(Notificador notificador, boolean esPreferido) {
        this.notificador = notificador;
        this.esPreferido = esPreferido;
    }

    public MedioDeComunicacion() {

    }

    public boolean esPreferido() {
        return this.esPreferido;
    }

    public abstract void enviar(Mensaje mensaje);
}