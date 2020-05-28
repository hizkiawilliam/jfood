/**
 * Enumeration class PaymentType
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */
package hizkia.jfood.unused;

public enum PaymentType
{
    Cashless("Cashless"), 
    Cash("Cash");
    
    private String payment;

    /**
     * Constructor for Payment Type
     * @param payment variable that stores string to print payment type
     */
    PaymentType(String payment)
    {
        this.payment = payment;
    }

    /**
     * Method to print Payment Type
     * @return toString variable that stores string to print payment type
     */
    public String toString()
    {
        return this.payment;
    }
}
