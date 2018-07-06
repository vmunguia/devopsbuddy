/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturalprogrammer.spring5tutorial.mail;

import javax.mail.MessagingException;
/**
 *
 * @author lmung
 */
public interface MailSender {
    
    void send(String to, String subject, String body) throws MessagingException;
}
