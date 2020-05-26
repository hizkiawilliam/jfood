package hizkia.jfood;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatabaseCustomerPostgre extends DatabaseConnection {
    public static Customer insertCustomer(Customer customer) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String name = customer.getName();
            String email = customer.getEmail();
            String password = customer.getPassword();
            String sql = "INSERT INTO customer (name, email, password) VALUES ('"+name+"','"+email+"','"+password+"');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method for get Last Customer Id (not used)
     * @return
     */
    public static int getCustomerLastId(){
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        try {
            String sql = "SELECT id from customer;";
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
     * Method for get Customer from PostgreSQL using customer id
     * @param id_cust
     * @return
     */
    public static Customer getCustomer(int id_cust){
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        String name = null;
        String email = null;
        String username = null;
        String password = null;
        int year = 0;
        int month = 0;
        int dayofmonth = 0;
        Customer customer = null;
        try {
            String sql = "SELECT * from customer where id=?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1,id_cust);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                username = rs.getString("username");
                password = rs.getString("password");
                year = rs.getInt("year");
                month = rs.getInt("month");
                dayofmonth = rs.getInt("dayofmonth");
            }
            stmt.close();
            c.close();
            customer = new Customer(id, name, email, password, year, month, dayofmonth);
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    /**
     * Metgod for get customer using email and password (for login)
     * @param email_cust
     * @param password_cust
     * @return
     */
    public static Customer getCustomer(String email_cust, String password_cust){
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        String name = null;
        String email = null;
        String username = null;
        String password = null;
        int year = 0;
        int month = 0;
        int dayofmonth = 0;
        Customer customer = null;
        try {
            String sql = "SELECT id, name, email, username, password, year, month, dayofmonth from customer where email=? and password=?;";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, email_cust);
            stmt.setString(2, password_cust);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                username = rs.getString("username");
                password = rs.getString("password");
                year = rs.getInt("year");
                month = rs.getInt("month");
                dayofmonth = rs.getInt("dayofmonth");
            }
            stmt.close();
            c.close();
            customer = new Customer(id, name, email, password, year, month, dayofmonth);
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    /**
     * Method for remove customer using customer id
     * @param id id of customer
     */
    public void removeCustomer(int id){
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM customer where id = "+id+";";
            stmt = c.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for login customer using customer email and password
     * @param email id of customer
     * @param password password of customer
     */
//    public static Customer getCustomerLogin(String email, String password)
//    {
//        for(Customer customer:CUSTOMER_DATABASE)
//        {
//            if (email.equals(customer.getEmail()) && password.equals(customer.getPassword()))
//            {
//                return customer;
//            }
//        }
//        return null;
//    }
}
