package org.example.bo;

import org.example.db.ItemDB;
import java.util.ArrayList;


/**
 * Handles operations related to items in the webshop.
 * ItemHandler acts as a connection between the business layer and
 * the database layer for retrieving items.
 */
public class ItemHandler {

    public static ArrayList<Item> getAllItems(){
        return new ArrayList<>(ItemDB.getItems());
    }

    public static Item getItem(int itemId) {

        ArrayList<Item> items = ItemHandler.getAllItems();

        for (Item i : items) {
            if (i.getId() == itemId) {
                return i;
            }
        }

        return null;
    }
}
