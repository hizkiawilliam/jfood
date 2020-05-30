/**
 * Class PromoCodeAlreadyExistsException is class that serves as promo error handling
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */
package hizkia.jfood.exception;

import hizkia.jfood.Promo;

public class PromoCodeAlreadyExistsException extends Exception
{
    private Promo promo_error;

    /**
     * Constructor for promo error handling
     * @param promo_input variable for passing the object promo
     */
    public PromoCodeAlreadyExistsException(Promo promo_input)
    {
        super("Promo Code: ");
        this.promo_error = promo_input;
    }

    @Override
    /**
     * Method to print the information of the error handling
     */
    public String getMessage()
    {
        return super.getMessage() + promo_error.getCode() + " already exists";
    }
}
