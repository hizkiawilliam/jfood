/**
 * Class CashInvoice represents object that handles Invoice with cashless payment
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */

package hizkia.jfood;

import java.util.*;
import java.text.*;

public class CashlessInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;

    /**
     * Constructor for objects of class CashlessInvoice without promo
     * @param id variable for identifying Invoice
     * @param foods variable that stores object food
     * @param customer variable to store information about customer
     */
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id,foods, customer);
    }

    /**
     * Constructor for objects of class CashlessInvoice without promo
     * @param id variable for identifying Invoice
     * @param foods variable that stores object food
     * @param customer variable to store information about customer
     * @param promo variable to store information about promo that available
     */
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer, Promo promo)
    {
        super(id,foods, customer);
        this.promo = promo;
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
     * Method as accessor or getter to get promo of the invoice
     * @return promo variable that stores information about promo of the invoice
     */
    public Promo getPromo()
    {
        return this.promo;
    }

    /**
     * Method as mutator or setter to get promo of the invoice
     * @param promo variable that stores information about promo of the invoice
     */
    public void setPromo(Promo promo)
    {
        this.promo = promo;
    }

    /**
     * Method to set the total price of the invoice. Total price set based on existence of promo
     */
    public void setTotalPrice()
    {
        super.totalPrice = 0;
        for(Food foods: getFoods())
        {
            if ((promo != null) && (promo.getActive()) && (foods.getPrice() >= promo.getMinPrice())) {
                super.totalPrice += foods.getPrice() - promo.getDiscount();
            } else {
                super.totalPrice += foods.getPrice();
            }
        }
    }

    /**
     * Method to print data of the invoice
     */
    public String toString()
    {
        int tempPrice = 0;
        StringBuilder foodName = new StringBuilder();
        for (Food food : getFoods())
        {
            tempPrice += food.getPrice();
            foodName.append(food.getName()).append(", ");
        }
        SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
        String date = format1.format(getDate().getTime());
        if (getPromo() != null && getPromo().getActive() && tempPrice > getPromo().getMinPrice())
        {
            return "================Invoice================" + "\n" +
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
            return "================Invoice================" + "\n" +
                    "ID: " + getId() + "\n" +
                    "Name: " + foodName + "\n" +
                    "Date: " + date + "\n" +
                    "Customer: " + getCustomer().getName() + "\n" +
                    "Total Price: " + totalPrice + "\n" +
                    "Status: " + getInvoiceStatus() + "\n" +
                    "Payment Type: " + getPaymentType() + "\n";
        }
    }
}
