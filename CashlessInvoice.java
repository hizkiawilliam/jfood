
/**
 * Write a description of class CashlessInvoice here.
 *
 * @author Hizkia William Eben
 * @version 12.03.2020
 */
public class CashlessInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;

    /**
     * Constructor for objects of class CashlessInvoice
     */
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus)
    {
        super(id,food, date, customer, invoiceStatus);
    }
    
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus, Promo promo)
    {
        super(id,food, date, customer, invoiceStatus);
        this.promo = promo;
    }

    @Override
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    public void setPromo(Promo promo)
    {
    }
    public void setTotalPrice()
    {
        if((promo != null)&&(promo.getActive() == true)&&(getFood().getPrice() >= promo.getMinPrice()))
        {
            super.totalPrice = getFood().getPrice() - promo.getDiscount();
        }   
        else
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
        if((promo != null)&&(promo.getActive() == true)&&(getFood().getPrice() >= promo.getMinPrice()))
        {
            System.out.println("Promo: " + promo.getCode());             
        }
        System.out.println("TotalPrice: " + super.getTotalPrice());  
        System.out.println("Status: " + super.getInvoiceStatus());        
        System.out.println("Payment Type: " + getPaymentType());  
    }
}
