/**
 * Write a description of class DatabasePromo here.
 *
 * @author Hizkia William Eben
 * @version 13.04.2020
 */

import  java.util.ArrayList;

public class DatabaseInvoice
{
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId = 0;

    /**
     * Method to show invoice list from invoice database
     * @return INVOICE_DATABASE array list that stores all information about invoices
     */
    public static ArrayList<Invoice> getInvoiceDatabase()
    {
        return INVOICE_DATABASE;
    }

    /**
     * Method to show last id of invoice in invoice database
     * @return last id in invoice database
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Method to show invoice by id in invoice database
     * @param id passing parameter that stores invoice id
     * @return invoice as object
     */
    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException
    {
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if (id == invoice.getId())
            {
                return invoice;
            }
        }
        throw new InvoiceNotFoundException(id);
    }

    /**
     * Method to show invoice by customer from invoice database
     * @param customerId passing parameter that stores customer id
     * @return invoice as object
     */
    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId)
    {
        ArrayList<Invoice> invoiceCustomer = new ArrayList<>();
        for(Invoice invoice:INVOICE_DATABASE)
        {
            if (customerId == invoice.getCustomer().getId())
            {
                invoiceCustomer.add(invoice);
            }
        }
        if (invoiceCustomer == null)
        {
            return null;
        } else
        {
            return invoiceCustomer;
        }
    }

    /**
     * Method to add invoice into invoice database
     * @param invoice passing parameter that stores object invoice
     * @return boolean that show the succession of the method
     */
    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException
    {
        for(Invoice invoiceCheck:INVOICE_DATABASE)
        {
            if (invoiceCheck.getCustomer() == invoice.getCustomer() && invoiceCheck.getInvoiceStatus() == InvoiceStatus.Ongoing)
            {
                throw new OngoingInvoiceAlreadyExistsException(invoice);
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    /**
     * Method to change invoice status in invoice database
     * @param id passing parameter that stores invoice id
     * @param invoiceStatus passing parameter that stores invoice status
     * @return boolean that show the succession of the method
     */
    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus)
    {
        for(Invoice invoice:INVOICE_DATABASE)
        {
            if (id == invoice.getId() && invoice.getInvoiceStatus() == InvoiceStatus.Ongoing)
            {
                invoice.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    /**
     * Method to remove invoice from invoice database
     * @param id passing parameter that stores invoice id
     * @return boolean that show the succession of the method
     */
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException
    {
        for(int i = 0;  i < INVOICE_DATABASE.size(); i++)
        {
            Invoice invoice = INVOICE_DATABASE.get(i);
            if (id == invoice.getId())
            {
                INVOICE_DATABASE.remove(id);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }
}
