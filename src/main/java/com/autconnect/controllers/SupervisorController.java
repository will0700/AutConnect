package com.autconnect.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.autconnect.models.Client;
import com.autconnect.models.User;
import com.autconnect.services.ClientService;
import com.autconnect.services.TherapistClientService;
import com.autconnect.services.UserService;
import com.autconnect.validators.UserValidator;

@Controller
public class SupervisorController {
	@Autowired UserService userService;
	@Autowired ClientService clientService;
	@Autowired UserValidator userValidator;
	@Autowired TherapistClientService therapistClientService;
	
	@GetMapping("/supervisor")
    public String supervisorDashboard(Principal principal, Model model) {
    	String email = principal.getName(); // "principal.getName()" is analogous to "session.findAttribute("sessionID")"
        model.addAttribute("currentUser", userService.findByEmail(email));
        //Messages needs to be worked on...
    	return "supervisorDashboard.jsp";
    }
    @GetMapping("/supervisor/messages")
    public String supervisorMessages(Principal principal, Model model) {
    	String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
        return "supervisorMessages.jsp";
    }
    @GetMapping("/supervisor/clients/{id}/messages")
    public String supervisorClientMessages(Principal principal, Model model, @PathVariable("id") Long id) {
    	String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
        model.addAttribute("client", clientService.findById(id));
        return "supervisorClientMessages.jsp";
    }
    @GetMapping("/supervisor/clients/create")
    public String supervisorCreateClientGet(@ModelAttribute("newClient") Client newClient, Principal principal, Model model) {
    	String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
        List<User> allTherapists = userService.findAllTherapists();
        model.addAttribute("therapists", allTherapists);
    	return "supervisorCreateClient.jsp";
    }
    @PostMapping("/supervisor/clients/create")
    public String supervisorCreateClientPost(@ModelAttribute("newClient") Client newClient) {
        if (this.clientService.createClient(newClient) != null) {
        	return "redirect:/supervisor/clients/"+newClient.getId();
        } else {
        	//if parent's email doesn't exist, service will have returned null for the new client.
        	//so we need to add flash error handling here and redirect to the create form.
        	return "redirect:/supervisor/clients/create";
        }
    	
    }
    @GetMapping("/supervisor/clients/{id}")
    public String supervisorClient(Principal principal, Model model, @PathVariable("id") Long id) {
    	String email = principal.getName(); 
        model.addAttribute("currentUser", userService.findByEmail(email));
        Client client = this.clientService.findById(id);
        if (client == null) {
        	return "redirect:/supervisor";
        } else {
        	model.addAttribute("client", client);
            return "supervisorClient.jsp";
        }
    }
    @PostMapping("/supervisor/clients/{id}/remove")
    public String supervisorClientRemove(@PathVariable("id") Long id) {
        this.clientService.deleteById(id);
        return "redirect:/supervisor";
    }
    
    @GetMapping("/supervisor/clients/{id}/therapists")
    public String supervisorClientTherapists(Principal principal, Model model, @PathVariable("id") Long id) {
    	String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        List<User> notTherapists = userService.findNotTherapists(client);
        model.addAttribute("notTherapists", notTherapists);
        return "supervisorTherapist.jsp";
    }
    @GetMapping("/supervisor/clients/{id}/therapists/remove/{tId}")
    public String supervisorClientTherapistsRemove(@PathVariable("id") Long cId, @PathVariable("tId") Long tId) {
    	therapistClientService.removeTherapist(cId, tId);
    	return "redirect:/supervisor/clients/" + cId + "/therapists";
    }
    @PostMapping("/supervisor/clients/{id}/therapists/add")
    public String supervisorClientTherapistAdd(RedirectAttributes redirectAttributes, @PathVariable("id") Long id, @RequestParam(value="therapistsAdded", required= false) List<User> newTherapists) {
    	if(newTherapists!=null) {	
    		therapistClientService.addTherapists(id, newTherapists);
    	} else {
    		redirectAttributes.addFlashAttribute("error", "Please make a selection");
    	}
    	return "redirect:/supervisor/clients/" + id + "/therapists";
    }
    @GetMapping("/supervisor/clients/{id}/targetGoals")
	public String supervisorTargetGoalsForm(Principal principal, Model model, @PathVariable(name="id") Long id) {
		String email = principal.getName();
		User user = userService.findByEmail(email);
		model.addAttribute("currentUser", user);
		model.addAttribute("client", this.clientService.findById(id));
		return "supervisorTargetGoals.jsp";
	}
}
