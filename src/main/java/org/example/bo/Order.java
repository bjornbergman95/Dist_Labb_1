package org.example.bo;

import org.example.db.ItemDB;
import org.example.db.OrderDB;
import org.example.ui.CartDTO;
import org.example.ui.ItemDTO;
import org.example.ui.UserDTO;

import java.util.ArrayList;

public class Order {
    private final ArrayList<Item> order;
    private final String username;

    public Order(CartDTO items, UserDTO user){
        order = new ArrayList<>();
        for (ItemDTO itemDTO : items.getItems()) {
            order.add(new Item(
                    itemDTO.getName(),
                    itemDTO.getDescription(),
                    itemDTO.getPrice(),
                    itemDTO.getStock(),
                    itemDTO.getId()
            ));
        }
        username = user.getUsername();
    }

    public static boolean checkout(Order order){
        return OrderDB.checkout(order);
    }

    public ArrayList<Item> getOrder() {
        return order;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Integer> getItemIds() {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Item item : order) {
            ids.add(item.getId());
        }
        return ids;
    }

}
