package com.autconnect.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autconnect.models.Goal;
import com.autconnect.models.Target;
import com.autconnect.repositories.GoalRepository;
import com.autconnect.repositories.TargetRepository;

@Service
public class GoalService {
	@Autowired
	GoalRepository goalRepository;
	TargetRepository targetRepository;
	
	public Goal createNewGoal(Goal newGoal) {
		return this.goalRepository.save(newGoal);
	}
}
