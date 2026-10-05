package org.example.ui;

import java.util.ArrayList;

public class CartDTO {
    private final ArrayList<ItemDTO> items;
    private int totalPrice;

    public CartDTO(ArrayList<ItemDTO> items, int totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public CartDTO() {
        this.items = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void addItem(ItemDTO item){
        if(item != null){
            items.add(item);
            totalPrice += item.getPrice();
        }
    }

    public ArrayList<ItemDTO> getItems() {
        return items;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
