package org.example.ui;

import org.example.bo.Item;
import org.example.db.ItemDB;

import java.util.ArrayList;

public class Snapshot {
    private static ArrayList<Item> allItems = new ArrayList<>();
    private static ArrayList<Item> basket = new ArrayList<>();

    public static void updateItems(ArrayList<ItemDB> items){
        allItems = new ArrayList<>(items);
    }

    public static ArrayList<Item> getAllItems(){
        return new ArrayList<>(allItems);
    }

    public static void updateBasket(Item item){
        basket.add(item);
    }

    public static ArrayList<Item> getBasket(){
        return new ArrayList<>(basket);
    }
}
