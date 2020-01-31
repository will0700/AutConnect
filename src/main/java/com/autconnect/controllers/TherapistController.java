package com.autconnect.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.autconnect.models.Behavior;
import com.autconnect.models.DailyNote;
import com.autconnect.models.Goal;
import com.autconnect.models.Target;
import com.autconnect.models.User;
import com.autconnect.services.BehaviorService;
import com.autconnect.services.ClientService;
import com.autconnect.services.DailyNoteService;
import com.autconnect.services.GoalService;
import com.autconnect.services.TargetService;
import com.autconnect.services.TherapistClientService;
import com.autconnect.services.UserService;

@Controller
public class TherapistController {
	@Autowired UserService userService;
	@Autowired TherapistClientService therapistClientService;
	@Autowired ClientService clientService;
	@Autowired BehaviorService behaviorService;
	@Autowired TargetService targetService;
	@Autowired GoalService goalService;
	@Autowired DailyNoteService dailyNoteService;
	
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
	
	@GetMapping("/therapist/clients/{id}")
	public String therapistClient(Principal principal, Model model, @PathVariable(name="id") Long id) {
		String email = principal.getName();
		User user = userService.findByEmail(email);
		model.addAttribute("currentUser", user);
		model.addAttribute("client", this.clientService.findById(id));
		return "therapistClient.jsp";
	}

	@GetMapping("/therapist/clients/{id}/targetGoals")
	public String therapistTargetGoalsForm(Principal principal, Model model,@ModelAttribute("newGoal") Goal newGoal, @PathVariable(name="id") Long id) {
		String email = principal.getName();
		User user = userService.findByEmail(email);
		model.addAttribute("currentUser", user);
		model.addAttribute("client", this.clientService.findById(id));
		return "therapistTargetGoals.jsp";
	}
	
	@GetMapping("/therapist/clients/{id}/newTarget")
	public String therapistNewTarget(Principal principal, Model model, @PathVariable(name="id") Long id, @ModelAttribute("newTarget") Target newTarget, @ModelAttribute("newGoal") Goal newGoal) {
		String email = principal.getName();
		User user = userService.findByEmail(email);
		model.addAttribute("currentUser", user);
		model.addAttribute("client", this.clientService.findById(id));
		return "therapistNewTarget.jsp";
	}
	@PostMapping("/therapist/clients/{id}/newTarget")
	public String therapistNewTarget(@PathVariable(name="id") Long id, @ModelAttribute("newTarget") Target newTarget) {
		this.targetService.createTarget(newTarget);
		return "redirect:/therapist/clients/" + id + "/targetGoals";
	}
	@PostMapping("/therapist/clients/{cId}/target/{tId}/newGoal")
	public String therapistNewGoal(@PathVariable(name="cId") Long cId, @PathVariable(name="tId") Long tId,@Valid @ModelAttribute("newGoal") Goal newGoal, BindingResult result) {
		Target target = this.targetService.getById(tId);
		newGoal.setTarget(target);
		this.goalService.createNewGoal(newGoal);
//		System.out.println("ROUTE IS WORKING");
		return "redirect:/therapist/clients/" + cId + "/targetGoals";
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
		return "redirect:/therapist/clients/" + id + "/dailyNotes";
	}
	@GetMapping("/therapist/clients/{id}/dailyNotes")
	public String therapistDailyNotesForm(Principal principal, Model model, @ModelAttribute("dailyNote") DailyNote dailyNote, @PathVariable(name="id") Long id) {
		String email = principal.getName();
		User user = userService.findByEmail(email);
		model.addAttribute("currentUser", user);
		model.addAttribute("client", this.clientService.findById(id));
		return "therapistDailyNotes.jsp";
	}
	@PostMapping("/therapist/clients/{id}/dailyNotes/add")
	public String therapistDailyNotesProcessing(@ModelAttribute("dailyNote") DailyNote dailyNote, @PathVariable(name="id") Long id) {
		this.dailyNoteService.saveDailyNote(dailyNote);
		return "redirect:/therapist/clients/" + id + "/dailyNotes";
	}
}
