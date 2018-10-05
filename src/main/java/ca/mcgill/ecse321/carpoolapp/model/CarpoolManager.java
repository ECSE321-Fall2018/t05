/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4262.30c9ffc7c modeling language!*/

package ca.mcgill.ecse321.carpoolapp.model;
import java.util.*;

// line 5 "../../../../../../../../ump/tmp588129/model.ump"
// line 135 "../../../../../../../../ump/tmp588129/model.ump"
public class CarpoolManager
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CarpoolManager Attributes
  private int id;

  //CarpoolManager Associations
  private List<User> users;
  private List<Driver> drivers;
  private List<Passenger> passengers;
  private List<Admin> admins;
  private List<Vehicle> vehicles;
  private List<Ad> ads;
  private List<Adress> adresses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CarpoolManager(int aId)
  {
    id = aId;
    users = new ArrayList<User>();
    drivers = new ArrayList<Driver>();
    passengers = new ArrayList<Passenger>();
    admins = new ArrayList<Admin>();
    vehicles = new ArrayList<Vehicle>();
    ads = new ArrayList<Ad>();
    adresses = new ArrayList<Adress>();
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
  /* Code from template association_GetMany */
  public Adress getAdress(int index)
  {
    Adress aAdress = adresses.get(index);
    return aAdress;
  }

  public List<Adress> getAdresses()
  {
    List<Adress> newAdresses = Collections.unmodifiableList(adresses);
    return newAdresses;
  }

  public int numberOfAdresses()
  {
    int number = adresses.size();
    return number;
  }

  public boolean hasAdresses()
  {
    boolean has = adresses.size() > 0;
    return has;
  }

  public int indexOfAdress(Adress aAdress)
  {
    int index = adresses.indexOf(aAdress);
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
    CarpoolManager existingCarpoolManager = aUser.getCarpoolManager();
    boolean isNewCarpoolManager = existingCarpoolManager != null && !this.equals(existingCarpoolManager);
    if (isNewCarpoolManager)
    {
      aUser.setCarpoolManager(this);
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
    //Unable to remove aUser, as it must always have a carpoolManager
    if (!this.equals(aUser.getCarpoolManager()))
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
    CarpoolManager existingCarpoolManager = aDriver.getCarpoolManager();
    boolean isNewCarpoolManager = existingCarpoolManager != null && !this.equals(existingCarpoolManager);
    if (isNewCarpoolManager)
    {
      aDriver.setCarpoolManager(this);
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
    //Unable to remove aDriver, as it must always have a carpoolManager
    if (!this.equals(aDriver.getCarpoolManager()))
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
    CarpoolManager existingCarpoolManager = aPassenger.getCarpoolManager();
    boolean isNewCarpoolManager = existingCarpoolManager != null && !this.equals(existingCarpoolManager);
    if (isNewCarpoolManager)
    {
      aPassenger.setCarpoolManager(this);
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
    //Unable to remove aPassenger, as it must always have a carpoolManager
    if (!this.equals(aPassenger.getCarpoolManager()))
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
    CarpoolManager existingCarpoolManager = aAdmin.getCarpoolManager();
    boolean isNewCarpoolManager = existingCarpoolManager != null && !this.equals(existingCarpoolManager);
    if (isNewCarpoolManager)
    {
      aAdmin.setCarpoolManager(this);
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
    //Unable to remove aAdmin, as it must always have a carpoolManager
    if (!this.equals(aAdmin.getCarpoolManager()))
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
  public static int minimumNumberOfVehicles()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Vehicle addVehicle(int aYear, String aBrand, int aPlateNumber, int aAvailableSeat, Driver... allDrivers)
  {
    return new Vehicle(aYear, aBrand, aPlateNumber, aAvailableSeat, this, allDrivers);
  }

  public boolean addVehicle(Vehicle aVehicle)
  {
    boolean wasAdded = false;
    if (vehicles.contains(aVehicle)) { return false; }
    CarpoolManager existingCarpoolManager = aVehicle.getCarpoolManager();
    boolean isNewCarpoolManager = existingCarpoolManager != null && !this.equals(existingCarpoolManager);
    if (isNewCarpoolManager)
    {
      aVehicle.setCarpoolManager(this);
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
    //Unable to remove aVehicle, as it must always have a carpoolManager
    if (!this.equals(aVehicle.getCarpoolManager()))
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
  public static int minimumNumberOfAds()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Ad addAd(int aId, boolean aIsActive, boolean aIsCompleted, Driver aDriver, Vehicle aVehicle, double price)
  {
    return new Ad(aId, aIsActive, aIsCompleted, this, aDriver, aVehicle, price);
  }

  public boolean addAd(Ad aAd)
  {
    boolean wasAdded = false;
    if (ads.contains(aAd)) { return false; }
    CarpoolManager existingCarpoolManager = aAd.getCarpoolManager();
    boolean isNewCarpoolManager = existingCarpoolManager != null && !this.equals(existingCarpoolManager);
    if (isNewCarpoolManager)
    {
      aAd.setCarpoolManager(this);
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
    //Unable to remove aAd, as it must always have a carpoolManager
    if (!this.equals(aAd.getCarpoolManager()))
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
  public static int minimumNumberOfAdresses()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Adress addAdress(String aStreet, String aCity, String aProvincel, String aPostalCode, int aX, int aY, Stop aStop)
  {
    return new Adress(aStreet, aCity, aProvincel, aPostalCode, aX, aY, this, aStop);
  }

  public boolean addAdress(Adress aAdress)
  {
    boolean wasAdded = false;
    if (adresses.contains(aAdress)) { return false; }
    CarpoolManager existingCarpoolManager = aAdress.getCarpoolManager();
    boolean isNewCarpoolManager = existingCarpoolManager != null && !this.equals(existingCarpoolManager);
    if (isNewCarpoolManager)
    {
      aAdress.setCarpoolManager(this);
    }
    else
    {
      adresses.add(aAdress);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAdress(Adress aAdress)
  {
    boolean wasRemoved = false;
    //Unable to remove aAdress, as it must always have a carpoolManager
    if (!this.equals(aAdress.getCarpoolManager()))
    {
      adresses.remove(aAdress);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAdressAt(Adress aAdress, int index)
  {  
    boolean wasAdded = false;
    if(addAdress(aAdress))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAdresses()) { index = numberOfAdresses() - 1; }
      adresses.remove(aAdress);
      adresses.add(index, aAdress);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAdressAt(Adress aAdress, int index)
  {
    boolean wasAdded = false;
    if(adresses.contains(aAdress))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAdresses()) { index = numberOfAdresses() - 1; }
      adresses.remove(aAdress);
      adresses.add(index, aAdress);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAdressAt(aAdress, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (users.size() > 0)
    {
      User aUser = users.get(users.size() - 1);
      aUser.delete();
      users.remove(aUser);
    }
    
    while (drivers.size() > 0)
    {
      Driver aDriver = drivers.get(drivers.size() - 1);
      aDriver.delete();
      drivers.remove(aDriver);
    }
    
    while (passengers.size() > 0)
    {
      Passenger aPassenger = passengers.get(passengers.size() - 1);
      aPassenger.delete();
      passengers.remove(aPassenger);
    }
    
    while (admins.size() > 0)
    {
      Admin aAdmin = admins.get(admins.size() - 1);
      aAdmin.delete();
      admins.remove(aAdmin);
    }
    
    while (vehicles.size() > 0)
    {
      Vehicle aVehicle = vehicles.get(vehicles.size() - 1);
      aVehicle.delete();
      vehicles.remove(aVehicle);
    }
    
    while (ads.size() > 0)
    {
      Ad aAd = ads.get(ads.size() - 1);
      aAd.delete();
      ads.remove(aAd);
    }
    
    while (adresses.size() > 0)
    {
      Adress aAdress = adresses.get(adresses.size() - 1);
      aAdress.delete();
      adresses.remove(aAdress);
    }
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "]";
  }
}