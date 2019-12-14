package com.autconnect.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.autconnect.models.User;
import com.autconnect.services.TherapistClientService;
import com.autconnect.services.UserService;

@Controller
public class TherapistController {
	@Autowired UserService userService;
	@Autowired TherapistClientService therapistClientService;
	
	@GetMapping("/therapist")
	public String therapistDashboard(Principal principal, Model model) {
		String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
		return "therapistDashboard.jsp";
	}
	@GetMapping("/therapist/pending")
	public String therapistClientsPending(Principal principal, Model model) {
		String email = principal.getName();
		User user = userService.findByEmail(email);
        model.addAttribute("currentUser", user);
        model.addAttribute("pendingClients", therapistClientService.findPending(user));
		return "therapistPending.jsp";
	}
}
