/**
 * Write a description of class DatabasePromo here.
 *
 * @author Hizkia William Eben
 * @version 03.04.2020
 */

import  java.util.ArrayList;

public class DatabaseInvoice
{
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId = 0;

    /**
     * Method to show food list
     * @return Database of promo
     */
    public static ArrayList<Invoice> getInvoiceDatabase()
    {
        return INVOICE_DATABASE;
    }

    /**
     * Method to show last id
     * @return last id in database
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Method to show invoice by id
     * @return invoice
     */
    public static Invoice getInvoiceById(int id)
    {
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if (id == invoice.getId())
            {
                return invoice;
            }
        }
        return null;
    }

    /**
     * Method to show invoice by customer
     * @return invoice
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
     * Method to add invoice
     * @return false default return param to check successability
     */
    public static boolean addInvoice(Invoice invoice)
    {
        for(Invoice invoiceCheck:INVOICE_DATABASE)
        {
            if (invoiceCheck.getInvoiceStatus() == InvoiceStatus.Ongoing)
            {
                return false;
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    /**
     * Method to change invoice status
     * @return false default return param to check successability
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
     * Method to remove invoice
     * @return false default return param to check successability
     */
    public static boolean removeInvoice(int id)
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
        return false;
    }
}
