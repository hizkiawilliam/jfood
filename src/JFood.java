/**
 * Write a description of class JFood here.
 *
 * @author Hizkia William Eben
 * @version 03.04.2020
 */

import kotlin.time.FormatToDecimalsKt;

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

        //==============================
        //===========Tugas 8============
        //==============================

        //=================Error Handling Customer Email================
        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Ramadhan", "ramadhan@ui.ac.id", "notPassword2"));
        }
        catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

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

        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Hizkia", "hizkia.william@gmail.com", "curuChuchu44", 2020, 4, 2));
        }
        catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        //=================Error Handling Promo Exists================
        try{
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1,"Mahasiswa",5000,20000,false));
        }
        catch (PromoCodeAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1,"Mahasiswa",5000,20000,true));
        }
        catch (PromoCodeAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        //=================Error Handling Customer Id================
        try{
            DatabaseCustomer.removeCustomer(4);
        }
        catch (CustomerNotFoundException e){
            System.out.println(e.getMessage());
        }

        //=================Error Handling Food Id================
        try{
            DatabaseFood.removeFood(4);
        }
        catch (FoodNotFoundException e){
            System.out.println(e.getMessage());
        }

        //=================Error Handling Seller Id================
        try {
            DatabaseSeller.getSellerById(3);
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        //=================Error Handling Promo Id================
        try{
            DatabasePromo.removePromo(3);
        }
        catch (PromoNotFoundException e){
            System.out.println(e.getMessage());
        }

        //======================Add food========================
        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Fried Chicken", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 28000, FoodCategory.Western));
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"French Fries", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 25000, FoodCategory.Western));
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Nasi Hainan", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 27000, FoodCategory.Rice));
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }


        //=================Print Yang Masuk Ke Database================
        System.out.println("\n");
        System.out.println("==========YANG MASUK DATABASE CUSTOMER===========");
        for (Customer customers : DatabaseCustomer.getCustomerDatabase())
        {
            System.out.println(customers);
        }

        System.out.println("===========YANG MASUK DATABASE PROMO===========");
        for (Promo promo : DatabasePromo.getPromoDatabase())
        {
            System.out.println(promo);
        }

        System.out.println("===========YANG MASUK DATABASE FOOD===========");
        for (Food food : DatabaseFood.getFoodDatabase())
        {
            System.out.println(food);
        }

        //==============================
        //===========Tugas 9============
        //==============================

        //========================Add Array list Food============================
        ArrayList<Food> newFood = new ArrayList<Food>();
        ArrayList<Food> newFood2 = new ArrayList<Food>();
        ArrayList<Food> newFood3 = new ArrayList<Food>();

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

        try {
            newFood3.add(DatabaseFood.getFoodById(3));
        }
        catch (FoodNotFoundException e){
            System.out.println(e.getMessage());
        }

        //========================Add Invoice============================
        try {
            DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1, newFood, DatabaseCustomer.getCustomerById(1), 5000));
        }
        catch(CustomerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1, newFood2, DatabaseCustomer.getCustomerById(2), 6000));
        }
        catch(CustomerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1, newFood3, DatabaseCustomer.getCustomerById(3), 7000));
        }
        catch(CustomerNotFoundException e){
            System.out.println(e.getMessage());
        }

        //========================Kalkulasi Invoice============================
        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            Thread calculate = new Thread(new PriceCalculator(invoice));
            calculate.start();
        }


        /*
        System.out.println("Daftar Customer: ");
        for (Customer customers : DatabaseCustomer.getCustomerDatabase())
        {
            System.out.println(customers);
        }
        System.out.println("\n");
         */

        /*
        System.out.println("Daftar Food Category Western: ");
        for (Food food : DatabaseFood.getFoodByCategory(FoodCategory.Western))
        {
            System.out.println(food);
        }
         */

        /* Modul 6
        //Nomor 1
        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1,"Mahasiswa",5000,20000,false));
//        DatabasePromo.addPromo(new Promo(DatabaseFood.getLastId()+1,"Mahasiswa",5000,10000,true));

        //Nomor 2
        System.out.println("Daftar Promo: ");
        for (Promo promo : DatabasePromo.getPromoDatabase())
        {
            System.out.println(promo);
        }

        //Nomor 3
        ArrayList<Food> newFood = new ArrayList<Food>();
        newFood.add(DatabaseFood.getFoodById(1));

        ArrayList<Food> newFood2 = new ArrayList<Food>();
        newFood2.add(DatabaseFood.getFoodById(1));
        newFood2.add(DatabaseFood.getFoodById(2));

        //Nomor 4
        DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId()+1,newFood,DatabaseCustomer.getCustomerById(1),5000));

        //Nomor 5
        DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size()-1).setTotalPrice();
        DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size()-1).setInvoiceStatus(InvoiceStatus.Finished);

        //Nomor 6
        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1,newFood2,DatabaseCustomer.getCustomerById(1),DatabasePromo.getPromoByCode("Mahasiswa")));

        //Nomor 7
        DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size()-1).setTotalPrice();

        //Nomor 8
        System.out.println("Daftar Invoice: ");
        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            System.out.println(invoice);
        }

        //Nomor 9
        DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size()-1).setInvoiceStatus(InvoiceStatus.Finished);

        //Nomor 10
        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1,newFood2,DatabaseCustomer.getCustomerById(2),DatabasePromo.getPromoByCode("Mahasiswa")));

        //Nomor 11
        for (Promo promo : DatabasePromo.getPromoDatabase())
        {
            promo.setActive(true);
        }

        //Nomor 12
        DatabaseInvoice.getInvoiceByCustomer(2).get(DatabaseInvoice.getInvoiceByCustomer(2).size()-1).setTotalPrice();

        //Nomor 13
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