package com.devopsbuddy.test.integration;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.devopsbuddy.DevOpsBuddyApplication;
import com.devopsbuddy.backend.persistance.domain.backend.Role;
import com.devopsbuddy.backend.persistance.domain.backend.User;
import com.devopsbuddy.backend.persistance.domain.backend.UserRole;
import com.devopsbuddy.backend.service.UserService;
import com.devopsbuddy.enums.PlansEnum;
import com.devopsbuddy.enums.RolesEnum;
import com.devopsbuddy.utils.UserUtils;

import org.junit.Assert;

/**
 * 
 * @author munga
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DevOpsBuddyApplication.class)
public class UserServiceIntegrationTest {

	@Autowired
	private UserService userService;

	@Test
	public void testCreateNewUser() throws Exception {
		Set<UserRole> userRoles = new HashSet<>();
		User basicUser = UserUtils.createBasicUser();
		userRoles.add(new UserRole(basicUser, new Role(RolesEnum.BASIC)));

		User user = userService.createUser(basicUser, PlansEnum.BASIC, userRoles);
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getId());
	}
}
