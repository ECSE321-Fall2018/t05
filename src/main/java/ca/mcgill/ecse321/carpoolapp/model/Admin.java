/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4262.30c9ffc7c modeling language!*/

package ca.mcgill.ecse321.carpoolapp.model;
import java.util.*;

// line 33 "../../../../../../../ump/tmp788046/model.ump"
// line 102 "../../../../../../../ump/tmp788046/model.ump"
public class Admin extends UserRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Admin Associations
  private List<Ad> ads;
  private CarPoolManager carPoolManager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Admin(User aUser, CarPoolManager aCarPoolManager)
  {
    super(aUser);
    ads = new ArrayList<Ad>();
    boolean didAddCarPoolManager = setCarPoolManager(aCarPoolManager);
    if (!didAddCarPoolManager)
    {
      throw new RuntimeException("Unable to create admin due to carPoolManager");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
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
  public CarPoolManager getCarPoolManager()
  {
    return carPoolManager;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAds()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addAd(Ad aAd)
  {
    boolean wasAdded = false;
    if (ads.contains(aAd)) { return false; }
    ads.add(aAd);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAd(Ad aAd)
  {
    boolean wasRemoved = false;
    if (ads.contains(aAd))
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
      existingCarPoolManager.removeAdmin(this);
    }
    carPoolManager.addAdmin(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ads.clear();
    CarPoolManager placeholderCarPoolManager = carPoolManager;
    this.carPoolManager = null;
    if(placeholderCarPoolManager != null)
    {
      placeholderCarPoolManager.removeAdmin(this);
    }
    super.delete();
  }

}