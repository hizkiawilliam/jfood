/**
 * Class EmailAlreadyExistsException is class that serves as email error handling when adding new customer to customer database
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */
package hizkia.jfood;

public class EmailAlreadyExistsException extends Exception
{
    private Customer customer_error;

    /**
     * Constructor for email customer error handling, to check if email already existed or not
     * @param customer_input parameter for passing object customer
     */
    public EmailAlreadyExistsException(Customer customer_input)
    {
        super("Customer Email: ");
        this.customer_error = customer_input;
    }

    @Override
    /**
     * Method to print the information of the error handling
     */
    public String getMessage()
    {
        return super.getMessage() + customer_error.getEmail() + " already exists";
    }
}
