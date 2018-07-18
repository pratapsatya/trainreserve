package com.Trains.auth.service;

import java.util.Date;
import java.util.List;

import com.Trains.auth.model.Tickets;


public interface TicketService {
	 void save(Tickets tickets);

	void insertData(String uname,String tickets,String tname,String date);
	

	List<Tickets> findByName(String uname);

}
