package com.autconnect.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.autconnect.models.User;
import com.autconnect.repositories.RoleRepository;
import com.autconnect.repositories.UserRepository;

@Service
public class UserService {
	@Autowired UserRepository userRepository;
	@Autowired RoleRepository roleRepository;
	@Autowired BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void createUser(User user, String role) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		if (role.equals("supervisor")) {
			user.setRoles(this.roleRepository.findByName("ROLE_SUPERVISOR"));
		} else if (role.equals("therapist")) {
			user.setRoles(this.roleRepository.findByName("ROLE_THERAPIST"));
		} else if (role.equals("parent")) {
			user.setRoles(this.roleRepository.findByName("ROLE_PARENT"));
		}
		this.userRepository.save(user);
	}
	
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
    }
		
	public User findById(Long id) {
		Optional<User> optionalUser = this.userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	public List<User> findAllTherapists(){
		return this.userRepository.findByRoles_Name("ROLE_THERAPIST");
	}
}
