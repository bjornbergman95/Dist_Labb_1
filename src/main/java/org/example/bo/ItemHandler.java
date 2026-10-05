package org.example.bo;

import org.example.db.ItemDB;
import org.example.ui.ItemDTO;

import java.util.ArrayList;
import java.util.List;

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
