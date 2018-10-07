package ca.mcgill.ecse321.carpoolapp.services;

//gitpackage ca.mcgill.ecse321.carpoolapp.services;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Service;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
	
	@InjectMocks
	private MethodServices service;

	
	@BeforeEach
	public void setUpEach() throws Exception 
	{
		MockitoAnnotations.initMocks(this);
		cm = new CarPoolManager(123);
		service = new MethodServices(cm);
	}
	
	@AfterEach
	public void clean()
	{
		cm.delete();
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
		
		try {
			Vehicle vehicle2 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver1);
		}
		catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "PlateNumber not unique!");
		}
		
		assertEquals(1, cm.getVehicles().size());
	}
	
	@Test
	void createAd() 
	{
		User user1 = service.createUser(101, "user1");
		
		Driver driver1 = service.createDriver(user1);
		Vehicle vehicle1 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver1);
		
		Ad ad1 = service.createAd(driver1, 101, 5, vehicle1);
		
		try {
			Ad ad2 = service.createAd(driver1, 101, 5, vehicle1);
		}
		catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "ID not unique!");
		}
		
		assertEquals(1, cm.getAds().size());
		assertEquals(101, cm.getAd(0).getId());
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
		
		Stop stop1 = service.createStop(ad1, time, date, 5, 5, 101);
		Stop stop2 = service.createStop(ad1, time, date, 5, 5, 102);
		Stop stop3 = service.createStop(ad1, time, date, 5, 5, 103);
		
		try {
			Stop stop4 = service.createStop(ad1, time, date, 5, 5, 103);
		}
		catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "ID not unique!");
		}
		
		
		assertEquals(3, cm.getStops().size());
		assertEquals(stop1, ad1.getStop(0));
		assertEquals(stop2, ad1.getStop(1));
		assertEquals(stop3, ad1.getStop(2));
	}
	
	@Test
	void getActiveDrivers() 
	{
		User user1 = service.createUser(101, "user1");
		User user2 = service.createUser(102, "user2");
		
		Driver driver1 = service.createDriver(user1);
		Driver driver2 = service.createDriver(user2);
		
		Vehicle vehicle1 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver1);
		Vehicle vehicle2 = service.createVehicle(2000, "bmw", "b2c3d4", 4, driver2);
		
		Ad ad1 = service.createAd(driver1, 101, 5, vehicle1);
		Ad ad2 = service.createAd(driver2, 102, 5, vehicle2);
		
		ArrayList<Driver> activeDrivers = service.getActiveDrivers();
		
		assertEquals(2, activeDrivers.size());
		assertEquals(driver1, activeDrivers.get(0));
		assertEquals(driver2, activeDrivers.get(1));	
	}

	
	@Test
	void getActiveAds() 
	{
		User user1 = service.createUser(101, "user1");
		User user2 = service.createUser(102, "user2");
		
		Driver driver1 = service.createDriver(user1);
		Driver driver2 = service.createDriver(user2);
		
		Vehicle vehicle1 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver1);
		Vehicle vehicle2 = service.createVehicle(2000, "bmw", "b2c3d4", 4, driver2);
		
		Ad ad1 = service.createAd(driver1, 101, 5, vehicle1);
		Ad ad2 = service.createAd(driver2, 102, 5, vehicle2);
		
		ArrayList<Ad> activeAds = service.getActiveAds();
		
		assertEquals(2, activeAds.size());
		assertEquals(ad1, activeAds.get(0));
		assertEquals(ad2, activeAds.get(1));	
	}
	
	@Test
	void getDistanceBetweenStop() 
	{
		User user1 = service.createUser(101, "user1");
		
		Driver driver1 = service.createDriver(user1);
		Vehicle vehicle1 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver1);
		
		Ad ad1 = service.createAd(driver1, 123, 5, vehicle1);
		
		Time time = new Time(3, 3, 3);
		Date date = new Date(4, 4, 4);
		
		Stop stop1 = service.createStop(ad1, time, date, 0, 0, 101);
		Stop stop2 = service.createStop(ad1, time, date, 3, 4, 102);
		
		assertEquals(5, service.getDistBetweenStops(stop1, stop2));
	}
	
	@Test
	void getDistanceAd() 
	{
		User user1 = service.createUser(101, "user1");
		
		Driver driver1 = service.createDriver(user1);
		Vehicle vehicle1 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver1);
		
		Ad ad1 = service.createAd(driver1, 123, 5, vehicle1);
		
		Time time = new Time(3, 3, 3);
		Date date = new Date(4, 4, 4);
		
		Stop stop1 = service.createStop(ad1, time, date, 0, 0, 101);
		Stop stop2 = service.createStop(ad1, time, date, 3, 4, 102);
		Stop stop4 = service.createStop(ad1, time, date, -3, -4, 104);
		
		assertEquals(15, service.getDistOfAd(ad1));
	}
	
	
//	@Test
//	void sortAdsDisance() 
//	{
//		User user1 = service.createUser(101, "user1");
//		User user2 = service.createUser(102, "user2");
//		
//		Driver driver1 = service.createDriver(user1);
//		Driver driver2 = service.createDriver(user2);
//		
//		Vehicle vehicle1 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver1);
//		Vehicle vehicle2 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver2);
//		
//		Ad ad1 = service.createAd(driver1, 123, 5, vehicle1);
//		Ad ad2 = service.createAd(driver2, 123, 5, vehicle2);
//		Ad ad3 = service.createAd(driver2, 123, 5, vehicle2);
//		
//		Time time = new Time(3, 3, 3);
//		Date date = new Date(4, 4, 4);
//		
//		Stop stop1 = service.createStop(ad1, time, date, 0, 0, 321);
//		Stop stop2 = service.createStop(ad1, time, date, -4, -5, 321);
//		Stop stop3 = service.createStop(ad2, time, date, 0, 0, 321);
//		Stop stop4 = service.createStop(ad2, time, date, -3, -4, 321);
//		Stop stop5 = service.createStop(ad3, time, date, 0, 0, 321);
//		Stop stop6 = service.createStop(ad3, time, date, 1, -1, 321);
//		
//		ArrayList<Ad> activeAds = service.getActiveAds();
//		
//		ArrayList<Ad> sortedAds = service.sortAdsDistance(activeAds);
//		
//		assertEquals(3, sortedAds.size());
//		assertEquals(ad3, sortedAds.get(0));
//		assertEquals(ad2, sortedAds.get(1));
//		assertEquals(ad1, sortedAds.get(2));	
//	}
	
//	@Test
//	void sortAdsPrice() 
//	{
//		User user1 = service.createUser(101, "user1");
//		User user2 = service.createUser(102, "user2");
//		
//		Driver driver1 = service.createDriver(user1);
//		Driver driver2 = service.createDriver(user2);
//		
//		Vehicle vehicle1 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver1);
//		Vehicle vehicle2 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver2);
//		
//		Ad ad1 = service.createAd(driver1, 123, 7, vehicle1);
//		Ad ad2 = service.createAd(driver2, 123, 5, vehicle2);
//		Ad ad3 = service.createAd(driver2, 123, 3, vehicle2);
//		
//		ArrayList<Ad> activeAds = service.getActiveAds();
//		
//		ArrayList<Ad> sortedAds = service.sortAdsPrice(activeAds);
//		
//		assertEquals(3, sortedAds.size());
//		assertEquals(ad1, sortedAds.get(2));
//		assertEquals(ad2, sortedAds.get(1));
//		assertEquals(ad3, sortedAds.get(0));	
//	}

	@Test
	void reserveASeat() 
	{
		User user1 = service.createUser(101, "user1");
		User user2 = service.createUser(102, "user2");
		User user3 = service.createUser(103, "user3");
		User user4 = service.createUser(104, "user4");
		
		Driver driver1 = service.createDriver(user1);
		Vehicle vehicle1 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver1);
	
		Passenger passenger1 = service.createPassenger(user2);
		Passenger passenger2 = service.createPassenger(user3);
		Passenger passenger3 = service.createPassenger(user4);
		
		Ad ad1 = service.createAd(driver1, 123, 5, vehicle1);
		
		Time time = new Time(3, 3, 3);
		Date date = new Date(4, 4, 4);
		
		Stop stop1 = service.createStop(ad1, time, date, 0, 0, 101);
		Stop stop2 = service.createStop(ad1, time, date, 3, 4, 102);
		Stop stop3 = service.createStop(ad1, time, date, -3, -4, 103);
		
		service.reserveASeat(passenger1, ad1, stop1, stop3);
		service.reserveASeat(passenger2, ad1, stop1, stop3);
		
		assertEquals(2, ad1.getPassengers().size());
		assertEquals(2, ad1.getStop(0).getPassengers().size());
		assertEquals(2, ad1.getStop(1).getPassengers().size());
		assertEquals(2, ad1.getStop(2).getPassengers().size());
		
		assertEquals(2, stop1.getPassengers().size());
		assertEquals(2, stop2.getPassengers().size());
		assertEquals(2, stop3.getPassengers().size());
		
		assertEquals(passenger1, stop1.getPassengers().get(0));
		assertEquals(passenger1, stop2.getPassengers().get(0));
		assertEquals(passenger1, stop3.getPassengers().get(0));
		
		assertEquals(passenger2, stop1.getPassengers().get(1));
		assertEquals(passenger2, stop2.getPassengers().get(1));
		assertEquals(passenger2, stop3.getPassengers().get(1));
		
		assertEquals(2, stop1.getNbOfAvailableSeat());
		
		stop2.setNbOfAvailableSeat(0);
		
		try {
			service.reserveASeat(passenger3, ad1, stop1, stop3);
		}
		catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Not enough place in the car!");
		}
	}
	
	@Test
	void cancelReservation() 
	{
		User user1 = service.createUser(101, "user1");
		User user2 = service.createUser(102, "user2");
		User user3 = service.createUser(103, "user3");
		
		Driver driver1 = service.createDriver(user1);
		Vehicle vehicle1 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver1);
	
		Passenger passenger1 = service.createPassenger(user2);
		Passenger passenger2 = service.createPassenger(user3);
		
		Ad ad1 = service.createAd(driver1, 123, 5, vehicle1);
		
		Time time = new Time(3, 3, 3);
		Date date = new Date(4, 4, 4);
		
		Stop stop1 = service.createStop(ad1, time, date, 0, 0, 101);
		Stop stop2 = service.createStop(ad1, time, date, 3, 4, 102);
		Stop stop3 = service.createStop(ad1, time, date, -3, -4, 103);
		
		service.reserveASeat(passenger1, ad1, stop1, stop3);
		service.reserveASeat(passenger2, ad1, stop1, stop3);
		
		service.cancelReservation(passenger1, ad1);
	
		assertEquals(0, 0);
		
		assertEquals(1, ad1.getPassengers().size());
		assertEquals(1, ad1.getStop(0).getPassengers().size());
		assertEquals(1, ad1.getStop(1).getPassengers().size());
		assertEquals(1, ad1.getStop(2).getPassengers().size());
		
		assertEquals(1, stop1.getPassengers().size());
		assertEquals(1, stop2.getPassengers().size());
		assertEquals(1, stop3.getPassengers().size());
		
		assertEquals(passenger2, stop1.getPassengers().get(0));
		assertEquals(passenger2, stop2.getPassengers().get(0));
		assertEquals(passenger2, stop3.getPassengers().get(0));
		
		assertEquals(3, stop1.getNbOfAvailableSeat());
	}
	
	@Test
	void getActivePassengers() 
	{
		User user1 = service.createUser(101, "user1");
		User user2 = service.createUser(102, "user2");
		User user3 = service.createUser(103, "user3");
		User user4 = service.createUser(104, "user4");
		
		Driver driver1 = service.createDriver(user1);
		Vehicle vehicle1 = service.createVehicle(2000, "bmw", "a1b2c3", 4, driver1);
	
		Passenger passenger1 = service.createPassenger(user2);
		Passenger passenger2 = service.createPassenger(user3);
		Passenger passenger3 = service.createPassenger(user4);
		
		Ad ad1 = service.createAd(driver1, 123, 5, vehicle1);
		
		Time time = new Time(3, 3, 3);
		Date date = new Date(4, 4, 4);
		
		Stop stop1 = service.createStop(ad1, time, date, 0, 0, 101);
		Stop stop2 = service.createStop(ad1, time, date, 3, 4, 102);
		Stop stop3 = service.createStop(ad1, time, date, -3, -4, 103);
		
		service.reserveASeat(passenger1, ad1, stop1, stop3);
		service.reserveASeat(passenger2, ad1, stop1, stop3);
		
		List<Passenger> activePassengers = service.getActivePassengers();
		
		assertEquals(2, activePassengers.size());
		assertEquals(passenger1, activePassengers.get(0));
		assertEquals(passenger2, activePassengers.get(1));
		
	}
	
	@Test
	void getTopDrivers() 
	{
		User user1 = service.createUser(101, "user1");
		User user2 = service.createUser(102, "user2");
		User user3 = service.createUser(103, "user3");
		
		Driver driver1 = service.createDriver(user1);
		Driver driver2 = service.createDriver(user2);
		Driver driver3 = service.createDriver(user3);
		
		driver1.setTotalDistance(50);
		driver2.setTotalDistance(100);
		driver3.setTotalDistance(10);
		
		ArrayList<Driver> sortedList = service.getTopDrivers();

		
		assertEquals(3, sortedList.size());
		assertEquals(driver1, sortedList.get(1));
		assertEquals(driver2, sortedList.get(0));	
		assertEquals(driver3, sortedList.get(2));	
	}
	
	

	@Test
	void getTopPassengers() 
	{
		User user1 = service.createUser(101, "user1");
		User user2 = service.createUser(102, "user2");
		User user3 = service.createUser(103, "user3");
		
		Passenger passenger1 = service.createPassenger(user1);
		Passenger passenger2 = service.createPassenger(user2);
		Passenger passenger3 = service.createPassenger(user3);
		
		passenger1.setTotalDistance(50);
		passenger2.setTotalDistance(100);
		passenger3.setTotalDistance(10);
		
		ArrayList<Passenger> sortedList = service.getTopPassengers();
		
		assertEquals(3, sortedList.size());
		assertEquals(passenger1, sortedList.get(1));
		assertEquals(passenger2, sortedList.get(0));	
		assertEquals(passenger3, sortedList.get(2));	
	}
	
	@Test
	void listAdsByStops() {
		
	}
	
}
