package com.autconnect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autconnect.repositories.GoalDailyRepository;

@Service
public class GoalDailyService {
	@Autowired
	GoalDailyRepository goalDailyRepository;
}
