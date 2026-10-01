package org.example.bo;

import org.example.db.ItemDB;
import org.example.ui.Snapshot;

import java.util.ArrayList;

public class Item {
    private final String name;
    private final String description;
    private final int price;
    private final int stock;

    public Item(String name, String description, int price, int stock){
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public int getPrice(){
        return this.price;
    }

    public int getStock(){
        return this.stock;
    }

    public static void getAllItems(){
        Snapshot.updateItems((ArrayList<ItemDB>) ItemDB.getItems());
    }
}
