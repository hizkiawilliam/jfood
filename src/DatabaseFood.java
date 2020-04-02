
/**
 * Write a description of class DatabaseFood here.
 *
 * @author Hizkia William Eben
 * @version 12.03.2020
 */

import jdk.jfr.Category;

import java.util.ArrayList;

public class DatabaseFood
{
    // instance variables - replace the example below with your own
    private static ArrayList<Food> FOOD_DATABASE= new ArrayList<Food>();
    private static int lastId = 0;
    
    /**
     * Constructor for objects of class DatabaseFood
     */
    public DatabaseFood()
    {
    }

    /**
     * Method to show food list
     * @return Database of foods
     */
    public static ArrayList<Food> getFoodDatabase()
    {
        return FOOD_DATABASE;
    }

    /**
     * Method to show last id
     * @return last id in database
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Method to show food by id
     * @return food
     */
    public static Food getFoodById(int id)
    {
        for(Food foods:FOOD_DATABASE)
        {
            if (id == foods.getId())
            {
                return foods;
            }
        }
        return null;
    }

    /**
     * Method to show food by seller
     * @return food
     */
    public static ArrayList<Food> getFoodBySeller(int sellerId)
    {
        ArrayList<Food> seller_foods = new ArrayList<>();
        for(Food food:FOOD_DATABASE)
        {
            if (sellerId == food.getSeller().getId())
            {
                seller_foods.add(food);
            }
        }
        return seller_foods;
    }

    /**
     * Method to show food by category
     * @return food
     */
    public static ArrayList<Food> getFoodByCategory(FoodCategory category)
    {
        ArrayList<Food> category_foods = new ArrayList<>();
        for(Food food:FOOD_DATABASE)
        {
            if (category == food.getCategory())
            {
                category_foods.add(food);
            }
        }
        return category_foods;
    }

    /**
    * Method to add food
    * @return false default return param to check successability
    */
    public static boolean addFood(Food food)
    {
        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;
    }
    
    /**
    * Method to remove food
    * @return false default return param to check successability
    */
    public static boolean removeFood(int id)
    {
        for(int i = 0;  i < FOOD_DATABASE.size(); i++)
        {
            Food food = FOOD_DATABASE.get(i);
            if (id == food.getId())
            {
                FOOD_DATABASE.remove(id);
            }
        }
        return true;
    }
}
