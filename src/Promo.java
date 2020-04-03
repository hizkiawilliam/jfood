
/**
 * Write a description of class Promo here.
 *
 * @author Hizkia William Eben
 * @version 03.04.2020
 */
public class Promo
{
    // instance variables - replace the example below with your own
    private int id;
    private String code;
    private int discount;
    private int minPrice;
    private boolean active;

    /**
     * Constructor for objects of class Promo
     */
    public Promo(int id, String code, int discount, int minPrice, boolean active)
    {
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.minPrice = minPrice;
        this.active = active;
    }
    
    public int getId()
    {
        return id;
    }
    public String getCode()
    {
        return code;
    }
    public int getDiscount()
    {
        return discount;
    }
    public int getMinPrice()
    {
        return minPrice;
    }
    public boolean getActive()
    {
        return active;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public void setCode(String code)
    {
        this.code = code;
    }
    public void setDiscount(int discount)
    {
        this.discount = discount;
    }
    public void setMinPrice(int minPrice)
    {
        this.minPrice = minPrice;
    }
    public void setActive(boolean active)
    {
        this.active = active;
    }
    /**
    * Method to set all variables Promo to String
    */    
    public String toString()
    {
         return  "==========Promo==========" +
                 "\nId = " + getId() +
                 "\nCode = " + getCode() +
                 "\nDiscount = " + getDiscount() +
                 "\nMin Price " + getDiscount() +
                 "\nActive Status" + getActive();
    }
}
