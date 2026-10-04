package org.example.bo;

import java.util.ArrayList;

public class Cart {

    private final ArrayList<Item> cart = new ArrayList<>();

    public void addItem(Item item){
        if(item != null) {
            cart.add(item);
        }
    }

    public ArrayList<Item> getItems(){
        return new ArrayList<>(cart);
    }

    public int getTotalPrice(){
        int total = 0;
        for (Item i : cart){
            total += i.getPrice();
        }
        return total;
    }

}
