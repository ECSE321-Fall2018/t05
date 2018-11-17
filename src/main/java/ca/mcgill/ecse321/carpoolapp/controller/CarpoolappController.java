package ca.mcgill.ecse321.carpoolapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.carpoolapp.repository.CarpoolappRepository;

@CrossOrigin
@RestController
public class CarpoolappController {

	@Autowired
	CarpoolappRepository repository;

	@RequestMapping("/")
	public String greeting() {
		return "Hello carpool!";
	}

}