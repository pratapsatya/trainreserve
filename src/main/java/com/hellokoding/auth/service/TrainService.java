package com.hellokoding.auth.service;
import java.util.List;

import com.hellokoding.auth.model.trains;
public interface TrainService {
	
	List<trains> getTrains(String source,String destination);

}
