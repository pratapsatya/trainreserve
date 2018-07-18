package com.Trains.auth.service;
import java.util.List;

import com.Trains.auth.model.Trains;
public interface TrainService {
	
	List<Trains> getTrains(String source,String destination);

}
