/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4262.30c9ffc7c modeling language!*/

package ca.mcgill.ecse321.carpoolapp.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Access;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

// line 33 "../../../../../../../ump/tmp788046/model.ump"
// line 102 "../../../../../../../ump/tmp788046/model.ump"
@Entity
@Table(name="admin")
@Access(AccessType.FIELD)
public class Admin extends UserRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id")
  private int id;
  private String name;
  private int carpool_manager_id;
  private int[] ads_id;
	
  //Admin Associations
  
  //@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
  @Transient
  private List<Ad> ads;
  @Transient
  private CarPoolManager carPoolManager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Admin(User aUser, CarPoolManager aCarPoolManager)
  {
    super(aUser);
    ads = new ArrayList<Ad>();
    boolean didAddCarPoolManager = setCarPoolManager(aCarPoolManager);
    this.id = aUser.getId();
    this.name = aUser.getName();
    if (!didAddCarPoolManager)
    {
      throw new RuntimeException("Unable to create admin due to carPoolManager");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  @Transient
  public Ad getAd(int index)
  {
    Ad aAd = ads.get(index);
    return aAd;
  }

  @Transient
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
  @Transient
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
  
  //----------------
  //Methods for data base
  //Added by Roger Zhang
  //----------------
  
  
  public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
  


  @Column(name="carpool_manager_id")
  public int getCarpoolManagerId() {
	  carpool_manager_id = this.getCarPoolManager().getId();
	  return carpool_manager_id;
  }
  
  
  @Column(name="ads_id")
  public int[] getAdIds() {
	  int nbOfAds = this.ads.size();
	  ads_id = new int[nbOfAds];
	  
	  for(int i = 0; i < nbOfAds; i++) {
		  ads_id[i] = this.ads.get(i).getId();
	  }
	  
	  return ads_id;
  }

}