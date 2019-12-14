package com.autconnect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autconnect.repositories.BehaviorRepository;

@Service
public class BehaviorService {
	@Autowired
	BehaviorRepository behaviorRepository;
}
