package org.example.ui;

import java.util.ArrayList;

public class CartDTO {
    private final ArrayList<ItemDTO> items;
    private final int totalPrice;

    public CartDTO(ArrayList<ItemDTO> items, int totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public ArrayList<ItemDTO> getItems() {
        return items;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
