package com.hellokoding.auth.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hellokoding.auth.model.tickets;
import com.hellokoding.auth.repository.ticketRepository;

@Service
@Component
public class ticketServiceImpl implements ticketService {
	@Autowired 
	private ticketRepository ticketRepository;
	
	@Override
	public void insertData(String uname,String tickets,String tname,Date date)
	{
		
		ticketRepository.insertData(uname,tickets,tname,date); 
		
	}
	@Override
	public List<tickets> findByName(String uname) 
	{
		
		List<tickets> ticket = ticketRepository.findByUname(uname); 
		return ticket;
	}
	
}
