package org.example.bo;

import org.example.ui.CartDTO;
import org.example.ui.ItemDTO;
import org.example.ui.UserDTO;

import java.util.ArrayList;

/**
  * Facade provides a simplified interface between the user interface (UI)
  * and the business logic (BO).
  * The class contains methods for logging in, retrieving items,
  * adding items to a cart and completing an order.
  */
public class Facade {

    /**
     *  Attempts to log in a user with the given username and password.
     *  @param username the username of the user
     *  @param password the password of the user
     *  @return a UserDTO containing the user's information if the login
     *  is successful, otherwise null
     */
    public static UserDTO logIn(String username, String password) {
        User user = UserService.login(username, password);

        if (user != null) {
            return new UserDTO(user.getUsername(), user.getRole());
        }

        return null;
    }

    /**
     *  Retrieves all available items from the item handler.
     *  The method converts the Item objects from the business layer
     *  into ItemDTO objects that can be used by the UI.
     *  @return an ArrayList containing all available items as ItemDTO objects
     */
    public static ArrayList<ItemDTO> getAllItems() {
        ArrayList<Item> items = ItemHandler.getAllItems();
        ArrayList<ItemDTO> list = new ArrayList<>();
        for (Item item : items) {
            list.add(new ItemDTO(item));
        }
        return list;
    }

    /**
     *  Adds an item to the specified shopping cart.
     *  The item is first retrieved using its item ID and then converted
     *  to an ItemDTO before being added to the cart.
     *  @param itemId the ID of the item to add
     *  @param cart the shopping cart to which the item should be added
     *  */
    public static void addToCart(int itemId, CartDTO cart) {
        Item item = ItemHandler.getItem(itemId);
        if (item != null) {
            cart.addItem(new ItemDTO(item));
        }
    }

    /**
     *  Completes the checkout process for the specified cart and user.
     *  If the checkout is successful, the cart is cleared.
     *  @param cart the shopping cart containing the items to purchase
     *  @param user the user making the purchase
     */
    public static void checkout(CartDTO cart, UserDTO user){
        Order order = new Order(cart, user);
        if(Order.checkout(order)){
            cart.clear();
        }
    }

}
