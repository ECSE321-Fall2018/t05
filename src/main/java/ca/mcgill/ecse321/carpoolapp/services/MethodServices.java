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
	public ArrayList<Driver> getTopDrivers(){
		return null;	
	}
	
	//distance AHB
	public ArrayList<Passenger> getTopPassengers()
	{
		return null;
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
			for (int j = 0; j < list.get(i).getNumberOfStops(); j++) {
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
	
	//AKC
	public ArrayList<Ad> getActiveAds(ArrayList<Ad> allAds)
	{
		return allAds;
		
	}
	
	//AKC
	public double getDistOfAd(Ad ad)
	{
		return 0;
		
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
