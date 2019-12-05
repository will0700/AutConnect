package com.autconnect.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.autconnect.models.Client;
import com.autconnect.models.User;
import com.autconnect.services.ClientService;
import com.autconnect.services.UserService;
import com.autconnect.validators.UserValidator;

@Controller
public class MainController {
	@Autowired UserService userService;
	@Autowired ClientService clientService;
	@Autowired UserValidator userValidator;
	
	//Public Routes (Login & Registration, Landing)
	@GetMapping("/register")
    public String registrationGET(@ModelAttribute("user") User newUser) {
        return "defaultRegistration.jsp";
    }
	@PostMapping("/register")
    public String registrationPOST(
    		@RequestParam(value="role") String role,
    		@Valid @ModelAttribute("user") User newUser, 
    		BindingResult result) {
		this.userValidator.validate(newUser, result);
        if (result.hasErrors()) {
            return "defaultRegistration.jsp";
        }
        this.userService.createUser(newUser, role);
        return "redirect:/login";
    }
	@RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "defaultLogin.jsp";
    }

    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
        return "landingPage.jsp";
    }
    
    //Supervisor Routes
//  @GetMapping("/supervisor/dashboard")
//    public String supervisorDashboardGet() {
//    	return "";
//    }
    
    @GetMapping("/supervisor/therapists")
    public String supervisorTherapistGet(Principal principal, Model model) {
    	String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
//        list of therapists whose supervisor is not principal...
//        List<User> unaddedTherapists = this.userService.something();
//        model.addAttribute("unaddedTherapists", unaddedTherapists);
        return "supervisorTherapist.jsp";
    }
    
    
    @GetMapping("/supervisor/clients/create")
    public String supervisorClientCreateGet(@ModelAttribute("newClient") Client newClient, Principal principal, Model model) {
    	String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
    	return "supervisorCreateClient.jsp";
    }
    @PostMapping("/supervisor/clients/create")
    public String supervisorClientCreatePost(@ModelAttribute("newClient") Client newClient) {
        this.clientService.createClient(newClient);
    	return "redirect:/supervisor/clients/all";
    }
//    @GetMapping("/supervisor/clients/all")
//    public String supervisorDashboard(Principal principal) {
//    	return "supervisorDashboard.jsp";
//    }
    
    
    //Therapist Routes
//    @GetMapping("/therapist/clients")
//    public String therapistClientsAllGET() {
//    	return "";
//    }
}