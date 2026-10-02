package org.example.bo;

public class Item {
    private final String name;
    private final String description;
    private final int price;
    private final int stock;
    private final int id;

    public Item(String name, String description, int price, int stock, int id){
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.id = id;
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

    public int getId(){
        return this.id;
    }

}
