package ca.mcgill.ecse321.carpoolapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ca.mcgill.ecse321.carpoolapp.model.Driver;
import ca.mcgill.ecse321.carpoolapp.model.View;
import ca.mcgill.ecse321.carpoolapp.repository.CarpoolappRepository;

@RestController
@RequestMapping("/drivers")
public class DriverController {

	@Autowired
	CarpoolappRepository repository;
	
	@JsonView(View.Summary.class)
	@GetMapping(produces = {
			MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Driver>>getDrivers()
	{
		List<Driver> Drivers = repository.getDrivers();
		return new ResponseEntity<List<Driver>>(Drivers, HttpStatus.OK);
	}
	
	@JsonView(View.Summary.class)
	@GetMapping(path="/{id}", produces = {
			MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<Driver> getDriver(@PathVariable int id)
	{	
		Driver driver = repository.getDriver(id);
		if(driver == null)
			return new ResponseEntity<Driver>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Driver>(driver, HttpStatus.OK);
	}
	
	@PostMapping(path="/{id}/{name}")
	public String createDriver(@PathVariable int id, @PathVariable String name) 
	{
		Driver driver = repository.createDriver(id, name);
		return driver.getUser().getName();
	}
	
	
	@PutMapping(path = "updateDriverTotalDistance/{driverID}/{totalDistance}")
	public int updateDriverTotalDistance(@PathVariable int driverID, @PathVariable int totalDistance) {
		Driver driver = repository.updateDriverTotalDistance(driverID, totalDistance);
		return driver.getTotalDistance();
	}
	
	@PutMapping(path = "updateDriverAcpk/{driverID}/{apck}")
	public int updateDriverAcpk(@PathVariable int driverID, @PathVariable int apck) {
		Driver driver = repository.updateDriverAcpk(driverID, apck);
		return driver.getAverageCostPerKm();
	}
	
	
}
