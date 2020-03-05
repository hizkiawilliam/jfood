/**
 * Write a description of class Invoice here.
 *
 * @author Hizkia William Eben
 * @version 05.03.2020
 */
public class Invoice
{
    private int id;
    private int idFood;
    private String date;
    private int totalPrice;
    private Customer customer;

    /**
     * Constructor for objects of class Customer
     * @param id variable for identifying Invoice
     * @param idFood variable to store id of foods
     * @param date variable to store email information
     * @param customer variable to store information about customer
     * @param totalPrice variable to store information about total price
     */
    public Invoice(int id, int idFood, String date, Customer customer, int totalPrice)
    {
        this.id = id;
        this.idFood = idFood;
        this.date = date;
        this.customer = customer;
        this.totalPrice = totalPrice;
    }
    
    /**
     * Method as accessor or getter to get id of the invoice
     * @return id variable that stores id of the invoice
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Method as accessor or getter to get idFood of the invoice
     * @return idFood variable that stores idFood of the invoice
     */
    public int getIdFood()
    {
        return idFood;
    }
    
    /**
     * Method as accessor to get date of the invoice created
     * @return date variable that stores date of the invoice
     */
    public String getDate()
    {
        return date;
    }
    
    /**
     * Method as accessor to get total price of the invoice
     * @return totalPrice variable that stores total price of the invoice
     */
    public int getTotalPrice()
    {
        return totalPrice;
    }
    
    /**
     * Method as accessor to get costumer information in the invoice
     * @return customer variable that stores customer information of the invoice
     */
    public Customer getCustomer()
    {
        return customer;
    }
    
    /**
    * Method as setter or mutator to set id of the invoice
    */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
    * Method as setter or mutator to set idFood of the invoice
    */
    public void setIdFoods(int idFood)
    {
        this.idFood = idFood;
    }
    
    /**
    * Method as setter or mutator to set date of the invoice
    */
    public void setDate(String date)
    {
        this.date = date;
    }
    
    /**
    * Method as setter or mutator to set total price of the invoice
    */
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    
    /**
    * Method as setter or mutator to set customer of the invoice
    */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    /**
    * Method to print data of the invoice
    */
    public void printData()
    {
        System.out.println(totalPrice);
    }
}
