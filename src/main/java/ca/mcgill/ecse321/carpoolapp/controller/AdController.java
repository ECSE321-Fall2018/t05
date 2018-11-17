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

import ca.mcgill.ecse321.carpoolapp.model.Ad;
import ca.mcgill.ecse321.carpoolapp.model.View;
import ca.mcgill.ecse321.carpoolapp.repository.CarpoolappRepository;

@CrossOrigin
@RestController
@RequestMapping("/ads")
public class AdController {

	@Autowired
	CarpoolappRepository repository;
	
	@JsonView(View.Summary.class)
	@GetMapping(produces = {
			MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Ad>>getAds()
	{
		List<Ad> Ads = repository.getAds();
		return new ResponseEntity<List<Ad>>(Ads, HttpStatus.OK);
	}
	
	@JsonView(View.Summary.class)
	@GetMapping(path="/{id}", produces = {
			MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<Ad> getAd(@PathVariable int id)
	{	
		Ad Ad = repository.getAd(id);
		if(Ad == null)
			return new ResponseEntity<Ad>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Ad>(Ad, HttpStatus.OK);
	}
	
	@PostMapping(path="/{id}/{price}/{driverID}/{vehiclePlate}")
	public int createAd(@PathVariable int id, @PathVariable int price, @PathVariable int driverID, @PathVariable String vehiclePlate) 
	{
		Ad Ad = repository.createAd(id, price, driverID, vehiclePlate);
		return Ad.getId();
	}
	
}
