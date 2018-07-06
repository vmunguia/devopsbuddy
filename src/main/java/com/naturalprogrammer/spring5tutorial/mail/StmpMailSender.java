/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturalprogrammer.spring5tutorial.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 *
 * @author lmung
 */
//@Component
public class StmpMailSender implements MailSender {

    private static Log log = LogFactory.getLog(StmpMailSender.class);
    
    private JavaMailSender javaMailSender;

    public StmpMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
/*
    @Override
    public void send(String to, String subject, String body) {
        log.info("Sending SMTP mail to: " + to);
        log.info("with subject: " + subject);
        log.info("and body: " + body);
    }
*/
    @Override
    public void send(String to, String subject, String body) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        
        helper = new MimeMessageHelper(message, true); // true indicates multipart message
        
        helper.setSubject(subject);
        helper.setTo(to);
        helper.setText(body, true); // true indicates html
        
        // continue using helper for more funcionalities
        // like adding attachments, etc.
        javaMailSender.send(message);
    }
}
