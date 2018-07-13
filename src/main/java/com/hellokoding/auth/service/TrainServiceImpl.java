package com.hellokoding.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hellokoding.auth.model.Trains;
import com.hellokoding.auth.repository.TrainRepository;


@Service
@Component
public class TrainServiceImpl implements TrainService{
	@Autowired 
	private TrainRepository trainRepository;

	@Override
	public List<Trains> getTrains(String source, String destination) {
		
		return trainRepository.getTrains(source,destination);
	}
	
}
