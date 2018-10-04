/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4262.30c9ffc7c modeling language!*/

package ca.mcgill.ecse321.carpoolapp.model;
import java.util.*;

// line 38 "../../../../../../../../ump/tmp588129/model.ump"
// line 105 "../../../../../../../../ump/tmp588129/model.ump"
public class Passenger extends UserRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Passenger Attributes
  private int averagePaidPerKm;
  private int totalDistance;

  //Passenger Associations
  private List<Ad> ads;
  private CarpoolManager carpoolManager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Passenger(User aUser, int aAveragePaidPerKm, int aTotalDistance, CarpoolManager aCarpoolManager)
  {
    super(aUser);
    averagePaidPerKm = aAveragePaidPerKm;
    totalDistance = aTotalDistance;
    ads = new ArrayList<Ad>();
    boolean didAddCarpoolManager = setCarpoolManager(aCarpoolManager);
    if (!didAddCarpoolManager)
    {
      throw new RuntimeException("Unable to create passenger due to carpoolManager");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAveragePaidPerKm(int aAveragePaidPerKm)
  {
    boolean wasSet = false;
    averagePaidPerKm = aAveragePaidPerKm;
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

  public int getAveragePaidPerKm()
  {
    return averagePaidPerKm;
  }

  public int getTotalDistance()
  {
    return totalDistance;
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
  public static int minimumNumberOfAds()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addAd(Ad aAd)
  {
    boolean wasAdded = false;
    if (ads.contains(aAd)) { return false; }
    ads.add(aAd);
    if (aAd.indexOfPassenger(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAd.addPassenger(this);
      if (!wasAdded)
      {
        ads.remove(aAd);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeAd(Ad aAd)
  {
    boolean wasRemoved = false;
    if (!ads.contains(aAd))
    {
      return wasRemoved;
    }

    int oldIndex = ads.indexOf(aAd);
    ads.remove(oldIndex);
    if (aAd.indexOfPassenger(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAd.removePassenger(this);
      if (!wasRemoved)
      {
        ads.add(oldIndex,aAd);
      }
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
      existingCarpoolManager.removePassenger(this);
    }
    carpoolManager.addPassenger(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Ad> copyOfAds = new ArrayList<Ad>(ads);
    ads.clear();
    for(Ad aAd : copyOfAds)
    {
      aAd.removePassenger(this);
    }
    CarpoolManager placeholderCarpoolManager = carpoolManager;
    this.carpoolManager = null;
    if(placeholderCarpoolManager != null)
    {
      placeholderCarpoolManager.removePassenger(this);
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "averagePaidPerKm" + ":" + getAveragePaidPerKm()+ "," +
            "totalDistance" + ":" + getTotalDistance()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "carpoolManager = "+(getCarpoolManager()!=null?Integer.toHexString(System.identityHashCode(getCarpoolManager())):"null");
  }
}