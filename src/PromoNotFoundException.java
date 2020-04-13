/**
 * Class PromoNotFoundException is class that serves as promo error handling
 *
 * @author Hizkia William Eben
 * @version 13.04.2020
 */

public class PromoNotFoundException extends Exception
{
    private int promo_error;

    /**
     * Constructor for promo error handling
     * @param promo_input variable for passing the information of id promo
     */
    public PromoNotFoundException(int promo_input)
    {
        super("Promo ID: ");
        this.promo_error = promo_input;
    }

    @Override
    /**
     * Method to print the information of the error handling
     */
    public String getMessage()
    {
        return super.getMessage() + promo_error + " not found";
    }
}
