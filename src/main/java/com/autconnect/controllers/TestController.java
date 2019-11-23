package com.autconnect.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.autconnect.models.User;
import com.autconnect.services.UserService;

@Controller
public class TestController {
	@Autowired UserService userService;
	
	@GetMapping(value = {"/", "/testing"})
	public String testIndex(@ModelAttribute("newUser") User newUser) {
		return "testLoginRegistration.jsp";
	}
	
	@PostMapping("/testing/register")
	public String testRegister(@RequestParam(value="role") String role, @ModelAttribute("newUser") User newUser, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "testLoginRegistration.jsp";
		} else {
			User registeredUser = this.userService.registerUser(newUser, role);
			session.setAttribute("user", registeredUser);
			return "redirect:/testing/dashboard";
		}
	}
	
//	@PostMapping("/testing/login")
//	public String testLogin(@RequestParam(value="email") String email, @RequestParam(value="password") String password, HttpSession session) {
//		this.userService.loginUser(email, password)
//		return "";
//	}
	
	@GetMapping("/testing/dashboard")
	public String testDashboard(HttpSession session) {
		if (session.getAttribute("user") == null) {
			System.out.println("no user in session");
			return "redirect:/testing";
		} else {
			return "testingDashboard.jsp";
		}
	}
}
