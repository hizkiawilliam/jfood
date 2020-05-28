/**
 * Class FoodNotFoundException is class that serves as food error handling
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */
package hizkia.jfood.exception;

public class FoodNotFoundException extends Exception
{
    private int food_error;

    /**
     * Constructor for food error handling, to check if food already existed or not
     * @param food_input parameter for passing food id
     */
    public FoodNotFoundException(int food_input)
    {
        super("Food ID: ");
        this.food_error = food_input;
    }

    @Override
    /**
     * Method to print the information of the error handling
     */
    public String getMessage()
    {
        return super.getMessage() + food_error + " not found";
    }
}
