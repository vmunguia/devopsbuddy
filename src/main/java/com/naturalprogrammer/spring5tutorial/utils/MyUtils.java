/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturalprogrammer.spring5tutorial.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author lmung
 */
@Component
public class MyUtils {

    private static MessageSource messageSource;

    /**
     * 
     * @param messageSource 
     */
    public MyUtils(MessageSource messageSource) {
        MyUtils.messageSource = messageSource;
    }
    
    public static String getMessage(String messageKey, Object...  args) {
        return messageSource.getMessage(messageKey, args,
                LocaleContextHolder.getLocale());
    }
}
