package com.Trains.auth.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Trains.auth.model.Tickets;

/*
 * This is the repository to store the ticket details after booking is completed
 * sql query to insert the values is written and data is inserted into the database
 * when the user want to see the list of tickets booked by him ,
 * the data of that particular user is fetched by the findByName() method */


public interface TicketRepository extends JpaRepository<Tickets, Integer> {
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value = "insert into tickets (uname,tickets, trainname, date) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
	void insertData(String uname,String tickets, String tname, String date);
	
	List<Tickets> findByUname(String uname);
}
