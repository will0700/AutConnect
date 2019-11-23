package com.autconnect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autconnect.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired ClientRepository clientRepository;
	
}
