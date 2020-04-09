public class PriceCalculator implements Runnable
{
    Invoice invoice;

    public PriceCalculator(Invoice invoice)
    {
        this.invoice = invoice;
    }

    @Override
    public void run()
    {
        System.out.println("Calculating invoice id: " + invoice.getId());
        invoice.setTotalPrice();
        System.out.println("finish calculating invoice id: " + invoice.getId());
        System.out.println("Total Price invoice id " + invoice.getId() + ": " + invoice.getTotalPrice());
    }
}
