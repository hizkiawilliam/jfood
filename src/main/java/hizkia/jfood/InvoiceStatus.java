/**
 * Enumeration class InvoiceStatus
 *
 * @author Hizkia William Eben
 * @version 13.04.2020
 */
package hizkia.jfood;

public enum InvoiceStatus
{
    Ongoing("Ongoing"), 
    Finished("Finished"),
    Cancelled("Canceled");
    
    private String status;

    /**
     * Constructor for Invoice Status
     * @param status variable that stores string to print invoice status
     */
    InvoiceStatus(String status)
    {
        this.status = status;
    }

    /**
     * Method to print invoice status
     * @return toString variable that stores string to print invoice status
     */
    public String toString()
    {
        return this.status;
    }
}
