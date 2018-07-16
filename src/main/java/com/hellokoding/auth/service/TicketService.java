package com.hellokoding.auth.service;

import java.util.Date;
import java.util.List;

import com.hellokoding.auth.model.Tickets;

public interface TicketService {
	void insertData(String uname,String tickets,String tname,String date);
	

	List<Tickets> findByName(String uname);

}
