package com.autconnect.services;

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
	
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
    }
	
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
}
