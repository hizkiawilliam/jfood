/**
 * Write a description of class Food here.
 *
 * @author Hizkia William Eben
 * @version 27.02.2020
 */
public class Food
{
    private int id;
    private String name;
    private int price;
    private Seller seller;
    private String category;


    /**
     * Constructor for objects of class Food
     */
    public Food(int id, String name, Seller seller, int price, String category)
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
    public String getCategory()
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
    public void setCategory(String Category)
    {
        this.category = category;
    }
    public void setSeller(Seller seller)
    {
        this.seller = seller;
    }
    public void printData()
    {
        System.out.println(name);
    }
}
