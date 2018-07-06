/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturalprogrammer.spring5tutorial.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 *
 * @author lmung
 */
//@Component
public class MockMailSender implements MailSender {

    private static Log log = LogFactory.getLog(MockMailSender.class);

    @Override
    public void send(String to, String subject, String body) {
        log.info("Sending MOCK mail to " + to);
        log.info("with subject " + subject);
        log.info("and body " + body);
    }
}
