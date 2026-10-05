package org.example.ui;

import org.example.bo.Item;

public class ItemDTO {
    private final String name;
    private final String description;
    private final int price;
    private final int stock;
    private final int id;

    //skapa de detamedlemmar som ska visas och ta bort arrayen

    public ItemDTO(Item item){
        this.name = item.getName();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.stock = item.getStock();
        this.id = item.getId();
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
