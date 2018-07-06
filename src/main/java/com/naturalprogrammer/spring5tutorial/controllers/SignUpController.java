/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturalprogrammer.spring5tutorial.controllers;

import com.naturalprogrammer.spring5tutorial.commands.UserCommand;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lmung
 */
@Controller
// En este caso muy particular como el mapeo es el mismo se puede
// poner una anotacion a nivel clase y se puede quitar el parametro
// de las anotaciones, y se llamara el correcto dependiendo del metodo
// de llamada HTTP.
@RequestMapping("/signup")
public class SignUpController {

    private final static Log LOG = LogFactory.getLog(SignUpController.class);

    /**
     * Se agrega modelo cuando se requiere de una validacion, de lo contrario
     * se deja sin parametros
     * @param model
     * @return 
     */
    // @RequestMapping(value="/signup", method=RequestMethod.GET)
    //@GetMapping("/signup") // esta anotacion y la anterior son equivalentes
    @GetMapping // se puede poner sin parametro solo si a nivel clase existe
                // el mapeo inicial o general
    public String signUp(Model model) {
        
        model.addAttribute("user", new UserCommand());
        return "signup";
    }

    // @RequestMapping(value="/signup", method=RequestMethod.POST)
    //@PostMapping("/signup") // esta anotacion y la anterior son equivalentes
/*
    @PostMapping // se puede poner sin parametro solo si a nivel clase existe
                // el mapeo inicial o general

    public String doSignUp(
            @RequestParam String email,
            @RequestParam String name,
            @RequestParam String password) {
        LOG.info("Email: " + email
        + "; Name: " + name
        + "; Password: " + password);
        
        return "redirect:/hello2";
    }
*/

    /**
     * Sin validacion de los campos de entrada.
     * @param user
     * @return 
     */
/*
    @PostMapping
    public String doSignUp(UserCommand user) {        
        LOG.info("Email: " + user.getEmail()
        + "; Name: " + user.getName()
        + "; Password: " + user.getPassword());

        return "redirect:/hello2";
    }
*/
    /**
     * Con validacion del objeto de entrada (entidad)
     * @param user
     * @param result
     * @return 
     */
/*
    @PostMapping
    public String doSignUp(@Validated UserCommand user, BindingResult result) {

        if (result.hasErrors()) {
            return "signup";
        }

        LOG.info("Email: " + user.getEmail()
        + "; Name: " + user.getName()
        + "; Password: " + user.getPassword());

        return "redirect:/hello2";
    }
*/
    /**
     * El formulario automaticamente liga el modelo con el atributo de la vista
     * en cammel case, pero en caso de que lo quiera cambiar por otra cosa
     * se hace por medio de una anotacion.
     * Este metodo y el anterior son exactamente iguales.
     * @param user
     * @param result
     * @return 
     */
    @PostMapping
    public String doSignUp(@Validated @ModelAttribute("user") UserCommand user, BindingResult result) {

        if (result.hasErrors()) {
            return "signup";
        }

        LOG.info("Email: " + user.getEmail()
        + "; Name: " + user.getName()
        + "; Password: " + user.getPassword());

        return "redirect:/hello2";
    }
}
