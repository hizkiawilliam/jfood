
/**
 * Write a description of class CashlessInvoice here.
 *
 * @author Hizkia William Eben
 * @version 12.03.2020
 */

import java.util.*;
import java.text.*;

public class CashlessInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;

    /**
     * Constructor for objects of class CashlessInvoice
     */
    public CashlessInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus)
    {
        super(id,food, customer, invoiceStatus);
    }
    
    public CashlessInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus, Promo promo)
    {
        super(id,food, customer, invoiceStatus);
        this.promo = promo;
    }

    //@Override
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    public Promo getPromo()
    {
        return this.promo;
    }
    
    public void setPromo(Promo promo)
    {
        this.promo = promo;
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
    
    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
       
        if ((promo != null) && (promo.getActive() == true) && (getFood().getPrice() >= promo.getMinPrice()))
        {
              return "===============Invoice===============" +
                   "\nID: " + super.getId() +
                   "\nFood: " + super.getFood().getName() +
                   "\nDate: " + sdf.format(super.getDate().getTime()) +
                   "\nCustomer: " + super.getCustomer().getName() + 
                   "\nPromo: " + promo.getCode() +
                   "\nTotalPrice: " + super.getTotalPrice() +  
                   "\nStatus: " + super.getInvoiceStatus() +        
                   "\nPayment Type: " + getPaymentType() + "\n\n";
        }
        else
        {
             return "===============Invoice===============" +
                   "\nID: " + super.getId() +
                   "\nFood: " + super.getFood().getName() +
                   "\nDate: " + sdf.format(super.getDate().getTime()) +
                   "\nCustomer: " + super.getCustomer().getName() + 
                   "\nTotalPrice: " + super.getTotalPrice() +  
                   "\nStatus: " + super.getInvoiceStatus() +        
                   "\nPayment Type: " + getPaymentType() + "\n\n";
        }
    }
}
