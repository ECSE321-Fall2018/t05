package ca.mcgill.ecse321.carpoolapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.carpoolapp.model.CarPoolManager;
import ca.mcgill.ecse321.carpoolapp.model.User;
import ca.mcgill.ecse321.carpoolapp.repository.CarpoolappRepository;

@RestController
@RequestMapping("/cm")
public class CMController {

	@Autowired
	CarpoolappRepository repository;
	
	@PostMapping
	public int createCM() 
	{
		CarPoolManager cm = repository.createCM(1);
		return cm.getId();
	}
	
}
