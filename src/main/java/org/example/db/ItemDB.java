package org.example.db;

import org.example.bo.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemDB extends Item {

    public ItemDB(String name, String description, int price, int stock) {
        super(name, description, price, stock);
    }

    public static List<ItemDB> getItems(){
        DbQueary db = new DbQueary();
        return db.getAllItems();
    }

}
