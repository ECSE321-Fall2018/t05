package ca.mcgill.ecse321.carpoolapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.carpoolapp.model.Driver;
import ca.mcgill.ecse321.carpoolapp.model.Vehicle;
import ca.mcgill.ecse321.carpoolapp.repository.CarpoolappRepository;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	@Autowired
	CarpoolappRepository repository;

	@PostMapping(path = "/{id}/{plate}/{year}/{seat}/{brand}")
	public String createVehicle(@PathVariable int id, @PathVariable String plate, @PathVariable int year, @PathVariable String brand, @PathVariable int seat) {
		Vehicle vehicle = repository.createVehicle(year, brand, plate, seat, id);
		return vehicle.toString();
	}
}
