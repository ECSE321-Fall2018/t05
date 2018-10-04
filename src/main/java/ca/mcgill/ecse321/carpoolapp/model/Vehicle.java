/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4262.30c9ffc7c modeling language!*/

package ca.mcgill.ecse321.carpoolapp.model;
import java.util.*;

// line 59 "../../../../../../../../ump/tmp588129/model.ump"
// line 120 "../../../../../../../../ump/tmp588129/model.ump"
public class Vehicle
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Vehicle Attributes
  private int year;
  private String brand;
  private int plateNumber;
  private int availableSeat;

  //Vehicle Associations
  private Ad ad;
  private CarpoolManager carpoolManager;
  private List<Driver> drivers;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Vehicle(int aYear, String aBrand, int aPlateNumber, int aAvailableSeat, CarpoolManager aCarpoolManager, Driver... allDrivers)
  {
    year = aYear;
    brand = aBrand;
    plateNumber = aPlateNumber;
    availableSeat = aAvailableSeat;
    boolean didAddCarpoolManager = setCarpoolManager(aCarpoolManager);
    if (!didAddCarpoolManager)
    {
      throw new RuntimeException("Unable to create vehicle due to carpoolManager");
    }
    drivers = new ArrayList<Driver>();
    boolean didAddDrivers = setDrivers(allDrivers);
    if (!didAddDrivers)
    {
      throw new RuntimeException("Unable to create Vehicle, must have at least 1 drivers");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setYear(int aYear)
  {
    boolean wasSet = false;
    year = aYear;
    wasSet = true;
    return wasSet;
  }

  public boolean setBrand(String aBrand)
  {
    boolean wasSet = false;
    brand = aBrand;
    wasSet = true;
    return wasSet;
  }

  public boolean setPlateNumber(int aPlateNumber)
  {
    boolean wasSet = false;
    plateNumber = aPlateNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setAvailableSeat(int aAvailableSeat)
  {
    boolean wasSet = false;
    availableSeat = aAvailableSeat;
    wasSet = true;
    return wasSet;
  }

  public int getYear()
  {
    return year;
  }

  public String getBrand()
  {
    return brand;
  }

  public int getPlateNumber()
  {
    return plateNumber;
  }

  public int getAvailableSeat()
  {
    return availableSeat;
  }
  /* Code from template association_GetOne */
  public Ad getAd()
  {
    return ad;
  }

  public boolean hasAd()
  {
    boolean has = ad != null;
    return has;
  }
  /* Code from template association_GetOne */
  public CarpoolManager getCarpoolManager()
  {
    return carpoolManager;
  }
  /* Code from template association_GetMany */
  public Driver getDriver(int index)
  {
    Driver aDriver = drivers.get(index);
    return aDriver;
  }

  public List<Driver> getDrivers()
  {
    List<Driver> newDrivers = Collections.unmodifiableList(drivers);
    return newDrivers;
  }

  public int numberOfDrivers()
  {
    int number = drivers.size();
    return number;
  }

  public boolean hasDrivers()
  {
    boolean has = drivers.size() > 0;
    return has;
  }

  public int indexOfDriver(Driver aDriver)
  {
    int index = drivers.indexOf(aDriver);
    return index;
  }
  /* Code from template association_SetOptionalOneToOne */
  public boolean setAd(Ad aNewAd)
  {
    boolean wasSet = false;
    if (ad != null && !ad.equals(aNewAd) && equals(ad.getVehicle()))
    {
      //Unable to setAd, as existing ad would become an orphan
      return wasSet;
    }

    ad = aNewAd;
    Vehicle anOldVehicle = aNewAd != null ? aNewAd.getVehicle() : null;

    if (!this.equals(anOldVehicle))
    {
      if (anOldVehicle != null)
      {
        anOldVehicle.ad = null;
      }
      if (ad != null)
      {
        ad.setVehicle(this);
      }
    }
    wasSet = true;
    return wasSet;
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
      existingCarpoolManager.removeVehicle(this);
    }
    carpoolManager.addVehicle(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfDriversValid()
  {
    boolean isValid = numberOfDrivers() >= minimumNumberOfDrivers();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDrivers()
  {
    return 1;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addDriver(Driver aDriver)
  {
    boolean wasAdded = false;
    if (drivers.contains(aDriver)) { return false; }
    drivers.add(aDriver);
    if (aDriver.indexOfVehicle(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDriver.addVehicle(this);
      if (!wasAdded)
      {
        drivers.remove(aDriver);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMStarToMany */
  public boolean removeDriver(Driver aDriver)
  {
    boolean wasRemoved = false;
    if (!drivers.contains(aDriver))
    {
      return wasRemoved;
    }

    if (numberOfDrivers() <= minimumNumberOfDrivers())
    {
      return wasRemoved;
    }

    int oldIndex = drivers.indexOf(aDriver);
    drivers.remove(oldIndex);
    if (aDriver.indexOfVehicle(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDriver.removeVehicle(this);
      if (!wasRemoved)
      {
        drivers.add(oldIndex,aDriver);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMStarToMany */
  public boolean setDrivers(Driver... newDrivers)
  {
    boolean wasSet = false;
    ArrayList<Driver> verifiedDrivers = new ArrayList<Driver>();
    for (Driver aDriver : newDrivers)
    {
      if (verifiedDrivers.contains(aDriver))
      {
        continue;
      }
      verifiedDrivers.add(aDriver);
    }

    if (verifiedDrivers.size() != newDrivers.length || verifiedDrivers.size() < minimumNumberOfDrivers())
    {
      return wasSet;
    }

    ArrayList<Driver> oldDrivers = new ArrayList<Driver>(drivers);
    drivers.clear();
    for (Driver aNewDriver : verifiedDrivers)
    {
      drivers.add(aNewDriver);
      if (oldDrivers.contains(aNewDriver))
      {
        oldDrivers.remove(aNewDriver);
      }
      else
      {
        aNewDriver.addVehicle(this);
      }
    }

    for (Driver anOldDriver : oldDrivers)
    {
      anOldDriver.removeVehicle(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDriverAt(Driver aDriver, int index)
  {  
    boolean wasAdded = false;
    if(addDriver(aDriver))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDrivers()) { index = numberOfDrivers() - 1; }
      drivers.remove(aDriver);
      drivers.add(index, aDriver);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDriverAt(Driver aDriver, int index)
  {
    boolean wasAdded = false;
    if(drivers.contains(aDriver))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDrivers()) { index = numberOfDrivers() - 1; }
      drivers.remove(aDriver);
      drivers.add(index, aDriver);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDriverAt(aDriver, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Ad existingAd = ad;
    ad = null;
    if (existingAd != null)
    {
      existingAd.delete();
    }
    CarpoolManager placeholderCarpoolManager = carpoolManager;
    this.carpoolManager = null;
    if(placeholderCarpoolManager != null)
    {
      placeholderCarpoolManager.removeVehicle(this);
    }
    ArrayList<Driver> copyOfDrivers = new ArrayList<Driver>(drivers);
    drivers.clear();
    for(Driver aDriver : copyOfDrivers)
    {
      aDriver.removeVehicle(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "year" + ":" + getYear()+ "," +
            "brand" + ":" + getBrand()+ "," +
            "plateNumber" + ":" + getPlateNumber()+ "," +
            "availableSeat" + ":" + getAvailableSeat()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "ad = "+(getAd()!=null?Integer.toHexString(System.identityHashCode(getAd())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "carpoolManager = "+(getCarpoolManager()!=null?Integer.toHexString(System.identityHashCode(getCarpoolManager())):"null");
  }
}