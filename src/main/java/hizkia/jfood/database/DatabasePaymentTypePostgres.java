package hizkia.jfood.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static hizkia.jfood.database.DatabaseConnection.connection;

public class DatabasePaymentTypePostgres {

    /**
     * Method for inserting paymentType to database
     * @param paymentType string type variable to be input to database for payment type
     * @return string name of payment type
     */
    public static String insertPaymentType(String paymentType) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String sql = "INSERT INTO paymentType (type) VALUES ('"+paymentType+"');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return paymentType;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method for get Last Id of paymentType
     * @return last id of paymentType in database
     */
    public static int getLastId(){
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        try {
            String sql = "SELECT id from paymentType;";
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
     * Method to get paymentType
     * @param paymentType string variable payment type
     * @return string of payment type if success
     */
    public static String getPaymentType(String paymentType)
    {
        Connection c = connection();
        PreparedStatement stmt;
        String name = null;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT type FROM paymentType WHERE type = '"+paymentType+"';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                name = rs.getString("type");
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
