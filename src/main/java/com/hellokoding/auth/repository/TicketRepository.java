package com.hellokoding.auth.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hellokoding.auth.model.Tickets;

public interface TicketRepository extends JpaRepository<Tickets, Integer> {
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value = "insert into tickets (uname,tickets, trainname, date) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
	void insertData(String uname,String tickets, String tname, String date);
	
	List<Tickets> findByUname(String uname);
}
