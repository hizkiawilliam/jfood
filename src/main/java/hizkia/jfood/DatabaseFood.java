/**
 * Write a description of class DatabaseFood here.
 *
 * @author Hizkia William Eben
 * @version 13.04.2020
 */
package hizkia.jfood;

import java.util.ArrayList;

public class DatabaseFood
{
    private static ArrayList<Food> FOOD_DATABASE= new ArrayList<Food>();
    private static int lastId = 0;
    
    /**
     * Constructor for objects of class DatabaseFood
     */
    public DatabaseFood()
    {
    }

    /**
     * Method to show food list from food database
     * @return FOOD_DATABASE arraylist that contains all information of foods
     */
    public static ArrayList<Food> getFoodDatabase()
    {
        return FOOD_DATABASE;
    }

    /**
     * Method to show last id of food in food database
     * @return last id in food database
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Method to show food by id from food database
     * @param id variable that stores information id of food
     * @return food as object
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
     * Method to show food by seller from database
     * @param sellerId variable that stores information of seller id
     * @return food as object
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
     * Method to show food by category from food database
     * @param category variable that stores information of food category
     * @return categoryFoods array list of food grouped by category
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
     * Method to add food into food database
     * @param food passing variable that stores food object
     * @return boolean that show the succession of the method
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
     * Method to remove food from database
     * @param id passing variable that stores food id
     * @return boolean that show the succession of the method
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
