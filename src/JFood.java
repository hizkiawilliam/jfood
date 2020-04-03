/**
 * Write a description of class JFood here.
 *
 * @author Hizkia William Eben
 * @version 03.04.2020
 */

import java.util.*;

public class JFood
{
    
    /**
     * Constructor for objects of class JFood
     * Defined as main program
     */
    public static void main(String[] args)
    {
        Location location1 = new Location("Depok", "Jawa Barat", "Universitas Indonesia");
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Ruki Harwahyu", "ruki.harwahyu@ui.ac.id", "08229812470", location1));

        Calendar calendar = new GregorianCalendar(2020, 4, 2);
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Hizkia", "hizkia.william@gmail.com", "curuChuchu44",calendar));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Hizkia", "hizkia.william@gmail.com", "curuChuchu44", 2020, 4, 2));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Ramadhan", "ramadhan@ui.ac.id", "notPassword2"));

        System.out.println("Daftar Customer: ");
        for (Customer customers : DatabaseCustomer.getCustomerDatabase())
        {
            System.out.println(customers);
        }
        System.out.println("\n");

        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Fried Chicken", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 30000, FoodCategory.Western));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"French Fries", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 25000, FoodCategory.Western));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Nasi Hainan", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 100000, FoodCategory.Rice));

        System.out.println("Daftar Food Category Western: ");
        for (Food food : DatabaseFood.getFoodByCategory(FoodCategory.Western))
        {
            System.out.println(food);
        }
        DatabasePromo.addPromo(new Promo(DatabaseFood.getLastId()+1,"Mahasiswa",10000,20000,false));
        DatabasePromo.addPromo(new Promo(DatabaseFood.getLastId()+1,"Mahasiswa",5000,10000,true));

        System.out.println("Daftar Promo: ");
        for (Promo promo : DatabasePromo.getPromoDatabase())
        {
            System.out.println(promo);
        }

        ArrayList<Food> newFood = new ArrayList<Food>();
        newFood.add(DatabaseFood.getFoodById(DatabaseFood.getLastId()));

        DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId()+1,newFood,DatabaseCustomer.getCustomerById(1),5000));
        DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId()).setTotalPrice();

        for (Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1))
        {
            invoice.setTotalPrice();
        }

        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1,newFood,DatabaseCustomer.getCustomerById(1),DatabasePromo.getPromoByCode("Mahasiswa")));

        for (Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1))
        {
            invoice.setTotalPrice();
        }

        System.out.println("Daftar Invoice: ");
        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            System.out.println(invoice);
        }

        for (Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1))
        {
            invoice.setInvoiceStatus(InvoiceStatus.Finished);
        }

        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1,newFood,DatabaseCustomer.getCustomerById(2),DatabasePromo.getPromoByCode("Mahasiswa")));

        for (Promo promo : DatabasePromo.getPromoDatabase())
        {
            promo.setActive(true);
        }

        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            invoice.setTotalPrice();
        }

        System.out.println("Daftar Invoice: ");
        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            System.out.println(invoice);
        }

        //DatabaseCustomer.getCustomerById(DatabaseCustomer.getLastId());
        /*
        Seller seller1 = new Seller(42806,"Hizkia William Eben","williamhizkia@gmail.com","082298840430",location1);
        Food food1 = new Food(1001,"White Coffee",seller1,25000,FoodCategory.Coffee);
        Food food2 = new Food(1002,"Ayam Bakar Kecap",seller1,17000,FoodCategory.Beverages);
        Food food3 = new Food(1003,"Roti Cokelat",seller1,7000,FoodCategory.Bakery);
        Customer customer1 = new Customer(42825,"Darrell Yonathan","131802938","da", new GregorianCalendar(2020,03,19));
        Customer customer2 = new Customer(42300,"Geraldy Christanto","geraldy.christanto@gmail.com","PemrogRaman1");
        Customer customer3 = new Customer(45905,"Ananda Rizky Duto","ananda.rizkyo@gmail.com","PemrogRaman2");
        
        //System.out.println(customer1.toString());
        //System.out.println(customer2.toString());
        //System.out.println(customer3.toString());    
        
        //customer1.setEmail("darrell.yonathan@gmail.com");
        //customer1.setPassword("PemrogRaman3");      
        
        //System.out.println(customer1.toString());
        //System.out.println(customer2.toString());
        //System.out.println(customer3.toString());  
        
        Promo promo1 = new Promo(1,"Promo Mahasiswa",3000,15000,true);
        CashlessInvoice invoice1 = new CashlessInvoice(1, food1,customer1,InvoiceStatus.Ongoing,promo1);
        //CashlessInvoice invoice3 = new CashlessInvoice(3, food3, "12,03,2020",customer2,InvoiceStatus.Finished,promo1);
        CashInvoice invoice4 = new CashInvoice(4, food1,customer2,InvoiceStatus.Ongoing);
        //CashInvoice invoice5 = new CashInvoice(5, food2, "13,03,2020",customer2,InvoiceStatus.Finished,7000);        
        
        invoice1.setTotalPrice();
        invoice4.setTotalPrice();
        //invoice3.setTotalPrice();
        //invoice4.setTotalPrice();
        //invoice5.setTotalPrice();        
        
        System.out.println(invoice1.toString());
        System.out.println(invoice4.toString());
        //invoice3.printData();
        //invoice4.printData();
        //invoice5.printData();        
        //Invoice invoice1 = new Invoice(0001,food1.getId(),"27-02-2020",customer1,food1.getPrice(),InvoiceStatus.Finished);
        //System.out.println(seller1.getName());
        //seller1.setName("Ramadhan");
        //System.out.println(seller1.getName());
        //food2.printData();
       // invoice1.printData();
        //DatabaseFood listfood1 = new DatabaseFood();
        //listfood1.addFood(food1);
        //listfood1.addFood(food2);
        //listfood1.getListFood();

         */
    }
}