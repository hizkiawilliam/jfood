/**
 * This is class will handle METHODS related to invoices
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */

package hizkia.jfood.controller;

import hizkia.jfood.*;
import hizkia.jfood.database.*;
import hizkia.jfood.exception.CustomerNotFoundException;
import hizkia.jfood.exception.FoodNotFoundException;
import hizkia.jfood.exception.InvoiceNotFoundException;
import hizkia.jfood.exception.OngoingInvoiceAlreadyExistsException;
import hizkia.jfood.unused.InvoiceStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/invoice")
@CrossOrigin(origins = "*", allowedHeaders = "")
@RestController
public class InvoiceController {

    /**
     * Method to prints all invoice in the data base
     * @return all invoice in database
     */
    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice()
    {
        return DatabaseInvoicePosgres.getInvoiceDatabase();
    }

    /**
     * Method to get invoice from id
     * @param id variable to store id of invoice
     * @return single invoice object
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id) throws InvoiceNotFoundException {
        return DatabaseInvoicePosgres.getInvoiceById(id);
    }

    /**
     * Method to get invoice from customer
     * @param customerId variable to store id of customer
     * @return single invoice object
     */
    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomer(@PathVariable int customerId) throws InvoiceNotFoundException {
        return DatabaseInvoicePosgres.getInvoiceByCustomer(customerId);
    }

    /**
     * Method to get invoice from customer with ongoing status
     * @param customerId variable to store id of customer
     * @return single invoice object
     */
    @RequestMapping(value = "/customerOngoing/{customerId}", method = RequestMethod.GET)
    public Invoice getInvoiceOngoingByCustomer(@PathVariable int customerId) throws InvoiceNotFoundException {
        ArrayList<Invoice>invoices = DatabaseInvoicePosgres.getInvoiceByCustomer(customerId);
        for(Invoice invoice:invoices){
            if(invoice.getInvoiceStatus().equals("Ongoing")){
                return invoice;
            }
        }
        return null;
    }

    /**
     * Method to remove invoice
     * @param id variable to store id of invoice
     * @return true if success, null if failed
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id) {
        return DatabaseInvoicePosgres.deleteInvoice(id);
    }

    /**
     * Method to adds new invoice into database with cash payment type
     * @param foodIdList variable that stores all foods that was purchased
     * @param customerId variable that stores id of the customer
     * @param deliveryFee variable that stores delivery fee
     * @return object invoice that was added to database
     */
    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value="foodList") ArrayList<Integer> foodIdList,
                                  @RequestParam(value="customerId") int customerId,
                                  @RequestParam(value="deliveryFee",required = false,defaultValue = "0") int deliveryFee)
    {
        ArrayList<Food> menu = new ArrayList<>();
        for (Integer foodId : foodIdList)
        {
            menu.add(DatabaseFoodPostgres.getFoodById(foodId));
        }
        try{
            for(Invoice invoiceCheck:DatabaseInvoicePosgres.getInvoiceByCustomer(customerId))
            {
                if (invoiceCheck.getInvoiceStatus().equals("Ongoing"))
                {
                    return null;
                }
            }
            Invoice invoice = new CashInvoice(DatabaseInvoice.getLastId() + 1, menu, DatabaseCustomerPostgres.getCustomerById(customerId), deliveryFee);
            return DatabaseInvoicePosgres.insertCashInvoice(invoice, deliveryFee);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method to adds new invoice into database with cashless payment type
     * @param foodIdList variable that stores all foods that was purchased
     * @param customerId variable that stores id of the customer
     * @param promoCode variable that stores promo code
     * @return object invoice that was added to database
     */
    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value="foodList") ArrayList<Integer> foodIdList,
                                  @RequestParam(value="customerId") int customerId,
                                  @RequestParam(value="promoCode",required = false) String promoCode)
    {
        ArrayList<Food> menu = new ArrayList<>();
        for (Integer foodId : foodIdList)
        {
            menu.add(DatabaseFoodPostgres.getFoodById(foodId));
        }

        Promo promo = DatabasePromoPostgres.getPromoByCode(promoCode);
        try{
            for(Invoice invoiceCheck:DatabaseInvoicePosgres.getInvoiceByCustomer(customerId))
            {
                if (invoiceCheck.getInvoiceStatus().equals("Ongoing"))
                {
                    return null;
                }
            }
            Invoice invoice = new CashlessInvoice(DatabaseInvoice.getLastId() + 1, menu, DatabaseCustomerPostgres.getCustomerById(customerId), promo);
            return DatabaseInvoicePosgres.insertCashlessInvoice(invoice,promoCode);
        }
        catch (Exception e){
            e.printStackTrace();
        }return null;
    }

    /**
     * Method to change invoice status into canceled
     * @param id_invoice variable to store id of invoice
     * @return single invoice object if success, null if failed
     */
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public Invoice cancelTransaction(@RequestParam(value="id") int id_invoice) throws InvoiceNotFoundException {
        return DatabaseInvoicePosgres.changeInvoiceStatus(id_invoice, "Canceled");
    }

    /**
     * Method to change invoice status into finished
     * @param id_invoice variable to store id of invoice
     * @return single invoice object if success, null if failed
     */
    @RequestMapping(value = "/finish", method = RequestMethod.POST)
    public Invoice finishTransaction(@RequestParam(value="id") int id_invoice) throws InvoiceNotFoundException {
        return DatabaseInvoicePosgres.changeInvoiceStatus(id_invoice, "Finished");
    }
}
