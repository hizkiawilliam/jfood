
/**
 * Write a description of class DatabaseFood here.
 *
 * @author Hizkia William Eben
 * @version 12.03.2020
 */

import java.util.*;

public class DatabaseSeller
{
    // instance variables - replace the example below with your own
    private static ArrayList<Seller> SELLER_DATABASE = new ArrayList<Seller>();
    private static int lastId = 0;

    /**
     * Constructor for objects of class DatabaseFood
     */
    public DatabaseSeller()
    {
    }

    /**
     * Method to show seller list
     * @return SELLER_DATABASE
     */
    public static ArrayList<Seller> getSellerDatabase()
    {
        return SELLER_DATABASE;
    }

    /**
    * Method to add seller
    * @return false default return param for boolean
    */
    public static boolean addSeller(Seller seller)
    {
        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;
    }
    
    /**
    * Method to remove seller
    * @return false default return param for boolean
    */
    public static boolean removeSeller(int id)
    {
        for(int i = 0;  i < SELLER_DATABASE.size(); i++)
        {
            Seller seller = SELLER_DATABASE.get(i);
            if (id == seller.getId())
            {
                SELLER_DATABASE.remove(id);
            }
        }
        return true;
    }
    
    /**
    * Method to show seller
    * @return Seller with specific id
    */
    public static Seller getSellerById(int id)
    {
        for(Seller sellers:SELLER_DATABASE)
        {
            if (id == sellers.getId())
            {
                return sellers;
            }
        }
        return null;
    }

    /**
     * Method to show seller
     * @return int of total seller
     */
    public static int getLastId()
    {
        return lastId;
    }
}
