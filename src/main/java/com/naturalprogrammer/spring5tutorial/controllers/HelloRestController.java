/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturalprogrammer.spring5tutorial.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lmung
 */
@RestController
public class HelloRestController {
    //@Value("${app.name}")
    //private String appName;
    
    @RequestMapping("/hello")
    public String hello() {
        return "Hello, world !! ...";
        //return "Hello, world " + appName;
    }
}
