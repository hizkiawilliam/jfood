/**
* Class Costumer is class that stores information for every customer object
*
* @author Hizkia William Eben
* @version 17.04.2020
*/
package hizkia.jfood;

import java.util.*;
import java.util.regex.*;
import java.text.*;
            
public class Customer
{
    private int id;
    private String name;
    private String email;
    private String password;
    private Calendar joinDate;

    /**
    * Constructor for objects of class Customer
    * @param id variable for identifying Customer
    * @param name variable to store name information of customer
    * @param email variable to store email information
    * @param password variable to store password
    * @param joinDate variable to store join date of customer
    */
    public Customer(int id, String name, String email, String password, Calendar joinDate)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = joinDate;
    }
    
    /**
    * Constructor for objects of class Customer with specific join date param
    * @param id variable for identifying Customer
    * @param name variable to store name information of customer
    * @param email variable to store email information
    * @param password variable to store password
    * @param year variable to store join year of customer
    * @param month variable to store join month of customer
    * @param dayOfMonth variable to store join day of customer
    */                
    public Customer(int id, String name, String email, String password, int year, int month, int dayOfMonth)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = new GregorianCalendar(year, month, dayOfMonth);
    }
    
    /**
    * Constructor for objects of class Customer without join date param
    * @param id variable for identifying Customer
    * @param name variable to store name information of customer
    * @param email variable to store email information
    * @param password variable to store password
    */ 
    public Customer(int id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = new GregorianCalendar();
        
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
    public Calendar getJoinDate()
    {
        return joinDate;
    }
                
    /**
    * Method as setter or mutator to set or change id of customer
    * @param id variable that stores information about id of the customer
    */
    public void setId(int id)
    {
        this.id = id;
    }
                
    /**
    * Method as setter or mutator to set or change name of customer
    * @param name variable that stores information about name of the customer
    */
    public void setName(String name)
    {
        this.name = name;
    }
                
    /**
    * Method as setter or mutator to set or change email of customer with regex checking
    * @param email variable that stores information about email of the customer
    */
    public void setEmail(String email)
    {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()==true)
        {
            this.email = email;
        }
        else
        {
            this.email = "";
        }   
    }
                
    /**
    * Method as setter or mutator to set or change password of customer with regex checking
    * @param password variable that stores information about name of the customer
    */
    public void setPassword(String password)
    {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()==true)
        {
            this.password = password;
        }
        else
        {
            this.password = "";
        }   
    }
            
    /**
    * Method as setter or mutator to set or change join date of customer
    * @param joinDate variable that stores information about join date of the customer
    */
    public void setJoinDate(Calendar joinDate)
    {
        this.joinDate = joinDate;
    }
            
    /**
    * Method as setter or mutator to set or change join date of customer with specific param
    * @param year variable that stores information about join year of the customer
    * @param month variable that stores information about join month of the customer
    * @param dayOfMonth variable that stores information about join date of the customer
    */
    public void setJoinDate(int year, int month, int dayOfMonth)
    {
       this.joinDate = new GregorianCalendar(year, month, dayOfMonth);
    }

    /**
     * Method to print data of the customer
     */
    public String toString()
    {  
       SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
       
       if (joinDate != null)
       {
           return  "========Customer========" +
                   "\nId = " + getId() + 
                   "\nNama = " + getName() +
                   "\nEmail = " + getEmail() + 
                   "\nPassword = " + getPassword() + 
                   "\nTanggal Join = " + sdf.format(getJoinDate().getTime())+"\n";
       }
       else
       {
           return  "\n========Customer========" +
                   "\nId = " + getId() + 
                   "\nNama = " + getName() + 
                   "\nEmail = " + getEmail() + 
                   "\nPassword = " + getPassword() + "\n";
       }
    }
}
