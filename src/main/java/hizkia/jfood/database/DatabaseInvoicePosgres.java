package hizkia.jfood.database;

import hizkia.jfood.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static hizkia.jfood.database.DatabaseConnection.connection;

public class DatabaseInvoicePosgres {

    /**
     * Method for inserting cash Invoice to database
     * @param invoice object invoice to be input
     * @param deliveryFee int of delivery fee
     * @return object invoice if success
     */
    public static Invoice insertCashInvoice(Invoice invoice, int deliveryFee) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            invoice.setTotalPrice();
            ArrayList<String> foodList = new ArrayList<>();
            ArrayList<Food> foods = invoice.getFoods();
            for (Food food:foods){
                foodList.add(String.valueOf(food.getId()));
            }
            String foodIdList = String.join(",", foodList);
            String sql = "INSERT INTO invoice (food_list, customer_id, delivery_fee, total_price, payment_type, invoice_status) VALUES" + "('{" + foodIdList + "}'," + invoice.getCustomer().getId() + "," + deliveryFee +
                    "," + invoice.getTotalPrice() + ",'" + invoice.getPaymentType() + "','" + invoice.getInvoiceStatus() + "');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return invoice;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method for inserting cashless Invoice to database
     * @param invoice object invoice to be input
     * @param promoCode string of promo code
     * @return object invoice if success
     */
    public static Invoice insertCashlessInvoice(Invoice invoice, String promoCode) {
        Connection c = connection();
        PreparedStatement stmt;
        ArrayList<String> tempFoodList = new ArrayList<>();
        try {
            c.setAutoCommit(false);
            invoice.setTotalPrice();
            for(Food foodPtr : invoice.getFoods()){
                tempFoodList.add(String.valueOf(foodPtr.getId()));
            }
            String foodIdList = String.join(",", tempFoodList);
            String sql = "INSERT INTO invoice (food_list, customer_id, promo_code, total_price, payment_type, invoice_status) VALUES" + "('{" + foodIdList + "}'," + invoice.getCustomer().getId() + ",'" + promoCode +
                    "'," + invoice.getTotalPrice() + ",'" + invoice.getPaymentType() + "','" + invoice.getInvoiceStatus() + "');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return invoice;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method for fetching invoice by id
     * @param id int variable for invoice id
     * @return Array list of invoices if success
     */
    public static Invoice getInvoiceById(int id) {
        ArrayList<Food> finalFoodList = new ArrayList<>();
        CashInvoice cashValue;
        CashlessInvoice cashlessValue;
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM invoice WHERE id = " + id + ";";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int invoiceId = rs.getInt("id");
                Array foodList = rs.getArray("food_list");
                Integer[] strFoodList = (Integer[])foodList.getArray();
                for (Integer integer : strFoodList) {
                    finalFoodList.add(DatabaseFoodPostgres.getFoodById(integer));
                }
                Customer customerId = DatabaseCustomerPostgres.getCustomerById(rs.getInt("customer_id"));
                Date invoiceDate = rs.getDate("invoice_date");
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(invoiceDate);

                int totalPrice = rs.getInt("total_price");
                String invoiceStatus = rs.getString("invoice_status");
                String paymentType = rs.getString("payment_type");

                if (paymentType.equals("Cash")){
                    int deliveryFee = rs.getInt("delivery_fee");
                    cashValue = new CashInvoice(invoiceId, finalFoodList, customerId, deliveryFee);
                    cashValue.setInvoiceStatus(invoiceStatus);
                    cashValue.setTotalPricePostgres(totalPrice);
                    return cashValue;
                }else if (paymentType.equals("Cashless")){
                    String promoCode = rs.getString("promo_code");
                    cashlessValue = new CashlessInvoice(invoiceId, finalFoodList, customerId, DatabasePromoPostgres.getPromoByCode(promoCode));
                    cashlessValue.setInvoiceStatus(invoiceStatus);
                    cashlessValue.setTotalPrice();
                    return cashlessValue;
                }
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method for fetching invoice by customer id
     * @param customerId int variable for customer id
     * @return Array list of invoices if success
     */
    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId) {
        ArrayList<Invoice> invoiceDatabase = new ArrayList<>();
        ArrayList<Food> finalFoodList = new ArrayList<>();
        CashInvoice cashValue;
        CashlessInvoice cashlessValue;
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM invoice WHERE customer_id = " + customerId + ";";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int invoiceId = rs.getInt("id");
                Array foodList = rs.getArray("food_list");
                Integer[] strFoodList = (Integer[])foodList.getArray();
                for (Integer integer : strFoodList) {
                    finalFoodList.add(DatabaseFoodPostgres.getFoodById(integer));
                }
                Customer customer = DatabaseCustomerPostgres.getCustomerById(rs.getInt("customer_id"));
                Date invoiceDate = rs.getDate("invoice_date");
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(invoiceDate);

                int totalPrice = rs.getInt("total_price");
                String invoiceStatus = rs.getString("invoice_status");
                String paymentType = rs.getString("payment_type");

                if (paymentType.equals("Cash")){
                    int deliveryFee = rs.getInt("delivery_fee");
                    cashValue = new CashInvoice(invoiceId, finalFoodList, customer, deliveryFee);
                    cashValue.setInvoiceStatus(invoiceStatus);
                    cashValue.setTotalPricePostgres(totalPrice);
                    invoiceDatabase.add(cashValue);
                }else if (paymentType.equals("Cashless")){
                    String promoCode = rs.getString("promo_code");
                    cashlessValue = new CashlessInvoice(invoiceId, finalFoodList, customer, DatabasePromoPostgres.getPromoByCode(promoCode));
                    cashlessValue.setInvoiceStatus(invoiceStatus);
                    cashlessValue.setTotalPrice();
                    invoiceDatabase.add(cashlessValue);
                }
            }
            rs.close();
            stmt.close();
            c.close();
            return invoiceDatabase;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method to change invoice status
     * @param id int variable for invoice id
     * @param invoiceStatus string variable for invoice status
     * @return invoice object if success
     */
    public static Invoice changeInvoiceStatus(int id, String invoiceStatus) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String sql = "UPDATE invoice SET invoice_status = '"+ invoiceStatus + "' WHERE id = "+ id +";";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return DatabaseInvoicePosgres.getInvoiceById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method to delete invoice from database
     * @param id int variable for invoice id
     * @return boolean, true if success
     */
    public static boolean deleteInvoice(int id) {
        Connection c = connection();
        PreparedStatement stmt;
        try {

            c.setAutoCommit(false);
            String sql = "DELETE FROM invoice WHERE id = "+ id +";";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Method for fetching all invoice in database
     * @return Array list of invoices if success
     */
    public static ArrayList<Invoice> getInvoiceDatabase() {
        ArrayList<Invoice> invoiceDatabase = new ArrayList<>();
        ArrayList<Food> finalFoodList = new ArrayList<>();
        CashInvoice cashValue;
        CashlessInvoice cashlessValue;
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM invoice;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int invoiceId = rs.getInt("id");
                Array foodList = rs.getArray("food_list");
                Integer[] strFoodList = (Integer[])foodList.getArray();
                for (Integer integer : strFoodList) {
                    finalFoodList.add(DatabaseFoodPostgres.getFoodById(integer));
                }
                Customer customer = DatabaseCustomerPostgres.getCustomerById(rs.getInt("customer_id"));
                Date invoiceDate = rs.getDate("invoice_date");
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(invoiceDate);

                int totalPrice = rs.getInt("total_price");
                String invoiceStatus = rs.getString("invoice_status");
                String paymentType = rs.getString("payment_type");

                if (paymentType.equals("Cash")){
                    int deliveryFee = rs.getInt("delivery_fee");
                    cashValue = new CashInvoice(invoiceId, finalFoodList, customer, deliveryFee);
                    cashValue.setInvoiceStatus(invoiceStatus);
                    cashValue.setTotalPricePostgres(totalPrice);
                    invoiceDatabase.add(cashValue);
                }else if (paymentType.equals("Cashless")){
                    String promoCode = rs.getString("promo_code");
                    cashlessValue = new CashlessInvoice(invoiceId, finalFoodList, customer, DatabasePromoPostgres.getPromoByCode(promoCode));
                    cashlessValue.setInvoiceStatus(invoiceStatus);
                    cashlessValue.setTotalPrice();
                    invoiceDatabase.add(cashlessValue);
                }
            }
            rs.close();
            stmt.close();
            c.close();
            return invoiceDatabase;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
