package com.autconnect.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.autconnect.models.Client;
import com.autconnect.services.ClientService;
import com.autconnect.services.DailyNoteService;
import com.autconnect.services.UserService;

@Controller
public class ParentController {
	@Autowired UserService userService;
	@Autowired ClientService clientService;
	@Autowired DailyNoteService dailyNoteService;
	
	@GetMapping("/parent")
	public String parentDashboard(Principal principal, Model model) {
		String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
		return "parentDashboard.jsp";
	}
	
	@GetMapping("/parent/clients/{id}")
	public String parentClient(Principal principal, Model model, @PathVariable("id") Long id) {
		String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
        model.addAttribute("client", clientService.findById(id));
		return "parentClient.jsp";
	}
	
	@GetMapping("/parent/clients/{id}/archive")
	public String parentArchive(Principal principal, Model model, @PathVariable("id") Long id) {
		model.addAttribute("currentUser", userService.findByEmail(principal.getName()));
		Client client = clientService.findById(id);
        model.addAttribute("client", client);
        model.addAttribute("dailyNotes", dailyNoteService.findByClient(client));
		return "parentArchive.jsp";
	}
	@GetMapping("/parent/clients/{id}/archive/{date}")
	public String parentDailySummary(Principal principal, Model model, @PathVariable("id") Long id) {
		return "";
	}
}
