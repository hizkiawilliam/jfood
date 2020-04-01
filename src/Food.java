/**
 * Class Food is class that stores information for every food object
 *
 * @author Hizkia William Eben
 * @version 20.03.2020
 */
public class Food
{
    private int id;
    private String name;
    private int price;
    private Seller seller;
    private FoodCategory category;


    /**
     * Constructor for objects of class Food
     */
    public Food(int id, String name, Seller seller, int price, FoodCategory category)
    {
        this.id = id;
        this.name = name;
        this.seller = seller;
        this.price = price;
        this.category = category;  
    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public int getPrice()
    {
        return price;
    }
    public FoodCategory getCategory()
    {
        return category;
    }
    public Seller getSeller()
    {
        return seller;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    public void setCategory(FoodCategory Category)
    {
        this.category = category;
    }
    public void setSeller(Seller seller)
    {
        this.seller = seller;
    }
    
    /**
    * Method to return all variables Food as String
    */    
    public String toString()
    {
         return "Id = " + getId() + 
                "Name = " + getName() + 
                "Seller = " + getSeller().getName() + 
                "City =" + seller.getLocation().getCity() + 
                "Price = " + getPrice() + 
                "Category = " + getCategory().toString();
    }
}
