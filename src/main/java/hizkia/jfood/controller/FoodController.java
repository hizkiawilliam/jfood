package hizkia.jfood.controller;

import hizkia.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/food")
@RestController

public class FoodController {

    @RequestMapping("")
    public ArrayList<Food> getAllFood()
    {
        return DatabaseFood.getFoodDatabase();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Food getFoodById(@PathVariable int id) throws FoodNotFoundException {
        Food food = DatabaseFood.getFoodById(id);
        return food;
    }

    @RequestMapping(value = "/seller/{sellerId}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerId) throws FoodNotFoundException {
        ArrayList<Food> food = DatabaseFood.getFoodBySeller(sellerId);
        return food;
    }

    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category) throws FoodNotFoundException {
        ArrayList<Food> food = DatabaseFood.getFoodByCategory(category);
        return food;
    }

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
