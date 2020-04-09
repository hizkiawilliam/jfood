
/**
 * Write a description of class DatabaseFood here.
 *
 * @author Hizkia William Eben
 * @version 03.04.2020
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
    * Method to remove seller
    * @return false default return param for boolean
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
    * Method to show seller
    * @return Seller with specific id
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
     * Method to show seller
     * @return int of total seller
     */
    public static int getLastId()
    {
        return lastId;
    }
}
