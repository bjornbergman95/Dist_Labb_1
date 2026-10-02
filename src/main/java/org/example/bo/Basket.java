package org.example.bo;

import org.example.ui.Snapshot;

import java.util.ArrayList;

public class Basket {

    private static ArrayList<Item> basket = new ArrayList<>();

    public static void addItem(Item item){
        if(item != null) {
            basket.add(item);
            Snapshot.updateBasket(new ArrayList<>(basket));
        }
    }
}
