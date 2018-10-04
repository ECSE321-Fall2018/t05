/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4262.30c9ffc7c modeling language!*/

package ca.mcgill.ecse321.carpoolapp.model;
import java.util.*;

// line 46 "../../../../../../../../ump/tmp588129/model.ump"
// line 110 "../../../../../../../../ump/tmp588129/model.ump"
public class Admin extends UserRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Admin Associations
  private List<Ad> ads;
  private CarpoolManager carpoolManager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Admin(User aUser, CarpoolManager aCarpoolManager)
  {
    super(aUser);
    ads = new ArrayList<Ad>();
    boolean didAddCarpoolManager = setCarpoolManager(aCarpoolManager);
    if (!didAddCarpoolManager)
    {
      throw new RuntimeException("Unable to create admin due to carpoolManager");
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
  public CarpoolManager getCarpoolManager()
  {
    return carpoolManager;
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
      existingCarpoolManager.removeAdmin(this);
    }
    carpoolManager.addAdmin(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ads.clear();
    CarpoolManager placeholderCarpoolManager = carpoolManager;
    this.carpoolManager = null;
    if(placeholderCarpoolManager != null)
    {
      placeholderCarpoolManager.removeAdmin(this);
    }
    super.delete();
  }

}