/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4262.30c9ffc7c modeling language!*/

package ca.mcgill.ecse321.carpoolapp.model;
import java.util.*;
import java.sql.Time;
import java.sql.Date;

// line 51 "../../../../../../../../ump/tmp588129/model.ump"
// line 115 "../../../../../../../../ump/tmp588129/model.ump"
public class Ad
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ad Attributes
  private int id;
  private boolean isActive;
  private boolean isCompleted;

  //Ad Associations
  private List<Stop> stops;
  private CarpoolManager carpoolManager;
  private Driver driver;
  private List<Passenger> passengers;
  private Vehicle vehicle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ad(int aId, boolean aIsActive, boolean aIsCompleted, CarpoolManager aCarpoolManager, Driver aDriver, Vehicle aVehicle)
  {
    id = aId;
    isActive = aIsActive;
    isCompleted = aIsCompleted;
    stops = new ArrayList<Stop>();
    boolean didAddCarpoolManager = setCarpoolManager(aCarpoolManager);
    if (!didAddCarpoolManager)
    {
      throw new RuntimeException("Unable to create ad due to carpoolManager");
    }
    boolean didAddDriver = setDriver(aDriver);
    if (!didAddDriver)
    {
      throw new RuntimeException("Unable to create ad due to driver");
    }
    passengers = new ArrayList<Passenger>();
    boolean didAddVehicle = setVehicle(aVehicle);
    if (!didAddVehicle)
    {
      throw new RuntimeException("Unable to create ad due to vehicle");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsActive(boolean aIsActive)
  {
    boolean wasSet = false;
    isActive = aIsActive;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsCompleted(boolean aIsCompleted)
  {
    boolean wasSet = false;
    isCompleted = aIsCompleted;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public boolean getIsActive()
  {
    return isActive;
  }

  public boolean getIsCompleted()
  {
    return isCompleted;
  }
  /* Code from template association_GetMany */
  public Stop getStop(int index)
  {
    Stop aStop = stops.get(index);
    return aStop;
  }

  public List<Stop> getStops()
  {
    List<Stop> newStops = Collections.unmodifiableList(stops);
    return newStops;
  }

  public int numberOfStops()
  {
    int number = stops.size();
    return number;
  }

  public boolean hasStops()
  {
    boolean has = stops.size() > 0;
    return has;
  }

  public int indexOfStop(Stop aStop)
  {
    int index = stops.indexOf(aStop);
    return index;
  }
  /* Code from template association_GetOne */
  public CarpoolManager getCarpoolManager()
  {
    return carpoolManager;
  }
  /* Code from template association_GetOne */
  public Driver getDriver()
  {
    return driver;
  }
  /* Code from template association_GetMany */
  public Passenger getPassenger(int index)
  {
    Passenger aPassenger = passengers.get(index);
    return aPassenger;
  }

  public List<Passenger> getPassengers()
  {
    List<Passenger> newPassengers = Collections.unmodifiableList(passengers);
    return newPassengers;
  }

  public int numberOfPassengers()
  {
    int number = passengers.size();
    return number;
  }

  public boolean hasPassengers()
  {
    boolean has = passengers.size() > 0;
    return has;
  }

  public int indexOfPassenger(Passenger aPassenger)
  {
    int index = passengers.indexOf(aPassenger);
    return index;
  }
  /* Code from template association_GetOne */
  public Vehicle getVehicle()
  {
    return vehicle;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfStopsValid()
  {
    boolean isValid = numberOfStops() >= minimumNumberOfStops();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStops()
  {
    return 1;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public Stop addStop(Time aTime, Date aDate, int aNbOfAvailableSeat, Adress aAdress)
  {
    Stop aNewStop = new Stop(aTime, aDate, aNbOfAvailableSeat, aAdress, this);
    return aNewStop;
  }

  public boolean addStop(Stop aStop)
  {
    boolean wasAdded = false;
    if (stops.contains(aStop)) { return false; }
    Ad existingAd = aStop.getAd();
    boolean isNewAd = existingAd != null && !this.equals(existingAd);

    if (isNewAd && existingAd.numberOfStops() <= minimumNumberOfStops())
    {
      return wasAdded;
    }
    if (isNewAd)
    {
      aStop.setAd(this);
    }
    else
    {
      stops.add(aStop);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStop(Stop aStop)
  {
    boolean wasRemoved = false;
    //Unable to remove aStop, as it must always have a ad
    if (this.equals(aStop.getAd()))
    {
      return wasRemoved;
    }

    //ad already at minimum (1)
    if (numberOfStops() <= minimumNumberOfStops())
    {
      return wasRemoved;
    }

    stops.remove(aStop);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStopAt(Stop aStop, int index)
  {  
    boolean wasAdded = false;
    if(addStop(aStop))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStops()) { index = numberOfStops() - 1; }
      stops.remove(aStop);
      stops.add(index, aStop);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStopAt(Stop aStop, int index)
  {
    boolean wasAdded = false;
    if(stops.contains(aStop))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStops()) { index = numberOfStops() - 1; }
      stops.remove(aStop);
      stops.add(index, aStop);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStopAt(aStop, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCarpoolManager(CarpoolManager aCarpoolManager)
  {
    boolean wasSet = false;
    if (aCarpoolManager == null)
    {
      return wasSet;
    }

    CarpoolManager existingCarpoolManager = carpoolManager;
    carpoolManager = aCarpoolManager;
    if (existingCarpoolManager != null && !existingCarpoolManager.equals(aCarpoolManager))
    {
      existingCarpoolManager.removeAd(this);
    }
    carpoolManager.addAd(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setDriver(Driver aDriver)
  {
    boolean wasSet = false;
    if (aDriver == null)
    {
      return wasSet;
    }

    Driver existingDriver = driver;
    driver = aDriver;
    if (existingDriver != null && !existingDriver.equals(aDriver))
    {
      existingDriver.removeAd(this);
    }
    driver.addAd(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPassengers()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addPassenger(Passenger aPassenger)
  {
    boolean wasAdded = false;
    if (passengers.contains(aPassenger)) { return false; }
    passengers.add(aPassenger);
    if (aPassenger.indexOfAd(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPassenger.addAd(this);
      if (!wasAdded)
      {
        passengers.remove(aPassenger);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removePassenger(Passenger aPassenger)
  {
    boolean wasRemoved = false;
    if (!passengers.contains(aPassenger))
    {
      return wasRemoved;
    }

    int oldIndex = passengers.indexOf(aPassenger);
    passengers.remove(oldIndex);
    if (aPassenger.indexOfAd(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPassenger.removeAd(this);
      if (!wasRemoved)
      {
        passengers.add(oldIndex,aPassenger);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPassengerAt(Passenger aPassenger, int index)
  {  
    boolean wasAdded = false;
    if(addPassenger(aPassenger))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPassengers()) { index = numberOfPassengers() - 1; }
      passengers.remove(aPassenger);
      passengers.add(index, aPassenger);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePassengerAt(Passenger aPassenger, int index)
  {
    boolean wasAdded = false;
    if(passengers.contains(aPassenger))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPassengers()) { index = numberOfPassengers() - 1; }
      passengers.remove(aPassenger);
      passengers.add(index, aPassenger);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPassengerAt(aPassenger, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToOptionalOne */
  public boolean setVehicle(Vehicle aNewVehicle)
  {
    boolean wasSet = false;
    if (aNewVehicle == null)
    {
      //Unable to setVehicle to null, as ad must always be associated to a vehicle
      return wasSet;
    }
    
    Ad existingAd = aNewVehicle.getAd();
    if (existingAd != null && !equals(existingAd))
    {
      //Unable to setVehicle, the current vehicle already has a ad, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Vehicle anOldVehicle = vehicle;
    vehicle = aNewVehicle;
    vehicle.setAd(this);

    if (anOldVehicle != null)
    {
      anOldVehicle.setAd(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while (stops.size() > 0)
    {
      Stop aStop = stops.get(stops.size() - 1);
      aStop.delete();
      stops.remove(aStop);
    }
    
    CarpoolManager placeholderCarpoolManager = carpoolManager;
    this.carpoolManager = null;
    if(placeholderCarpoolManager != null)
    {
      placeholderCarpoolManager.removeAd(this);
    }
    Driver placeholderDriver = driver;
    this.driver = null;
    if(placeholderDriver != null)
    {
      placeholderDriver.removeAd(this);
    }
    ArrayList<Passenger> copyOfPassengers = new ArrayList<Passenger>(passengers);
    passengers.clear();
    for(Passenger aPassenger : copyOfPassengers)
    {
      aPassenger.removeAd(this);
    }
    Vehicle existingVehicle = vehicle;
    vehicle = null;
    if (existingVehicle != null)
    {
      existingVehicle.setAd(null);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "isActive" + ":" + getIsActive()+ "," +
            "isCompleted" + ":" + getIsCompleted()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "carpoolManager = "+(getCarpoolManager()!=null?Integer.toHexString(System.identityHashCode(getCarpoolManager())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "driver = "+(getDriver()!=null?Integer.toHexString(System.identityHashCode(getDriver())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "vehicle = "+(getVehicle()!=null?Integer.toHexString(System.identityHashCode(getVehicle())):"null");
  }
}