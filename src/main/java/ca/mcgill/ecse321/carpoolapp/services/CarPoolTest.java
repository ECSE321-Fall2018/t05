package ca.mcgill.ecse321.carpoolapp.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.xml.ws.Service;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ca.mcgill.ecse321.carpoolapp.model.Ad;
import ca.mcgill.ecse321.carpoolapp.model.Admin;
import ca.mcgill.ecse321.carpoolapp.model.CarPoolManager;
import ca.mcgill.ecse321.carpoolapp.model.Driver;
import ca.mcgill.ecse321.carpoolapp.model.Passenger;
import ca.mcgill.ecse321.carpoolapp.model.Stop;
import ca.mcgill.ecse321.carpoolapp.model.User;
import ca.mcgill.ecse321.carpoolapp.model.Vehicle;

class CarPoolTest
{

	@Mock
	private CarPoolManager cm;
	private MethodServices service;
	
	@BeforeEach
	public void setUpEach() throws Exception 
	{
		cm = new CarPoolManager(123);
		service = new MethodServices(cm);
	}

	@Test
	void createUser() 
	{
		User user1 = service.createUser(101, "user1");
		try {
			User user2 = service.createUser(101, "user2");
		}
		catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "User ID not unique!");
		}
		
		assertEquals(1, cm.getUsers().size());
		
		assertEquals(101, cm.getUser(0).getId());
		assertEquals("user1", user1.getName());
		assertEquals(0, user1.getUserRoles().size());
	}
	
	@Test
	void createDriver() 
	{
		User user1 = service.createUser(101, "user1");
		
		Driver driver1 = service.createDriver(user1);
		
		assertEquals(1, cm.getDrivers().size());
		assertEquals(user1, driver1.getUser());
		assertEquals(1, user1.getUserRoles().size());
	}
	
	@Test
	void createPassenger() 
	{
		User user1 = service.createUser(101, "user1");
		
		Passenger passenger1 = service.createPassenger(user1);
		
		assertEquals(1, cm.getPassengers().size());
	}

	@Test
	void createAdmin() 
	{
		User user1 = service.createUser(101, "user1");
		
		Admin admin1 = service.createAdmin(user1);
		
		assertEquals(1, cm.getAdmins().size());
	}
	
	@Test
	void createVehicle() 
	{
		User user1 = service.createUser(101, "user1");
		
		Driver driver1 = service.createDriver(user1);
		Vehicle vehicle1 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver1);
		
		assertEquals(1, cm.getVehicles().size());
	}
	
	@Test
	void createAd() 
	{
		User user1 = service.createUser(101, "user1");
		
		Driver driver1 = service.createDriver(user1);
		Vehicle vehicle1 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver1);
		
		Ad ad1 = service.createAd(driver1, 123, 5, vehicle1);
		
		assertEquals(1, cm.getAds().size());
		assertEquals(123, cm.getAd(0).getId());
		assertEquals(driver1, cm.getAd(0).getDriver());
		assertEquals(vehicle1, cm.getAd(0).getVehicle());
	}
	
	@Test
	void createStop() 
	{
		User user1 = service.createUser(101, "user1");
		
		Driver driver1 = service.createDriver(user1);
		Vehicle vehicle1 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver1);
		
		Ad ad1 = service.createAd(driver1, 123, 5, vehicle1);
		
		Time time = new Time(3, 3, 3);
		Date date = new Date(4, 4, 4);
		
		Stop stop1 = service.createStop(ad1, time, date, 5, 5, 321);
		
		assertEquals(1, cm.getStops().size());
		assertEquals(stop1, ad1.getStop(0));
	}
	
	@Test
	void getActiveDrivers() 
	{
		User user1 = service.createUser(101, "user1");
		User user2 = service.createUser(102, "user2");
		
		Driver driver1 = service.createDriver(user1);
		Driver driver2 = service.createDriver(user2);
		
		Vehicle vehicle1 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver1);
		Vehicle vehicle2 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver2);
		
		Ad ad1 = service.createAd(driver1, 123, 5, vehicle1);
		
		ArrayList<Driver> activeDrivers = service.getActiveDrivers();
		
		assertEquals(1, activeDrivers.size());
		
	}

}
