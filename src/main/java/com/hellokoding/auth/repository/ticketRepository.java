package com.hellokoding.auth.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hellokoding.auth.model.tickets;

public interface ticketRepository extends JpaRepository<tickets, String> {
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value = "insert into tickets (uname,tickets, trainname) VALUES (?1, ?2, ?3)", nativeQuery = true)
	void insertData(String uname,String tickets, String tname);
	
	List<tickets> findByName(String uname);
}
