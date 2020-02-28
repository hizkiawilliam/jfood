
/**
 * Write a description of class JFood here.
 *
 * @author Hizkia William Eben
 * @version 27.02.2020
 */
public class JFood
{
    
    /**
     * Constructor for objects of class JFood
     * Defined as main program
     */
    public static void main(String[] args)
    {
        Location location1 = new Location("Depok", "Jawa Barat", "Universitas Indonesia");
        Seller seller1 = new Seller(42806,"Hizkia William Eben","williamhizkia@gmail.com","082298840430",location1);
        Food food1 = new Food(1001,"Ayam Goreng Kremes",seller1,17000,"Ayam");
        Customer customer1 = new Customer(42825,"Darrell Yonathan","darrell.yonathan@ui.ac.id","pemrograman","27-02-2020");
        Invoice invoice1 = new Invoice(0001,1001,"27-02-2020",customer1,17000);
        System.out.println(seller1.getName());
        seller1.setName("Ramadhan");
        System.out.println(seller1.getName());
        food1.printData();
    }
}
