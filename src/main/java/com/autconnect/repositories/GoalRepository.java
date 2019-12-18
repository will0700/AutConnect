package com.autconnect.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.autconnect.models.Goal;

@Repository
public interface GoalRepository extends CrudRepository<Goal, Long>{

}
