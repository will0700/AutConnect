package com.autconnect.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.autconnect.models.Target;

@Repository
public interface TargetRepository extends CrudRepository<Target, Long>{

}
