package com.atyeti.flightbooking.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FLIGHT_DETAILS")
public class FlightDetails {

	@Column(name = 
			"flight_id")
	@GeneratedValue
	@Id
	private long id;
	
	private String availableSeats;
	
	private String price;
	
	private Date flightDepartureDate;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "flightDetails", cascade = CascadeType.ALL)
	  private Set<Flight> flights = new HashSet<Flight>();

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

	public Date getFlightDepartureDate() {
		return flightDepartureDate;
	}

	public void setFlightDepartureDate(Date flightDepartureDate) {
		this.flightDepartureDate = flightDepartureDate;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}
	
	
	
	
	
	
}
