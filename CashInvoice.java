
/**
 * Write a description of class CashInvoice here.
 *
 * @author Hizkia William Eben
 * @version 13.03.2020
 */

import java.util.*;
import java.text.*;

public class CashInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee;

    /**
     * Constructor for objects of class CashInvoice
     */

    public CashInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus)
    {
        super(id,food, customer, invoiceStatus);
    }
    
    public CashInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus, int deliveryFee)
    {
        super(id,food, customer, invoiceStatus);
        this.deliveryFee = deliveryFee;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    //@Override
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
    
    public String toString()
    {        
        return "===============Invoice===============" +
               "\nID: " + super.getId() +
               "\nFood: " + super.getFood().getName() +
               "\nDate: " + super.getDate() +
               "\nCustomer: " + super.getCustomer().getName() +
               "\nDelivery Fee: " + getDeliveryFee() +        
               "\nTotalPrice: " + super.getTotalPrice() +
               "\nStatus: " + super.getInvoiceStatus() +
               "\nPayment Type: " + getPaymentType();  
    }
}
