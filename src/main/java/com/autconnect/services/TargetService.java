package com.autconnect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autconnect.models.Target;
import com.autconnect.repositories.TargetRepository;

@Service
public class TargetService {
	@Autowired
	TargetRepository targetRepository;
	
	public Target createTarget(Target target) {
		return this.targetRepository.save(target);
	}
}
