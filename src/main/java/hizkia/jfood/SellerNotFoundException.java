/**
 * Class SellerNotFoundException is class that serves as seller error handling
 *
 * @author Hizkia William Eben
 * @version 13.04.2020
 */
package hizkia.jfood;

public class SellerNotFoundException extends Exception
{
    private int seller_error;

    /**
     * Constructor for seller error handling
     * @param seller_input variable for passing the information of id seller
     */
    public SellerNotFoundException(int seller_input)
    {
        super("Seller ID: ");
        this.seller_error = seller_input;
    }

    @Override
    /**
     * Method to print the information of the error handling
     */
    public String getMessage()
    {
        return super.getMessage() + seller_error + " not found";
    }
}
