package org.example.bo;

import org.example.db.ItemDB;
import org.example.ui.ItemDTO;

import java.util.ArrayList;
import java.util.List;

public class ItemHandler {

    public static void getAllItems(){
        List<ItemDB> items = ItemDB.getItems();
        ItemDTO.updateItems(new ArrayList<>(items));

    }

    public static Item getItem(int itemId){
        ArrayList<Item> items = ItemDTO.getAllItems();
        for(Item i : items){
            if(i.getId() == itemId){
                return i;
            }
        }
        return null;
    }
}
