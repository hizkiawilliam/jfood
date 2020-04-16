/**
 * Write a description of class JFood here.
 *
 * @author Hizkia William Eben
 * @version 13.04.2020
 */
package hizkia.jfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JFood
{
    public static void main(String[] args) {

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


        SpringApplication.run(JFood.class, args);

    }
}