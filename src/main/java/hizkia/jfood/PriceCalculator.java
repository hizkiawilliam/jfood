/**
 * Class to calculate total price of invoice
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */
package hizkia.jfood;

public class PriceCalculator implements Runnable
{
    Invoice invoice;

    /**
     * Constructor of PriceCalculator
     * @param invoice passing parameter that stores object invoice to be calculated
     */
    public PriceCalculator(Invoice invoice)
    {
        this.invoice = invoice;
    }

    @Override
    /**
     * Method to execute setTotalPrice process of invoices
     */
    public void run()
    {
        System.out.println("Calculating invoice id: " + invoice.getId());
        invoice.setTotalPrice();
        System.out.println("finish calculating invoice id: " + invoice.getId());
        System.out.println("Total Price invoice id " + invoice.getId() + ": " + invoice.getTotalPrice());
    }
}
