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


@Entity
public class Flight {

	
	@Id
	@GeneratedValue
	@Column(name="flight_id")
	private Long id;
	
	
	private long airlineid;
	private String airlineName;
	private String fromLocation;
	private String toLocation;
	private Date departureTime;
	private Date arrivalTime;
	private String totalSeats;
	
	  @OneToMany(fetch = FetchType.EAGER, mappedBy = "flight", cascade = CascadeType.ALL)
	  private Set<FlightDetails> flightDetails = new HashSet<FlightDetails>();
	
	

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getAirlineid() {
		return airlineid;
	}

	public void setAirlineid(long airlineid) {
		this.airlineid = airlineid;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(String totalSeats) {
		this.totalSeats = totalSeats;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<FlightDetails> getFlightDetails() {
		return flightDetails;
	}

	public void setFlightDetails(Set<FlightDetails> flightDetails) {
		this.flightDetails = flightDetails;
	}

	
	
	
	

}
