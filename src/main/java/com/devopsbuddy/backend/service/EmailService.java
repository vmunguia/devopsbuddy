package com.devopsbuddy.backend.service;

import org.springframework.mail.SimpleMailMessage;

import com.devopsbuddy.web.domian.frontend.FeedbackPojo;

/**
 * Contract for email service.
 * @author munga
 *
 */
public interface EmailService {

	/**
	 * Send an email with the content in the feedback pojo.
	 * @param feedback The feedback Pojo
	 */
	public void sendFeedbackEmail(FeedbackPojo feedback);

	/**
	 * Send an email with the content of the Simple Mail Message object.
	 * @param message The object containing the email content
	 */
	public void sendGenericEmailMessage(SimpleMailMessage message);
}
