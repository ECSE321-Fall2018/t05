package ca.mcgill.ecse321.carpoolapp.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

}
