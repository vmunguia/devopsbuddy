package com.devopsbuddy.backend.persistance.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devopsbuddy.backend.persistance.domain.backend.User;

/**
 * 
 * @author munga
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	/**
	 * Returns a User given a username or null if not found.
	 * @param username The username
	 * @return a User given a username or null if not found.
	 */
	public User findByUsername(String username);
}
