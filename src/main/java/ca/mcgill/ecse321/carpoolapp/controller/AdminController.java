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

import ca.mcgill.ecse321.carpoolapp.model.Admin;
import ca.mcgill.ecse321.carpoolapp.repository.CarpoolappRepository;

@CrossOrigin
@RestController
@RequestMapping("/admins")
public class AdminController {

		@Autowired
		CarpoolappRepository repository;
		
		@GetMapping(produces = {
				MediaType.APPLICATION_JSON_VALUE})
		public ResponseEntity<List<Admin>>getAdmins()
		{
			List<Admin> admins = repository.getAdmins();
			return new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
		}
		
		@GetMapping(path="/{id}", produces = {
				MediaType.APPLICATION_JSON_VALUE
				})
		public ResponseEntity<Admin> getAdmin(@PathVariable int id)
		{	
			Admin adm = repository.getAdmin(id);
			if(adm == null)
				return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Admin>(adm, HttpStatus.OK);
		}
		
		@PostMapping(path="/{id}/{name}")
		public String createAdmin(@PathVariable int id, @PathVariable String name) 
		{
			Admin adm = repository.createAdmin(id, name);
			return adm.getUser().getName();
		}

}
