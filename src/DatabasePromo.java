/**
 * Write a description of class DatabasePromo here.
 *
 * @author Hizkia William Eben
 * @version 03.04.2020
 */

import  java.util.ArrayList;

public class DatabasePromo
{
    // instance variables - replace the example below with your own
    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<Promo>();
    private static int lastId = 0;

    /**
     * Method to show promo list
     * @return Database of promo
     */
    public static ArrayList<Promo> getPromoDatabase()
    {
        return PROMO_DATABASE;
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
     * Method to show promo by id
     * @return promo
     */
    public static Promo getPromoById(int id) throws PromoNotFoundException
    {
        for(Promo promo:PROMO_DATABASE)
        {
            if (id == promo.getId())
            {
                return promo;
            }
        }
        throw new PromoNotFoundException(id);
    }

    /**
     * Method to show promo by code
     * @return food
     */
    public static Promo getPromoByCode(String code)
    {
        for(Promo promo:PROMO_DATABASE)
        {
            if (code == promo.getCode())
            {
                return promo;
            }
        }
        return null;
    }

    /**
     * Method to add promo
     * @return false default return param to check successability
     */
    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistsException
    {
        for(Promo promoCheck:PROMO_DATABASE)
        {
            if (promoCheck.getCode() == promo.getCode())
            {
                throw new PromoCodeAlreadyExistsException(promo);
            }
        }
        PROMO_DATABASE.add(promo);
        lastId = promo.getId();
        return true;
    }

    /**
     * Method to activate promo
     * @return false default return param to check successability
     */
    public static boolean activatePromo(int id)
    {
        for(Promo promo:PROMO_DATABASE)
        {
            if (id == promo.getId())
            {
                promo.setActive(true);
                return true;
            }
        }
        return false;
    }

    /**
     * Method to deactivate promo
     * @return false default return param to check successability
     */
    public static boolean deactivatePromo(int id)
    {
        for(Promo promo:PROMO_DATABASE)
        {
            if (id == promo.getId())
            {
                promo.setActive(false);
                return true;
            }
        }
        return false;
    }

    /**
     * Method to remove promo
     * @return false default return param to check successability
     */
    public static boolean removePromo(int id) throws PromoNotFoundException
    {
        for(int i = 0;  i < PROMO_DATABASE.size(); i++)
        {
            Promo promo = PROMO_DATABASE.get(i);
            if (id == promo.getId())
            {
                PROMO_DATABASE.remove(id);
                return true;
            }
        }
        throw new PromoNotFoundException(id);
    }
}
