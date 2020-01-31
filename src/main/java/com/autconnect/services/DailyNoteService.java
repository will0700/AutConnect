package com.autconnect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autconnect.models.Client;
import com.autconnect.models.DailyNote;
import com.autconnect.repositories.DailyNoteRepository;

@Service
public class DailyNoteService {
	@Autowired DailyNoteRepository dailyNoteRepository;
	
	public DailyNote saveDailyNote(DailyNote dailyNote) {
		return this.dailyNoteRepository.save(dailyNote);
	}
	
	public List<DailyNote> findByClient(Client client){
		return this.dailyNoteRepository.findByClient(client);
	}
	//test
}
