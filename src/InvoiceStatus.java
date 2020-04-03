
/**
 * Enumeration class InvoiceStatus - write a description of the enum class here
 *
 * @author Hizkia William Eben
 * @version 03.04.2020
 */
public enum InvoiceStatus
{
    Ongoing("Ongoing"), 
    Finished("Finished"),
    Cancelled("Canceled");
    
    private String status;
    
    InvoiceStatus(String status)
    {
        this.status = status;
    }
    
    public String toString()
    {
        return this.status;
    }
}
