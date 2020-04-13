/**
 * Class CustomerNotFoundException is class that serves as customer error handling
 *
 * @author Hizkia William Eben
 * @version 13.04.2020
 */

public class CustomerNotFoundException extends Exception
{
    private int customer_error;

    /**
     * Constructor for customer error handling
     * @param customer_input variable for passing the information of id customer
     */
    public CustomerNotFoundException(int customer_input)
    {
        super("Customer ID: ");
        this.customer_error = customer_input;
    }

    @Override
    /**
     * Method to print the information of the error handling
     */
    public String getMessage()
    {
        return super.getMessage() + customer_error + " not found";
    }
}
