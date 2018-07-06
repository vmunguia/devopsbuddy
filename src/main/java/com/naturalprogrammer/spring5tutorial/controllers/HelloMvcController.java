/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturalprogrammer.spring5tutorial.controllers;

import com.naturalprogrammer.spring5tutorial.utils.MyUtils;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author INFORMATICA
 */
@Controller
public class HelloMvcController {
    
    @Autowired
//    @Qualifier("ms")
    private MessageSource messageSource;

    /**
     * 
     * @param model
     * @return 
     */
    @RequestMapping("/hello2")
    public String hello2(Model model) {
        model.addAttribute("name", "Victor H. Munguia");
        return "hello2";
    }

    /**
     * 
     * @return 
     */
    @RequestMapping("/hello3")
    public ModelAndView hello3() {
        ModelAndView mav = new ModelAndView("hello3");

        mav.addObject("name", "Victor H. Munguia");

        return mav;
    }

    /**
     * 
     * @param model
     * @return 
     */
    @RequestMapping("/hello4")
    public String hello4(Model model) {
        model.addAttribute("name", "Victor H. Munguia");
        return "hello4";
    }

    /**
     * 
     * @param model
     * @return 
     */
    @RequestMapping("/hello5")
    public String hello5(Model model) {
        model.addAttribute("name", messageSource.getMessage("name", null, LocaleContextHolder.getLocale()));
        return "hello4";
    }

    /**
     * 
     * @param model
     * @return 
     */
    @RequestMapping("/hello6")
    public String hello6(Model model) {
        Object[] urls = {"http://below18.example.com", "http://above18.example.com"};
        
        model.addAttribute("name", messageSource.getMessage("text", urls, LocaleContextHolder.getLocale()));
        return "hello4";
    }

    /**
     * 
     * @param model
     * @return 
     */
    @RequestMapping("/hello7")
    public String hello7(Model model) {
        model.addAttribute("name",
                MyUtils.getMessage("text",
                        "http://below18.example.com",
                        "http://above18.example.com"));
        return "hello4";
    }

    /**
     * 
     * @param model
     * @param id
     * @param name
     * @return 
     */
    @RequestMapping("/hello8/{id}")
    public String hello8ID(Model model,
            @PathVariable("id") int id,
            @RequestParam("name") String name) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);

        return "hello8-id";
    }

    /**
     * Para Java 1.8 se puede compilar con la directive -parameters
     * de esta manera el nombre de la valiable de los parametros son
     * el mismo nombre que buscara como parametros de entrada por parte
     * del url.
     * @param model
     * @param id
     * @param name
     * @return 
     */
    @RequestMapping("/hello9/{id}")
    public String hello9ID(Model model,
            @PathVariable int id,
            @RequestParam(required=false) String name) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);

        return "hello8-id";
    }

    /**
     * 
     * @param model
     * @param id
     * @param name
     * @param age
     * @return 
     */
    @RequestMapping("/hello10/{id}/{name}")
    public String hello10ID(Model model,
            @PathVariable int id,
            @PathVariable String name,
            @RequestParam(required=false) int age) {
        model.addAttribute("id", id);
        model.addAttribute("name", name + " is " + age + " year(s) old.");

        return "hello8-id";
    }

    @RequestMapping("/hello11/{id}")
    public String hello11ID(Model model,
            @PathVariable int id,
            Optional<String> name) {
        model.addAttribute("id", id);
        model.addAttribute("name", name.orElse("No name"));

        return "hello8-id";
    }

}
