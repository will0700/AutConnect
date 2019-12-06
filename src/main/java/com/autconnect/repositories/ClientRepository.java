package com.autconnect.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.autconnect.models.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
	Optional<Client> findById(Long id);
}
