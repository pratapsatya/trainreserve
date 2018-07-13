package com.hellokoding.auth.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.hellokoding.auth.model.Trains;

public interface TrainRepository extends JpaRepository<Trains, Integer>{
	
	@Query("select t from Trains t where t.source=?1 and t.destination=?2")
	List<Trains> getTrains(String source,String destination);
}
