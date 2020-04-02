
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
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id,foods, customer);
    }
    
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer, Promo promo)
    {
        super(id,foods, customer);
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
        for(Food foods: getFoods())
        {
            if ((promo != null) && (promo.getActive() == true) && (foods.getPrice() >= promo.getMinPrice())) {
                super.totalPrice += foods.getPrice() - promo.getDiscount();
            } else {
                super.totalPrice += foods.getPrice();
            }
        }
    }
    
    public String toString()
    {
        int tempPrice = 0;
        String foodName = "";
        for (Food food : getFoods())
        {
            tempPrice += food.getPrice();
            foodName += food.getName() + ", ";
        }
        SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
        String date = format1.format(getDate().getTime());
        if (getPromo() != null && getPromo().getActive() == true && tempPrice > getPromo().getMinPrice())
        {
            return "\n================Invoice================" + "\n" +
                    "ID: " + getId() + "\n" +
                    "Name: " + foodName + "\n" +
                    "Date: " + date + "\n" +
                    "Customer: " + getCustomer().getName() + "\n" +
                    "Promo: " + getPromo().getCode() + "\n" +
                    "Total Price: " + totalPrice + "\n" +
                    "Status: " + getInvoiceStatus() + "\n" +
                    "Payment Type: " + getPaymentType() + "\n";
        }
        else
        {
            return "\n================Invoice================" + "\n" +
                    "ID: " + getId() + "\n" +
                    "Name: " + foodName + "\n" +
                    "Date: " + date + "\n" +
                    "Customer: " + getCustomer().getName() + "\n" +
                    "Total Price: " + totalPrice + "\n" +
                    "Status: " + getInvoiceStatus() + "\n" +
                    "Payment Type: " + getPaymentType() + "\n";
        }
        /*
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
       
        if ((promo != null) && (promo.getActive() == true) && (getFoods().getPrice() >= promo.getMinPrice()))
        {
              return "===============Invoice===============" +
                   "\nID: " + super.getId() +
                   "\nFood: " + super.getFoods().getName() +
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
                   "\nFood: " + super.getFoods().getName() +
                   "\nDate: " + sdf.format(super.getDate().getTime()) +
                   "\nCustomer: " + super.getCustomer().getName() + 
                   "\nTotalPrice: " + super.getTotalPrice() +  
                   "\nStatus: " + super.getInvoiceStatus() +        
                   "\nPayment Type: " + getPaymentType() + "\n\n";
        }

         */
    }
}
