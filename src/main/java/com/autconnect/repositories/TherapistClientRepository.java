package com.autconnect.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.autconnect.models.Client;
import com.autconnect.models.TherapistClient;
import com.autconnect.models.User;

@Repository
public interface TherapistClientRepository extends CrudRepository<TherapistClient, Long>{
	List<TherapistClient> findByClient(Client client);
	Long deleteByClientAndTherapist(Client client, User therapist);
	List<TherapistClient> findByTherapistAndPending(User therapist, Boolean pending);
	TherapistClient findByTherapistAndClient(User therapist, Client client);
}
