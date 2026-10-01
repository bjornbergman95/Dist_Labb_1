package org.example.db;

import org.example.bo.Item;
import org.example.bo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbQueary {
    private Connection connection;


    public DbQueary(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://mysql-lab1:3306/webshop",
                    "root",
                    "admin"
            );

            System.out.println("Connection ok.");

        } catch (ClassNotFoundException e) {
            System.out.println("MYSQL driver not found.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
    }

    public User login(String username) throws SQLException {
        String sql = "SELECT * FROM `user` WHERE username = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, username);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                User u = new User(
                        result.getString("username"),
                        result.getString("password")
                );
                System.out.println(u);
                return u;

            }

        } catch(SQLException e){
            System.out.println("Error while logging in.");
        }
        return new User(null,null);
    }

    public List<ItemDB> getAllItems(){
        String sql = "SELECT * FROM `product`";
        try(PreparedStatement statement = connection.prepareStatement(sql)){

            ResultSet result = statement.executeQuery();
            ArrayList<ItemDB> items = new ArrayList<>();
            while(true){
                if(result.next()){
                    items.add(new ItemDB(
                            result.getString("name"),
                            result.getString("description"),
                            result.getInt("price"),
                            result.getInt("stock")
                    ));
                } else{
                    break;
                }
            }
            return items;

        } catch(SQLException e){
            System.out.println("Error while loading items");
        }
        return null;
    }
}
