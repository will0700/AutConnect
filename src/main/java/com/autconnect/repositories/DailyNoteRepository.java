package com.autconnect.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.autconnect.models.Client;
import com.autconnect.models.DailyNote;

@Repository
public interface DailyNoteRepository extends CrudRepository<DailyNote, Long>{
	List<DailyNote> findByClient(Client client);
//	List<DailyNote> findByClientOrderByDate(Client client);
}
