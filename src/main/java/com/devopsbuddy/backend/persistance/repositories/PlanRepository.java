package com.devopsbuddy.backend.persistance.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devopsbuddy.backend.persistance.domain.backend.Plan;

/**
 * 
 * @author munga
 *
 */
@Repository
public interface PlanRepository extends CrudRepository<Plan, Integer> {

}
