package com.hellokoding.auth.service;

import java.util.Date;
import java.util.List;

import com.hellokoding.auth.model.tickets;

public interface ticketService {
	void insertData(String uname,String tickets,String tname,Date date);
	//List<Profile> getData(String uname);

	List<tickets> findByName(String uname);

}
