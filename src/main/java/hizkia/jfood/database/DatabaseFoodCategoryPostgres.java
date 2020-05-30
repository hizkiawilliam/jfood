package hizkia.jfood.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static hizkia.jfood.database.DatabaseConnection.connection;

public class DatabaseFoodCategoryPostgres {

    /**
     * Method for inserting promo to database
     * @param name string type variable to be input to database for food category
     * @return string name of food category
     */
    public static String insertFoodCategory(String name) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String sql = "INSERT INTO foodCategory (name) VALUES ('"+name+"');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return name;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method for get Last Id of foodCategory
     * @return last id of foodCategory in database
     */
    public static int getLastId(){
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        try {
            String sql = "SELECT id from foodCategory;";
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
     * Method to get food category
     * @param categoryName string variable for food category
     * @return string of food category if success
     */
    public static String getFoodCategoryByName(String categoryName)
    {
        Connection c = connection();
        PreparedStatement stmt;
        String name = null;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT name FROM foodCategory WHERE name = '"+categoryName+"';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                name = rs.getString("name");
            }
            rs.close();
            stmt.close();
            c.close();
            if (name == null){
                return null;
            }
            else {
                return name;
            }

        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }
}
