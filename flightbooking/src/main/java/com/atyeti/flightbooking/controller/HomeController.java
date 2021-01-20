package com.atyeti.flightbooking.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atyeti.flightbooking.model.Flight;
import com.atyeti.flightbooking.model.FlightDetails;
import com.atyeti.flightbooking.repo.FlightDetailsRepo;

@Controller
public class HomeController {

	@Autowired
	private FlightDetailsRepo flightDetailsRepo;

	@RequestMapping("/checkFlight")
	public List<Flight> getFlight(@RequestParam("from") String from,@RequestParam("to") String to) {

		List<Flight> flightList=new ArrayList<>(); 
		
		FlightDetails flightDetails = flightDetailsRepo.findByflightDepartureDate(LocalDate.now());

		Set<Flight> flightSet = flightDetails.getFlights();

		for (Flight flight : flightSet) {
			if (flight.getFromLocation().equals(from) && flight.getToLocation().equals(to)) {

				flightList.add(flight);
			}

		}

		System.out.println("flightList  :: "+flightList.size());
		return flightList;

	}

}
