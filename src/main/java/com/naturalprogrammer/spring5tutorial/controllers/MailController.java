/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturalprogrammer.spring5tutorial.controllers;

import com.naturalprogrammer.spring5tutorial.mail.MailSender;
import com.naturalprogrammer.spring5tutorial.mail.MockMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.mail.MessagingException;
/**
 *
 * @author lmung
 */
@RestController
public class MailController {

    //@Autowired
    private MailSender mailSender;

    // este metodo es lo mismo que la declaracion de arriba
    //@Autowired
    //public void setMailSender(MailSender mailSender) {
    //    this.mailSender = mailSender;
    //}

    //Se puede usar tambien en su lugar el constructor sin anotacion y spring
    //automaticamente inyecta las dependencias 
    public MailController(MailSender smtp) {
        this.mailSender = smtp;
    }

    @RequestMapping("/mail")
    public String mail() throws MessagingException {
        mailSender.send("mungassey@gmail.com", "A test mail", "Body of the test mail.");

        return "Mail sent";
    }
}
