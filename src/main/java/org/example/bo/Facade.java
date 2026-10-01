package org.example.bo;

import java.sql.SQLException;
import java.util.ArrayList;

public class Facade {

    public static boolean logIn(String username, String password) throws SQLException {
        return UserService.login(username, password);
    }

    public static ArrayList<Item> getBasket(){
        return Item.getBasket();
    }

    public static ArrayList<Item> getAllItems(){
        return Item.getAllItems();
    }

    public static void addToBasket(){

    }

}
