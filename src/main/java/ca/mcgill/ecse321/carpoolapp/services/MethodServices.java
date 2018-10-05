package ca.mcgill.ecse321.carpoolapp.services;

import java.util.ArrayList;

import org.apache.tomcat.jni.Address;

import ca.mcgill.ecse321.carpoolapp.model.Ad;
import ca.mcgill.ecse321.carpoolapp.model.Admin;
import ca.mcgill.ecse321.carpoolapp.model.CarpoolManager;
import ca.mcgill.ecse321.carpoolapp.model.Driver;
import ca.mcgill.ecse321.carpoolapp.model.Passenger;
import ca.mcgill.ecse321.carpoolapp.model.Stop;
import ca.mcgill.ecse321.carpoolapp.model.User;
import ca.mcgill.ecse321.carpoolapp.model.Vehicle;

public class MethodServices 
{
	private CarpoolManager cm;
	
	public MethodServices(CarpoolManager cm) {
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
	
	//AKC
	public Address createAddress()
	{
		return null;
		
	}
	
	
	//AKC
	public Stop createStop()
	{
		return null;
		
	}
	
	//AKC
	public Ad createAd()
	{
		return null;
		
	}
	
	//AKC
	public Vehicle createVehicle()
	{
		return null;
		
	}

	//AKC
	public ArrayList<Driver> getActiveDrivers()
	{
		return null;
		
	}
	
	//AKC
	public ArrayList<Passenger> getActivePassengers()
	{
		return null;
	
	}
	
	//distance AHB
	public ArrayList<Driver> getTopDrivers()
	{
		return null;
		
	}
	
	//distance AHB
	public ArrayList<Passenger> getTopPassengers()
	{
		return null;
	
	}
	
	//AHB
	public ArrayList<Ad> listAds(Stop start, Stop end)
	{
		return null;
		
	}
	
	//AKC
	public ArrayList<Ad> getActiveAds(ArrayList<Ad> allAds)
	{
		return allAds;
		
	}
	
	//AKC
	public int getDistOfAd(Ad ad)
	{
		return 0;
		
	}
	
	//AHB
	public ArrayList<Ad> sortAdsDistance(ArrayList<Ad> activeAds)
	{
		return activeAds;
		
	}
	
	//AHB
	public ArrayList<Ad> sortAdsPrice(ArrayList<Ad> activeAds)
	{
		return activeAds;
		
	}
	
	
	//AHB
	public ArrayList<Ad> sortAdsCarType(ArrayList<Ad> activeAds)
	{
		return activeAds;
		
	}
	
	//AKC
	public void reserveASeat(Passenger passenger, Ad ad, Stop start, Stop end)
	{
		return;
	}
	
	//AKC
	public void cancelReservation(Passenger passenger, Ad ad, Stop start, Stop end)
	{
		return;
	}
	
	//AKC
	public void completeAd(Ad ad)
	{
		return;
	}
	
}
