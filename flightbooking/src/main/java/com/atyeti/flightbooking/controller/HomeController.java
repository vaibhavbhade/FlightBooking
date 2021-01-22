package com.atyeti.flightbooking.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atyeti.flightbooking.model.Flight;
import com.atyeti.flightbooking.model.FlightDetails;
import com.atyeti.flightbooking.repo.FlightDetailsRepo;
import com.atyeti.flightbooking.repo.FlightRepository;

@RestController
public class HomeController {

	@Autowired
	private FlightDetailsRepo flightDetailsRepo;

	@Autowired
	private FlightRepository flightRepository;

	@GetMapping("/checkFlight")
	public Map<Flight, FlightDetails> getFlight(String from, String to) {

		Map<Flight, FlightDetails> finalFlightMap = new HashMap<>();

		LocalDate date = LocalDate.now();

		List<Flight> flightList = flightRepository.getFlight(from, to);

		for (Flight flight : flightList) {

			Set<FlightDetails> flightDetailsSet = flight.getFlightDetails();

			for (FlightDetails Flightdetails : flightDetailsSet) {

				if (Flightdetails.getFlightDepartureDate().equals(date)) {

					finalFlightMap.put(flight, Flightdetails);
				}

			}

		}

		for (Entry<Flight, FlightDetails> flight : finalFlightMap.entrySet()) {

			System.out.println(flight.getKey().getId() + " :: " + flight.getValue().getFlightDepartureDate());

		}

		System.out.println("hhhhh");
		return finalFlightMap;

	}

}
