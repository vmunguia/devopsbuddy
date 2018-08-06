package com.devopsbuddy.test.integration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.devopsbuddy.DevOpsBuddyApplication;
import com.devopsbuddy.backend.persistance.domain.backend.Plan;
import com.devopsbuddy.backend.persistance.domain.backend.Role;
import com.devopsbuddy.backend.persistance.domain.backend.User;
import com.devopsbuddy.backend.persistance.domain.backend.UserRole;
import com.devopsbuddy.backend.persistance.repositories.PlanRepository;
import com.devopsbuddy.backend.persistance.repositories.RoleRepository;
import com.devopsbuddy.backend.persistance.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DevOpsBuddyApplication.class)
public class RepostoriesIntegrationTest {

	@Autowired
	private PlanRepository planRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	private static final int BASIC_PLAN_ID = 1;
	private static final int BASIC_ROLE_ID = 1;

	@Before
	public void init() {
		Assert.assertNotNull(planRepository);
		Assert.assertNotNull(roleRepository);
		Assert.assertNotNull(userRepository);
	}

	@Test
	public void testCreateNewPlan() throws Exception {
		Plan basicPlan = createBasicPlan();
		planRepository.save(basicPlan);
		Plan retrievedPlan = planRepository.findOne(BASIC_PLAN_ID);
		Assert.assertNotNull(retrievedPlan);		
	}

	@Test
	public void testCreateNewRole() throws Exception {
		Role basicRole = createBasicRole();
		roleRepository.save(basicRole);
		Role retrievedRole = roleRepository.findOne(BASIC_ROLE_ID);
		Assert.assertNotNull(retrievedRole);		
	}

	@Test
	public void createNewUser() {
		Plan basicPlan = createBasicPlan();
		planRepository.save(basicPlan);
		
		User basicUser = createBasicUser();
		basicUser.setPlan(basicPlan);
		
		Role basicRole = createBasicRole();
		Set<UserRole> userRoles = new HashSet<>();
		
		UserRole userRole = new UserRole();
		userRole.setUser(basicUser);
		userRole.setRole(basicRole);
		userRoles.add(userRole);
		
		basicUser.getUserRoles().addAll(userRoles);
		
		for (UserRole ur : userRoles) {
			roleRepository.save(ur.getRole());
		}
		
		basicUser = userRepository.save(basicUser);
		User newlyCreatedUser = userRepository.findOne(basicUser.getId());
		Assert.assertNotNull(newlyCreatedUser);
		Assert.assertTrue(newlyCreatedUser.getId() != 0);
		Assert.assertNotNull(newlyCreatedUser.getPlan());
		Assert.assertNotNull(newlyCreatedUser.getPlan().getId());
		Set<UserRole> newlyCreatedUserUerRoles = newlyCreatedUser.getUserRoles();
		
		for (UserRole ur : newlyCreatedUserUerRoles) {
			Assert.assertNotNull(ur.getRole());
			Assert.assertNotNull(ur.getRole().getId());
		}
	}

	private Plan createBasicPlan() {
		Plan plan = new Plan();
		plan.setId(BASIC_PLAN_ID);
		plan.setName("Basic");

		return plan;
	}

	private Role createBasicRole() {
		Role role = new Role();
		role.setId(BASIC_ROLE_ID);
		role.setName("ROLE_USER");

		return role;
	}

	private User createBasicUser() {
		User user = new User();
		user.setUsername("munga");
		user.setPassword("abc123");
		user.setEmail("mungassey@gmail.com");
		user.setFirstName("Victor H");
		user.setLastName("Munguia");
		user.setPhoneNumber("+52 (646) 132-8819");
		user.setCountry("MX");
		user.setEnabled(true);
		user.setDescription("A basic user");
		user.setProfileImageUrl("http://localhost:8080/images/me.jpg");

		return user;
	}
}
