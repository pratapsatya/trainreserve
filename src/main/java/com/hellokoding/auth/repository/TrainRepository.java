package com.hellokoding.auth.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hellokoding.auth.model.trains;

public interface TrainRepository extends JpaRepository<trains, Integer>{
	
	@Query("select t from trains t where t.source=?1 and t.destination=?2")
	List<trains> getTrains(String source,String destination);
}
