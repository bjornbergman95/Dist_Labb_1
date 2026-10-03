package org.example.bo;

import java.util.ArrayList;

public class Basket {

    private final ArrayList<Item> basket = new ArrayList<>();

    public void addItem(Item item){
        if(item != null) {
            basket.add(item);
        }
    }

    public ArrayList<Item> getItems(){
        return new ArrayList<>(basket);
    }

}
