package com.devopsbuddy.web.i18n;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

/**
 * 
 * @author munga
 *
 */
@Service
public class I18NService {

	/** The application logger */
	private static final Logger LOG = LoggerFactory.getLogger(I18NService.class);

	@Autowired
	private MessageSource messageSource;

	/**
	 * Returns a message for the given message ID and the default locale in the session context
	 * @param messageID The key to the message resource file
	 * @return
	 */
	public String getMessage(String messageID) {
		Locale locale = LocaleContextHolder.getLocale();

		LOG.info("Returning i18n text for messageID {}", messageID);

		return getMessage(messageID, locale);
	}

	/**
	 * Returns a message for the given message ID and locale
	 * @param messageID The key to the message resource file
	 * @param locale The Locale
	 * @return
	 */
	public String getMessage(String messageID, Locale locale) {
		return messageSource.getMessage(messageID, null, locale);
	}
}
