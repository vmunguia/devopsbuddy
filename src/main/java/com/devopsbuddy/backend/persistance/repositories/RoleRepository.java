package com.devopsbuddy.backend.persistance.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devopsbuddy.backend.persistance.domain.backend.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
