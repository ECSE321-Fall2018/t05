/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4262.30c9ffc7c modeling language!*/

package ca.mcgill.ecse321.carpoolapp.model;
import java.util.*;

// line 4 "../../../../../../../ump/tmp788046/model.ump"
// line 79 "../../../../../../../ump/tmp788046/model.ump"
public class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private int id;
  private String name;

  //User Associations
  private List<UserRole> userRoles;
  private CarPoolManager CarPoolManager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(int aId, String aName, CarPoolManager aCarPoolManager)
  {
    id = aId;
    name = aName;
    userRoles = new ArrayList<UserRole>();
    boolean didAddCarPoolManager = setCarPoolManager(aCarPoolManager);
    if (!didAddCarPoolManager)
    {
      throw new RuntimeException("Unable to create user due to CarPoolManager");
    }
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

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template association_GetMany */
  public UserRole getUserRole(int index)
  {
    UserRole aUserRole = userRoles.get(index);
    return aUserRole;
  }

  public List<UserRole> getUserRoles()
  {
    List<UserRole> newUserRoles = Collections.unmodifiableList(userRoles);
    return newUserRoles;
  }

  public int numberOfUserRoles()
  {
    int number = userRoles.size();
    return number;
  }

  public boolean hasUserRoles()
  {
    boolean has = userRoles.size() > 0;
    return has;
  }

  public int indexOfUserRole(UserRole aUserRole)
  {
    int index = userRoles.indexOf(aUserRole);
    return index;
  }
  /* Code from template association_GetOne */
  public CarPoolManager getCarPoolManager()
  {
    return CarPoolManager;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUserRoles()
  {
    return 0;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfUserRoles()
  {
    return 3;
  }
  /* Code from template association_AddOptionalNToOne */


  public boolean addUserRole(UserRole aUserRole)
  {
    boolean wasAdded = false;
    if (userRoles.contains(aUserRole)) { return false; }
    if (numberOfUserRoles() >= maximumNumberOfUserRoles())
    {
      return wasAdded;
    }

    User existingUser = aUserRole.getUser();
    boolean isNewUser = existingUser != null && !this.equals(existingUser);
    if (isNewUser)
    {
      aUserRole.setUser(this);
    }
    else
    {
      userRoles.add(aUserRole);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUserRole(UserRole aUserRole)
  {
    boolean wasRemoved = false;
    //Unable to remove aUserRole, as it must always have a user
    if (!this.equals(aUserRole.getUser()))
    {
      userRoles.remove(aUserRole);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserRoleAt(UserRole aUserRole, int index)
  {  
    boolean wasAdded = false;
    if(addUserRole(aUserRole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUserRoles()) { index = numberOfUserRoles() - 1; }
      userRoles.remove(aUserRole);
      userRoles.add(index, aUserRole);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserRoleAt(UserRole aUserRole, int index)
  {
    boolean wasAdded = false;
    if(userRoles.contains(aUserRole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUserRoles()) { index = numberOfUserRoles() - 1; }
      userRoles.remove(aUserRole);
      userRoles.add(index, aUserRole);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserRoleAt(aUserRole, index);
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

    CarPoolManager existingCarPoolManager = CarPoolManager;
    CarPoolManager = aCarPoolManager;
    if (existingCarPoolManager != null && !existingCarPoolManager.equals(aCarPoolManager))
    {
      existingCarPoolManager.removeUser(this);
    }
    CarPoolManager.addUser(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=userRoles.size(); i > 0; i--)
    {
      UserRole aUserRole = userRoles.get(i - 1);
      aUserRole.delete();
    }
    CarPoolManager placeholderCarPoolManager = CarPoolManager;
    this.CarPoolManager = null;
    if(placeholderCarPoolManager != null)
    {
      placeholderCarPoolManager.removeUser(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "CarPoolManager = "+(getCarPoolManager()!=null?Integer.toHexString(System.identityHashCode(getCarPoolManager())):"null");
  }
}