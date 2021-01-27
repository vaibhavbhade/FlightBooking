package com.atyeti.flightbooking.repo;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.atyeti.flightbooking.model.FlightDetails;

public interface FlightDetailsRepo  extends CrudRepository<FlightDetails, Long>{

	public Set<FlightDetails>  findByflightDepartureDate(LocalDate date);
}
