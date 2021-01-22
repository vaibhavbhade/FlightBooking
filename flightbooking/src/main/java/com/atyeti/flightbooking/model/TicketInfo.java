package com.atyeti.flightbooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class TicketInfo {
	
	
	@Id
	@GeneratedValue
	private long ticketId;
	
	private String Status;
	
	@ManyToOne
	private FlightDetails flightDetails;

	@ManyToOne
	private User user;



	public long getTicketId() {
		return ticketId;
	}



	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}



	public String getStatus() {
		return Status;
	}



	public void setStatus(String status) {
		Status = status;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public FlightDetails getFlightDetails() {
		return flightDetails;
	}



	public void setFlightDetails(FlightDetails flightDetails) {
		this.flightDetails = flightDetails;
	}

	 
	 
	
	 

}
