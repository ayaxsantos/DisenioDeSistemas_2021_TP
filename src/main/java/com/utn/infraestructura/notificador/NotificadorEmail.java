package com.utn.infraestructura.notificador;

import com.utn.dominio.Notificador;
import com.utn.dominio.excepcion.EmailNoEnviadoException;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

public class NotificadorEmail implements Notificador {

    private final String emailOrigen = "rescatedepatitas.dds.g6.k3002@gmail.com";
    private final String contraseñaEmailOrigen = "ddsg6k3002";

    @Override
    public void enviar(String origen, String destinatario, String asunto, String cuerpo) {
        Properties propiedades = this.propiedades();
        Session sesion = Session.getDefaultInstance(propiedades);
        MimeMessage mensaje = new MimeMessage(sesion);
        try {
            mensaje.setFrom(new InternetAddress(emailOrigen));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mensaje.setSubject(asunto);
            mensaje.setText(cuerpo);
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(emailOrigen, contraseñaEmailOrigen);
            transporte.sendMessage(mensaje, mensaje.getRecipients(Message.RecipientType.TO));
            transporte.close();
        } catch (MessagingException ex) {
            throw new EmailNoEnviadoException();
        }
    }

    private Properties propiedades() {
        Properties propiedades = new Properties();
        propiedades.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedades.setProperty("mail.smtp.starttls.enable", "true");
        propiedades.setProperty("mail.smtp.port", "587");
        propiedades.setProperty("mail.smtp.auth", "true");
        return propiedades;
    }

}