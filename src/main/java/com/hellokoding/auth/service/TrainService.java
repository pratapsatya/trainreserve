package com.hellokoding.auth.service;
import java.util.List;

import com.hellokoding.auth.model.Trains;
public interface TrainService {
	
	List<Trains> getTrains(String source,String destination);

}
