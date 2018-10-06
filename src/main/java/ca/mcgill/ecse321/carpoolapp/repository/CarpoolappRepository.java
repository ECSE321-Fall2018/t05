package ca.mcgill.ecse321.carpoolapp.repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.carpoolapp.model.Ad;
import ca.mcgill.ecse321.carpoolapp.model.Admin;
import ca.mcgill.ecse321.carpoolapp.model.CarPoolManager;
import ca.mcgill.ecse321.carpoolapp.model.Driver;
import ca.mcgill.ecse321.carpoolapp.model.Passenger;
import ca.mcgill.ecse321.carpoolapp.model.Stop;
import ca.mcgill.ecse321.carpoolapp.model.User;
import ca.mcgill.ecse321.carpoolapp.model.Vehicle;


@Repository
public class CarpoolappRepository {

	@Autowired
	EntityManager entityManager;

//	@Transactional
//	public Participant createParticipant(String name) {
//		Participant participant = new Participant();
//		participant.setName(name);
//		entityManager.persist(participant);
//		return participant;
//	}
//
//	@Transactional
//	public Participant getParticipant(String name) {
//		Participant participant = entityManager.find(Participant.class, name);
//		return participant;
//	}

	
	//AN
	@Transactional
	public User getUser(int id) {
		User user = entityManager.find(User.class, id);
		return user;	
	}
	
	//AN
	@Transactional 
	public Ad getAd(int id) {
		Ad ad = entityManager.find(Ad.class, id);
		return ad;
	}
	
	@Transactional
	public User createUser(int id, String name, CarPoolManager carpoolManager) {
		User user = new User(id, name, carpoolManager);
		entityManager.persist(user);
		return user;
		
	}
}














