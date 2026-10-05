package org.example.bo;

import org.example.ui.ItemDTO;

import java.util.ArrayList;

public class Facade {

    public static User logIn(String username, String password) {
        return UserService.login(username, password);
    }

    public static ArrayList<ItemDTO> getCart(User user) {
        ArrayList<Item> items = user.getCart().getItems();
        ArrayList<ItemDTO> list = new ArrayList<>();
        for (Item item : items) {
            list.add(new ItemDTO(item));
        }
        return list;
    }

    public static ArrayList<ItemDTO> getAllItems() {
        ArrayList<Item> items = ItemHandler.getAllItems();
        ArrayList<ItemDTO> list = new ArrayList<>();
        for (Item item : items) {
            list.add(new ItemDTO(item));
        }
        return list;
    }

    public static void addToCart(int itemId, User user) {
        Item item = ItemHandler.getItem(itemId);

        if (item != null) {
            user.getCart().addItem(item);
        }
    }

    public static int getTotalPrice(User user){
        return user.getCart().getTotalPrice();
    }

}
