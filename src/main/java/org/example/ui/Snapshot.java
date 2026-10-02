package org.example.ui;

import org.example.bo.Item;
import java.util.ArrayList;

public class Snapshot {
    private static ArrayList<Item> allItems = new ArrayList<>();

    public static void updateItems(ArrayList<Item> items){
        Snapshot.allItems = new ArrayList<>(items);
    }

    public static ArrayList<Item> getAllItems(){
        return new ArrayList<>(allItems);
    }

}
