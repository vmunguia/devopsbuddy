/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturalprogrammer.spring5tutorial.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;

/**
 *
 * @author lmung
 */
@Configuration
public class MailConfig {
    
    @Bean
    public DemoBean demoBean() {
        return new DemoBean();
    }
    
    //@Autowired
    //JavaMailSender javaMailSender;
    
    @Bean
    //@Profile("dev")
    @ConditionalOnProperty(name="spring.mail.host", havingValue="foo",
            matchIfMissing=true)
    public MockMailSender mockMailSender() {
        return new MockMailSender();
    }
    
    @Bean
    //@Profile("prod")
    //@Profile("!dev")
    @ConditionalOnProperty("spring.mail.host")
    public StmpMailSender stmpMailSender(JavaMailSender javaMailSender) {
        demoBean();
        
        return new StmpMailSender(javaMailSender);
    }
}
