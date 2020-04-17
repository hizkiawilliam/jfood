/**
 * Class DatabaseCustomer contains all object of Customers stored in ArrayList Customer
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */
package hizkia.jfood;

import java.util.ArrayList;

public class DatabaseCustomer
{
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();
    private static int lastId = 0;

    /**
     * Constructor for objects of class DatabaseCustomer
     */
    public DatabaseCustomer()
    {
    }

    /**
     * Method to show all customer inside customer database
     * @return CUSTOMER_DATABASE array list that contain all customer information
     */
    public static ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
    }

    /**
     * Method to show last id of the object in the customer database
     * @return last id in database
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Method to show customer by id from the database
     * @param id variable that stores information id of customer
     * @return customer as object
     */
    public static Customer getCustomerById(int id) throws CustomerNotFoundException
    {
        for(Customer customer:CUSTOMER_DATABASE)
        {
            if (id == customer.getId())
            {
                return customer;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    /**
     * Method to add customer into the database
     * @param customer parameter that passes object customer
     * @return boolean that show the succession of the method
     */
    public static boolean addCustomer(Customer customer) throws EmailAlreadyExistsException
    {
        for(Customer customers:CUSTOMER_DATABASE)
        {
            if (customers.getEmail().equals(customer.getEmail()))
            {
                throw new EmailAlreadyExistsException(customer);
            }
        }
        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId();
        return true;
    }

    /**
     * Method to remove customer from database
     * @param id variable that stores id of customer
     * @return boolean that show the succession of the method
     */
    public static boolean removeCustomer(int id) throws CustomerNotFoundException
    {
        for(int i = 0;  i < CUSTOMER_DATABASE.size(); i++)
        {
            Customer customer = CUSTOMER_DATABASE.get(i);
            if (id == customer.getId())
            {
                CUSTOMER_DATABASE.remove(id);
                return true;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    /**
     * Method to remove customer from database
     * @param email variable that stores email of customer
     * @param password variable that stores password of customer
     * @return boolean that show the succession of the method
     */
    public static Customer getCustomerLogin(String email, String password)
    {
        for(Customer customer:CUSTOMER_DATABASE)
        {
            if (email.equals(customer.getEmail()) && password.equals(customer.getPassword()))
            {
                return customer;
            }
        }
        return null;
    }
}
