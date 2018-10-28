package ca.mcgill.ecse321.carpoolapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.carpoolapp.model.User;
import ca.mcgill.ecse321.carpoolapp.repository.CarpoolappRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	CarpoolappRepository repository;
	
	@GetMapping
	public String getUser()
	{
		User usr = new User();
		
		usr.setId(12);
		usr.setName("Roger");
		return usr.getName();
		
		
	}
	
	@PostMapping
	public String createUser() 
	{
		User usr = repository.createUser(1, "Roger");
		return usr.getName();
	}
	
	

}
