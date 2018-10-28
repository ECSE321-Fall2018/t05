/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4295.41a59b8ce modeling language!*/

package ca.mcgill.ecse321.carpoolapp.model;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// line 68 "../../../../../../../../ump/18102077559/model.ump"
// line 131 "../../../../../../../../ump/18102077559/model.ump"
@Entity
@Table(name="carpoolmanager")
public class CarPoolManager
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CarPoolManager Attributes
  private int id;

  //CarPoolManager Associations
  private List<User> users;
  private List<Driver> drivers;
  private List<Passenger> passengers;
  private List<Admin> admins;
  private List<Ad> ads;
  private List<Vehicle> vehicles;
  private List<Stop> stops;
  
  //------------------------
  // SETTERS
  //------------------------
  
  public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}
  

  //------------------------
  // CONSTRUCTOR
  //------------------------

public CarPoolManager(int aId)
  {
    id = aId;
    users = new ArrayList<User>();
    drivers = new ArrayList<Driver>();
    passengers = new ArrayList<Passenger>();
    admins = new ArrayList<Admin>();
    ads = new ArrayList<Ad>();
    vehicles = new ArrayList<Vehicle>();
    stops = new ArrayList<Stop>();
  }

public CarPoolManager()
{
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
  @Id
  public int getId()
  {
    return id;
  }
  /* Code from template association_GetMany */
  public User getUser(int index)
  {
    User aUser = users.get(index);
    return aUser;
  }
  @OneToMany(mappedBy="carPoolManager", cascade= {CascadeType.ALL})
  public List<User> getUsers()
  {
    List<User> newUsers = Collections.unmodifiableList(users);
    return newUsers;
  }

  public int numberOfUsers()
  {
    int number = users.size();
    return number;
  }

  public boolean hasUsers()
  {
    boolean has = users.size() > 0;
    return has;
  }

  public int indexOfUser(User aUser)
  {
    int index = users.indexOf(aUser);
    return index;
  }
  /* Code from template association_GetMany */
  public Driver getDriver(int index)
  {
    Driver aDriver = drivers.get(index);
    return aDriver;
  }
  @OneToMany(mappedBy="carPoolManager", cascade= {CascadeType.ALL})
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
  /* Code from template association_GetMany */
  public Passenger getPassenger(int index)
  {
    Passenger aPassenger = passengers.get(index);
    return aPassenger;
  }
  @OneToMany(mappedBy="carPoolManager", cascade= {CascadeType.ALL})
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
  /* Code from template association_GetMany */
  public Admin getAdmin(int index)
  {
    Admin aAdmin = admins.get(index);
    return aAdmin;
  }
  @OneToMany(mappedBy="carPoolManager", cascade= {CascadeType.ALL})
  public List<Admin> getAdmins()
  {
    List<Admin> newAdmins = Collections.unmodifiableList(admins);
    return newAdmins;
  }

  public int numberOfAdmins()
  {
    int number = admins.size();
    return number;
  }

  public boolean hasAdmins()
  {
    boolean has = admins.size() > 0;
    return has;
  }

  public int indexOfAdmin(Admin aAdmin)
  {
    int index = admins.indexOf(aAdmin);
    return index;
  }
  /* Code from template association_GetMany */
  public Ad getAd(int index)
  {
    Ad aAd = ads.get(index);
    return aAd;
  }
  @OneToMany(mappedBy="carPoolManager", cascade= {CascadeType.ALL})
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
  /* Code from template association_GetMany */
  public Vehicle getVehicle(int index)
  {
    Vehicle aVehicle = vehicles.get(index);
    return aVehicle;
  }
  @OneToMany(mappedBy="carPoolManager", cascade= {CascadeType.ALL})
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
  public Stop getStop(int index)
  {
    Stop aStop = stops.get(index);
    return aStop;
  }
  @OneToMany(mappedBy="carPoolManager", cascade= {CascadeType.ALL})
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUsers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public User addUser(int aId, String aName)
  {
    return new User(aId, aName, this);
  }

  public boolean addUser(User aUser)
  {
    boolean wasAdded = false;
    if (users.contains(aUser)) { return false; }
    CarPoolManager existingCarPoolManager = aUser.getCarPoolManager();
    boolean isNewCarPoolManager = existingCarPoolManager != null && !this.equals(existingCarPoolManager);
    if (isNewCarPoolManager)
    {
      aUser.setCarPoolManager(this);
    }
    else
    {
      users.add(aUser);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUser(User aUser)
  {
    boolean wasRemoved = false;
    //Unable to remove aUser, as it must always have a carPoolManager
    if (!this.equals(aUser.getCarPoolManager()))
    {
      users.remove(aUser);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserAt(User aUser, int index)
  {  
    boolean wasAdded = false;
    if(addUser(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAt(User aUser, int index)
  {
    boolean wasAdded = false;
    if(users.contains(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserAt(aUser, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDrivers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Driver addDriver(User aUser, int aAverageCostPerKm, int aTotalDistance)
  {
    return new Driver(aUser, aAverageCostPerKm, aTotalDistance, this);
  }

  public boolean addDriver(Driver aDriver)
  {
    boolean wasAdded = false;
    if (drivers.contains(aDriver)) { return false; }
    CarPoolManager existingCarPoolManager = aDriver.getCarPoolManager();
    boolean isNewCarPoolManager = existingCarPoolManager != null && !this.equals(existingCarPoolManager);
    if (isNewCarPoolManager)
    {
      aDriver.setCarPoolManager(this);
    }
    else
    {
      drivers.add(aDriver);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDriver(Driver aDriver)
  {
    boolean wasRemoved = false;
    //Unable to remove aDriver, as it must always have a carPoolManager
    if (!this.equals(aDriver.getCarPoolManager()))
    {
      drivers.remove(aDriver);
      wasRemoved = true;
    }
    return wasRemoved;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPassengers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Passenger addPassenger(User aUser, int aAveragePaidPerKm, int aTotalDistance)
  {
    return new Passenger(aUser, aAveragePaidPerKm, aTotalDistance, this);
  }

  public boolean addPassenger(Passenger aPassenger)
  {
    boolean wasAdded = false;
    if (passengers.contains(aPassenger)) { return false; }
    CarPoolManager existingCarPoolManager = aPassenger.getCarPoolManager();
    boolean isNewCarPoolManager = existingCarPoolManager != null && !this.equals(existingCarPoolManager);
    if (isNewCarPoolManager)
    {
      aPassenger.setCarPoolManager(this);
    }
    else
    {
      passengers.add(aPassenger);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePassenger(Passenger aPassenger)
  {
    boolean wasRemoved = false;
    //Unable to remove aPassenger, as it must always have a carPoolManager
    if (!this.equals(aPassenger.getCarPoolManager()))
    {
      passengers.remove(aPassenger);
      wasRemoved = true;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAdmins()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Admin addAdmin(User aUser)
  {
    return new Admin(aUser, this);
  }

  public boolean addAdmin(Admin aAdmin)
  {
    boolean wasAdded = false;
    if (admins.contains(aAdmin)) { return false; }
    CarPoolManager existingCarPoolManager = aAdmin.getCarPoolManager();
    boolean isNewCarPoolManager = existingCarPoolManager != null && !this.equals(existingCarPoolManager);
    if (isNewCarPoolManager)
    {
      aAdmin.setCarPoolManager(this);
    }
    else
    {
      admins.add(aAdmin);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAdmin(Admin aAdmin)
  {
    boolean wasRemoved = false;
    //Unable to remove aAdmin, as it must always have a carPoolManager
    if (!this.equals(aAdmin.getCarPoolManager()))
    {
      admins.remove(aAdmin);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAdminAt(Admin aAdmin, int index)
  {  
    boolean wasAdded = false;
    if(addAdmin(aAdmin))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAdmins()) { index = numberOfAdmins() - 1; }
      admins.remove(aAdmin);
      admins.add(index, aAdmin);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAdminAt(Admin aAdmin, int index)
  {
    boolean wasAdded = false;
    if(admins.contains(aAdmin))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAdmins()) { index = numberOfAdmins() - 1; }
      admins.remove(aAdmin);
      admins.add(index, aAdmin);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAdminAt(aAdmin, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAds()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Ad addAd(int aId, double aPrice, boolean aIsActive, boolean aIsCompleted, Driver aDriver, Vehicle aVehicle)
  {
    return new Ad(aId, aPrice, aIsActive, aIsCompleted, aDriver, aVehicle, this);
  }

  public boolean addAd(Ad aAd)
  {
    boolean wasAdded = false;
    if (ads.contains(aAd)) { return false; }
    CarPoolManager existingCarPoolManager = aAd.getCarPoolManager();
    boolean isNewCarPoolManager = existingCarPoolManager != null && !this.equals(existingCarPoolManager);
    if (isNewCarPoolManager)
    {
      aAd.setCarPoolManager(this);
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
    //Unable to remove aAd, as it must always have a carPoolManager
    if (!this.equals(aAd.getCarPoolManager()))
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfVehicles()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Vehicle addVehicle(int aYear, String aBrand, String aPlateNumber, int aAvailableSeat, Driver... allDrivers)
  {
    return new Vehicle(aYear, aBrand, aPlateNumber, aAvailableSeat, this, allDrivers);
  }

  public boolean addVehicle(Vehicle aVehicle)
  {
    boolean wasAdded = false;
    if (vehicles.contains(aVehicle)) { return false; }
    CarPoolManager existingCarPoolManager = aVehicle.getCarPoolManager();
    boolean isNewCarPoolManager = existingCarPoolManager != null && !this.equals(existingCarPoolManager);
    if (isNewCarPoolManager)
    {
      aVehicle.setCarPoolManager(this);
    }
    else
    {
      vehicles.add(aVehicle);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVehicle(Vehicle aVehicle)
  {
    boolean wasRemoved = false;
    //Unable to remove aVehicle, as it must always have a carPoolManager
    if (!this.equals(aVehicle.getCarPoolManager()))
    {
      vehicles.remove(aVehicle);
      wasRemoved = true;
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
  public static int minimumNumberOfStops()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Stop addStop(Time aTime, Date aDate, int aNbOfAvailableSeat, int aX, int aY, int aId, Ad aAd)
  {
    return new Stop(aTime, aDate, aNbOfAvailableSeat, aX, aY, aId, aAd, this);
  }

  public boolean addStop(Stop aStop)
  {
    boolean wasAdded = false;
    if (stops.contains(aStop)) { return false; }
    CarPoolManager existingCarPoolManager = aStop.getCarPoolManager();
    boolean isNewCarPoolManager = existingCarPoolManager != null && !this.equals(existingCarPoolManager);
    if (isNewCarPoolManager)
    {
      aStop.setCarPoolManager(this);
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
    //Unable to remove aStop, as it must always have a carPoolManager
    if (!this.equals(aStop.getCarPoolManager()))
    {
      stops.remove(aStop);
      wasRemoved = true;
    }
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

  public void delete()
  {
    for(int i=users.size(); i > 0; i--)
    {
      User aUser = users.get(i - 1);
      aUser.delete();
    }
    for(int i=drivers.size(); i > 0; i--)
    {
      Driver aDriver = drivers.get(i - 1);
      aDriver.delete();
    }
    for(int i=passengers.size(); i > 0; i--)
    {
      Passenger aPassenger = passengers.get(i - 1);
      aPassenger.delete();
    }
    for(int i=admins.size(); i > 0; i--)
    {
      Admin aAdmin = admins.get(i - 1);
      aAdmin.delete();
    }
    for(int i=ads.size(); i > 0; i--)
    {
      Ad aAd = ads.get(i - 1);
      aAd.delete();
    }
    for(int i=vehicles.size(); i > 0; i--)
    {
      Vehicle aVehicle = vehicles.get(i - 1);
      aVehicle.delete();
    }
    for(int i=stops.size(); i > 0; i--)
    {
      Stop aStop = stops.get(i - 1);
      aStop.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "]";
  }
}