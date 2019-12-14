package com.autconnect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autconnect.models.Client;
import com.autconnect.models.TherapistClient;
import com.autconnect.models.User;
import com.autconnect.repositories.TherapistClientRepository;

@Service
public class TherapistClientService {
	@Autowired TherapistClientRepository therapistClientRepository;
	@Autowired UserService userService;
	@Autowired ClientService clientService;
	
	public List<TherapistClient> findByClient(Client client){
		return this.therapistClientRepository.findByClient(client);
	}
	public void removeTherapist(Long clientId, Long therapistId) {
		User therapist = this.userService.findById(therapistId);
		Client client = this.clientService.findById(clientId);
		//this.therapistClientRepository.deleteByClientAndTherapist(client, therapist);
		TherapistClient tC = therapistClientRepository.findByTherapistAndClient(therapist, client);
		therapistClientRepository.delete(tC);
	}
	public List<TherapistClient> findPending(User therapist){
		return this.therapistClientRepository.findByTherapistAndPending(therapist, true);
	}
	public void addTherapists(Long id, List<User> newTherapists) {
		Client client = this.clientService.findById(id);
		for (User therapist : newTherapists) {
			TherapistClient tC = new TherapistClient(client, therapist);
			this.therapistClientRepository.save(tC);
		}
	}
}
