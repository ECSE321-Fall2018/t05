package ca.mcgill.ecse321.carpoolapp.controller;

import java.sql.Date;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.carpoolapp.model.Ad;
import ca.mcgill.ecse321.carpoolapp.model.Admin;
import ca.mcgill.ecse321.carpoolapp.model.Driver;
import ca.mcgill.ecse321.carpoolapp.model.Passenger;
import ca.mcgill.ecse321.carpoolapp.model.Stop;
import ca.mcgill.ecse321.carpoolapp.model.Vehicle;
import ca.mcgill.ecse321.carpoolapp.repository.CarpoolappRepository;

@RestController
public class CarpoolappController {

	@Autowired
	CarpoolappRepository repository;

	@RequestMapping("/")
	public String greeting() {
		return "Hello carpool!";
	}
	
	@PostMapping("/stop/{id}")
	public int createStop(Ad ad, Time time, Date date, int x, int y, @PathVariable("id") int id) {
		
		Stop stop = repository.createStop(ad, time, date, x, y, id);
		return stop.getId();
	}
	
	@GetMapping("/stop/{id}")
	public String queryStop(@PathVariable("id") int id) {
		
		Stop stop = repository.getStop(id);
		if (stop == null) {
			return "NOT FOUND";
		}
		return "Ad number" + stop.getId();
	}
	
	

}