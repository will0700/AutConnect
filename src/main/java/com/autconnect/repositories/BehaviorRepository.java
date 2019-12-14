package com.autconnect.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.autconnect.models.Behavior;

@Repository
public interface BehaviorRepository extends CrudRepository<Behavior, Long> {
	
}
