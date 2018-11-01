package ca.mcgill.ecse321.carpoolapp.controller;

<<<<<<< HEAD
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

import ca.mcgill.ecse321.carpoolapp.model.Admin;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

>>>>>>> issue19
import ca.mcgill.ecse321.carpoolapp.model.Passenger;
import ca.mcgill.ecse321.carpoolapp.repository.CarpoolappRepository;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

	@Autowired
	CarpoolappRepository repository;
<<<<<<< HEAD

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Passenger>> getPassengers() {
		List<Passenger> passengers = repository.getPassengers();
		return new ResponseEntity<List<Passenger>>(passengers, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Passenger> getPassenger(@PathVariable int id) {
		Passenger psg = repository.getPassenger(id);
		if (psg == null)
			return new ResponseEntity<Passenger>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Passenger>(psg, HttpStatus.OK);
	}

	@PostMapping(path = "/{id}/{name}")
	public String createAdmin(@PathVariable int id, @PathVariable String name) {
		Passenger psg = repository.createPassenger(id, name);
		return psg.getUser().getName();
	}

	@PutMapping(path = "updatePassengerAppk/{passengerID}/{appk}")
	public int updatePassengerAppk(@PathVariable int passengerID, @PathVariable int appk) {
		Passenger psg = repository.updateAppk(passengerID, appk);
		return psg.getAveragePaidPerKm();
	}

	@PutMapping(path = "updatePassengerTotalDistance/{passengerID}/{totalDistance}")
	public int updatePassengerTotalDistance(@PathVariable int passengerID, @PathVariable int totalDistance) {
		Passenger psg = repository.updatePassengerTotalDistance(passengerID, totalDistance);
		return psg.getTotalDistance();
	}

=======
	
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
>>>>>>> issue19
}
