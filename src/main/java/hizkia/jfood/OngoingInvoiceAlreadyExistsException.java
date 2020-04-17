/**
 * Class OngoingInvoiceAlreadyExistsException is class that serves as invoice error handling
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */
package hizkia.jfood;

public class OngoingInvoiceAlreadyExistsException extends Exception
{
    private Invoice invoice_error;

    /**
     * Constructor for invoice error handling
     * @param invoice_input variable for passing the object invoice
     */
    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input)
    {
        super("Ongoing Invoice: ");
        this.invoice_error = invoice_input;
    }

    @Override
    /**
     * Method to print the information of the error handling
     */
    public String getMessage()
    {
        return super.getMessage() + invoice_error.getId() + " already exists";
    }
}
