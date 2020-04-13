
/**
 * Write a description of class CashInvoice here.
 *
 * @author Hizkia William Eben
 * @version 13.04.2020
 */

import java.util.*;
import java.text.*;

public class CashInvoice extends Invoice
{
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee;

    /**
     * Constructor for objects of class CashInvoice without delivery fee
     * @param id variable for identifying Invoice
     * @param foods variable that stores object food
     * @param customer variable to store information about customer
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }

    /**
     * Constructor for objects of class Customer with delivery fee
     * @param id variable for identifying Invoice
     * @param foods variable that stores object food
     * @param customer variable to store information about customer
     * @param deliveryFee variable to store information about deliveryFee
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer, int deliveryFee)
    {
        super(id, foods, customer);
        this.deliveryFee = deliveryFee;
    }

    /**
     * Method as accessor or getter to get payment type of the invoice
     * @return PAYEMENT_TYPE variable that stores information about payment type of the invoice
     */
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }

    /**
     * Method as accessor or getter to get delivery fee of the invoice
     * @return deliveryFee variable that stores information about delivery fee of the invoice
     */
    public int getDeliveryFee()
    {
        return this.deliveryFee;
    }

    /**
     * Method as mutator or setter to set amount of deliveryFee of the invoice
     * @param deliveryFee variable that stores information about payment type of the invoice
     */
    public void setDeliveryFee(int deliveryFee)
    {
        this.deliveryFee = deliveryFee;
    }

    /**
     * Method to set the total price of the invoice. Total price set based on existence of deliveryFee
     */
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

    /**
     * Method to print data of the invoice
     */
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
