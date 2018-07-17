package com.hellokoding.auth.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hellokoding.auth.model.Tickets;
import com.hellokoding.auth.repository.TicketRepository;

@Service
@Component
public class TicketServiceImpl implements TicketService {
	@Autowired 
	private TicketRepository ticketRepository;
	
	@Override
	public void insertData(String uname,String tickets,String tname,String date)
	{
		
		ticketRepository.insertData(uname,tickets,tname,date); 
		
	}
	@Override
	public List<Tickets> findByName(String uname) 
	{
		
		return ticketRepository.findByUname(uname); 
		
	}
	@Override
	public void save(Tickets tickets) {
		ticketRepository.save(tickets);
		
	}
	
}
