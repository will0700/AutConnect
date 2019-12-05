package com.autconnect.repositories;

import org.springframework.data.repository.CrudRepository;

import com.autconnect.models.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
	
}
