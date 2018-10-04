/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4262.30c9ffc7c modeling language!*/

package ca.mcgill.ecse321.carpoolapp.model;
import java.sql.Time;
import java.sql.Date;

// line 78 "../../../../../../../../ump/tmp588129/model.ump"
// line 130 "../../../../../../../../ump/tmp588129/model.ump"
public class Adress
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Adress Attributes
  private String street;
  private String city;
  private String provincel;
  private String postalCode;
  private int x;
  private int y;

  //Adress Associations
  private CarpoolManager carpoolManager;
  private Stop stop;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Adress(String aStreet, String aCity, String aProvincel, String aPostalCode, int aX, int aY, CarpoolManager aCarpoolManager, Stop aStop)
  {
    street = aStreet;
    city = aCity;
    provincel = aProvincel;
    postalCode = aPostalCode;
    x = aX;
    y = aY;
    boolean didAddCarpoolManager = setCarpoolManager(aCarpoolManager);
    if (!didAddCarpoolManager)
    {
      throw new RuntimeException("Unable to create adress due to carpoolManager");
    }
    if (aStop == null || aStop.getAdress() != null)
    {
      throw new RuntimeException("Unable to create Adress due to aStop");
    }
    stop = aStop;
  }

  public Adress(String aStreet, String aCity, String aProvincel, String aPostalCode, int aX, int aY, CarpoolManager aCarpoolManager, Time aTimeForStop, Date aDateForStop, int aNbOfAvailableSeatForStop, Ad aAdForStop)
  {
    street = aStreet;
    city = aCity;
    provincel = aProvincel;
    postalCode = aPostalCode;
    x = aX;
    y = aY;
    boolean didAddCarpoolManager = setCarpoolManager(aCarpoolManager);
    if (!didAddCarpoolManager)
    {
      throw new RuntimeException("Unable to create adress due to carpoolManager");
    }
    stop = new Stop(aTimeForStop, aDateForStop, aNbOfAvailableSeatForStop, this, aAdForStop);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStreet(String aStreet)
  {
    boolean wasSet = false;
    street = aStreet;
    wasSet = true;
    return wasSet;
  }

  public boolean setCity(String aCity)
  {
    boolean wasSet = false;
    city = aCity;
    wasSet = true;
    return wasSet;
  }

  public boolean setProvincel(String aProvincel)
  {
    boolean wasSet = false;
    provincel = aProvincel;
    wasSet = true;
    return wasSet;
  }

  public boolean setPostalCode(String aPostalCode)
  {
    boolean wasSet = false;
    postalCode = aPostalCode;
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

  public String getStreet()
  {
    return street;
  }

  public String getCity()
  {
    return city;
  }

  public String getProvincel()
  {
    return provincel;
  }

  public String getPostalCode()
  {
    return postalCode;
  }

  public int getX()
  {
    return x;
  }

  public int getY()
  {
    return y;
  }
  /* Code from template association_GetOne */
  public CarpoolManager getCarpoolManager()
  {
    return carpoolManager;
  }
  /* Code from template association_GetOne */
  public Stop getStop()
  {
    return stop;
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
      existingCarpoolManager.removeAdress(this);
    }
    carpoolManager.addAdress(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    CarpoolManager placeholderCarpoolManager = carpoolManager;
    this.carpoolManager = null;
    if(placeholderCarpoolManager != null)
    {
      placeholderCarpoolManager.removeAdress(this);
    }
    Stop existingStop = stop;
    stop = null;
    if (existingStop != null)
    {
      existingStop.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "street" + ":" + getStreet()+ "," +
            "city" + ":" + getCity()+ "," +
            "provincel" + ":" + getProvincel()+ "," +
            "postalCode" + ":" + getPostalCode()+ "," +
            "x" + ":" + getX()+ "," +
            "y" + ":" + getY()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "carpoolManager = "+(getCarpoolManager()!=null?Integer.toHexString(System.identityHashCode(getCarpoolManager())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "stop = "+(getStop()!=null?Integer.toHexString(System.identityHashCode(getStop())):"null");
  }
}