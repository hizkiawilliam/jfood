/**
 * Write a description of class DatabaseFood here.
 *
 * @author Hizkia William Eben
 * @version 13.04.2020
 */
package hizkia.jfood;

import java.util.*;

public class DatabaseSeller
{
    private static ArrayList<Seller> SELLER_DATABASE = new ArrayList<Seller>();
    private static int lastId = 0;

    /**
     * Constructor for objects of class DatabaseFood
     */
    public DatabaseSeller()
    {
    }

    /**
     * Method to show seller list from seller database
     * @return SELLER_DATABASE array list that stores all sellers
     */
    public static ArrayList<Seller> getSellerDatabase()
    {
        return SELLER_DATABASE;
    }

    /**
     * Method to add seller into seller database
     * @param seller passing parameter that stores object seller
     * @return boolean that show the succession of the method
     */
    public static boolean addSeller(Seller seller)
    {
        for(Seller sellerCheck:SELLER_DATABASE)
        {
            if (sellerCheck.getId() == seller.getId())
            {
                return false;
            }
        }
        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;
    }
    
    /**
     * Method to remove seller from seller database
     * @param id passing parameter that stores seller id
     * @return boolean that show the succession of the method
     */
    public static boolean removeSeller(int id) throws SellerNotFoundException
    {
        for(int i = 0;  i < SELLER_DATABASE.size(); i++)
        {
            Seller seller = SELLER_DATABASE.get(i);
            if (id == seller.getId())
            {
                SELLER_DATABASE.remove(id);
            }
        }
        throw new SellerNotFoundException(id);
    }
    
    /**
     * Method to show seller from seller database
     * @param id passing parameter that stores seller id
     * @return Seller object with specific id
     */
    public static Seller getSellerById(int id) throws SellerNotFoundException
    {
        for(Seller sellers:SELLER_DATABASE)
        {
            if (id == sellers.getId())
            {
                return sellers;
            }
        }
        throw new SellerNotFoundException(id);
    }

    /**
     * Method to show last id of seller in seller database
     * @return lastId variable
     */
    public static int getLastId()
    {
        return lastId;
    }
}
