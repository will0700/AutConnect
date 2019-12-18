package com.autconnect.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.autconnect.models.Behavior;
import com.autconnect.models.User;
import com.autconnect.services.BehaviorService;
import com.autconnect.services.ClientService;
import com.autconnect.services.TherapistClientService;
import com.autconnect.services.UserService;

@Controller
public class TherapistController {
	@Autowired UserService userService;
	@Autowired TherapistClientService therapistClientService;
	@Autowired ClientService clientService;
	@Autowired BehaviorService behaviorService;
	
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
	@GetMapping("/therapist/clients/{id}/targetGoals")
	public String therapistTargetGoalsForm(Principal principal, Model model, @PathVariable(name="id") Long id) {
		String email = principal.getName();
		User user = userService.findByEmail(email);
		model.addAttribute("currentUser", user);
		model.addAttribute("client", this.clientService.findById(id));
		return "therapistTargetGoals.jsp";
	}
	
	@GetMapping("/therapist/clients/{id}/behaviors")
	public String therapistBehaviorForm(Principal principal, Model model, @ModelAttribute("behavior") Behavior behavior, @PathVariable(name="id") Long id) {
		String email = principal.getName();
		User user = userService.findByEmail(email);
		model.addAttribute("currentUser", user);
		model.addAttribute("client", this.clientService.findById(id));
		return "therapistBehavior.jsp";
	}
	@PostMapping("/therapist/clients/{id}/behaviors/add")
	public String therapistBehaviorProcessing(@ModelAttribute("behavior") Behavior behavior, @PathVariable(name="id") Long id) {
		this.behaviorService.saveBehavior(behavior);
		return "redirect:/therapist/clients/{id}/dailyNotes";
	}
	@GetMapping("/therapist/clients/{id}/dailyNotes")
	public String therapistDailyNotesForm() {
		return "therapistDailyNotes.jsp";
	}
}
