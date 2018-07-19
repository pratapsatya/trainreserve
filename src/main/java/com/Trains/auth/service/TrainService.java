package com.Trains.auth.service;
import java.util.List;
import com.Trains.auth.model.Trains;

/**
 * 
 * @author laharipratap
 *This is the service to get the list of trains from a particular source to destination
 */

public interface TrainService {
	
	List<Trains> getTrains(String source,String destination);

}
