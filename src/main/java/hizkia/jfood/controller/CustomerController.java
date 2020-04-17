/**
 * This is class will handle METHODS related to customers
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */

package hizkia.jfood.controller;

import hizkia.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/customer")
@RestController

public class CustomerController {

    /**
     * Method to prints all customer in the data base
     * @return all customer in database
     */
    @RequestMapping("")
    public ArrayList<Customer> getAllCustomer()
    {
        return DatabaseCustomer.getCustomerDatabase();
    }

    /**
     * Method to get customer from id
     * @param id variable to store id of customer
     * @return single customer object
     */
    @RequestMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        Customer customer = null;
        try {
            customer = DatabaseCustomer.getCustomerById(id);
        } catch (CustomerNotFoundException e) {
            e.getMessage();
            return null;
        }
        return customer;
    }

    /**
     * Method to adds new customer into database
     * @param name variable that stores name of the customer
     * @param email variable that stores email of the customer
     * @param password variable that stores password of the customer
     * @return object customer that was added to database
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Customer registerCustomer(@RequestParam(value="name") String name,
                                @RequestParam(value="email") String email,
                                @RequestParam(value="password") String password)
    {
        Customer customer = new Customer(DatabaseCustomer.getLastId()+1, name, email, password);
        try {
            DatabaseCustomer.addCustomer(customer);
        } catch (EmailAlreadyExistsException e) {
            e.getMessage();
            return null;
        }
        return customer;
    }

    /**
     * Method to log into the application
     * @param name variable that stores name of the customer
     * @param email variable that stores email of the customer
     * @param password variable that stores password of the customer
     * @return object customer that was logged in
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Customer loginCustomer(@RequestParam(value="name") String name,
                                  @RequestParam(value="email") String email,
                                  @RequestParam(value="password") String password)
    {
        return DatabaseCustomer.getCustomerLogin(email, password);
    }
}
