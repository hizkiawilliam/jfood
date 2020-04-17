/**
 * Class InvoiceNotFoundException is class that serves as invoice error handling
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */
package hizkia.jfood;

public class InvoiceNotFoundException extends Exception
{
    private int invoice_error;

    /**
     * Constructor for invoice error handling
     * @param invoice_input variable for passing the object invoice
     */
    public InvoiceNotFoundException(int invoice_input)
    {
        super("Invoice ID: ");
        this.invoice_error = invoice_input;
    }

    @Override
    /**
     * Method to print the information of the error handling
     */
    public String getMessage()
    {
        return super.getMessage() + invoice_error + " not found";
    }
}
