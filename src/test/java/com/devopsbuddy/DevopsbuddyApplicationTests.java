package com.devopsbuddy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.devopsbuddy.web.i18n.I18NService;

import junit.framework.Assert;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes=DevOpsBuddyApplication.class)
@ContextConfiguration(classes = DevOpsBuddyApplication.class)
@WebAppConfiguration
public class DevopsbuddyApplicationTests {

	@Autowired
	private I18NService i18nService;
	
	@Test
	public void testMessageByLocaleService() throws Exception {
		String expectedResult = "Bootstrap starter template";
		String messageID = "index.main.callout";
		String actual = i18nService.getMessage(messageID);
		Assert.assertEquals("The actual and expected Strings don't match", expectedResult, actual);
	}
}
