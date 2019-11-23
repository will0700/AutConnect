package com.autconnect.repositories;

import org.springframework.data.repository.CrudRepository;

import com.autconnect.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	Role findRoleById(Long id);
}
