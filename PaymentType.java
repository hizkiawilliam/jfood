
/**
 * Enumeration class PaymentType - write a description of the enum class here
 *
 * @author Hizkia William Eben
 * @version 05.03.2020
 */
public enum PaymentType
{
    Cashless("Cashless"), 
    Cash("Cash");
    
    private String payment;
    
    PaymentType(String payment)
    {
        this.payment = payment;
    }
    
    public String toString()
    {
        return this.payment;
    }
}
