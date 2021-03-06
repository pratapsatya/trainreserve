package com.Trains.auth.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.Trains.auth.model.Trains;

/**
 * 
 * @author laharipratap
 *This is a repository from where,
 *  the list of trains for a particular pair of source and destination  are retrieved
 */

public interface TrainRepository extends JpaRepository<Trains, Integer>{
	
	@Query("select t from Trains t where t.source=?1 and t.destination=?2")
	List<Trains> getTrains(String source,String destination);
}
