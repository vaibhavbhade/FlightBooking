package com.atyeti.flightbooking.repo;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.atyeti.flightbooking.model.FlightDetails;

public interface FlightDetailsRepo  extends CrudRepository<FlightDetails, Long>{

	public FlightDetails  findByflightDepartureDate(LocalDate localDate);
}
