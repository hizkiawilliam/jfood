/**
 * Class Location is class that stores information for every location object
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */
package hizkia.jfood;

public class Location
{
    private int id;
    private String province;
    private String description;
    private String city;

    /**
     * Constructor for objects of class Location
     * @param city variable to store name of city for object location
     * @param province variable to store name province
     * @param description variable that stores information about description of location
     */
    public Location(int id, String city, String province, String description)
    {
        this.id = id;
        this.city = city;
        this.province = province;
        this.description = description;
    }

    /**
     * Method as accessor to get id information
     * @return provice variable
     */
    public int getId()
    {
        return id;
    }

    /**
     * Method as accessor to get province information
     * @return provice variable
     */
    public String getProvince()
    {
        return province;
    }
    
    /**
     * Method as accessor to get city name
     * @return city variable
     */
    public String getCity()
    {
        return city;
    }
    
    /**
     * Method as accessor to get description for object location
     * @return description variable
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Method as setter to set id
     * @param id passing parameter that stores information of province
     */
    public void setProvince(int id)
    {
        this.id = id;
    }

    /**
     * Method as setter to set province
     * @param province passing parameter that stores information of province
     */
    public void setProvince(String province)
    {
        this.province = province;
    }
    
    /**
     * Method as setter to set city name
     * @param city passing parameter that stores information of city
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    
    /**
     * Method as setter to set description
     * @param description passing parameter that stores description information
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
     * Method to return all variables Location as String
     */
    public String toString()
    {
         return "Province = " + getProvince() + 
                "City = " + getCity() + 
                "Description = " + getDescription();
    }
}
