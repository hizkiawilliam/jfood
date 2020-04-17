package hizkia.jfood.controller;

import hizkia.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/invoice")
@RestController
public class InvoiceController {

    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice()
    {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id) throws InvoiceNotFoundException {
        Invoice invoice = DatabaseInvoice.getInvoiceById(id);
        return invoice;
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomer(@PathVariable int customerId) throws InvoiceNotFoundException {
        ArrayList<Invoice> invoice = DatabaseInvoice.getInvoiceByCustomer(customerId);
        return invoice;
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@RequestParam(value="id") @PathVariable int id, @RequestParam(value="status") InvoiceStatus status) throws InvoiceNotFoundException {
        if (DatabaseInvoice.changeInvoiceStatus(id, status))
        {
            return DatabaseInvoice.getInvoiceById(id);
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id) {
        try
        {
            DatabaseInvoice.removeInvoice(id);
        } catch (InvoiceNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }
        return true;
    }

    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value="foodList") ArrayList<Integer> foodIdList,
                                  @RequestParam(value="customerId") int customerId,
                                  @RequestParam(value="deliveryFee") int deliveryFee)
    {
        ArrayList<Food> menu = new ArrayList<>();
        for (Integer foodId : foodIdList)
        {
            try
            {
                menu.add(DatabaseFood.getFoodById(foodId));
            } catch (FoodNotFoundException e) {
                e.printStackTrace();
            }

        }
        try{
            Invoice invoice = new CashInvoice(DatabaseInvoice.getLastId() + 1, menu, DatabaseCustomer.getCustomerById(customerId), deliveryFee);
            DatabaseInvoice.addInvoice(invoice);
            DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId()).setTotalPrice();
            return invoice;
        }
        catch (OngoingInvoiceAlreadyExistsException | CustomerNotFoundException | InvoiceNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value="foodList") ArrayList<Integer> foodIdList,
                                  @RequestParam(value="customerId") int customerId,
                                  @RequestParam(value="promoCode") String promoCode)
    {
        ArrayList<Food> menu = new ArrayList<>();
        for (Integer foodId : foodIdList)
        {
            try
            {
                menu.add(DatabaseFood.getFoodById(foodId));
            } catch (FoodNotFoundException e) {
                e.printStackTrace();
            }

        }

        Promo promo = DatabasePromo.getPromoByCode(promoCode);
        try{
            Invoice invoice = new CashlessInvoice(DatabaseInvoice.getLastId() + 1, menu, DatabaseCustomer.getCustomerById(customerId), promo);
            DatabaseInvoice.addInvoice(invoice);
            DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId()).setTotalPrice();
            return invoice;
        }
        catch (OngoingInvoiceAlreadyExistsException | CustomerNotFoundException | InvoiceNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
