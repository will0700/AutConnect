package com.autconnect.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.autconnect.models.Client;
import com.autconnect.models.Role;
import com.autconnect.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
	Optional<User> findById(Long id);
	List<User> findByRoles_Name(String roleName);
	
	@Query(value="SELECT u from User u WHERE :client NOT MEMBER OF u.clientsT AND 2 MEMBER OF u.roles")
	List<User> findByNotTherapist(@Param("client") Client client);
}
