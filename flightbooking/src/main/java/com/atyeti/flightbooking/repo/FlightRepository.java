package com.atyeti.flightbooking.repo;

import org.springframework.data.repository.CrudRepository;

import com.atyeti.flightbooking.model.Flight;

public interface FlightRepository  extends CrudRepository<Flight, Long> {

}
