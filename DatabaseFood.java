
/**
 * Write a description of class DatabaseFood here.
 *
 * @author Hizkia William Eben
 * @version 05.03.2020
 */

import java.util.ArrayList;

public class DatabaseFood
{
    // instance variables - replace the example below with your own
    // private ArrayList<Food> listFood = new ArrayList<>();
    private String[] listFood;
    private int data = 0;
    
    /**
     * Constructor for objects of class DatabaseFood
     */
    public DatabaseFood()
    {
    }
    
    /**
    * Method to add food
    * @return false default return param to check successability
    */
    public boolean addFood(Food food)
    {
        return false;
    }
    
    /**
    * Method to remove food
    * @return false default return param to check successability
    */
    public boolean removeFood(Food food)
    {
        return false;
    }
    
    /**
    * Method to show food
    * @return null
    */
    public Food getFood()
    {
        return null;
    }
    
    /**
    * Method to show food list
    * @return null
    */
    public String[] getListFood()
    {
        return listFood;
    }
    
}
