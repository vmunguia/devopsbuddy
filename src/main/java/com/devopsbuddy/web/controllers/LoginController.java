package com.devopsbuddy.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author munga
 *
 */
@Controller
public class LoginController {

	/**
	 * The login view name
	 */
	public static final String LOGIN_VIEW_NAME = "user/login";

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		return LOGIN_VIEW_NAME;
	}
}
