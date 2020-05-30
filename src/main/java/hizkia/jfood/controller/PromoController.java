/**
 * This is class will handle METHODS related to promos
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */

package hizkia.jfood.controller;

import hizkia.jfood.*;
import hizkia.jfood.database.DatabasePromo;
import hizkia.jfood.database.DatabasePromoPostgres;
import hizkia.jfood.exception.PromoCodeAlreadyExistsException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/promo")
@CrossOrigin(origins = "*", allowedHeaders = "")
@RestController
public class PromoController {

    /**
     * Method to prints all promo in the data base
     * @return all promo in database
     */
    @RequestMapping("")
    public ArrayList<Promo> getAllPromo()
    {
        return DatabasePromoPostgres.getPromoDatabase();
    }

    /**
     * Method to get promo from id
     * @param code variable to store code of promo
     * @return single promo object
     */
    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@PathVariable String code){
        Promo promo = DatabasePromoPostgres.getPromoByCode(code);
        return promo;
    }

    /**
     * Method to adds new invoice into database with cash payment type
     * @param code variable that stores code of the promo
     * @param discount variable that stores discount amount of the promo
     * @param minPrice variable that stores minimum price of the promo
     * @param active variable that stores information if promo active or not
     * @return object promo that was added to database
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value="code") String code,
                            @RequestParam(value="discount") int discount,
                            @RequestParam(value="minPrice") int minPrice,
                            @RequestParam(value="active") boolean active)
    {
        Promo promo = new Promo(DatabasePromoPostgres.getLastId()+1,code,discount,minPrice,active);
        return DatabasePromoPostgres.insertPromo(promo);
    }
}
