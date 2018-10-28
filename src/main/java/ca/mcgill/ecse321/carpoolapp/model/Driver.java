/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4295.41a59b8ce modeling language!*/

package ca.mcgill.ecse321.carpoolapp.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// line 15 "../../../../../../../../ump/18102077559/model.ump"
// line 99 "../../../../../../../../ump/18102077559/model.ump"
@Entity
@Table(name="driver")
public class Driver extends UserRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Driver Attributes
  private int averageCostPerKm;
  private int totalDistance;
  private int driver_id;

  //Driver Associations
  private List<Vehicle> vehicles;
  private List<Ad> ads;
  private CarPoolManager carPoolManager;
  
  @Id
  public int getId() {
	  this.driver_id = this.getUser().getId();
	  return driver_id;
  }
  
  public boolean setId(int aId) {
	  this.driver_id = aId;
	  return this.getUser().setId(aId);
  }
  
  public void setVehicles(List<Vehicle> vehicles) {
	this.vehicles = vehicles;
  }

  public void setAds(List<Ad> ads) {
		this.ads = ads;
  }



  //------------------------
  // CONSTRUCTOR
  //------------------------


public Driver(User aUser, int aAverageCostPerKm, int aTotalDistance, CarPoolManager aCarPoolManager)
  {
    super(aUser);
    averageCostPerKm = aAverageCostPerKm;
    totalDistance = aTotalDistance;
    vehicles = new ArrayList<Vehicle>();
    ads = new ArrayList<Ad>();
    boolean didAddCarPoolManager = setCarPoolManager(aCarPoolManager);
    if (!didAddCarPoolManager)
    {
      throw new RuntimeException("Unable to create driver due to carPoolManager");
    }
  }


public Driver()
{

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
  @ManyToMany(cascade = CascadeType.ALL, mappedBy = "drivers")
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
  @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
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
  @ManyToOne 
  @JoinTable(name = "driver_carpoolManager")
  public CarPoolManager getCarPoolManager()
  {
    return carPoolManager;
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
  public Ad addAd(int aId, double aPrice, boolean aIsActive, boolean aIsCompleted, Vehicle aVehicle, CarPoolManager aCarPoolManager)
  {
    return new Ad(aId, aPrice, aIsActive, aIsCompleted, this, aVehicle, aCarPoolManager);
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
  public boolean setCarPoolManager(CarPoolManager aCarPoolManager)
  {
    boolean wasSet = false;
    if (aCarPoolManager == null)
    {
      return wasSet;
    }

    CarPoolManager existingCarPoolManager = carPoolManager;
    carPoolManager = aCarPoolManager;
    if (existingCarPoolManager != null && !existingCarPoolManager.equals(aCarPoolManager))
    {
      existingCarPoolManager.removeDriver(this);
    }
    carPoolManager.addDriver(this);
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
    
    CarPoolManager placeholderCarPoolManager = carPoolManager;
    this.carPoolManager = null;
    if(placeholderCarPoolManager != null)
    {
      placeholderCarPoolManager.removeDriver(this);
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "averageCostPerKm" + ":" + getAverageCostPerKm()+ "," +
            "totalDistance" + ":" + getTotalDistance()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "carPoolManager = "+(getCarPoolManager()!=null?Integer.toHexString(System.identityHashCode(getCarPoolManager())):"null");
  }
}