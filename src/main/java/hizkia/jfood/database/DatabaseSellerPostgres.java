package hizkia.jfood.database;

import hizkia.jfood.Customer;
import hizkia.jfood.Seller;
import hizkia.jfood.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static hizkia.jfood.database.DatabaseConnection.connection;

public class DatabaseSellerPostgres {

    /**
     * Method for inserting seller to database
     * @param seller object seller to be input
     * @return object seller if success
     */
    public static Seller insertSeller(Seller seller) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String name = seller.getName();
            String email = seller.getEmail();
            String phoneNumber = seller.getPhoneNumber();
            int locationId = seller.getLocation().getId();
            String sql = "INSERT INTO seller (name, email, phoneNumber, locationId) VALUES ('"+name+"','"+email+"','"+phoneNumber+"','"+locationId+"');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return seller;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method for get Last seller Id (not used)
     * @return last id of seller in database
     */
    public static int getLastId(){
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        try {
            String sql = "SELECT id from seller;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
            }
            stmt.close();
            c.close();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * Method for get seller from PostgreSQL using seller id
     * @param id_seller int var for seller id
     * @return object seller if success
     */
    public static Seller getSellerById(int id_seller){
        Connection c = connection();
        PreparedStatement stmt;
        Seller seller = null;
        int id = 0;
        String name = null;
        String email = null;
        String phoneNumber = null;
        int locationId = 0;
        try {
            String sql = "SELECT * FROM seller WHERE id = '"+id_seller+"';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
                name = rs.getString("name");
                email  = rs.getString("email");
                phoneNumber = rs.getString("phoneNumber");
                locationId = rs.getInt("locationId");
            }
            rs.close();
            stmt.close();
            c.close();
            seller = new Seller(id, name, email, phoneNumber, DatabaseLocationPostgres.getLocationById(locationId));
            return seller;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Method for remove seller using seller id
     * @param id id of seller
     */
    public void removeCustomer(int id){
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM seller WHERE id = "+id+";";
            stmt = c.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
