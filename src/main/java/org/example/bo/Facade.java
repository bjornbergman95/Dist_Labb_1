package org.example.bo;

import org.example.ui.CartDTO;
import org.example.ui.ItemDTO;
import org.example.ui.UserDTO;

import java.util.ArrayList;

//UI entrypoint to BO
public class Facade {

    public static UserDTO logIn(String username, String password) {
        User user = UserService.login(username, password);

        if (user != null) {
            return new UserDTO(user.getUsername(), user.getRole());
        }

        return null;
    }

    public static ArrayList<ItemDTO> getAllItems() {
        ArrayList<Item> items = ItemHandler.getAllItems();
        ArrayList<ItemDTO> list = new ArrayList<>();
        for (Item item : items) {
            list.add(new ItemDTO(item));
        }
        return list;
    }

    public static void addToCart(int itemId, CartDTO cart) {
        Item item = ItemHandler.getItem(itemId);
        if (item != null) {
            cart.addItem(new ItemDTO(item));
        }
    }

    public static void checkout(CartDTO cart, UserDTO user){
        Order order = new Order(cart, user);
        if(Order.checkout(order)){
            cart.clear();
        }
    }

}
