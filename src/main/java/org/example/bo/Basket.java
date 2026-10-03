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

    public int getTotalPrice(){
        int total = 0;
        for (Item i : basket){
            total += i.getPrice();
        }
        return total;
    }

}
