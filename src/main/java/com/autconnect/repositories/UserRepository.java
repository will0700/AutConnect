package com.autconnect.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.autconnect.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
	Optional<User> findById(Long id);
	List<User> findByRoles_Name(String roleName);
}
