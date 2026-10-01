package org.example.bo;

import org.example.ui.Snapshot;

import java.sql.SQLException;
import java.util.ArrayList;

public class Facade {

    public static boolean logIn(String username, String password) throws SQLException {
        return UserService.login(username, password);
    }

    public static ArrayList<Item> viewBasket(){
        return null;
    }

    public static ArrayList<Item> getAllItems(){
        Item.getAllItems();
        return Snapshot.getAllItems();
    }

    public static void addToBasket(){

    }

}
