package org.example.bo;

import java.util.ArrayList;

class Item {
    private String name;
    private int artNr;
    private int price;

    Item(String name, int artNr){
        this.name = name;
        this.artNr = artNr;
    }

    static ArrayList<Item> getBasket(){
        ArrayList<Item> basket = new ArrayList<>();

        return basket;
    }

    static ArrayList<Item> getAllItems(){
        return null;
    }

    public int getPrice(){
        return this.price;
    }

}
