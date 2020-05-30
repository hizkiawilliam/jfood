package hizkia.jfood.database;

import hizkia.jfood.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static hizkia.jfood.database.DatabaseConnection.connection;

public class DatabaseLocationPostgres {

    /**
     * Method for inserting promo to database
     * @param location object location to be input
     * @return object location if success
     */
    public static Location insertLocation(Location location) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String city = location.getCity();
            String province = location.getProvince();
            String description = location.getDescription();
            String sql = "INSERT INTO location (city, province, description) VALUES ('"+city+"','"+province+"','"+description+"');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return location;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method for get last id of location
     * @return last id of location in database
     */
    public static int getLastId(){
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        try {
            String sql = "SELECT id from location;";
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
     * Method to get location
     * @param locationId integer for location id
     * @return object location if success
     */
    public static Location getLocationById(int locationId)
    {
        Connection c = connection();
        PreparedStatement stmt;
        Location location = null;
        int id = 0;
        String city = null;
        String province = null;
        String description = null;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM location WHERE id = '"+locationId+"';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                id = rs.getInt("id");
                city = rs.getString("city");
                province  = rs.getString("province");
                description = rs.getString("description");
            }
            rs.close();
            stmt.close();
            c.close();
            if (city == null){
                return null;
            }
            else {
                location = new Location(id, city, province, description);
                return location;
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }
}
