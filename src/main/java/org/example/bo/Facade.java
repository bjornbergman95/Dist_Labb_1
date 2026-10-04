package org.example.bo;

import org.example.ui.ItemDTO;

import java.util.ArrayList;

public class Facade {

    public static User logIn(String username, String password){
        return UserService.login(username, password);
    }

    public static ArrayList<Item> getCart(User user){
        return user.getCart().getItems();
    }

    public static ArrayList<Item> getAllItems(){
        ItemHandler.getAllItems();
        return ItemDTO.getAllItems();
    }

    public static void addToCart(int itemId, User user){
        Item item = ItemHandler.getItem(itemId);

        if(item != null) {
            user.getCart().addItem(item);
        }
    }

    public static int getTotalPrice(User user){
        return user.getCart().getTotalPrice();
    }

}
