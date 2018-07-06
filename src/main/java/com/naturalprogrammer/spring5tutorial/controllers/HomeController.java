/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturalprogrammer.spring5tutorial.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author INFORMATICA
 */
@Controller
public class HomeController {

    /**
     * 
     * @return 
     */
    @RequestMapping("/home")
    //@ResponseBody: esta anotacion desactiva que la cadena devuelta sea una vista, y la convierte en JSON
    public String home() {
        return "home";
    }

    /**
     * 
     * @return 
     */
    @RequestMapping("/home3")
    public String home3() {
        return "home3-bootstrap";
    }

    /**
     * 
     * @return 
     */
    @RequestMapping("/home4")
    public String home4() {
        return "home4-bootstrap";
    }
}
