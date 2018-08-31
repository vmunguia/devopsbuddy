package com.devopsbuddy.backend.persistance.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devopsbuddy.backend.persistance.domain.backend.PasswordResetToken;

/**
 * 
 * @author munga
 *
 */
@Repository
public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetToken, Long> {

	/**
	 * 
	 * @param token
	 * @return
	 */
	PasswordResetToken findByToken(String token);

	/**
	 * 
	 * @param userId
	 * @return
	 */
	@Query("select ptr from PasswordResetToken ptr inner join ptr.user u where ptr.user = ?1")
	Set<PasswordResetToken> findAllByUserId(long userId);
}
