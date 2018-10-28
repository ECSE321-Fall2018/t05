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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// line 57 "../../../../../../../../ump/18102077559/model.ump"
// line 126 "../../../../../../../../ump/18102077559/model.ump"
@Entity
@Table(name="stop")
public class Stop
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Stop Attributes
  private Time time;
  private Date date;
  private int nbOfAvailableSeat;
  private int x;
  private int y;
  private int id;

  //Stop Associations
  private List<Passenger> passengers;
  private Ad ad;
  private CarPoolManager carPoolManager;
  
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

  //------------------------
  // CONSTRUCTOR
  //------------------------



public Stop(Time aTime, Date aDate, int aNbOfAvailableSeat, int aX, int aY, int aId, Ad aAd, CarPoolManager aCarPoolManager)
  {
    time = aTime;
    date = aDate;
    nbOfAvailableSeat = aNbOfAvailableSeat;
    x = aX;
    y = aY;
    id = aId;
    passengers = new ArrayList<Passenger>();
    boolean didAddAd = setAd(aAd);
    if (!didAddAd)
    {
      throw new RuntimeException("Unable to create stop due to ad");
    }
    boolean didAddCarPoolManager = setCarPoolManager(aCarPoolManager);
    if (!didAddCarPoolManager)
    {
      throw new RuntimeException("Unable to create stop due to carPoolManager");
    }
  }

public Stop()
{
  
}

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTime(Time aTime)
  {
    boolean wasSet = false;
    time = aTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setNbOfAvailableSeat(int aNbOfAvailableSeat)
  {
    boolean wasSet = false;
    nbOfAvailableSeat = aNbOfAvailableSeat;
    wasSet = true;
    return wasSet;
  }

  public boolean setX(int aX)
  {
    boolean wasSet = false;
    x = aX;
    wasSet = true;
    return wasSet;
  }

  public boolean setY(int aY)
  {
    boolean wasSet = false;
    y = aY;
    wasSet = true;
    return wasSet;
  }

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public Time getTime()
  {
    return time;
  }

  public Date getDate()
  {
    return date;
  }

  public int getNbOfAvailableSeat()
  {
    return nbOfAvailableSeat;
  }

  public int getX()
  {
    return x;
  }

  public int getY()
  {
    return y;
  }
  @Id
  public int getId()
  {
    return id;
  }
  /* Code from template association_GetMany */
  public Passenger getPassenger(int index)
  {
    Passenger aPassenger = passengers.get(index);
    return aPassenger;
  }
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name="stop_passenger", joinColumns=@JoinColumn(name="id"), inverseJoinColumns=
  @JoinColumn(name="passenger_id"))
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
  @ManyToOne
  @JoinTable(name = "stop_ad")
  public Ad getAd()
  {
    return ad;
  }
  /* Code from template association_GetOne */
  @ManyToOne
  @JoinTable(name = "ad_carpoolManager")
  public CarPoolManager getCarPoolManager()
  {
    return carPoolManager;
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
    if (aPassenger.indexOfStop(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPassenger.addStop(this);
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
    if (aPassenger.indexOfStop(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPassenger.removeStop(this);
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
  /* Code from template association_SetOneToMany */
  public boolean setAd(Ad aAd)
  {
    boolean wasSet = false;
    if (aAd == null)
    {
      return wasSet;
    }

    Ad existingAd = ad;
    ad = aAd;
    if (existingAd != null && !existingAd.equals(aAd))
    {
      existingAd.removeStop(this);
    }
    ad.addStop(this);
    wasSet = true;
    return wasSet;
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
      existingCarPoolManager.removeStop(this);
    }
    carPoolManager.addStop(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Passenger> copyOfPassengers = new ArrayList<Passenger>(passengers);
    passengers.clear();
    for(Passenger aPassenger : copyOfPassengers)
    {
      aPassenger.removeStop(this);
    }
    Ad placeholderAd = ad;
    this.ad = null;
    if(placeholderAd != null)
    {
      placeholderAd.removeStop(this);
    }
    CarPoolManager placeholderCarPoolManager = carPoolManager;
    this.carPoolManager = null;
    if(placeholderCarPoolManager != null)
    {
      placeholderCarPoolManager.removeStop(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "nbOfAvailableSeat" + ":" + getNbOfAvailableSeat()+ "," +
            "x" + ":" + getX()+ "," +
            "y" + ":" + getY()+ "," +
            "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "time" + "=" + (getTime() != null ? !getTime().equals(this)  ? getTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "ad = "+(getAd()!=null?Integer.toHexString(System.identityHashCode(getAd())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "carPoolManager = "+(getCarPoolManager()!=null?Integer.toHexString(System.identityHashCode(getCarPoolManager())):"null");
  }
}