package org.example.db;

import org.example.bo.Order;
import org.example.bo.User;

import java.sql.*;
import java.util.ArrayList;

/**
 * Handles communication with the webshop database.
 * DbQueary is responsible for connecting to the database and
 * performing database operations related to users, products and orders.
 */
public class DbQueary {

    /**
     * Creates a new DbQueary object and loads the MySQL JDBC driver.
     * If the MySQL driver cannot be found, an error message is printed.
     */
    public DbQueary(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL driver loaded.");
        } catch (ClassNotFoundException e) {
            System.out.println("MYSQL driver not found.");
            e.printStackTrace();

        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://mysql-lab1:3306/webshop",
                "root",
                "admin"
        );
    }

    /**
     * Retrieves a user from the database using the specified username.
     * The method uses a prepared statement to prevent SQL injection.
     * @param username the username of the user to retrieve
     * @return a User object containing the user's information,
     * or null if no user with the specified username is found
     * @throws SQLException if a database error occurs
     */
    public User login(String username) throws SQLException {
        String sql = "SELECT * FROM `user` WHERE username = ?";

        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){


            statement.setString(1, username);

            try(ResultSet result = statement.executeQuery()){
                if (result.next()) {

                    return new User(
                            result.getString("username"),
                            result.getString("password"),
                            result.getString("role")
                    );
                }
            }
        }
        return null;
    }

    /**
     * Retrieves all products from the product table in the database.
     * Each database row is converted into an ItemDB object and added
     * to an ArrayList.
     * @return an ArrayList containing all products in the database
     * @throws SQLException if a database error occurs
     */
    public ArrayList<ItemDB> getAllItems() throws SQLException{
        String sql = "SELECT * FROM `product`";
        ArrayList<ItemDB> items = new ArrayList<>();

        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery()){

            while(result.next()) {
                items.add(new ItemDB(
                        result.getString("name"),
                        result.getString("description"),
                        result.getInt("price"),
                        result.getInt("stock"),
                        result.getInt("id")
                ));
            }
        }
        return items;
    }

    /**
     * Processes a checkout for an order by decreasing the stock
     * of each product in the order.
     * The database transaction is committed only if all products
     * can be updated successfully. If one or more products cannot
     * be updated, the transaction is rolled back.
     * @param order the order to be checked out
     * @return true if the checkout was successful, otherwise false
     * @throws SQLException if a database error occurs during checkout
     */
    public boolean checkout(Order order) throws SQLException {

        String sql = "UPDATE product " +
                "SET stock = stock - 1 " +
                "WHERE id = ? AND stock > 0";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false);

            try {
                for (Integer id : order.getItemIds()) {

                    statement.setInt(1, id);

                    int rows = statement.executeUpdate();

                    if (rows == 0) {
                        connection.rollback();
                        return false;
                    }
                }

                connection.commit();
                return true;

            } catch (SQLException e) {
                connection.rollback();
                throw e;
            }
        }
    }

}
