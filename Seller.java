/**
 * Write a description of class Seller here.
 *
 * @author Hizkia William Eben
 * @version 05.03.2020
 */
public class Seller
{

    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;

    /**
     * Constructor for objects of class Customer
     * @param id variable for identifying seller
     * @param name variable to store name of seller
     * @param email variable to store email information about seller's email
     * @param phoneNumber variable to store information about phone number of seller
     * @param location variable to store information about location as object
     */
    public Seller(int id, String name, String email, String phoneNumber, Location location)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }
    
    /**
    * Method as accessor to get id
    * @return id
    */
    public int getId()
    {
        return id;
    }
    
    /**
    * Method as accessor to get name
    * @return name
    */
    public String getName()
    {
        return name;
    }
    
    /**
    * Method as accessor to get email
    * @return email
    */
    public String getEmail()
    {
        return email;
    }
    
    /**
    * Method as accessor to get phone number
    * @return phoneNumber
    */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    /**
    * Method as accessor to get location
    * @return location
    */
    public Location getLocation()
    {
        return location;
    }
    
    /**
    * Method as setter to set id
    */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
    * Method as setter to set name
    */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
    * Method as setter to set email
    */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
    * Method as setter to set phone number
    */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    /**
    * Method as accessor to set location
    * @return location
    */
    public void setLocation(Location location)
    {
        this.location = location;
    }
    
    /**
    * Method as to print data, specificaly for seller name
    */
    public void printData()
    {
        System.out.println(name);
    }
}
