/**
 * This is class will handle METHODS related to sellers
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */

package hizkia.jfood.controller;

import hizkia.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/seller")
@CrossOrigin(origins = "*", allowedHeaders = "")
@RestController

public class SellerController {

    /**
     * Method to prints all seller in the data base
     * @return all seller in database
     */
    @RequestMapping("")
    public ArrayList<Seller> getAllSeller()
    {
        return DatabaseSeller.getSellerDatabase();
    }

    /**
     * Method to get seller from id
     * @param id variable to store id of seller
     * @return single seller object
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Seller getSellerById(@PathVariable int id) throws SellerNotFoundException {
        Seller seller = DatabaseSeller.getSellerById(id);
        return seller;
    }

    /**
     * Method to adds new seller into database
     * @param name variable that stores name of the seller
     * @param email variable that stores email of the seller
     * @param phoneNumber variable that stores phone number of the seller
     * @param province variable that stores province information of the seller
     * @param city variable that stores city of the seller
     * @param description variable that stores location description of seller
     * @return object seller that was added to database
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Seller addSeller(@RequestParam(value="name") String name,
                            @RequestParam(value="email") String email,
                            @RequestParam(value="phoneNumber") String phoneNumber,
                            @RequestParam(value="province") String province,
                            @RequestParam(value="description") String description,
                            @RequestParam(value="city") String city)
    {
        Seller seller = new Seller(DatabaseSeller.getLastId()+1, name, email, phoneNumber, new Location(city, province, description));
        DatabaseSeller.addSeller(seller);
        return seller;
    }
}
