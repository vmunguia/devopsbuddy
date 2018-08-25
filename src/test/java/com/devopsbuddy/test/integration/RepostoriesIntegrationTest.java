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
import com.devopsbuddy.enums.PlansEnum;
import com.devopsbuddy.enums.RolesEnum;
import com.devopsbuddy.utils.UserUtils;

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

	/**
	 * 
	 */
	@Before
	public void init() {
		Assert.assertNotNull(planRepository);
		Assert.assertNotNull(roleRepository);
		Assert.assertNotNull(userRepository);
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCreateNewPlan() throws Exception {
		Plan basicPlan = createBasicPlan(PlansEnum.BASIC);
		planRepository.save(basicPlan);
		Plan retrievedPlan = planRepository.findOne(PlansEnum.BASIC.getId());
		Assert.assertNotNull(retrievedPlan);		
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCreateNewRole() throws Exception {
		//Role basicRole = createBasicRole();
		Role basicRole = createBasicRole(RolesEnum.BASIC);
		roleRepository.save(basicRole);
		Role retrievedRole = roleRepository.findOne(RolesEnum.BASIC.getId());
		Assert.assertNotNull(retrievedRole);		
	}

	/**
	 * 
	 */
	@Test
	public void createNewUser() {
/*
		Plan basicPlan = createBasicPlan(PlansEnum.BASIC);
		planRepository.save(basicPlan);

		User basicUser = UserUtils.createBasicUser();
		basicUser.setPlan(basicPlan);

		Role basicRole = createBasicRole(RolesEnum.BASIC);
		Set<UserRole> userRoles = new HashSet<>();

		UserRole userRole = new UserRole(basicUser, basicRole);
		//UserRole userRole = new UserRole();
		//userRole.setUser(basicUser);
		//userRole.setRole(basicRole);
		userRoles.add(userRole);

		basicUser.getUserRoles().addAll(userRoles);

		for (UserRole ur : userRoles) {
			roleRepository.save(ur.getRole());
		}
*/
		User basicUser = createUser();

		//basicUser = userRepository.save(basicUser);
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

	/**
	 * 
	 * @throws Exception
	 */
	public void testDeleteUser() throws Exception {
		User basicUser = createUser();
		userRepository.delete(basicUser.getId());
	}

	/**
	 * 
	 * @return
	 */
/*
	private Plan createBasicPlan() {
		Plan plan = new Plan();
		plan.setId(PlansEnum.BASIC.getId());
		plan.setName("Basic");

		return plan;
	}
*/
	/**
	 * 
	 * @return
	 */
/*
	private Role createBasicRole() {
		Role role = new Role();
		role.setId(BASIC_ROLE_ID);
		role.setName("ROLE_USER");

		return role;
	}
*/

	/**
	 * 
	 * @param plansEnum
	 * @return
	 */
	private Plan createBasicPlan(PlansEnum plansEnum) {
		return new Plan(plansEnum);
	}

	/**
	 * 
	 * @param rolesEnum
	 * @return
	 */
	private Role createBasicRole(RolesEnum rolesEnum) {
		return new Role(rolesEnum);
	}

	/**
	 * 
	 * @return
	 */
/*
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
*/

	/**
	 * 
	 * @param plansEnum
	 * @return
	 */
	private Plan createPlan(PlansEnum plansEnum) {
		return new Plan(plansEnum);
	}

	/**
	 * 
	 * @param rolesEnum
	 * @return
	 */
	private Role createRole(RolesEnum rolesEnum) {
		return new Role(rolesEnum);
	}

	/**
	 * 
	 * @return
	 */
	private User createUser() {
		Plan basicPlan = createPlan(PlansEnum.BASIC);
		planRepository.save(basicPlan);

		User basicUser = UserUtils.createBasicUser();
		basicUser.setPlan(basicPlan);

		Role basicRole = createRole(RolesEnum.BASIC);
		roleRepository.save(basicRole);

		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole(basicUser, basicRole);
		userRoles.add(userRole);
	
		basicUser.getUserRoles().addAll(userRoles);
		basicUser = userRepository.save(basicUser);

		return basicUser;
	}
}
