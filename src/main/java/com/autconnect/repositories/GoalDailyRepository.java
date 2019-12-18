package com.autconnect.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.autconnect.models.GoalDaily;

@Repository
public interface GoalDailyRepository extends CrudRepository<GoalDaily, Long>{

}
