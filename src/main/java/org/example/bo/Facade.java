package org.example.bo;

import org.example.ui.CartDTO;
import org.example.ui.ItemDTO;
import org.example.ui.UserDTO;

import java.util.ArrayList;

public class Facade {

    public static UserDTO logIn(String username, String password) {
        User user = UserService.login(username, password);

        if (user != null) {
            return new UserDTO(user.getUsername(), user.getRole());
        }

        return null;
    }

    public static CartDTO getCart(Cart cart) {

        ArrayList<ItemDTO> items = new ArrayList<>();

        for (Item item : cart.getItems()) {
            items.add(new ItemDTO(item));
        }

        return new CartDTO(items, cart.getTotalPrice());
    }

    public static ArrayList<ItemDTO> getAllItems() {
        ArrayList<Item> items = ItemHandler.getAllItems();
        ArrayList<ItemDTO> list = new ArrayList<>();
        for (Item item : items) {
            list.add(new ItemDTO(item));
        }
        return list;
    }

    public static void addToCart(int itemId, Cart cart) {
        Item item = ItemHandler.getItem(itemId);

        if (item != null) {
            cart.addItem(item);
        }
    }

}
