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
	private Long id;
	
	private int availableSeats;
	
	private int price;
	
	private String flightDepartureDate;
	
	
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

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getFlightDepartureDate() {
		return flightDepartureDate;
	}

	public void setFlightDepartureDate(String flightDepartureDate) {
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
