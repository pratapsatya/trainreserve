package com.Trains.auth.service;

import java.util.Date;
import java.util.List;

import com.Trains.auth.model.Tickets;


/**
 * 
 * @author laharipratap
 *This is a service used to declare methods for'
 * -saving the details of the tickets booked by the user
 * -get the history of the user 
 */

public interface TicketService {
	 void save(Tickets tickets);

	void insertData(String uname,String tickets,String tname,String date);
	

	List<Tickets> findByName(String uname);

}
