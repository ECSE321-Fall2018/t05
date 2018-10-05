/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4262.30c9ffc7c modeling language!*/

package ca.mcgill.ecse321.carpoolapp.model;
import java.util.*;

// line 28 "../../../../../../../../ump/tmp588129/model.ump"
// line 100 "../../../../../../../../ump/tmp588129/model.ump"
public class Driver extends UserRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Driver Attributes
  private int averageCostPerKm;
  private int totalDistance;

  //Driver Associations
  private List<Vehicle> vehicles;
  private List<Ad> ads;
  private CarpoolManager carpoolManager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Driver(User aUser, int aAverageCostPerKm, int aTotalDistance, CarpoolManager aCarpoolManager)
  {
    super(aUser);
    averageCostPerKm = aAverageCostPerKm;
    totalDistance = aTotalDistance;
    vehicles = new ArrayList<Vehicle>();
    ads = new ArrayList<Ad>();
    boolean didAddCarpoolManager = setCarpoolManager(aCarpoolManager);
    if (!didAddCarpoolManager)
    {
      throw new RuntimeException("Unable to create driver due to carpoolManager");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAverageCostPerKm(int aAverageCostPerKm)
  {
    boolean wasSet = false;
    averageCostPerKm = aAverageCostPerKm;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotalDistance(int aTotalDistance)
  {
    boolean wasSet = false;
    totalDistance = aTotalDistance;
    wasSet = true;
    return wasSet;
  }

  public int getAverageCostPerKm()
  {
    return averageCostPerKm;
  }

  public int getTotalDistance()
  {
    return totalDistance;
  }
  /* Code from template association_GetMany */
  public Vehicle getVehicle(int index)
  {
    Vehicle aVehicle = vehicles.get(index);
    return aVehicle;
  }

  public List<Vehicle> getVehicles()
  {
    List<Vehicle> newVehicles = Collections.unmodifiableList(vehicles);
    return newVehicles;
  }

  public int numberOfVehicles()
  {
    int number = vehicles.size();
    return number;
  }

  public boolean hasVehicles()
  {
    boolean has = vehicles.size() > 0;
    return has;
  }

  public int indexOfVehicle(Vehicle aVehicle)
  {
    int index = vehicles.indexOf(aVehicle);
    return index;
  }
  /* Code from template association_GetMany */
  public Ad getAd(int index)
  {
    Ad aAd = ads.get(index);
    return aAd;
  }

  public List<Ad> getAds()
  {
    List<Ad> newAds = Collections.unmodifiableList(ads);
    return newAds;
  }

  public int numberOfAds()
  {
    int number = ads.size();
    return number;
  }

  public boolean hasAds()
  {
    boolean has = ads.size() > 0;
    return has;
  }

  public int indexOfAd(Ad aAd)
  {
    int index = ads.indexOf(aAd);
    return index;
  }
  /* Code from template association_GetOne */
  public CarpoolManager getCarpoolManager()
  {
    return carpoolManager;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfVehicles()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addVehicle(Vehicle aVehicle)
  {
    boolean wasAdded = false;
    if (vehicles.contains(aVehicle)) { return false; }
    vehicles.add(aVehicle);
    if (aVehicle.indexOfDriver(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aVehicle.addDriver(this);
      if (!wasAdded)
      {
        vehicles.remove(aVehicle);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeVehicle(Vehicle aVehicle)
  {
    boolean wasRemoved = false;
    if (!vehicles.contains(aVehicle))
    {
      return wasRemoved;
    }

    int oldIndex = vehicles.indexOf(aVehicle);
    vehicles.remove(oldIndex);
    if (aVehicle.indexOfDriver(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aVehicle.removeDriver(this);
      if (!wasRemoved)
      {
        vehicles.add(oldIndex,aVehicle);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addVehicleAt(Vehicle aVehicle, int index)
  {  
    boolean wasAdded = false;
    if(addVehicle(aVehicle))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVehicles()) { index = numberOfVehicles() - 1; }
      vehicles.remove(aVehicle);
      vehicles.add(index, aVehicle);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVehicleAt(Vehicle aVehicle, int index)
  {
    boolean wasAdded = false;
    if(vehicles.contains(aVehicle))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVehicles()) { index = numberOfVehicles() - 1; }
      vehicles.remove(aVehicle);
      vehicles.add(index, aVehicle);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVehicleAt(aVehicle, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAds()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Ad addAd(int aId, boolean aIsActive, boolean aIsCompleted, CarpoolManager aCarpoolManager, Vehicle aVehicle, double price)
  {
    return new Ad(aId, aIsActive, aIsCompleted, aCarpoolManager, this, aVehicle, price);
  }

  public boolean addAd(Ad aAd)
  {
    boolean wasAdded = false;
    if (ads.contains(aAd)) { return false; }
    Driver existingDriver = aAd.getDriver();
    boolean isNewDriver = existingDriver != null && !this.equals(existingDriver);
    if (isNewDriver)
    {
      aAd.setDriver(this);
    }
    else
    {
      ads.add(aAd);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAd(Ad aAd)
  {
    boolean wasRemoved = false;
    //Unable to remove aAd, as it must always have a driver
    if (!this.equals(aAd.getDriver()))
    {
      ads.remove(aAd);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAdAt(Ad aAd, int index)
  {  
    boolean wasAdded = false;
    if(addAd(aAd))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAds()) { index = numberOfAds() - 1; }
      ads.remove(aAd);
      ads.add(index, aAd);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAdAt(Ad aAd, int index)
  {
    boolean wasAdded = false;
    if(ads.contains(aAd))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAds()) { index = numberOfAds() - 1; }
      ads.remove(aAd);
      ads.add(index, aAd);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAdAt(aAd, index);
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
      existingCarpoolManager.removeDriver(this);
    }
    carpoolManager.addDriver(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Vehicle> copyOfVehicles = new ArrayList<Vehicle>(vehicles);
    vehicles.clear();
    for(Vehicle aVehicle : copyOfVehicles)
    {
      if (aVehicle.numberOfDrivers() <= Vehicle.minimumNumberOfDrivers())
      {
        aVehicle.delete();
      }
      else
      {
        aVehicle.removeDriver(this);
      }
    }
    while (ads.size() > 0)
    {
      Ad aAd = ads.get(ads.size() - 1);
      aAd.delete();
      ads.remove(aAd);
    }
    
    CarpoolManager placeholderCarpoolManager = carpoolManager;
    this.carpoolManager = null;
    if(placeholderCarpoolManager != null)
    {
      placeholderCarpoolManager.removeDriver(this);
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "averageCostPerKm" + ":" + getAverageCostPerKm()+ "," +
            "totalDistance" + ":" + getTotalDistance()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "carpoolManager = "+(getCarpoolManager()!=null?Integer.toHexString(System.identityHashCode(getCarpoolManager())):"null");
  }
}