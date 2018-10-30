package ca.mcgill.ecse321.carpoolapp.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

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
import ca.mcgill.ecse321.carpoolapp.services.MethodServices;

@Repository
public class CarpoolappRepository {
	
	private CarPoolManager carpoolManager;
	private MethodServices methodservices;
	
	@Autowired
	EntityManager entityManager;
	
	@Transactional
	public User createUser(int id, String name) {
		
		User usr = new User();
		
		usr.setId(12);
		usr.setName("Roger");
		entityManager.persist(usr);
		return usr;
	}

	
	@Transactional
	public Admin createAdmin(int id, String name)
	{
		int cmId = 1;
		CarPoolManager cm = entityManager.find(CarPoolManager.class, cmId);
		if(cm == null) {
			cm = new CarPoolManager(cmId);
			entityManager.persist(cm);
		} 
		this.carpoolManager = cm;
		
//		methodservices = new MethodServices(carpoolManager);
//		
//		User newUser = methodservices.createUser(id, name);
//		entityManager.persist(newUser);
//		Admin newAdmin = methodservices.createAdmin(newUser);
//		entityManager.persist(newAdmin);
//		
//		return newAdmin;
		
//		CarPoolManager cm = new CarPoolManager(1);
//		entityManager.persist(cm);
		
		User usr = new User(id, name, cm);
		entityManager.persist(usr);
		
		Admin adm = new Admin(usr, cm);
		adm.setName(usr.getName());
		entityManager.persist(adm);
		return adm;
	}
	
	@Transactional
	public Admin getAdmin(int id)
	{
		Admin foundAdmin = entityManager.find(Admin.class, id);
		return foundAdmin;
	}
	
	@Transactional
	public List<Admin> getAdmins(){
		List<Admin> admins = new ArrayList<>(); 
		admins = entityManager.createQuery("SELECT a FROM Admin a").getResultList();
		return admins;
	}
	
	// TODO Edit, Delete Admin
	
	@Transactional
	public Driver createDriver(int id, String name)
	{
		User newUser = methodservices.createUser(id, name);
		Driver newDriver = methodservices.createDriver(newUser);
		entityManager.persist(newDriver);
		return newDriver;
	}
	
	@Transactional
	public Driver getDriver(int id)
	{
		Driver foundDriver = entityManager.find(Driver.class, id);
		return foundDriver;
	}
	
	// TODO Edit, Delete Driver
	
	@Transactional
	public Passenger createPassenger(int id, String name)
	{
		int cmId = 1;
		CarPoolManager cm = entityManager.find(CarPoolManager.class, cmId);
		if(cm == null) {
			cm = new CarPoolManager(cmId);
			entityManager.persist(cm);
		} 
		this.carpoolManager = cm;
		
		User usr = new User(id, name, cm);
		entityManager.persist(usr);
		
		Passenger psg = new Passenger(usr, 0, 0, cm);
		psg.setName(psg.getName());
		entityManager.persist(psg);
		return psg;
	}
	
	@Transactional
	public Passenger getPassenger(int id)
	{
		Passenger foundPassenger = entityManager.find(Passenger.class, id);
		return foundPassenger;
	}
	
	@Transactional
	public List<Passenger> getPassengers(){
		List<Passenger> passengers = new ArrayList<>(); 
		passengers = entityManager.createQuery("SELECT p FROM Passenger p").getResultList();
		return passengers;
	}
	
	@Transactional
	public Ad createAd(Driver driver, int id, double price, Vehicle vehicle)
	{
		Ad newAd = methodservices.createAd(driver, id, price, vehicle);
		entityManager.persist(newAd);
		return newAd;
	}
	
	@Transactional
	public Ad getAd(int id)
	{
		Ad foundAd = entityManager.find(Ad.class, id);
		return foundAd;
	}
	
	// TODO Edit, Delete Ad
	
	@Transactional
	public Stop createStop(Ad ad, Time time, Date date, int x, int y, int id)
	{
		Stop newStop = methodservices.createStop(ad, time, date, x, y, id);
		entityManager.persist(newStop);
		return newStop;
	}
	
	@Transactional
	public Stop getStop(int id)
	{
		Stop foundStop = entityManager.find(Stop.class, id);
		return foundStop;
	}
	
	//TODO Edit, Delete Stop
	
	@Transactional
	public Vehicle createVehicle(int year, String brand, String plateNumber, int availableSeat, Driver driver)
	{
		Vehicle newVehicle = methodservices.createVehicle(year, brand, plateNumber, availableSeat, driver);
		entityManager.persist(newVehicle);
		return newVehicle;
	}
	
	@Transactional
	public Vehicle getVehicle(String aPlateNumber)
	{
		Vehicle foundVehicle = entityManager.find(Vehicle.class, aPlateNumber);
		return foundVehicle;
	}
	
	//TODO Edit, Delete Vehicle
	
	
	
	
	
}
