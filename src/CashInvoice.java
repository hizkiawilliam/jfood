
/**
 * Write a description of class CashInvoice here.
 *
 * @author Hizkia William Eben
 * @version 03.04.2020
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

    public CashInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }
    
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer, int deliveryFee)
    {
        super(id, foods, customer);
        this.deliveryFee = deliveryFee;
    }

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
        super.totalPrice = 0;
        if(deliveryFee > 0)
        {
            for(Food foods:getFoods()) {
                super.totalPrice += foods.getPrice();
            }
            super.totalPrice += getDeliveryFee();
        }   
        else if(deliveryFee == 0)
        {
            for(Food foods:getFoods()) {
                super.totalPrice += foods.getPrice();
            }
        }
    }
    
    public String toString()
    {
        String foodName = "";
        for (Food food : getFoods())
        {
            foodName += food.getName() + ", ";
        }
        SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
        String date = format1.format(getDate().getTime());
        return "================Invoice================" + "\n" +
                "ID: " + getId() + "\n" +
                "Name: " + foodName + "\n" +
                "Date: " + date + "\n" +
                "Customer: " + getCustomer().getName() + "\n" +
                "Delivery Fee: " + getDeliveryFee() + "\n" +
                "Total Price: " + totalPrice + "\n" +
                "Status: " + getInvoiceStatus() + "\n" +
                "Payment Type: " + getPaymentType() + "\n";
    }
}
