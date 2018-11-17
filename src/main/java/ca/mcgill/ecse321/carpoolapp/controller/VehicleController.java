package ca.mcgill.ecse321.carpoolapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ca.mcgill.ecse321.carpoolapp.model.Vehicle;
import ca.mcgill.ecse321.carpoolapp.model.View;
import ca.mcgill.ecse321.carpoolapp.repository.CarpoolappRepository;

@CrossOrigin
@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	

	@Autowired
	CarpoolappRepository repository;
	
	@JsonView(View.Summary.class)
	@GetMapping(produces = {
			MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Vehicle>>getVehicles()
	{
		List<Vehicle> Vehicles = repository.getVehicles();
		return new ResponseEntity<List<Vehicle>>(Vehicles, HttpStatus.OK);
	}
	
	@JsonView(View.Summary.class)
	@GetMapping(path="/{plate}", produces = {
			MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<Vehicle> getVehicle(@PathVariable String plate)
	{	
		Vehicle vehicle = repository.getVehicle(plate);
		if(vehicle == null)
			return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
	}
	
	@PostMapping(path="/{plate}/{year}/{brand}/{seating}/{driverID}")
	public String createVehicle(@PathVariable String plate, @PathVariable int year, @PathVariable String brand, @PathVariable int seating, @PathVariable int driverID) 
	{
		Vehicle vehicle = repository.createVehicle(year, brand, plate, seating, driverID);
		return vehicle.getPlateNumber();
	}
	
	
}
