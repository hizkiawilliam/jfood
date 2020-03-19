/**
 * Write a description of class Location here.
 *
 * @author Hizkia William Eben
 * @version 12.03.2020
 */
public class Location
{
    private String province;
    private String description;
    private String city;

    /**
     * Constructor for objects of class Location
     * @param city variable to store name of city for object location
     * @param province variable to store name province
     * @param description variabel that stores information about description of location 
     */
    public Location(String city, String province, String description)
    {
        this.city = city;
        this.province = province;
        this.description = description;
    }
    
    /**
    * Method as accessor to get province information
    * @return information
    */
    public String getProvince()
    {
        return province;
    }
    
    /**
    * Method as accessor to get city name
    * @return city
    */
    public String getCity()
    {
        return city;
    }
    
    /**
    * Method as accessor to get description for object location
    * @return description
    */
    public String getDescription()
    {
        return description;
    }
    
    /**
    * Method as setter to set province
    */
    public void setProvince(String province)
    {
        this.province = province;
    }
    
    /**
    * Method as setter to set city name
    */
    public void setCity(String city)
    {
        this.city = city;
    }
    
    /**
    * Method as setter to set description
    */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
    * Method to set all variables Location to String
    */    
    public String toString()
    {
         return "Province = " + getProvince() + "City = " + getCity() + "Description = " + getDescription();
    }
}
