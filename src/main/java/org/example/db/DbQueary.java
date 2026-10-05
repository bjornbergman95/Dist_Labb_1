package org.example.db;

import org.example.bo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbQueary {

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
}
