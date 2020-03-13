/**
 * Write a description of class Invoice here.
 *
 * @author Hizkia William Eben
 * @version 12.03.2020
 */
public abstract class Invoice
{
    private int id;
    private Food food;
    private String date;
    protected int totalPrice;
    private Customer customer;
    private InvoiceStatus status;
    private PaymentType paymentType;

    /**
     * Constructor for objects of class Customer
     * @param id variable for identifying Invoice
     * @param idFood variable to store id of foods
     * @param date variable to store email information
     * @param customer variable to store information about customer
     * @param totalPrice variable to store information about total price
     */
    public Invoice(int id, Food food, String date, Customer customer, InvoiceStatus status)
    {
        this.id = id;
        this.food = food;
        this.date = date;
        this.customer = customer;
        this.status = status;
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
    public Food getFood()
    {
        return food;
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
     * Method as accessor to get payment type information in the invoice
     * @return paymentType object that stores payment type information of the invoice
     */
    public abstract PaymentType getPaymentType();
    
    /**
     * Method as accessor to get invoice status of the invoice
     * @return totalPrice variable that stores invoice status of the invoice
     */
    public InvoiceStatus getInvoiceStatus()
    {
        return status;
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
    public void setFoods(Food food)
    {
        this.food = food;
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
    public abstract void setTotalPrice();
    
    /**
    * Method as setter or mutator to set customer of the invoice
    */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    /**
    * Method as setter or mutator to set payment type of the invoice
    */
    public void setPaymentType(PaymentType paymentType)
    {
        this.paymentType = paymentType;
    }
    
    /**
    * Method as setter or mutator to set invoice status of the invoice
    */
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.status = status;
    }
    
    /**
    * Method to print data of the invoice
    */
    public abstract void printData();
}