/**
 * This is class will handle METHODS related to customers
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */

package hizkia.jfood.controller;

import hizkia.jfood.*;
import hizkia.jfood.database.DatabaseCustomer;
import hizkia.jfood.database.DatabaseCustomerPostgres;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequestMapping("/customer")
@CrossOrigin(origins = "*", allowedHeaders = "")
@RestController

public class CustomerController {

    /**
     * Method to prints all customer in the data base (unused)
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
        Customer customer = DatabaseCustomerPostgres.getCustomerById(id);
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
        String regexEmail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern patternEmail = Pattern.compile(regexEmail);
        Matcher matcherEmail = patternEmail.matcher(email);

        String regexPass = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        Pattern patternPass = Pattern.compile(regexPass);
        Matcher matcherPass = patternPass.matcher(password);
        if(matcherEmail.matches() && matcherPass.matches()){
            Customer customer = new Customer(DatabaseCustomerPostgres.getLastId()+1, name, email, password);
            return DatabaseCustomerPostgres.insertCustomer(customer);
        }
        return null;
    }

    /**
     * Method to log into the application
     * @param email variable that stores email of the customer
     * @param password variable that stores password of the customer
     * @return object customer that was logged in
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Customer loginCustomer(@RequestParam(value="email") String email,
                                  @RequestParam(value="password") String password)
    {
        return DatabaseCustomerPostgres.getCustomerLogin(email, password);
    }
}
