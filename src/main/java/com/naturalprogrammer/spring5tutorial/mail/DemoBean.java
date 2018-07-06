/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturalprogrammer.spring5tutorial.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author lmung
 */
public class DemoBean {
    
    private static Log log = LogFactory.getLog(DemoBean.class);

    public DemoBean() {
        log.info("Demo bean created.");
    }
}
