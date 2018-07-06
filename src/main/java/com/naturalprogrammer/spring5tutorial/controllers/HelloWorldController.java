/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturalprogrammer.spring5tutorial.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author INFORMATICA
 */
@Controller
public class HelloWorldController {
    
    /**
     * 
     * @param model
     * @return 
     */
    @RequestMapping("/")
    public String sayHello() {
        return "index";
    }
}
