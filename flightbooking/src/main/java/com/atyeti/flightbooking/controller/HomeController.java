package com.atyeti.flightbooking.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atyeti.flightbooking.model.Flight;
import com.atyeti.flightbooking.model.FlightDetails;
import com.atyeti.flightbooking.model.Role;
import com.atyeti.flightbooking.model.TicketInfo;
import com.atyeti.flightbooking.model.User;
import com.atyeti.flightbooking.model.UserPayment;
import com.atyeti.flightbooking.model.UserRole;
import com.atyeti.flightbooking.repo.FlightDetailsRepo;
import com.atyeti.flightbooking.repo.FlightRepository;
import com.atyeti.flightbooking.repo.TicketInfoRepository;
import com.atyeti.flightbooking.repo.UserPaymentRepository;
import com.atyeti.flightbooking.repo.UserRepo;
import com.atyeti.flightbooking.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private FlightDetailsRepo flightDetailsRepo;

	@Autowired
	private FlightRepository flightRepository;
	
	
	@GetMapping("/checkFlight")
	public String getFlight(@RequestParam("from") String from,@RequestParam("to") String to,@RequestParam("Depdate") String date ,Model model,@RequestParam(value="seatsNotAvalible" ,required = false)boolean seatsNotAvalible) {

		System.out.println(date);
		
		Map<Flight, FlightDetails> finalFlightMap = new HashMap<>();

		//LocalDate dates = LocalDate.now();

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

		model.addAttribute("finalFlightMap", finalFlightMap);

		
		if(seatsNotAvalible==true) {
			model.addAttribute("seatsNotAvalible", true);
		}
		return "checkFlight";

	}

	@GetMapping("/")
	public String homePage(Model model) {
		List<String> fromList = new ArrayList<>();
		List<String> toFlightList = new ArrayList<>();

		List<Flight> flightList = (List<Flight>) flightRepository.findAll();
		String from = "";
		String to = "";
		for (Flight flight : flightList) {
			if (!from.equals(flight.getFromLocation())) {
				fromList.add(flight.getFromLocation());
				from = flight.getFromLocation();
			}

			if (!to.equals(flight.getToLocation())) {
				toFlightList.add(flight.getToLocation());
				to = flight.getToLocation();
			}

		}

		model.addAttribute("flightList", flightList);
		model.addAttribute("fromList", fromList);
		model.addAttribute("toFlightList", toFlightList);

		return "home";
	}

	

	}

	