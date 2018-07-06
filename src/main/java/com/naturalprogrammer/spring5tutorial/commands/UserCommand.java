/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturalprogrammer.spring5tutorial.commands;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author lmung
 */
public class UserCommand {
    //@NotBlank(message="Please provide your email address")
    @NotBlank(message="{blankEmail}")
    @Email
    @Size(min=4, max=250, message="{emailSizeError}")
    private String email;
    
    @NotBlank
    @Size(min=1, max=100)
    private String name;
    
    @NotBlank
    @Size(min=6, max=32)
    private String password;

    /**
     * 
     * @return 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
