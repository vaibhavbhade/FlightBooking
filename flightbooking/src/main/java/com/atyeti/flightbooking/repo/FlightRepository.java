package com.atyeti.flightbooking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.atyeti.flightbooking.model.Flight;

public interface FlightRepository  extends CrudRepository<Flight, Long> {

	
	@Query("from Flight where from_location =:from and to_location =:to")
	List<Flight> getFlight(String from,@Param("to") String to);

}
