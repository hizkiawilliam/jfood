/**
 * Main Program runs here
 *
 * @author Hizkia William Eben
 * @version 17.04.2020
 */
package hizkia.jfood;

import java.util.*;

import hizkia.jfood.database.*;
import hizkia.jfood.exception.EmailAlreadyExistsException;
import hizkia.jfood.exception.SellerNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JFood
{
    public static void main(String[] args) {

        //LOCATION
        //Location location1 = new Location("Depok", "Jawa Barat", "Universitas Indonesia");
        //DatabaseLocationPostgre.insertLocation(location1);
        //SELLER
//        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Geraldy Christanto", "geraldy.christanto@ui.ac.id", "082245910341", DatabaseLocationPostgres.getLocationById(1)));
//        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Darrell Yonathan", "darrell.yonathan@ui.ac.id", "082297844221", DatabaseLocationPostgres.getLocationById(1)));
//        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Ananda Rizky Duto", "ananda.rizky@ui.ac.id", "082238295642", DatabaseLocationPostgres.getLocationById(1)));
//        DatabaseSellerPostgres.insertSeller(new Seller(DatabaseSeller.getLastId()+1, "Geraldy Christanto", "geraldy.christanto@ui.ac.id", "082245910341", DatabaseLocationPostgres.getLocationById(1)));
//        DatabaseSellerPostgres.insertSeller(new Seller(DatabaseSeller.getLastId()+1, "Darrell Yonathan", "darrell.yonathan@ui.ac.id", "082297844221", DatabaseLocationPostgres.getLocationById(1)));
//        DatabaseSellerPostgres.insertSeller(new Seller(DatabaseSeller.getLastId()+1, "Ananda Rizky Duto", "ananda.rizky@ui.ac.id", "082238295642", DatabaseLocationPostgres.getLocationById(1)));

//        DatabaseFoodPostgres.insertFood(new Food(DatabaseFood.getLastId()+1,"Fried Chicken", DatabaseSellerPostgres.getSellerById(1), 28000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Western")));
//        DatabaseFoodPostgres.insertFood(new Food(DatabaseFood.getLastId()+1,"Fried Chicken", DatabaseSellerPostgres.getSellerById(1), 28000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Western")));
//        DatabaseFoodPostgres.insertFood(new Food(DatabaseFood.getLastId()+1,"French Fries", DatabaseSellerPostgres.getSellerById(1), 25000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Western")));
//        DatabaseFoodPostgres.insertFood(new Food(DatabaseFood.getLastId()+1,"Ayam Hainan", DatabaseSellerPostgres.getSellerById(2), 22000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Western")));
//        DatabaseFoodPostgres.insertFood(new Food(DatabaseFood.getLastId()+1,"Nasi Pecel", DatabaseSellerPostgres.getSellerById(2), 15000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Rice")));
//        DatabaseFoodPostgres.insertFood(new Food(DatabaseFood.getLastId()+1,"Nasi Goreng Ayam", DatabaseSellerPostgres.getSellerById(2), 18000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Rice")));
//        DatabaseFoodPostgres.insertFood(new Food(DatabaseFood.getLastId()+1,"Nasi Ayam Rica-rica", DatabaseSellerPostgres.getSellerById(2), 21000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Rice")));
//        DatabaseFoodPostgres.insertFood(new Food(DatabaseFood.getLastId()+1,"Bulgogi Rice", DatabaseSellerPostgres.getSellerById(3), 45000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Korean")));
//        DatabaseFoodPostgres.insertFood(new Food(DatabaseFood.getLastId()+1,"Korean BBQ", DatabaseSellerPostgres.getSellerById(3), 48000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Korean")));
//        DatabaseFoodPostgres.insertFood(new Food(DatabaseFood.getLastId()+1,"Bibimbap", DatabaseSellerPostgres.getSellerById(3), 39000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Korean")));
//        DatabaseFoodPostgres.insertFood(new Food(DatabaseFood.getLastId()+1,"Topoki", DatabaseSellerPostgres.getSellerById(3), 40000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Korean")));

//        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Fried Chicken", DatabaseSellerPostgres.getSellerById(1), 28000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Western")));
//        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"French Fries", DatabaseSellerPostgres.getSellerById(1), 25000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Western")));
//        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Ayam Hainan", DatabaseSellerPostgres.getSellerById(2), 22000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Western")));
//        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Nasi Pecel", DatabaseSellerPostgres.getSellerById(2), 15000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Rice")));
//        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Nasi Goreng Ayam", DatabaseSellerPostgres.getSellerById(2), 18000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Rice")));
//        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Nasi Ayam Rica-rica", DatabaseSellerPostgres.getSellerById(2), 21000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Rice")));
//        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bulgogi Rice", DatabaseSellerPostgres.getSellerById(3), 45000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Korean")));
//        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Korean BBQ", DatabaseSellerPostgres.getSellerById(3), 48000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Korean")));
//        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bibimbap", DatabaseSellerPostgres.getSellerById(3), 39000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Korean")));
//        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Topoki", DatabaseSellerPostgres.getSellerById(3), 40000, DatabaseFoodCategoryPostgres.getFoodCategoryByName("Korean")));



        //Customer
//        try {
//            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Hizkia William", "williamhizkia@gmail.com", "hEllO123"));
//        }
//        catch (EmailAlreadyExistsException e){
//            System.out.println(e.getMessage());
//        }

        //Promo
        //DatabasePromoPostgre.insertPromo(new Promo(DatabasePromo.getLastId()+1, "dirumahaja", 15000, 50000, true));

/*
        //======================Add Location======================
        Location location1 = new Location("Depok", "Jawa Barat", "Universitas Indonesia");
        Location location2 = new Location("Jakarta Timur", "Jakarta", "Jalan Otista");
        Location location3 = new Location("Bogor", "Jawa Barat", "Jalan Roda");

        //======================Add Seller========================
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Hizkia William", "hizkia.william@ui.ac.id", "082298840430", location2));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Ananda Rizky", "ananda.rizky@ui.ac.id", "082298124702", location1));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Darrell Yonathan", "darrell.yonathan@ui.ac.id", "082298115370", location3));

        //======================Add Food==========================
        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Fried Chicken", DatabaseSeller.getSellerById(1), 28000, FoodCategory.Western));
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"French Fries", DatabaseSeller.getSellerById(2), 25000, FoodCategory.Western));
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Nasi Hainan", DatabaseSeller.getSellerById(3), 27000, FoodCategory.Rice));
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        //======================Add Customer==========================
        Calendar calendar = new GregorianCalendar(2020, 4, 2);
        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Ridho", "ridhogani@ui.ac.id", "YeahBoi27"));
        }
        catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Hizkia", "hizkia.william@gmail.com", "curuChuchu44",calendar));
        }
        catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        //======================Add ArraylistFood==========================
        ArrayList<Food> newFood = new ArrayList<Food>();
        ArrayList<Food> newFood2 = new ArrayList<Food>();

        try {
            newFood.add(DatabaseFood.getFoodById(1));
        }
        catch(FoodNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            newFood2.add(DatabaseFood.getFoodById(1));
        }
        catch (FoodNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            newFood2.add(DatabaseFood.getFoodById(2));
        }
        catch (FoodNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Invoice invoice = new CashInvoice(DatabaseInvoice.getLastId() + 1, newFood2, DatabaseCustomer.getCustomerById(1), 7000);
            DatabaseInvoice.addInvoice(invoice);
            DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId()).setTotalPrice();
            DatabaseInvoice.changeInvoiceStatus(1, InvoiceStatus.Finished);
        }
        catch (OngoingInvoiceAlreadyExistsException | CustomerNotFoundException | InvoiceNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Invoice invoice = new CashInvoice(DatabaseInvoice.getLastId() + 1, newFood, DatabaseCustomer.getCustomerById(2), 10000);
            DatabaseInvoice.addInvoice(invoice);
            DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId()).setTotalPrice();
            DatabaseInvoice.changeInvoiceStatus(2, InvoiceStatus.Cancelled);
        }
        catch (OngoingInvoiceAlreadyExistsException | CustomerNotFoundException | InvoiceNotFoundException e){
            System.out.println(e.getMessage());
        }*/
        SpringApplication.run(JFood.class, args);

    }
}