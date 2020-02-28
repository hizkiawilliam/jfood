/**
 * Write a description of class Customer here.
 *
 * @author Hizkia William Eben
 * @version 27.02.2020
 */
public class Customer
{
    private int id;
    private String name;
    private String email;
    private String password;
    private String joinDate;
   

    /**
     * Constructor for objects of class Customer
     * @param id variable for identifying Customer
     * @param name variable to store name information of customer
     * @param email variable to store email information
     * @param password variable to store password
     * @param joinDate variable to store join date of customer
     */
    public Customer(int id, String name, String email, String password, String joinDate)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }
    
    /**
     * Method as accessor to get id of the costumer
     * @return id variable that stores id of customer
     */
    public int getId()
    {
        return id;
    }
    
    /**
    * Method as accessor to get name of the customer
    * @return name variable that stores name of customer
    */
    public String getName()
    {
        return name;
    }

    /**
    * Method as accessor to get email of the customer
    * @return email variable that stores email of customer
    */
    public String getEmail()
    {
        return email;
    }

    /**
    * Method as accessor to get password of the customer
    * @return password variable that stores password of the customer
    */
    public String getPassword()
    {
        return password;
    }
    
    /**
    * Method as accessor to get the join date of the customer
    * @return joinDate variable that stores information of join date of the customer
    */
    public String getJoinDate()
    {
        return joinDate;
    }
    
    /**
    * Method as setter or mutator to set or change id of customer
    */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
    * Method as setter or mutator to set or change name of customer
    */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
    * Method as setter or mutator to set or change name of customer
    */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
    * Method as setter or mutator to set or change password of customer
    */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    /**
    * Method as setter or mutator to set or change join date of customer
    */
    public void setJoinDate(String joinDate)
    {
        this.joinDate = joinDate;
    }
    
    /**
    * Method to print name of the customer
    */    
    public void printData()
    {
        System.out.println(name);
    }
}
