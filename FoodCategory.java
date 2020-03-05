
/**
 * Enumeration class FoodCategory - write a description of the enum class here
 *
 * @author (Hizkia William Eben
 * @version 05-03-20
 */
public enum FoodCategory
{
    Beverages("Beverages"), 
    Coffee("Coffee"), 
    Western("Western"), 
    Snacks("Snacks"), 
    Rice("Rice"), 
    Noodles("Noodles"), 
    Bakery("Bakery"), 
    Japanese("Japanese");
    
    private String toString;
    
    FoodCategory(String toString)
    {
        this.toString = toString;
    }
    
    public String toString()
    {
        return this.toString;
    }
}


