package com.atyeti.flightbooking.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="FLIGHT_DETAILS")
public class FlightDetails {


	@GeneratedValue
	@Id
	private long id;
	
	private String availableSeats;
	
	private String price;
	
	private LocalDate flightDepartureDate;
	
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="flight_id")
	private Flight flight;
	
	@OneToMany(mappedBy = "flightDetails")
	private List<TicketInfo> ticketInfoList;
	
	
	
	 
	public FlightDetails() {
		super();
		// TODO Auto-generated constructor stu b
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(String availableSeats) {
		this.availableSeats = availableSeats;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public LocalDate getFlightDepartureDate() {
		return flightDepartureDate;
	}

	public void setFlightDepartureDate(LocalDate flightDepartureDate) {
		this.flightDepartureDate = flightDepartureDate;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public List<TicketInfo> getTicketInfoList() {
		return ticketInfoList;
	}

	public void setTicketInfoList(List<TicketInfo> ticketInfoList) {
		this.ticketInfoList = ticketInfoList;
	}


	
	
	
	
	
	
}
