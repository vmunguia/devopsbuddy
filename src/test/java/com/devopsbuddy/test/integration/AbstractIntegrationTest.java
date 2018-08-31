package com.devopsbuddy.test.integration;

import java.util.HashSet;
import java.util.Set;

import org.junit.rules.TestName;
import org.springframework.beans.factory.annotation.Autowired;

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

/**
 * 
 * @author munga
 *
 */
public abstract class AbstractIntegrationTest {

	@Autowired
	protected PlanRepository planRepository;

	@Autowired
	protected RoleRepository roleRepository;

	@Autowired
	protected UserRepository userRepository;

	/**
	 * 
	 * @param plansEnum
	 * @return
	 */
	protected Plan createPlan(PlansEnum plansEnum) {
		return new Plan(plansEnum);
	}

	/**
	 * 
	 * @param rolesEnum
	 * @return
	 */
	protected Role createRole(RolesEnum rolesEnum) {
		return new Role(rolesEnum);
	}

	/**
	 * 
	 * @return
	 */
	protected User createUser(String username, String email) {
		Plan basicPlan = createPlan(PlansEnum.BASIC);
		planRepository.save(basicPlan);

		User basicUser = UserUtils.createBasicUser(username, email);
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

	/**
	 * 
	 * @param testName
	 * @return
	 */
	protected User createUser(TestName testName) {
		return createUser(testName.getMethodName(), testName.getMethodName() + "@devopsbuddy.com");
	}
}
