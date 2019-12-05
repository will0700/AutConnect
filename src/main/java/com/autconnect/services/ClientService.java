package com.autconnect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autconnect.models.Client;
import com.autconnect.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired ClientRepository clientRepository;
	
	public Client createClient(Client newClient) {
		return this.clientRepository.save(newClient);
	}
}
