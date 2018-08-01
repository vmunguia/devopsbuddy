package com.devopsbuddy.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author munga
 *
 */
@Controller
public class PayloadController {

	/**
	 * The payload view name
	 */
	public static final String PAYLOAD_VIEW_NAME = "payload/payload";

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/payload")
	public String payload() {
		return PAYLOAD_VIEW_NAME;
	}

}
