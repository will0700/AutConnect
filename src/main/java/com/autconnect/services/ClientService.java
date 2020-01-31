package com.autconnect.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autconnect.models.Client;
import com.autconnect.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired ClientRepository clientRepository;
	
	public Client createClient(Client newClient) {
		//pull out string,
		return this.clientRepository.save(newClient);
	}
	
	public Client findById(Long id) {
		Optional<Client> optionalClient = this.clientRepository.findById(id);
		if (optionalClient.isPresent()) {
			return optionalClient.get();
		} else {
			return null;
		}
	}
	
	public void deleteById(Long id) {
		this.clientRepository.deleteById(id);
	}
}