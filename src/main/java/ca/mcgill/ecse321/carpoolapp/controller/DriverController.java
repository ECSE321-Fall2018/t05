package ca.mcgill.ecse321.carpoolapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.carpoolapp.model.Driver;
import ca.mcgill.ecse321.carpoolapp.repository.CarpoolappRepository;

@RestController
@RequestMapping("/drivers")
public class DriverController {

	@Autowired
	CarpoolappRepository repository;
	
	@GetMapping
	public String getDriver()
	{
		return "Get driver was called";
	}
	
	@PostMapping(path="/{id}/{name}")
	public String createDriver(@PathVariable int id, @PathVariable String name)
	{
		Driver driver = repository.createDriver(id, name);
		return driver.toString();
	}
	
	
}
