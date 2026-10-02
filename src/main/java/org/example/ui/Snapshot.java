package org.example.ui;

import org.example.bo.Item;
import java.util.ArrayList;

public class Snapshot {
    private static ArrayList<Item> allItems = new ArrayList<>();
    private static ArrayList<Item> basket = new ArrayList<>();

    public static void updateItems(ArrayList<Item> items){
        Snapshot.allItems = items;
    }

    public static ArrayList<Item> getAllItems(){
        return new ArrayList<>(allItems);
    }

    public static void updateBasket(ArrayList<Item> basket){
        Snapshot.basket = basket;
    }

    public static ArrayList<Item> getBasket(){
        return new ArrayList<>(basket);
    }
}
