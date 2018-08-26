package com.devopsbuddy.utils;

import com.devopsbuddy.backend.persistance.domain.backend.User;

/**
 * 
 * @author munga
 *
 */
public class UserUtils {

	/**
	 * Non instantiable.
	 */
	private UserUtils() {
		throw new AssertionError("Non instantiable");
	}

	public static User createBasicUser(String username, String email) {
		User user = new User();

		//user.setUsername("munga");
		user.setUsername(username);
		user.setPassword("abc123");
		//user.setEmail("mungassey@gmail.com");
		user.setEmail(email);
		user.setFirstName("Victor H");
		user.setLastName("Munguia");
		user.setPhoneNumber("+52 (646) 132-8819");
		user.setCountry("MX");
		user.setEnabled(true);
		user.setDescription("A basic user");
		user.setProfileImageUrl("http://localhost:8080/images/me.jpg");
		user.setStripeCustomerId("acct_1Cl8CZKzxovBhL1t");

		return user;
	}
}
