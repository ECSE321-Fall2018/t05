package ca.mcgill.ecse321.carpoolapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.carpoolapp.model.Admin;
import ca.mcgill.ecse321.carpoolapp.repository.CarpoolappRepository;

@RestController
@RequestMapping("/admins")
public class AdminController {

		@Autowired
		CarpoolappRepository repository;
		
		@GetMapping
		public String getAdmin()
		{
			return "Get admin was called";
			
		}
		
		@PostMapping(path="/{id}/{name}")
		public String createAdmin(@PathVariable int id, @PathVariable String name) 
		{
			Admin adm = repository.createAdmin(id, name);
			return adm.toString();
		}

}
