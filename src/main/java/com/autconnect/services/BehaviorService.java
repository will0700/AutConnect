package com.autconnect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autconnect.models.Behavior;
import com.autconnect.repositories.BehaviorRepository;

@Service
public class BehaviorService {
	@Autowired
	BehaviorRepository behaviorRepository;
	
	public void saveBehavior(Behavior behavior) {
		this.behaviorRepository.save(behavior);
	}
}
