/**
 * This is class will handle METHODS related to foods
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */

package hizkia.jfood.controller;

import hizkia.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/food")
@RestController

public class FoodController {

    /**
     * Method to prints all food in the data base
     * @return all food in database
     */
    @RequestMapping("")
    public ArrayList<Food> getAllFood()
    {
        return DatabaseFood.getFoodDatabase();
    }

    /**
     * Method to get food from id
     * @param id variable to store id of food
     * @return single food object
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Food getFoodById(@PathVariable int id) throws FoodNotFoundException {
        Food food = DatabaseFood.getFoodById(id);
        return food;
    }

    /**
     * Method to get food from sellerId
     * @param sellerId variable to store id of seller
     * @return single food object
     */
    @RequestMapping(value = "/seller/{sellerId}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerId) throws FoodNotFoundException {
        ArrayList<Food> food = DatabaseFood.getFoodBySeller(sellerId);
        return food;
    }

    /**
     * Method to get food from category
     * @param category variable to store category
     * @return single food object
     */
    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category) throws FoodNotFoundException {
        ArrayList<Food> food = DatabaseFood.getFoodByCategory(category);
        return food;
    }

    /**
     * Method to adds new food into database
     * @param name variable that stores name of the food
     * @param price variable that stores email of the food
     * @param category variable that stores password of the food
     * @param sellerId variable that stores sellerId of the food
     * @return object food that was added to database
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value="name") String name,
                                  @RequestParam(value="price") int price,
                                  @RequestParam(value="category") FoodCategory category,
                                  @RequestParam(value="sellerId") int sellerId)
    {

        try{
            Food food = new Food(DatabaseFood.getLastId()+1,name, DatabaseSeller.getSellerById(sellerId), price, category);
            DatabaseFood.addFood(food);
            return food;
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
