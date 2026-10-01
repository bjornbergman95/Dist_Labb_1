package org.example.db;

import org.example.bo.User;

import java.sql.*;

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
            System.out.println("MYSQL DRIVER NOT FOUND");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("DATABASE CONNECTION FAILED");
            e.printStackTrace();
        }
    }

    public User login(String username) throws SQLException {
        String sql = "SELECT * FROM `user` WHERE username = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql)){


            System.out.println("Here333");
            statement.setString(1, username);
            System.out.println("Here222");
            ResultSet result = statement.executeQuery();
            System.out.println("Here111");
            if (result.next()) {
                System.out.println("Here");
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
}
