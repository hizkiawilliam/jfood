
/**
 * Write a description of class DatabaseFood here.
 *
 * @author Hizkia William Eben
 * @version 03.04.2020
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
    public static Food getFoodById(int id) throws FoodNotFoundException
    {
        for(Food foods:FOOD_DATABASE)
        {
            if (id == foods.getId())
            {
                return foods;
            }
        }
        throw new FoodNotFoundException(id);
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
        ArrayList<Food> categoryFoods = new ArrayList<>();
        for(Food food:FOOD_DATABASE) {
            if (category == food.getCategory())
            {
                categoryFoods.add(food);
            }
        }
        if (categoryFoods == null)
        {
            return null;
        } else
            {
            return categoryFoods;
        }
    }

    /**
    * Method to add food
    * @return false default return param to check successability
    */
    public static boolean addFood(Food food)
    {
        for(Food foodCheck:FOOD_DATABASE)
        {
            if (foodCheck.getId() == food.getId())
            {
                return false;
            }
        }
        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;
    }
    
    /**
    * Method to remove food
    * @return false default return param to check successability
    */
    public static boolean removeFood(int id) throws FoodNotFoundException
    {
        for(int i = 0;  i < FOOD_DATABASE.size(); i++)
        {
            Food food = FOOD_DATABASE.get(i);
            if (id == food.getId())
            {
                FOOD_DATABASE.remove(id);
                return true;
            }
        }
        throw new FoodNotFoundException(id);
    }
}
