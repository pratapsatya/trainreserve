package com.Trains.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trains")
public class Trains {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int trains_id;
	
	@Column(name="trainnumber")
	private String trainnumber;
	
	@Column(name="source")
	private String source;
	@Column(name="destination")
	private String destination;
	
	@Column(name="timings")
	private String timings;
	@Column(name="trainname")
	private String trainname;
	
	@Column(name="available")
	private String available;
	@Column(name="day")
	private String day;
	
	public int getTrains_id() {
		return trains_id;
	}
	public void setTrains_id(int trains_id) {
		this.trains_id = trains_id;
	}
	public String getTrainnumber() {
		return trainnumber;
	}
	public void setTrainnumber(String trainnumber) {
		this.trainnumber = trainnumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTrainname() {
		return trainname;
	}
	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}
	
	
}
