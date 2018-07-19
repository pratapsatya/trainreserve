package com.Trains.auth.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/*
 * This is a pojo class for "tickets"
 * tickets is the name of the table which stores the name of the user 
 * and trainname booked by the user
 * and no of tickets booked by the user
 * and the date of journey
 * */



@Entity
@Table(name="tickets")
public class Tickets {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="uname")
	private String uname;
	
	@Column(name="trainname")
	private String trainname;
	@Column(name="tickets")
	private String tickets;
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getTrainname() {
		return trainname;
	}
	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}
	
	
	public String getTickets() {
		return tickets;
	}
	public void setTickets(String tickets) {
		this.tickets = tickets;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Tickets(int id, String uname, String trainname, String tickets, Date date) {
		super();
		this.id = id;
		this.uname = uname;
		this.trainname = trainname;
		this.tickets = tickets;
		this.date = date;
	}
	public Tickets() {
		
	}

}
