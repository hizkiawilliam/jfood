/**
 * Enumeration class FoodCategory (unused)
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */
package hizkia.jfood.unused;

public enum FoodCategory
{
    Beverages("Beverages"), 
    Coffee("Coffee"), 
    Western("Western"), 
    Snacks("Snacks"), 
    Rice("Rice"), 
    Noodles("Noodles"), 
    Bakery("Bakery"), 
    Japanese("Japanese"),
    Korean("Korean");
    
    private String toString;

    /**
     * Constructor for Food category
     * @param toString variable that stores string to print food category
     */
    FoodCategory(String toString)
    {
        this.toString = toString;
    }

    /**
     * Method to print food category
     * @return toString variable that stores string to print food category
     */
    public String toString()
    {
        return this.toString;
    }
}


