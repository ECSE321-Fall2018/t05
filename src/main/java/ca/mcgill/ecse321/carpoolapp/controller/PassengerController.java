package ca.mcgill.ecse321.carpoolapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.carpoolapp.model.Passenger;
import ca.mcgill.ecse321.carpoolapp.repository.CarpoolappRepository;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

	@Autowired
	CarpoolappRepository repository;
	
	@GetMapping
	public String getPassenger()
	{
		return "Get passenger was called";
	}
	
	@PostMapping(path="/{id}/{name}")
	public String createPassenger(@PathVariable int id, @PathVariable String name)
	{
		Passenger passenger = repository.createPassenger(id, name);
		return passenger.toString();
	}
}
