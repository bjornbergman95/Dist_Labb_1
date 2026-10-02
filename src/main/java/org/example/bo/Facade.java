package org.example.bo;

import org.example.ui.Snapshot;

import java.sql.SQLException;
import java.util.ArrayList;

public class Facade {

    public static User logIn(String username, String password) throws SQLException {
        return UserService.login(username, password);
    }

    public static ArrayList<Item> getBasket(User user){
        return user.getBasket().getItems();
    }

    public static ArrayList<Item> getAllItems(){
        ItemHandler.getAllItems();
        return Snapshot.getAllItems();
    }

    public static void addToBasket(int itemId, User user){
        Item item = ItemHandler.getItem(itemId);

        if(item != null) {
            user.getBasket().addItem(item);
        }
    }

}
