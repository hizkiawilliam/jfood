/**
 * Class DatabasePromo contains all object of Promos stored in ArrayList Promo
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */
package hizkia.jfood.database;

import hizkia.jfood.Promo;
import hizkia.jfood.exception.PromoCodeAlreadyExistsException;
import hizkia.jfood.exception.PromoNotFoundException;

import  java.util.ArrayList;

public class DatabasePromo
{
    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<Promo>();
    private static int lastId = 0;

    /**
     * Method to show promo list from promo database
     * @return PROMO_DATABASE array list that stores information of all promo
     */
    public static ArrayList<Promo> getPromoDatabase()
    {
        return PROMO_DATABASE;
    }

    /**
     * Method to show last id of promo in promo database
     * @return last id of promo in database
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Method to show promo by id in promo database
     * @param id passing parameter that stores promo id
     * @return promo as object
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
     * Method to show promo by code in promo database
     * @param code passing parameter that stores promo code
     * @return food as object
     */
    public static Promo getPromoByCode(String code)
    {
        for(Promo promo:PROMO_DATABASE)
        {
            if (code.equals(promo.getCode()))
            {
                return promo;
            }
        }
        return null;
    }

    /**
     * Method to add promo into promo database
     * @param promo passing parameter that stores object promo
     * @return boolean that show the succession of the method
     */
    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistsException
    {
        for(Promo promoCheck:PROMO_DATABASE)
        {
            if (promoCheck.getCode().equals(promo.getCode()))
            {
                throw new PromoCodeAlreadyExistsException(promo);
            }
        }
        PROMO_DATABASE.add(promo);
        lastId = promo.getId();
        return true;
    }

    /**
     * Method to activate promo in promo database
     * @param id passing parameter that stores promo id
     * @return boolean that show the succession of the method
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
     * Method to deactivate promo from promo database
     * @param id passing parameter that stores promo id
     * @return boolean that show the succession of the method
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
     * Method to remove promo from promo database
     * @param id passing parameter that stores promo id
     * @return boolean that show the succession of the method
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
