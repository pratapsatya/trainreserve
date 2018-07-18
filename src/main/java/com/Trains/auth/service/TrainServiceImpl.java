package com.Trains.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Trains.auth.model.Trains;
import com.Trains.auth.repository.TrainRepository;


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
