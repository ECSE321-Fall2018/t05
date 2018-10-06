package ca.mcgill.ecse321.carpoolapp.services;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.Address;

import ca.mcgill.ecse321.carpoolapp.model.Ad;
import ca.mcgill.ecse321.carpoolapp.model.Admin;
import ca.mcgill.ecse321.carpoolapp.model.CarPoolManager;
import ca.mcgill.ecse321.carpoolapp.model.Driver;
import ca.mcgill.ecse321.carpoolapp.model.Passenger;
import ca.mcgill.ecse321.carpoolapp.model.Stop;
import ca.mcgill.ecse321.carpoolapp.model.User;
import ca.mcgill.ecse321.carpoolapp.model.Vehicle;

public class MethodServices 
{
	private CarPoolManager cm;
	
	public MethodServices(CarPoolManager cm) {
		this.cm = cm;
	}
	
	//AKC
	public User createUser()
	{
		
		return null;
		
	}
	
	//AKC
	public Driver createDriver()
	{
		return null;
		
	}
	
	//AKC
	public Passenger createPassenger()
	{
		return null;
		
	}
	
	//AKC
	public Admin createAdmin()
	{
		return null;
		
	}
	
	
<<<<<<< HEAD
	//AKC-done
	public Stop createStop(Ad ad, Time time,Date date, int x, int y, int nbOfAvailableSeat, int id)
=======
	//AKC
	public Stop createStop()
>>>>>>> a3821ec7439c1ab90533fe8a17425dcd1fbe505b
	{
		Stop newStop = cm.addStop(time, date, x, y, nbOfAvailableSeat, ad, id);
		return newStop;
	}
	
	//AKC-done
	public Ad createAd(Driver driver, int id, double price, Vehicle vehicle)
	{
		if(price < 0)
		{
			throw new IllegalArgumentException();
		}
		
		Ad newAd = cm.addAd(id, price, true, false, driver, vehicle);
		
		return newAd;	
	}
	
	//AKC-done
	public Vehicle createVehicle(int year, String brand, String plateNumber, int availableSeat, Driver driver)
	{
		if(year < 0)
		{
			throw new IllegalArgumentException();
		}
		Vehicle newVehicle = cm.addVehicle(year, brand, plateNumber, availableSeat, driver);
		return newVehicle;
	}

	//AKC-done
	public ArrayList<Driver> getActiveDrivers()
	{
		Ad curAd;
		Driver curDriver;
		ArrayList<Driver> activeDrivers = new ArrayList<Driver>();
		ArrayList<Ad> activeAds = getActiveAds();
	
		//get all ads if they are active add driver to the list
		//if driver is already on list do not add
		for(int i = 0; i < activeAds.size(); i++)
		{
			curAd = activeAds.get(i);
			curDriver = curAd.getDriver();
			
			if(activeDrivers.contains(curDriver) == false)
			{
				activeDrivers.add(curDriver);
			}
		}
		return activeDrivers;
	}
	
	//AKC-done
	public ArrayList<Passenger> getActivePassengers()
	{
		Ad curAd;
		List<Passenger> curPassengers;
		ArrayList<Passenger> activePassengers = new ArrayList<Passenger>();
		ArrayList<Ad> activeAds = getActiveAds();
		
		//get activeAds
		//get their passenger, look if each passenger is already in the list
		for(int i = 0; i < activeAds.size(); i++)
		{
			curAd = activeAds.get(i);
			curPassengers = curAd.getPassengers();
			
			for(int j = 0; j < curPassengers.size(); j++)
			{
				if(activePassengers.contains(curPassengers.get(j)) == false)
				{
					activePassengers.add(curPassengers.get(j));
				}
			}
		}
		
		return activePassengers;
	
	}
	
	//distance AHB-done
	public ArrayList<Driver> getTopDrivers(){
		ArrayList<Driver> sortedList = new ArrayList<Driver>();
		sortedList = (ArrayList<Driver>) cm.getDrivers();
		
		Driver temp;
		int max = 0;
		int minIndex = 0;
		
		//sortedList.size()-1 because else j will be out of bounds
		for (int i = 0; i < sortedList.size() -1; i++) {
			//will compare current element with next elements
			max = sortedList.get(i).getTotalDistance();
			for (int j = i+1; j < sortedList.size(); j++) {
				if (max < sortedList.get(j).getTotalDistance()) {
					max = sortedList.get(j).getTotalDistance(); //set the new min
					minIndex = j; //set the index in list of smallest value up to now
				}
			}
			//swap elements
			temp = sortedList.get(i);
			sortedList.set(i, sortedList.get(minIndex));
			sortedList.set(minIndex, temp);
		}
		return sortedList;
	}
	
	//distance AHB-done
	public ArrayList<Passenger> getTopPassengers()
	{
		ArrayList<Passenger> sortedList = new ArrayList<Passenger>();
		sortedList = (ArrayList<Passenger>) cm.getPassengers();
		
		Passenger temp;
		int max = 0;
		int minIndex = 0;
		
		//sortedList.size()-1 because else j will be out of bounds
		for (int i = 0; i < sortedList.size() -1; i++) {
			//will compare current element with next elements
			max = sortedList.get(i).getTotalDistance();
			for (int j = i+1; j < sortedList.size(); j++) {
				if (max < sortedList.get(j).getTotalDistance()) {
					max = sortedList.get(j).getTotalDistance(); //set the new min
					minIndex = j; //set the index in list of smallest value up to now
				}
			}
			//swap elements
			temp = sortedList.get(i);
			sortedList.set(i, sortedList.get(minIndex));
			sortedList.set(minIndex, temp);
		}
		return sortedList;
	}
	
	//AHB-done
	public ArrayList<Ad> listAds(Stop start, Stop end)
	{
		//Put all existing adds inside list
		ArrayList<Ad> list = new ArrayList<Ad>();
		list = (ArrayList<Ad>) cm.getAds();
		
		//Create a sorted list
		ArrayList<Ad> sortedList = new ArrayList<Ad>();
		
		int startIndex = 0;
		int endIndex = 0;
		
		//for each ad
		for (int i = 0; i < list.size(); i++) {
			//for each stop of the current ad
			for (int j = 0; j < list.get(i).getStops().size(); j++) {
				//if the current stop equals the desired starting stop of the customer, register its index in the itinerary
				if (list.get(i).getStop(j).equals(start))
					startIndex = j;
				//if the current stop equals the desired ending stop of the customer, register its index in the itinerary
				if (list.get(i).getStop(j).equals(end))
					endIndex = j;
			}
			//make sure start stop is before end stop
			if (startIndex < endIndex)
				sortedList.add(list.get(i));
		}
		return sortedList;
		
	}
	
	//AKC-done
	public ArrayList<Ad> getActiveAds()
	{
		ArrayList<Ad> activeAds = new ArrayList<Ad>();
		List<Ad> allAds = cm.getAds();
		
		for(Ad curAd: allAds)
		{
			if(curAd.getIsActive() == true)
			{
				activeAds.add(curAd);
			}
		}
		
		return activeAds;
	}
	
	//AKC-done
	public double getDistOfAd(Ad ad)
	{
		double distance = 0;
		List<Stop> stops = ad.getStops();
		
		for(int i = 0; i < stops.size()-1; i++)
		{
			distance += getDistBetweenStops(stops.get(i), stops.get(i+1));
		}
		
		return distance;	
	}
	
	public double getDistBetweenStops(Stop first, Stop next)
	{
		double yNext = next.getY();
		double xNext = next.getX();
		double yFirst = first.getY();
		double xFirst = first.getX();
		
		double distance;
		
		distance = Math.hypot(xNext-xFirst, yNext-yFirst);
		
		return distance;
	}
	
	//AHB-done
	public ArrayList<Ad> sortAdsDistance(ArrayList<Ad> activeAds)
	{
		ArrayList<Ad> sortedList = new ArrayList<Ad>();
		sortedList = activeAds;
		
		Ad temp;
		double min = 0;
		int minIndex = 0;
		
		//sortedList.size()-1 because else j will be out of bounds
		for (int i = 0; i < sortedList.size() -1; i++) {
			//will compare current element with next elements
			min = getDistOfAd(sortedList.get(i));
			for (int j = i+1; j < sortedList.size(); j++) {
				if (min > getDistOfAd(sortedList.get(j))) {
					min = getDistOfAd(sortedList.get(j)); //set the new min
					minIndex = j; //set the index in list of smallest value up to now
				}
			}
			//swap elements
			temp = sortedList.get(i);
			sortedList.set(i, sortedList.get(minIndex));
			sortedList.set(minIndex, temp);
		}
		return sortedList;
	}
	
	//AHB-done
	public ArrayList<Ad> sortAdsPrice(ArrayList<Ad> activeAds){
		ArrayList<Ad> sortedList = new ArrayList<Ad>();
		sortedList = activeAds;
		
		Ad temp;
		double min = 0;
		int minIndex = 0;
		
		//sortedList.size()-1 because else j will be out of bounds
		for (int i = 0; i < sortedList.size()-1; i++) {
			//will compare current element with next elements
			min = sortedList.get(i).getPrice();
			for (int j = i+1; j < sortedList.size(); j++) {
				if (min > sortedList.get(j).getPrice()) {
					min = sortedList.get(j).getPrice(); //set the new min
					minIndex = j; //set the index in list of smallest value up to now
				}
			}
			//swap elements
			temp = sortedList.get(i);
			sortedList.set(i, sortedList.get(minIndex));
			sortedList.set(minIndex, temp);
		}
		return sortedList;
	}
	
	
	//AHB-done
	public ArrayList<Ad> sortAdsCarType(ArrayList<Ad> activeAds)
	{
		ArrayList<Ad> sortedList = new ArrayList<Ad>();
		sortedList = activeAds;
		
		Ad temp;
		String name = "";
		int minIndex = 0;
		
		//sortedList.size()-1 because else j will be out of bounds
		for (int i = 0; i < sortedList.size()-1; i++) {
			//will compare current element with next elements
			name = sortedList.get(i).getVehicle().getBrand();
			for (int j = i+1; j < sortedList.size(); j++) {
				//if negative, then sortedList.get(i).getVehicle().getBrand() is lexicographically smaller than name 
				if (name.compareTo(sortedList.get(i).getVehicle().getBrand()) < 0) {
					name = sortedList.get(i).getVehicle().getBrand(); //set the new min
					minIndex = j; //set the index in list of smallest value up to now
				}
			}
			//swap elements
			temp = sortedList.get(i);
			sortedList.set(i, sortedList.get(minIndex));
			sortedList.set(minIndex, temp);
		}
		return sortedList;
		
	}
	
	//AKC-done
	//true if done false if not done
	public boolean reserveASeat(Passenger passenger, Ad ad, Stop start, Stop end)
	{
		int startIndex = 0;
		int endIndex = 0;
		
		//get index of start and end stop
		for(int i = 0; i < ad.getStops().size(); i++)
		{
			if(ad.getStop(i).getId() == start.getId())
			{
				startIndex = i;
			}
			if(ad.getStop(i).getId() == end.getId())
			{
				endIndex = i;
			}
		}
		
		//check if there's place
		Stop curStop;
		for(int j = startIndex; j < endIndex; j++)
		{
			curStop = ad.getStop(j);
			
			int nbOfAvailableSeats = curStop.getNbOfAvailableSeat();
			if(nbOfAvailableSeats < 1)
			{
				return false;
			}
		}
		
		//enough place, add passenger and reduce seating
		for(int j = startIndex; j < endIndex; j++)
		{
			curStop = ad.getStop(j);
			
			curStop.addPassenger(passenger);
			curStop.setNbOfAvailableSeat(curStop.getNbOfAvailableSeat()-1);
		}
		
		return true;
	}
	
	//AKC-done
	public void cancelReservation(Passenger passenger, Ad ad, Stop start, Stop end)
	{
		int startIndex = 0;
		int endIndex = 0;
		
		//get index of start and end stop
		for(int i = 0; i < ad.getStops().size(); i++)
		{
			if(ad.getStop(i).getId() == start.getId())
			{
				startIndex = i;
			}
			if(ad.getStop(i).getId() == end.getId())
			{
				endIndex = i;
			}
		}
		//for all stops remove passenger and increase seating
		Stop curStop;
		for(int j = startIndex; j < endIndex; j++)
		{
			curStop = ad.getStop(j);
			curStop.removePassenger(passenger);
			curStop.setNbOfAvailableSeat(curStop.getNbOfAvailableSeat()+1);
		}
		return;
	}
	
	//AKC
	public void completeAd(Ad ad)
	{
		Driver driver = ad.getDriver();
		double adDistance = getDistOfAd(ad);
		
		//update driver avg price
		int totalMoney = driver.getAverageCostPerKm()*driver.getTotalDistance();
		totalMoney += adDistance*ad.getPrice();
		int newAvgPrice = (int) (totalMoney/(adDistance+driver.getTotalDistance()));
		
		//update totalDIstance
		driver.setTotalDistance((int) (adDistance+driver.getTotalDistance()));
		
		//turn off activity of ad
		ad.setIsCompleted(true);
		ad.setIsActive(false);
		
		
		return;
	}
	
}
