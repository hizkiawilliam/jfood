
/**
 * Write a description of class CashInvoice here.
 *
 * @author Hizkia William Eben
 * @version 13.03.2020
 */
public class CashInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee;

    /**
     * Constructor for objects of class CashInvoice
     */
    public CashInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus)
    {
        super(id,food, date, customer, invoiceStatus);
    }
    
    public CashInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus, int deliveryFee)
    {
        super(id,food, date, customer, invoiceStatus);
        this.deliveryFee = deliveryFee;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    @Override
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    public int getDeliveryFee()
    {
        return this.deliveryFee;
    }
    
    public void setDeliveryFee(int deliveryFee)
    {
        this.deliveryFee = deliveryFee;
    }
    
    public void setTotalPrice()
    {
        if(deliveryFee > 0)
        {
            super.totalPrice = getFood().getPrice() + getDeliveryFee();
        }   
        else if(deliveryFee == 0)
        {
            super.totalPrice = getFood().getPrice();
        }
    }
    
    public void printData()
    {
        System.out.println("===============Invoice===============");
        System.out.println("ID: " + super.getId());
        System.out.println("Food: " + super.getFood().getName());        
        System.out.println("Date: " + super.getDate());
        System.out.println("Customer: " + super.getCustomer().getName()); 
        System.out.println("Delivery Fee: " + getDeliveryFee());         
        System.out.println("TotalPrice: " + super.getTotalPrice());  
        System.out.println("Status: " + super.getInvoiceStatus());        
        System.out.println("Payment Type: " + getPaymentType());  
    }
}
