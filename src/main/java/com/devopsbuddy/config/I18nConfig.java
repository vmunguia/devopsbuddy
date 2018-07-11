package com.devopsbuddy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class I18nConfig {

	/**
	 * 
	 * @return
	 */
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource resourceBundleMessagesource = new ReloadableResourceBundleMessageSource();
		resourceBundleMessagesource.setBasename("classpath:i18n/messages");
		//Check for new messages every 30 minutes
		resourceBundleMessagesource.setCacheSeconds(1800);

		return resourceBundleMessagesource;
	}
}
