package com.autconnect.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autconnect.models.Role;
import com.autconnect.models.User;
import com.autconnect.repositories.RoleRepository;
import com.autconnect.repositories.UserRepository;

@Service
public class UserService {
	@Autowired UserRepository userRepository;
	@Autowired RoleRepository roleRepository;
	public User registerUser(User newUser, String roleString) {
		List<Role> roles = new ArrayList<Role>();
		if (roleString.equals("supervisor")) {
			Role role = this.roleRepository.findRoleById((long) 1);
			roles.add(role);
		} else if (roleString.equals("therapist")) {
			Role role = this.roleRepository.findRoleById((long) 2);
			roles.add(role);
		} else if (roleString.equals("parent")) {
			Role role = this.roleRepository.findRoleById((long) 3);
			roles.add(role);
		}
		newUser.setRoles(roles);
		return this.userRepository.save(newUser);
	}
}
