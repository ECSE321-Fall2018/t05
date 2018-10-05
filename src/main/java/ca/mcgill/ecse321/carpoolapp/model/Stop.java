/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4262.30c9ffc7c modeling language!*/

package ca.mcgill.ecse321.carpoolapp.model;
import java.sql.Time;
import java.sql.Date;

// line 69 "../../../../../../../../ump/tmp588129/model.ump"
// line 125 "../../../../../../../../ump/tmp588129/model.ump"
public class Stop
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Stop Attributes
  private Time time;
  private Date date;
  private int nbOfAvailableSeat;

  //Stop Associations
  private Adress adress;
  private Ad ad;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Stop(Time aTime, Date aDate, int aNbOfAvailableSeat, Adress aAdress, Ad aAd)
  {
    time = aTime;
    date = aDate;
    nbOfAvailableSeat = aNbOfAvailableSeat;
    if (aAdress == null || aAdress.getStop() != null)
    {
      throw new RuntimeException("Unable to create Stop due to aAdress");
    }
    adress = aAdress;
    boolean didAddAd = setAd(aAd);
    if (!didAddAd)
    {
      throw new RuntimeException("Unable to create stop due to ad");
    }
  }

  public Stop(Time aTime, Date aDate, int aNbOfAvailableSeat, String aStreetForAdress, String aCityForAdress, String aProvincelForAdress, String aPostalCodeForAdress, int aXForAdress, int aYForAdress, CarpoolManager aCarpoolManagerForAdress, Ad aAd)
  {
    time = aTime;
    date = aDate;
    nbOfAvailableSeat = aNbOfAvailableSeat;
    adress = new Adress(aStreetForAdress, aCityForAdress, aProvincelForAdress, aPostalCodeForAdress, aXForAdress, aYForAdress, aCarpoolManagerForAdress, this);
    boolean didAddAd = setAd(aAd);
    if (!didAddAd)
    {
      throw new RuntimeException("Unable to create stop due to ad");
    }
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
  /* Code from template association_GetOne */
  public Adress getAdress()
  {
    return adress;
  }
  /* Code from template association_GetOne */
  public Ad getAd()
  {
    return ad;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setAd(Ad aAd)
  {
    boolean wasSet = false;
    //Must provide ad to stop
    if (aAd == null)
    {
      return wasSet;
    }

    if (ad != null && ad.getNumberOfStops() <= Ad.minimumNumberOfStops())
    {
      return wasSet;
    }

    Ad existingAd = ad;
    ad = aAd;
    if (existingAd != null && !existingAd.equals(aAd))
    {
      boolean didRemove = existingAd.removeStop(this);
      if (!didRemove)
      {
        ad = existingAd;
        return wasSet;
      }
    }
    ad.addStop(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Adress existingAdress = adress;
    adress = null;
    if (existingAdress != null)
    {
      existingAdress.delete();
    }
    Ad placeholderAd = ad;
    this.ad = null;
    if(placeholderAd != null)
    {
      placeholderAd.removeStop(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "nbOfAvailableSeat" + ":" + getNbOfAvailableSeat()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "time" + "=" + (getTime() != null ? !getTime().equals(this)  ? getTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "adress = "+(getAdress()!=null?Integer.toHexString(System.identityHashCode(getAdress())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "ad = "+(getAd()!=null?Integer.toHexString(System.identityHashCode(getAd())):"null");
  }  

}